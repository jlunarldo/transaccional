package syncdata.sdt.business.service;

import reactor.core.publisher.Mono;
import syncdata.sdt.business.dto.MenuDTO;
import syncdata.sdt.business.entities.Menu;
import syncdata.sdt.model.reponse.GeneralResponse;
import syncdata.sdt.model.reponse.GetResponse;

public interface MenuService {

    GeneralResponse saveMenu(MenuDTO menuDTO);



    public Mono<GetResponse<Menu>> getMenuResponse(long id);


    public Mono<GetResponse<Menu>> getAllMenu();

    public GeneralResponse updateMenu(MenuDTO menuDTO);
    GeneralResponse deleteMenu(long id);

    //public Mono<GetResponse<Menu>> getFlowName(String flowName);

    //public Mono<GetResponse<Menu>> getByFlag(String flag);
}
