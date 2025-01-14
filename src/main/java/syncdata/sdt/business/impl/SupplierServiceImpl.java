package syncdata.sdt.business.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import syncdata.sdt.business.dto.SupplierDTO;
import syncdata.sdt.business.entities.Supplier;
import syncdata.sdt.business.repository.SupplierRepository;
import syncdata.sdt.business.service.SupplierService;
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
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    @Override
    public GeneralResponse saveSupplier(SupplierDTO supplierDTO){

        Supplier supplier = GeneralMapper.mapper(Supplier.class, supplierDTO);
        supplier.setRegisterDate(Timestamp.valueOf(LocalDateTime.now()));
        supplier.setFlag(1);
        supplierRepository.save(supplier);

        return new GeneralResponse();
    }

    @Override
    public Mono<GetResponse<Supplier>> getSupplierResponse(long id){
        return Mono.fromSupplier(() -> {

            Optional<Supplier> supplierOptional = supplierRepository.findById(id);

            if (!supplierOptional.isPresent()) {
                throw new GeneralException("No existe proveedor");
            }
            Supplier supplier = supplierOptional.get();
            return GetResponse.<Supplier>builder()
                    .object(supplier)
                    .build();

        });
    }

    @Override
    public Mono<GetResponse<Supplier>> getAllSupplier(){
        return Mono.fromSupplier(() -> {

            List<Supplier> listSupplier = supplierRepository.findAll();

            return GetResponse.<Supplier>builder()
                    .list(listSupplier)
                    .build();

        });
    }

    @Override
    public GeneralResponse updateSupplier(SupplierDTO supplierDTO){

        return new GeneralResponse();
    }

    @Override
    public GeneralResponse deleteSupplier(long id){
        GeneralResponse generalResponse = new GeneralResponse();

        if (supplierRepository.existsById(id)) {

            supplierRepository.deleteById(id);
            generalResponse.setMessage("Proveedor se ha eliminado correctamente ");
            return generalResponse;
        } else {
            generalResponse.setMessage("No se ha encontrado proveedor");
            return generalResponse;
        }
    }
}
