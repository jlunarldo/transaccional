package syncdata.sdt.business.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import syncdata.sdt.business.dto.PayMethodDTO;
import syncdata.sdt.business.entities.PayMethod;
import syncdata.sdt.business.repository.PayMethodRepository;
import syncdata.sdt.business.service.PayMethodService;
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
public class PayMethodServiceImpl implements PayMethodService {

    @Autowired
    private PayMethodRepository payMethodRepository;

    @Override
    public GeneralResponse savePayMethod(PayMethodDTO payMethodDTO){

        PayMethod payMethod = GeneralMapper.mapper(PayMethod.class, payMethodDTO);
        payMethod.setRegisterDate(Timestamp.valueOf(LocalDateTime.now()));
        payMethod.setFlag(1);
        payMethodRepository.save(payMethod);

        return new GeneralResponse();
    }

    @Override
    public Mono<GetResponse<PayMethod>> getPayMethodResponse(long id){
        return Mono.fromSupplier(() -> {

            Optional<PayMethod> payMethodOptional = payMethodRepository.findById(id);

            if (!payMethodOptional.isPresent()) {
                throw new GeneralException("No existe método de pago");
            }
            PayMethod payMethod = payMethodOptional.get();
            return GetResponse.<PayMethod>builder()
                    .object(payMethod)
                    .build();

        });
    }

    @Override
    public Mono<GetResponse<PayMethod>> getAllPayMethod(){
        return Mono.fromSupplier(() -> {

            List<PayMethod> listPayMethod = payMethodRepository.findAll();

            return GetResponse.<PayMethod>builder()
                    .list(listPayMethod)
                    .build();

        });
    }

    @Override
    public GeneralResponse updatePayMethod(PayMethodDTO payMethodDTO){

        return new GeneralResponse();
    }

    @Override
    public GeneralResponse deletePayMethod(long id){
        GeneralResponse generalResponse = new GeneralResponse();

        if (payMethodRepository.existsById(id)) {

            payMethodRepository.deleteById(id);
            generalResponse.setMessage("Método de pago se ha eliminado correctamente ");
            return generalResponse;
        } else {
            generalResponse.setMessage("No se ha encontrado método de pago");
            return generalResponse;
        }
    }
}
