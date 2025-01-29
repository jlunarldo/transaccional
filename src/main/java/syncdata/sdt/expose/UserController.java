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
import syncdata.sdt.business.entities.UserGeneral;
import syncdata.sdt.business.interactor.UserRecord;
import syncdata.sdt.exception.GeneralException;
import syncdata.sdt.model.request.UserRequest;
import syncdata.sdt.model.reponse.GeneralResponse;
import syncdata.sdt.model.reponse.GetResponse;

@RestController
@RequestMapping("/user/v1/")
@Slf4j
@RequiredArgsConstructor
public class UserController {
    @Autowired
    private UserRecord userRecord;

    @ApiResponses(value={
            @ApiResponse(code=201, message = "", response = GeneralResponse.class),
            @ApiResponse(code=400, message = "Error", response = GeneralException.class),
            @ApiResponse(code=401, message = "Acceso no autorizado", response = GeneralException.class),
            @ApiResponse(code=500, message = "Ocurrio un error", response = GeneralException.class),
    })

    @PostMapping(value=("create"), produces = "application/json;charset=UTF-8")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<GeneralResponse> createUser (@Valid  @RequestBody UserRequest userRequest){
        //log.info("Este es el request: "+ userRequest);

        String message="Creado con éxito";
        GeneralResponse generalResponse = userRecord.saveUserRequest(userRequest) ;
        generalResponse.setMessage(message);

        return Mono.justOrEmpty((generalResponse));
    }


    @GetMapping(value=("getUser/{id}"), produces = "application/json;charset=UTF-8")
    @ResponseStatus(HttpStatus.OK)
    public Mono<GetResponse<UserGeneral>> getUserResponse (@PathVariable   long id){

        return userRecord.getUserGeneralResponse(id);
    }


    @GetMapping(value=("getUser/"), produces = "application/json;charset=UTF-8")
    @ResponseStatus(HttpStatus.OK)
    public Mono<GetResponse<UserGeneral>> getAllUser(){
        return userRecord.gelAllUser();
    }


    @ApiResponses(value={
            @ApiResponse(code=201, message = "", response = GeneralResponse.class),
            @ApiResponse(code=400, message = "Error", response = GeneralException.class),
            @ApiResponse(code=401, message = "Acces not autorizhed", response = GeneralException.class),
            @ApiResponse(code=500, message = "Ocurrio un error", response = GeneralException.class),
    })
    @GetMapping(value=("name/{fullname}"), produces = "application/json;charset=UTF-8")
    @ResponseStatus(HttpStatus.OK)
    public Mono<GetResponse<UserGeneral>> getUserName (@PathVariable("fullname") String fullName){
        log.info(fullName);
        return userRecord.getUserName(fullName);
    }

    @GetMapping(value=("flag/{flag}"), produces = "application/json;charset=UTF-8")
    @ResponseStatus(HttpStatus.OK)
    public Mono<GetResponse<UserGeneral>> getFlag (@PathVariable("flag") int flag){
        String flagString= String.valueOf(flag);

        return userRecord.getflag(flagString);
    }


    @PutMapping(value=("updateUser"), produces = "application/json;charset=UTF-8")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<GeneralResponse> updateUser (@Valid  @RequestBody UserRequest userRequest){
        //falta verificar si éxiste el id?
        //si no existe lo creamos?

        String message="User creado con éxito";
        GeneralResponse generalResponse = new GeneralResponse();
        generalResponse.setMessage(message);
        return Mono.justOrEmpty((generalResponse));
    }

    @DeleteMapping(value=("deleteUser/{id}"), produces = "application/json;charset=UTF-8")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<GeneralResponse> deleteUser (@PathVariable   long id){
        return Mono.justOrEmpty((userRecord.deleteUserReponse(id)));
    }


}
