package syncdata.sdt.business.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Mono;
import syncdata.sdt.business.dto.RolDTO;
import syncdata.sdt.business.entities.Rol;
import syncdata.sdt.business.repository.RolRepository;
import syncdata.sdt.business.service.RolService;
import syncdata.sdt.exception.GeneralException;
import syncdata.sdt.mapper.GeneralMapper;
import syncdata.sdt.model.reponse.GeneralResponse;
import syncdata.sdt.model.reponse.GetResponse;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;



@Service
@RequiredArgsConstructor
@Transactional
@Slf4j

public class RolServiceImpl implements RolService {

    @Autowired
    private RolRepository rolRepository;

    @Override
    public GeneralResponse saveRol(RolDTO rolDTO){

        Rol rol= GeneralMapper.mapper(Rol.class, rolDTO);
        rol.setRegisterDate(Timestamp.valueOf(LocalDateTime.now()));
        rol.setFlag(1);
        rolRepository.save(rol);

        return new GeneralResponse();
    }

    @Override
    public Mono<GetResponse<Rol>> gelRolResponse(long id){
        return Mono.fromSupplier(()->{

            Optional<Rol> rolOptional= rolRepository.findById(id);

            if(!rolOptional.isPresent()){
                throw new GeneralException("No existe usuario");
            }
            Rol rol= rolOptional.get();
            return GetResponse.<Rol>builder()
                    .object(rol)
                    .build();

        });
    }


    @Override
    public Mono<GetResponse<Rol>> gelAllRol(){
        return Mono.fromSupplier(()->{

            List<Rol> listRol= rolRepository.findAll();

            return GetResponse.<Rol>builder().
                    list(listRol).
                    build();

        });

    }




    @Override
    public GeneralResponse updateRol(RolDTO rolDTO){

        return new GeneralResponse();
    }

    @Override
    public GeneralResponse deleteRol(long id){
        GeneralResponse generalResponse = new GeneralResponse();

        if( rolRepository.existsById(id)) {
            //UserGeneral userGeneral = userGeneralOptional.get();
            rolRepository.deleteById(id);
            generalResponse.setMessage("User se ha eliminado correctamente ");
            return generalResponse;
        }else{
            generalResponse.setMessage("No se ha encontrado User");
            return generalResponse;
        }

    }
}
