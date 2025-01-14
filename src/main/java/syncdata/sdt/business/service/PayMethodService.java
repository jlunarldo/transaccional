package syncdata.sdt.business.service;

import reactor.core.publisher.Mono;
import syncdata.sdt.business.dto.PayMethodDTO;
import syncdata.sdt.business.entities.PayMethod;
import syncdata.sdt.model.reponse.GeneralResponse;
import syncdata.sdt.model.reponse.GetResponse;

public interface PayMethodService {

    GeneralResponse savePayMethod(PayMethodDTO PayMethodDTO);

    public Mono<GetResponse<PayMethod>> getPayMethodResponse(long id);

    public Mono<GetResponse<PayMethod>> getAllPayMethod();

    public GeneralResponse updatePayMethod(PayMethodDTO payMethodDTO);

    GeneralResponse deletePayMethod(long id);
}
