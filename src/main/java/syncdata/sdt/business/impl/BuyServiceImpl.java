package syncdata.sdt.business.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import syncdata.sdt.business.dto.BuyDTO;
import syncdata.sdt.business.entities.Buy;
import syncdata.sdt.business.repository.BuyRepository;
import syncdata.sdt.business.service.BuyService;
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
public class BuyServiceImpl implements BuyService {

    @Autowired
    private BuyRepository buyRepository;

    @Override
    public GeneralResponse saveBuy(BuyDTO buyDTO){

        Buy buy = GeneralMapper.mapper(Buy.class, buyDTO);
        buy.setRegisterDate(Timestamp.valueOf(LocalDateTime.now()));
        buy.setFlag(1);
        buyRepository.save(buy);

        return new GeneralResponse();
    }

    @Override
    public Mono<GetResponse<Buy>> getBuyResponse(long id){
        return Mono.fromSupplier(() -> {

            Optional<Buy> buyOptional = buyRepository.findById(id);

            if (!buyOptional.isPresent()) {
                throw new GeneralException("No existe compra");
            }
            Buy buy = buyOptional.get();
            return GetResponse.<Buy>builder()
                    .object(buy)
                    .build();

        });
    }

    @Override
    public Mono<GetResponse<Buy>> getAllBuy(){
        return Mono.fromSupplier(() -> {

            List<Buy> listBuy = buyRepository.findAll();

            return GetResponse.<Buy>builder()
                    .list(listBuy)
                    .build();

        });
    }

    @Override
    public GeneralResponse updateBuy(BuyDTO buyDTO){

        return new GeneralResponse();
    }

    @Override
    public GeneralResponse deleteBuy(long id){
        GeneralResponse generalResponse = new GeneralResponse();

        if (buyRepository.existsById(id)) {

            buyRepository.deleteById(id);
            generalResponse.setMessage("Compra se ha eliminado correctamente ");
            return generalResponse;
        } else {
            generalResponse.setMessage("No se ha encontrado compra");
            return generalResponse;
        }
    }


}
