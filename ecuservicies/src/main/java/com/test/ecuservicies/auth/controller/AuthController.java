package com.test.ecuservicies.auth.controller;

import com.test.ecuservicies.auth.jwt.JwtUtil;
import com.test.ecuservicies.auth.model.AuthRequest;
import com.test.ecuservicies.auth.model.AuthResponse;
import com.test.ecuservicies.auth.model.RefreshTokenRequest;
import com.test.ecuservicies.auth.model.RefreshTokenResponse;
import com.test.ecuservicies.auth.service.CustomUserDetailsService;
import com.test.ecuservicies.user.model.User;
import com.test.ecuservicies.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ecu/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request) {
        User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Credenciales inválidas");
        }

        // Renombra la llamada para mayor claridad
        String accessToken = jwtUtil.generateAccessToken(user);

        // Genera el nuevo refresh token
        String refreshToken = jwtUtil.generateRefreshToken(user);

        // Devuelve ambos tokens
        return new AuthResponse(accessToken, refreshToken);
    }

    @PostMapping("/refresh")
    public RefreshTokenResponse refreshToken(@RequestBody RefreshTokenRequest request) {
        String refreshToken = request.getRefreshToken();

        // Extrae el username del refresh token
        String username = jwtUtil.getUsernameFromToken(refreshToken);

        // Carga los detalles del usuario para asegurarte de que aún existe y está
        // activo
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);

        // Valida el refresh token
        if (jwtUtil.validateToken(refreshToken, userDetails.getUsername())) {
            // Si es válido, obtén el objeto User completo para generar el nuevo access
            // token con todos sus claims
            User user = userRepository.findByUsername(username)
                    .orElseThrow(() -> new RuntimeException("Usuario no encontrado durante el refresco"));

            // Genera un nuevo access token
            String newAccessToken = jwtUtil.generateAccessToken(user);

            return new RefreshTokenResponse(newAccessToken);
        } else {
            throw new RuntimeException("Refresh token inválido o expirado");
        }
    }

}
