package syncdata.sdt.business.interactor;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import syncdata.sdt.business.dto.ProductDTO;
import syncdata.sdt.business.entities.Product;
import syncdata.sdt.business.service.ProductService;
import syncdata.sdt.mapper.GeneralMapper;
import syncdata.sdt.model.reponse.GeneralResponse;
import syncdata.sdt.model.reponse.GetResponse;
import syncdata.sdt.model.request.ProductRequest;

@Service
@Slf4j
public class ProductRecord {

    @Autowired
    private ProductService productService;

    public GeneralResponse saveProductRequest(ProductRequest productRequest){

        ProductDTO productDTO= GeneralMapper.mapper(ProductDTO.class, productRequest);

        return productService.saveProduct(productDTO);

    }

    public Mono<GetResponse<Product>> getProductResponse(long id){

        return productService.getProductResponse(id);
    }

    public Mono<GetResponse<Product>> getAllProduct(){
        return productService.getAllProduct();
    }

    public GeneralResponse deleteProductResponse(long id){
        return productService.deleteProduct(id);
    }

    public Mono<GetResponse<String>> getAllUniqueCategories(){
        return productService.getAllUniqueCategories();
    }


    public Mono<GetResponse<Product>> getProductCategorie(String categorie){
        return productService.getProductCategorie(categorie);
    }/*p*/

    /*public Mono<GetResponse<Product>> getflag(String flag){
        return productService.getByFlag(flag);
    }*/
}
