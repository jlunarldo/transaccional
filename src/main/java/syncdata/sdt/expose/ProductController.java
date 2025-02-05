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
import syncdata.sdt.business.entities.Product;
import syncdata.sdt.business.interactor.ProductRecord;
import syncdata.sdt.exception.GeneralException;
import syncdata.sdt.model.request.ProductRequest;
import syncdata.sdt.model.reponse.GeneralResponse;
import syncdata.sdt.model.reponse.GetResponse;

@RestController
@RequestMapping("/product/v1/")
@Slf4j
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {
    @Autowired
    private ProductRecord productRecord;

    @ApiResponses(value={
            @ApiResponse(code=201, message = "", response = GeneralResponse.class),
            @ApiResponse(code=400, message = "Error", response = GeneralException.class),
            @ApiResponse(code=401, message = "Acceso no autorizado", response = GeneralException.class),
            @ApiResponse(code=500, message = "Ocurrio un error", response = GeneralException.class),
    })
    @PostMapping(value=("create"), produces = "application/json;charset=UTF-8")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<GeneralResponse> createProduct (@Valid  @RequestBody ProductRequest productRequest){
        String message="Creado con éxito";
        GeneralResponse generalResponse = productRecord.saveProductRequest(productRequest);
        generalResponse.setMessage(message);
        return Mono.justOrEmpty(generalResponse);
    }

    @GetMapping(value=("getProduct/{id}"), produces = "application/json;charset=UTF-8")
    @ResponseStatus(HttpStatus.OK)
    public Mono<GetResponse<Product>> getProductResponse (@PathVariable long id){
        return productRecord.getProductResponse(id);
    }

    @GetMapping(value=("getAllProduct"), produces = "application/json;charset=UTF-8")
    @ResponseStatus(HttpStatus.OK)
    public Mono<GetResponse<Product>> getAllProduct(){
        return productRecord.getAllProduct();
    }


    @GetMapping(value=("getUniqueCategorie"), produces = "application/json;charset=UTF-8")
    @ResponseStatus(HttpStatus.OK)
    public Mono<GetResponse<String>> getAllUniqueCategories(){
        return productRecord.getAllUniqueCategories();
    }
   /* @ApiResponses(value={
            @ApiResponse(code=201, message = "", response = GeneralResponse.class),
            @ApiResponse(code=400, message = "Error", response = GeneralException.class),
            @ApiResponse(code=401, message = "Acces not autorizhed", response = GeneralException.class),
            @ApiResponse(code=500, message = "Ocurrio un error", response = GeneralException.class),
    })
    @GetMapping(value=("name/{productName}"), produces = "application/json;charset=UTF-8")
    @ResponseStatus(HttpStatus.OK)
    public Mono<GetResponse<Product>> getProductName (@PathVariable("productName") String productName){
        log.info(productName);
        return productRecord.getProductName(productName);
    }
    @GetMapping(value=("flag/{flag}"), produces = "application/json;charset=UTF-8")
    @ResponseStatus(HttpStatus.OK)
    public Mono<GetResponse<Product>> getFlag (@PathVariable("flag") int flag){
        String flagString= String.valueOf(flag);
        return productRecord.getFlag(flagString);
    }*/


    @PutMapping(value=("updateProduct"), produces = "application/json;charset=UTF-8")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<GeneralResponse> updateProduct (@Valid  @RequestBody ProductRequest productRequest){
        String message="Product actualizado con éxito";
        GeneralResponse generalResponse = new GeneralResponse();
        generalResponse.setMessage(message);
        return Mono.justOrEmpty(generalResponse);
    }

    @DeleteMapping(value=("deleteProduct/{id}"), produces = "application/json;charset=UTF-8")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<GeneralResponse> deleteProduct (@PathVariable long id){
        return Mono.justOrEmpty(productRecord.deleteProductResponse(id));
    }
}
