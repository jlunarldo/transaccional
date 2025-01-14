package syncdata.sdt.expose;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import syncdata.sdt.business.entities.Rol;
import syncdata.sdt.business.interactor.RolRecord;
import syncdata.sdt.exception.GeneralException;
import syncdata.sdt.model.reponse.GeneralResponse;
import syncdata.sdt.model.reponse.GetResponse;
import syncdata.sdt.model.request.RolRequest;

@RestController
@RequestMapping("/rol/v1/")
@Slf4j
@RequiredArgsConstructor
public class RolController {

    @Autowired
    private RolRecord rolRecord;

    @ApiResponses(value={
            @ApiResponse(code=201, message = "", response = GeneralResponse.class),
            @ApiResponse(code=400, message = "Error", response = GeneralException.class),
            @ApiResponse(code=401, message = "Acceso no autorizado", response = GeneralException.class),
            @ApiResponse(code=500, message = "Ocurrio un error", response = GeneralException.class),
    })

    @PostMapping(value=("/create"), produces = "application/json;charset=UTF-8")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<GeneralResponse> createRol (@Valid @RequestBody RolRequest rolRequest){
        //log.info("Este es el request: "+ userRequest);

        String message="Creado con éxito";
        GeneralResponse generalResponse = rolRecord.saveRolRequest(rolRequest) ;
        generalResponse.setMessage(message);

        return Mono.justOrEmpty((generalResponse));
    }


    @GetMapping(value=("/getRolResponse/{id}"), produces = "application/json;charset=UTF-8")
    @ResponseStatus(HttpStatus.OK)
    public Mono<GetResponse<Rol>> getRolResponse (@PathVariable long id){

        return rolRecord.getRolResponse(id);
    }


    @GetMapping(value=("/getAllRol/{id}"), produces = "application/json;charset=UTF-8")
    @ResponseStatus(HttpStatus.FOUND)
    public Mono<GetResponse<Rol>> getRolDTO (){
        return rolRecord.getAllRol();
    }


    @PutMapping(value=("/updateRol"), produces = "application/json;charset=UTF-8")
    @ResponseStatus(HttpStatus.OK)
    public Mono<GeneralResponse> updateRol (@Valid  @RequestBody RolRequest rolRequest){
        //falta verificar si éxiste el id?
        //si no existe lo creamos?

        String message="Rol creado con éxito";
        GeneralResponse generalResponse = new GeneralResponse();
        generalResponse.setMessage(message);
        return Mono.justOrEmpty((generalResponse));
    }

    @DeleteMapping(value=("/deleteRol/{id}"), produces = "application/json;charset=UTF-8")
    //@ResponseStatus(HttpStatus.)
    public Mono<GeneralResponse> deleteRol (@PathVariable   long id){


        return Mono.justOrEmpty((rolRecord.deleteRolReponse(id)));
    }
}
