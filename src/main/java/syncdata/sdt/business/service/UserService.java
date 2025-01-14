package syncdata.sdt.business.service;

import reactor.core.publisher.Mono;
import syncdata.sdt.business.dto.UserGeneralDTO;
import syncdata.sdt.business.entities.UserGeneral;
import syncdata.sdt.model.reponse.GeneralResponse;
import syncdata.sdt.model.reponse.GetResponse;

public interface UserService {

    GeneralResponse saveUser(UserGeneralDTO userGeneralDTO);

    Mono<GetResponse<UserGeneral>> getUserResponse(long id);

    GeneralResponse updateUser(UserGeneralDTO userGeneralDTO);

    GeneralResponse deleteUser(long id);

    Mono<GetResponse<UserGeneral>> gelAllUser();

    Mono<GetResponse<UserGeneral>> getUserName(String userName);

    Mono<GetResponse<UserGeneral>> getByFlag(String userName);
}
