package syncdata.sdt.business.interactor;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import syncdata.sdt.business.entities.UserGeneral;
import syncdata.sdt.business.service.UserService;
import syncdata.sdt.business.dto.UserGeneralDTO;
import syncdata.sdt.mapper.GeneralMapper;
import syncdata.sdt.model.reponse.GeneralResponse;
import syncdata.sdt.model.request.UserRequest;
import syncdata.sdt.model.reponse.GetResponse;

@Service
@Slf4j
public class UserRecord {
    @Autowired
    private UserService userService;



    public Mono<GetResponse<UserGeneral>> getUserGeneralResponse(long id){

        return userService.getUserResponse(id);
    }

    public Mono<GetResponse<UserGeneral>> gelAllUser(){
        return userService.gelAllUser();
    }

    public GeneralResponse deleteUserReponse(long id){
        return userService.deleteUser(id);
    }

    public Mono<GetResponse<UserGeneral>> getUserName(String userName){
        return userService.getUserName(userName);
    }

    public Mono<GetResponse<UserGeneral>> getflag(String flag){
        return userService.getByFlag(flag);
    }

    public GeneralResponse saveUserRequest(UserRequest userRequest){

        UserGeneralDTO userGeneralDTO= GeneralMapper.mapper(UserGeneralDTO.class, userRequest);

        return userService.saveUser(userGeneralDTO);

    }
}
