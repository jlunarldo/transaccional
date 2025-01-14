 package syncdata.sdt.business.service;

import reactor.core.publisher.Mono;
import syncdata.sdt.business.dto.BuyDTO;
import syncdata.sdt.business.entities.Buy;
import syncdata.sdt.model.reponse.GeneralResponse;
import syncdata.sdt.model.reponse.GetResponse;

public interface BuyService {
    GeneralResponse saveBuy(BuyDTO buyDTO);

    public Mono<GetResponse<Buy>> getBuyResponse(long id);

    public Mono<GetResponse<Buy>> getAllBuy();

    public GeneralResponse updateBuy(BuyDTO buyDTO);

    GeneralResponse deleteBuy(long id);
}
