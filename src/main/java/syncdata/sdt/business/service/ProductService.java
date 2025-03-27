package syncdata.sdt.business.service;

import reactor.core.publisher.Mono;
import syncdata.sdt.business.dto.ProductDTO;
import syncdata.sdt.business.dto.UserGeneralDTO;
import syncdata.sdt.business.entities.Product;
import syncdata.sdt.model.reponse.GeneralResponse;
import syncdata.sdt.model.reponse.GetResponse;

import java.util.List;

public interface ProductService {

    public GeneralResponse saveProduct(ProductDTO ProductDTO);

    public Mono<GetResponse<Product>> getProductResponse(long id);

    public Mono<GetResponse<Product>> getAllProduct();

    public GeneralResponse updateProduct(ProductDTO productDTO);

    public GeneralResponse deleteProduct(long id);

    public Mono<GetResponse<String>> getAllUniqueCategories();

    public Mono<GetResponse<Product>> getProductCategorie(String categorie);


}
