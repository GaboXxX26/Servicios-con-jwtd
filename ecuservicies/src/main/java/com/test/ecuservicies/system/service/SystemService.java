package com.test.ecuservicies.system.service;

import org.springframework.stereotype.Service;

import com.test.ecuservicies.system.client.RemoteSystemClient;
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

@Service
public class SystemService {

    private final RemoteSystemClient remoteClient;

    public SystemService(RemoteSystemClient remoteClient) {
        this.remoteClient = remoteClient;
    }

    // El método ahora usa el tipo correcto y devuelve un Mono
    // public Mono<NewEmergencyResponse> newEmergency(NewEmergencyRequest request) {
    //     return remoteClient.newEmergencyRemote(request);
    // }
    public NewEmergencyResponse newEmergency(NewEmergencyRequest request) {
        // Llamada síncrona para simplificar
        return remoteClient.newEmergency(request);
    }

    public NewRegisterResponse newRegister(NewRegisterRequest request) {
        return remoteClient.newRegister(request);
    }
    public GetStatusResponse getStatus(GetStatusRequest request) {
        return remoteClient.getStatus(request);
    }

    public SetCanceladoResponse setCancelado(SetCanceladoRequest request) {
        return remoteClient.setCancelado(request);
    }

    public MineducResponse mineducLogin(MineducRequest request) {
        return remoteClient.mineducLogin(request);
    }

    public MineducRecoveryResponse recoveryMineduc(MineducRecoveryRequest request) {
        return remoteClient.recoveryMineduc(request);
    }

    public MineducPasswordResponse validarClaveMineduc(MineducPasswordRequest request) {
        return remoteClient.validarClaveMineduc(request);
    }

    public MineducDisableResponse disableMineduc(MineducDisableRequest request) {
        return remoteClient.disableMineduc(request);
    }

}
