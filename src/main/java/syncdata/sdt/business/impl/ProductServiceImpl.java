package syncdata.sdt.business.impl;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import syncdata.sdt.business.dto.UserGeneralDTO;
import syncdata.sdt.business.entities.UserGeneral;
import syncdata.sdt.business.service.ProductService;
import syncdata.sdt.business.dto.ProductDTO;
import syncdata.sdt.business.entities.Product;
import syncdata.sdt.business.repository.ProductRepository;
import syncdata.sdt.exception.CustomException;
import syncdata.sdt.exception.GeneralException;
import syncdata.sdt.mapper.GeneralMapper;
import syncdata.sdt.model.reponse.GeneralResponse;
import syncdata.sdt.model.reponse.GetResponse;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@Slf4j
public class ProductServiceImpl implements ProductService {

    @Autowired
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }



    @Override
    public Mono<GetResponse<Product>> getProductResponse(long id){
        return Mono.fromSupplier(()->{

            Optional<Product> productOptional= productRepository.findById(id);

            if(!productOptional.isPresent()){
                throw  new CustomException("No existe producto", HttpStatus.BAD_REQUEST);
            }
            Product product= productOptional.get();
            return GetResponse.<Product>builder()
                    .object(product)
                    .build();

        });
    }

    @Override
    public Mono<GetResponse<Product>> getAllProduct() {
        return Mono.fromSupplier(()->{

            List<Product> listProduct= productRepository.findAll();

            return GetResponse.<Product>builder().
                    list(listProduct).
                    build();

        });
    }

    @Override
    public Mono<GetResponse<String>> getAllUniqueCategories(){
        return Mono.fromSupplier(()->{
            List<String> listCategorie= productRepository.getAllUniqueCategories();

            return GetResponse.<String>builder().
                    list(listCategorie).
                    build();
        });
    }
    /*@Override
    public Mono<GetResponse<Product>> getAllProduct{
        return Mono.fromSupplier(()->{

            List<Product> listProduct= productRepository.findAll();

            return GetResponse.<Product>builder().
                    list(listProduct).
                    build();

        });
    }*/

    @Override
    public GeneralResponse updateProduct(ProductDTO productDTO){
        return new GeneralResponse();
    }

    @Override
    public GeneralResponse deleteProduct(long id){
        GeneralResponse generalResponse = new GeneralResponse();

        if(productRepository.existsById(id)) {
            productRepository.deleteById(id);
            generalResponse.setMessage("Product deleted correctly");
            return generalResponse;
        }else{
            throw  new CustomException("Product not found", HttpStatus.BAD_REQUEST);
        }
    }


   @Override
    public Mono<GetResponse<Product>> getProductCategorie(String categorie){
        return Mono.fromSupplier(()->{

           List<Product> listProductCategorie= productRepository.findByCategorie(categorie);

            return GetResponse.<Product>builder()
                    .list(listProductCategorie)
                    .build();

        });
    }

    @Override
    public GeneralResponse saveProduct(ProductDTO productDTO){

        Product product= GeneralMapper.mapper(Product.class, productDTO);
        product.setRegisterDate(Timestamp.valueOf(LocalDateTime.now()));
        product.setFlag(1);
        productRepository.save(product);

        return new GeneralResponse();
    }







     /*@Override
    public Mono<GetResponse<Product>> getProductByName(String productName){
        return Mono.fromSupplier(()->{

            log.info(productName);
            List<Product> product= productRepository.getByProductName(productName);
            if(product.isEmpty()){
                throw  new CustomException("Not exist product with name= " + productName, HttpStatus.BAD_REQUEST);
            }

            return GetResponse.<Product>builder()
                    .list(product)
                    .build();
        });
    }

    @Override
    public Mono<GetResponse<Product>> getByFlag(String flag){
        return Mono.fromSupplier(()->{

            log.info(flag);
            List<Product> product= productRepository.getByFlag(flag);
            log.info(product.getFirst().getProductName());
            if(product==null){
                throw  new CustomException("Not exist product with flag: "+ flag, HttpStatus.BAD_REQUEST);
            }

            return GetResponse.<Product>builder()
                    .list(product)
                    .build();
        });
    }*/
}
