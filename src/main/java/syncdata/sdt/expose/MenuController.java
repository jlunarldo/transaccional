package syncdata.sdt.expose;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import syncdata.sdt.business.entities.Menu;
import syncdata.sdt.business.interactor.MenuRecord;
import syncdata.sdt.exception.GeneralException;
import syncdata.sdt.model.request.MenuRequest;
import syncdata.sdt.model.reponse.GeneralResponse;
import syncdata.sdt.model.reponse.GetResponse;

@RestController
@RequestMapping("/menu/v1/")
@Slf4j
@RequiredArgsConstructor
public class MenuController {
    @Autowired
    private MenuRecord menuRecord;

    @ApiResponses(value={
            @ApiResponse(code=201, message = "", response = GeneralResponse.class),
            @ApiResponse(code=400, message = "Error", response = GeneralException.class),
            @ApiResponse(code=401, message = "Acceso no autorizado", response = GeneralException.class),
            @ApiResponse(code=500, message = "Ocurrio un error", response = GeneralException.class),
    })
    @PostMapping(value=("create"), produces = "application/json;charset=UTF-8")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<GeneralResponse> createMenu (@Valid @RequestBody MenuRequest menuRequest){
        String message = "Creado con éxito";
        GeneralResponse generalResponse = menuRecord.saveMenuRequest(menuRequest);
        generalResponse.setMessage(message);
        return Mono.justOrEmpty(generalResponse);
    }

    @GetMapping(value=("getMenu/{id}"), produces = "application/json;charset=UTF-8")
    @ResponseStatus(HttpStatus.OK)
    public Mono<GetResponse<Menu>> getMenuResponse (@PathVariable long id){
        return menuRecord.getMenuGeneralResponse(id);
    }

    @GetMapping(value=("getMenu/"), produces = "application/json;charset=UTF-8")
    @ResponseStatus(HttpStatus.OK)
    public Mono<GetResponse<Menu>> getAllMenu(){
        return menuRecord.getAllMenu();
    }

    @ApiResponses(value={
            @ApiResponse(code=201, message = "", response = GeneralResponse.class),
            @ApiResponse(code=400, message = "Error", response = GeneralException.class),
            @ApiResponse(code=401, message = "Acces not authorized", response = GeneralException.class),
            @ApiResponse(code=500, message = "Ocurrio un error", response = GeneralException.class),
    })
    /*@GetMapping(value=("flow/{flowName}"), produces = "application/json;charset=UTF-8")
    @ResponseStatus(HttpStatus.OK)
    public Mono<GetResponse<Menu>> getFlowName (@PathVariable("flowName") String flowName){
        log.info(flowName);
        return menuRecord.getFlowName(flowName);
    }*/

    @PutMapping(value=("updateMenu"), produces = "application/json;charset=UTF-8")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<GeneralResponse> updateMenu (@Valid @RequestBody MenuRequest menuRequest){
        String message = "Menu actualizado con éxito";
        GeneralResponse generalResponse = new GeneralResponse();
        generalResponse.setMessage(message);
        return Mono.justOrEmpty(generalResponse);
    }

    @DeleteMapping(value=("deleteMenu/{id}"), produces = "application/json;charset=UTF-8")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<GeneralResponse> deleteMenu (@PathVariable long id){
        return Mono.justOrEmpty(menuRecord.deleteMenuResponse(id));
    }
}
