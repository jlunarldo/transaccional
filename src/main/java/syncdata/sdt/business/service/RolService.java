package syncdata.sdt.business.service;

import reactor.core.publisher.Mono;
import syncdata.sdt.business.dto.RolDTO;
import syncdata.sdt.business.dto.UserGeneralDTO;
import syncdata.sdt.business.entities.Rol;
import syncdata.sdt.model.reponse.GeneralResponse;
import syncdata.sdt.model.reponse.GetResponse;

public interface RolService {

    GeneralResponse saveRol(RolDTO rolDTO);

    Mono<GetResponse<Rol>> gelRolResponse(long id);

    GeneralResponse updateRol(RolDTO rolDTO);

    GeneralResponse deleteRol(long id);

    Mono<GetResponse<Rol>> gelAllRol();
}
