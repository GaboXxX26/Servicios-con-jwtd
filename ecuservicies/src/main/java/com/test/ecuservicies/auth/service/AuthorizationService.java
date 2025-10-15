package com.test.ecuservicies.auth.service;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.test.ecuservicies.system.model.EcuSystem;
import com.test.ecuservicies.user.model.User;

@Service("authorizationService")
public class AuthorizationService {
    /**
     * Verifica si el usuario autenticado tiene acceso a un ID de sistema
     * específico.
     * 
     * @param authentication El objeto de autenticación de Spring Security
     *                       (inyectado automáticamente)
     * @param systemId       El ID del sistema al que se quiere acceder.
     * @return true si el usuario tiene acceso, false en caso contrario.
     */

         public boolean hasAccess(Authentication authentication, Long systemId) {
        // 1. Obtenemos el "principal", que es nuestro objeto de usuario
        //    (asumiendo que tu clase User implementa UserDetails)
        if (!(authentication.getPrincipal() instanceof User)) {
            return false;
        }
        User user = (User) authentication.getPrincipal();

        // 2. Usamos la misma lógica que tenías antes: buscamos si alguno de los
        //    sistemas del usuario coincide con el ID requerido.
        return user.getSystems().stream()
                .map(EcuSystem::getSystem_id)
                .anyMatch(id -> id.equals(systemId));
    }
}
