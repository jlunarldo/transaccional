package syncdata.sdt.business.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import syncdata.sdt.business.dto.ProductDTO;
import syncdata.sdt.business.entities.Product;
import syncdata.sdt.business.repository.ProductRepository;
import syncdata.sdt.business.service.ProductService;
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
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public GeneralResponse saveProduct(ProductDTO productDTO){

        Product product = GeneralMapper.mapper(Product.class, productDTO);
        product.setRegisterDate(Timestamp.valueOf(LocalDateTime.now()));
        product.setFlag(1);
        productRepository.save(product);

        return new GeneralResponse();
    }

    @Override
    public Mono<GetResponse<Product>> getProductResponse(long id){
        return Mono.fromSupplier(() -> {

            Optional<Product> productOptional = productRepository.findById(id);

            if (!productOptional.isPresent()) {
                throw new GeneralException("No existe producto");
            }
            Product product = productOptional.get();
            return GetResponse.<Product>builder()
                    .object(product)
                    .build();

        });
    }

    @Override
    public Mono<GetResponse<Product>> getAllProduct(){
        return Mono.fromSupplier(() -> {

            List<Product> listProduct = productRepository.findAll();

            return GetResponse.<Product>builder()
                    .list(listProduct)
                    .build();

        });
    }

    @Override
    public GeneralResponse updateProduct(ProductDTO productDTO){

        return new GeneralResponse();
    }

    @Override
    public GeneralResponse deleteProduct(long id){
        GeneralResponse generalResponse = new GeneralResponse();

        if (productRepository.existsById(id)) {

            productRepository.deleteById(id);
            generalResponse.setMessage("Producto se ha eliminado correctamente ");
            return generalResponse;
        } else {
            generalResponse.setMessage("No se ha encontrado producto");
            return generalResponse;
        }
    }
}
