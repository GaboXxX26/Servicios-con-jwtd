package com.test.ecuservicies.system.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.ecuservicies.system.dto.GetStatusRequest;
import com.test.ecuservicies.system.dto.GetStatusResponse;
import com.test.ecuservicies.system.dto.MineducDisableRequest;
import com.test.ecuservicies.system.dto.MineducDisableResponse;
import com.test.ecuservicies.system.dto.MineducPasswordRequest;
import com.test.ecuservicies.system.dto.MineducPasswordResponse;
import com.test.ecuservicies.system.dto.MineducRecoveryRequest;
import com.test.ecuservicies.system.dto.MineducRecoveryResponse;
import com.test.ecuservicies.system.dto.MineducRequest;
import com.test.ecuservicies.system.dto.MineducResponse;
import com.test.ecuservicies.system.dto.NewEmergencyRequest;
import com.test.ecuservicies.system.dto.NewEmergencyResponse;
import com.test.ecuservicies.system.dto.NewRegisterRequest;
import com.test.ecuservicies.system.dto.NewRegisterResponse;
import com.test.ecuservicies.system.dto.SetCanceladoRequest;
import com.test.ecuservicies.system.dto.SetCanceladoResponse;
import com.test.ecuservicies.system.service.SystemService;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/systems")
public class SystemController {

    private final SystemService systemService;

    public SystemController(SystemService systemService) {
        this.systemService = systemService;
    }

    @PostMapping("/newEmergency")
    @PreAuthorize("@authorizationService.hasAccess(authentication, 1L)")
    // public Mono<NewEmergencyResponse> newEmergency(@RequestBody
    // NewEmergencyRequest request) {
    // return systemService.newEmergency(request);
    // }
    public NewEmergencyResponse newEmergency(@RequestBody NewEmergencyRequest request) {
        // Llamada síncrona para simplificar
        return systemService.newEmergency(request);
    }

    @PostMapping("/newRegister")
    @PreAuthorize("@authorizationService.hasAccess(authentication, 2L)")
    public NewRegisterResponse newRegister(@RequestBody NewRegisterRequest request) {
        return systemService.newRegister(request);
    }

    @PostMapping("/getStatus")
    @PreAuthorize("@authorizationService.hasAccess(authentication, 3L)")
    public GetStatusResponse getStatus(@RequestBody GetStatusRequest request) {
        return systemService.getStatus(request);
    }

    @PostMapping("/setCancelado")
    @PreAuthorize("@authorizationService.hasAccess(authentication, 4L)")
    public SetCanceladoResponse setCancelado(@RequestBody SetCanceladoRequest request) {
        return systemService.setCancelado(request);
    }

    @PostMapping("/mineducLogin")
    @PreAuthorize("@authorizationService.hasAccess(authentication, 5L)")
    public MineducResponse mineducLogin(@RequestBody MineducRequest request) {
        return systemService.mineducLogin(request);
    }

    @PostMapping("/recoveryMineduc")
    @PreAuthorize("@authorizationService.hasAccess(authentication, 6L)")
    public MineducRecoveryResponse recoveryMineduc(@RequestBody MineducRecoveryRequest request) {
        return systemService.recoveryMineduc(request);
    }

    @PostMapping("/validarClaveMineduc")
    @PreAuthorize("@authorizationService.hasAccess(authentication, 7L)")
    public MineducPasswordResponse validarClaveMineduc(@RequestBody MineducPasswordRequest request) {
        return systemService.validarClaveMineduc(request);
    }

    @PostMapping("/disableMineduc")
    @PreAuthorize("@authorizationService.hasAccess(authentication, 8L)")
    public MineducDisableResponse disableMineduc(@RequestBody MineducDisableRequest request) {
        return systemService.disableMineduc(request);
    }

}
