package syncdata.sdt.business.interactor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import syncdata.sdt.business.dto.RolDTO;
import syncdata.sdt.business.entities.Rol;
import syncdata.sdt.business.service.RolService;
import syncdata.sdt.mapper.GeneralMapper;
import syncdata.sdt.model.reponse.GeneralResponse;
import syncdata.sdt.model.reponse.GetResponse;
import syncdata.sdt.model.request.RolRequest;


@Service
@Slf4j
public class RolRecord {

    @Autowired
    private RolService rolService;

    public GeneralResponse saveRolRequest(RolRequest rolRequest){

        RolDTO rolDTO= GeneralMapper.mapper(RolDTO.class, rolRequest);

        return rolService.saveRol(rolDTO);

    }


    public Mono<GetResponse<Rol>> getRolResponse(long id){

        return rolService.gelRolResponse(id);
    }

    public Mono<GetResponse<Rol>> getAllRol(){

        return rolService.gelAllRol();
    }


    public GeneralResponse deleteRolReponse(long id){
        return rolService.deleteRol(id);
    }

}
