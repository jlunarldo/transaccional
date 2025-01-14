package syncdata.sdt.business.service;

import reactor.core.publisher.Mono;
import syncdata.sdt.business.dto.SupplierDTO;
import syncdata.sdt.business.entities.Supplier;
import syncdata.sdt.model.reponse.GeneralResponse;
import syncdata.sdt.model.reponse.GetResponse;

public interface SupplierService {

    GeneralResponse saveSupplier(SupplierDTO supplierDTO);

    public Mono<GetResponse<Supplier>> getSupplierResponse(long id);

    public Mono<GetResponse<Supplier>> getAllSupplier();

    public GeneralResponse updateSupplier(SupplierDTO supplierDTO);

    GeneralResponse deleteSupplier(long id);
}
