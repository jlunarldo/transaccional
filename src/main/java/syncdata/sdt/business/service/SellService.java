package syncdata.sdt.business.service;

import reactor.core.publisher.Mono;
import syncdata.sdt.business.dto.SellDTO;
import syncdata.sdt.business.entities.Sell;
import syncdata.sdt.model.reponse.GeneralResponse;
import syncdata.sdt.model.reponse.GetResponse;

public interface SellService {

    GeneralResponse saveSell(SellDTO sellDTO);

    public Mono<GetResponse<Sell>> getSellResponse(long id);

    public Mono<GetResponse<Sell>> getAllSell();

    public GeneralResponse updateSell(SellDTO sellDTO);

    GeneralResponse deleteSell(long id);
}
