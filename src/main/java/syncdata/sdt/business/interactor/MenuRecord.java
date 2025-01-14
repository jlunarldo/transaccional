package syncdata.sdt.business.interactor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import syncdata.sdt.business.entities.Menu;
import syncdata.sdt.business.service.MenuService;
/**/import syncdata.sdt.business.dto.MenuDTO;
import syncdata.sdt.mapper.GeneralMapper;
import syncdata.sdt.model.reponse.GeneralResponse;
import syncdata.sdt.model.request.MenuRequest;
import syncdata.sdt.model.reponse.GetResponse;

@Service
@Slf4j
public class MenuRecord {
    @Autowired
    private MenuService menuService;

    public GeneralResponse saveMenuRequest(MenuRequest menuRequest) {
        MenuDTO menuDTO = GeneralMapper.mapper(MenuDTO.class, menuRequest);
        return menuService.saveMenu(menuDTO);
    }

    public Mono<GetResponse<Menu>> getMenuGeneralResponse(long id) {
        return menuService.getMenuResponse(id);
    }

    public Mono<GetResponse<Menu>> getAllMenu() {
        return menuService.getAllMenu();
    }

    public GeneralResponse deleteMenuResponse(long id) {
        return menuService.deleteMenu(id);
    }

    /*public Mono<GetResponse<Menu>> getFlowName(String flowName) {
        return menuService.getFlowName(flowName);
    }*/
}
