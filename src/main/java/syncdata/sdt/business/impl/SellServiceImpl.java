package syncdata.sdt.business.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import syncdata.sdt.business.dto.SellDTO;
import syncdata.sdt.business.entities.Sell;
import syncdata.sdt.business.repository.SellRepository;
import syncdata.sdt.business.service.SellService;
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
public class SellServiceImpl implements SellService {

    @Autowired
    private SellRepository sellRepository;

    @Override
    public GeneralResponse saveSell(SellDTO sellDTO){

        Sell sell = GeneralMapper.mapper(Sell.class, sellDTO);
        sell.setRegisterDate(Timestamp.valueOf(LocalDateTime.now()));
        sell.setFlag(1);
        sellRepository.save(sell);

        return new GeneralResponse();
    }

    @Override
    public Mono<GetResponse<Sell>> getSellResponse(long id){
        return Mono.fromSupplier(() -> {

            Optional<Sell> sellOptional = sellRepository.findById(id);

            if (!sellOptional.isPresent()) {
                throw new GeneralException("No existe venta");
            }
            Sell sell = sellOptional.get();
            return GetResponse.<Sell>builder()
                    .object(sell)
                    .build();

        });
    }

    @Override
    public Mono<GetResponse<Sell>> getAllSell(){
        return Mono.fromSupplier(() -> {

            List<Sell> listSell = sellRepository.findAll();

            return GetResponse.<Sell>builder()
                    .list(listSell)
                    .build();

        });
    }

    @Override
    public GeneralResponse updateSell(SellDTO sellDTO){

        return new GeneralResponse();
    }

    @Override
    public GeneralResponse deleteSell(long id){
        GeneralResponse generalResponse = new GeneralResponse();

        if (sellRepository.existsById(id)) {

            sellRepository.deleteById(id);
            generalResponse.setMessage("Venta se ha eliminado correctamente ");
            return generalResponse;
        } else {
            generalResponse.setMessage("No se ha encontrado venta");
            return generalResponse;
        }
    }
}
