package syncdata.sdt.business.service;

import reactor.core.publisher.Mono;
import syncdata.sdt.business.dto.ProductDTO;
import syncdata.sdt.business.entities.Product;
import syncdata.sdt.model.reponse.GeneralResponse;
import syncdata.sdt.model.reponse.GetResponse;

public interface ProductService {

    GeneralResponse saveProduct(ProductDTO ProductDTO);

    public Mono<GetResponse<Product>> getProductResponse(long id);

    public Mono<GetResponse<Product>> getAllProduct();

    public GeneralResponse updateProduct(ProductDTO productDTO);

    GeneralResponse deleteProduct(long id);
}
