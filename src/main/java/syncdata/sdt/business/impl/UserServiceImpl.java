package syncdata.sdt.business.impl;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import syncdata.sdt.business.service.UserService;
import syncdata.sdt.business.dto.UserGeneralDTO;
import syncdata.sdt.business.entities.UserGeneral;
import syncdata.sdt.business.repository.UserGeneralRepository;
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
public class UserServiceImpl implements UserService {

    private final UserGeneralRepository userGeneralRepository;

    public UserServiceImpl(UserGeneralRepository userGeneralRepository) {
        this.userGeneralRepository = userGeneralRepository;
    }


    @Override
    public GeneralResponse saveUser(UserGeneralDTO userGeneralDTO){

        UserGeneral userGeneral= GeneralMapper.mapper(UserGeneral.class, userGeneralDTO);
        userGeneral.setRegisterDate(Timestamp.valueOf(LocalDateTime.now()));
        userGeneral.setFlag(1);
        userGeneralRepository.save(userGeneral);

        return new GeneralResponse();
    }





    @Override
    public Mono<GetResponse<UserGeneral>> getUserResponse(long id){
        return Mono.fromSupplier(()->{

            Optional<UserGeneral> userGeneralOptional= userGeneralRepository.findById(id);

            if(!userGeneralOptional.isPresent()){
                throw  new CustomException("No existe usuario", HttpStatus.BAD_REQUEST);
            }
            UserGeneral userGeneral= userGeneralOptional.get();
            return GetResponse.<UserGeneral>builder()
                        .object(userGeneral)
                        .build();

        });
    }


    @Override
    public Mono<GetResponse<UserGeneral>> gelAllUser(){
        return Mono.fromSupplier(()->{

            List<UserGeneral> listUserGeneral= userGeneralRepository.findAll();

            return GetResponse.<UserGeneral>builder().
                    list(listUserGeneral).
                    build();

        });

    }
    @Override
    public GeneralResponse updateUser(UserGeneralDTO userGeneralDTO){

        return new GeneralResponse();
    }
    @Override
    public GeneralResponse deleteUser(long id){
        GeneralResponse generalResponse = new GeneralResponse();

       if( userGeneralRepository.existsById(id)) {
           //UserGeneral userGeneral = userGeneralOptional.get();
           userGeneralRepository.deleteById(id);
           generalResponse.setMessage("User delete correctly");
           return generalResponse;
       }else{
           throw  new CustomException("User not find", HttpStatus.BAD_REQUEST);
       }

    }
    @Override
    public Mono<GetResponse<UserGeneral>> getUserName(String userName){
        return Mono.fromSupplier(()->{

            log.info(userName);
            List<UserGeneral> userGeneral= userGeneralRepository.getByUserName(userName);
            //log.info(userGeneral.get(0).getUserName());
            if(userGeneral.isEmpty()){
               throw  new CustomException("Not exist user with username= " + userName, HttpStatus.BAD_REQUEST);
            }

            return GetResponse.<UserGeneral>builder()
                    .list(userGeneral)
                    .build();

        });

    }

    @Override
    public Mono<GetResponse<UserGeneral>> getByFlag(String flag){

        return Mono.fromSupplier(()->{

            log.info(flag);
            List<UserGeneral> userGeneral= userGeneralRepository.getByFlag(flag);
            log.info(userGeneral.getFirst().getUserName());
            if(userGeneral==null){
                throw  new CustomException("Not exist user with flag: "+ flag, HttpStatus.BAD_REQUEST);
            }

            return GetResponse.<UserGeneral>builder()
                    .list(userGeneral)
                    .build();

        });
    }
}
