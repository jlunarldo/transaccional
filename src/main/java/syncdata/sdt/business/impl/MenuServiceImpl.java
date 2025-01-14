package syncdata.sdt.business.impl;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import syncdata.sdt.business.service.MenuService;
import syncdata.sdt.business.dto.MenuDTO;
import syncdata.sdt.business.entities.Menu;
import syncdata.sdt.business.repository.MenuRepository;
import syncdata.sdt.exception.CustomException;
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
public class MenuServiceImpl implements MenuService {

    private final MenuRepository menuRepository;

    public MenuServiceImpl(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    @Override
    public GeneralResponse saveMenu(MenuDTO menuDTO) {
        Menu menu = GeneralMapper.mapper(Menu.class, menuDTO);
        menu.setRegisterDate(Timestamp.valueOf(LocalDateTime.now()));
        menu.setFlag(1);
        menuRepository.save(menu);

        return new GeneralResponse();
    }

    @Override
    public Mono<GetResponse<Menu>> getMenuResponse(long id) {
        return Mono.fromSupplier(() -> {
            Optional<Menu> menuOptional = menuRepository.findById(id);
            if (!menuOptional.isPresent()) {
                throw new CustomException("No existe menu", HttpStatus.BAD_REQUEST);
            }
            Menu menu = menuOptional.get();
            return GetResponse.<Menu>builder()
                    .object(menu)
                    .build();
        });
    }

    @Override
    public Mono<GetResponse<Menu>> getAllMenu() {
        return Mono.fromSupplier(() -> {
            List<Menu> listMenu = menuRepository.findAll();
            return GetResponse.<Menu>builder()
                    .list(listMenu)
                    .build();
        });
    }

    @Override
    public GeneralResponse updateMenu(MenuDTO menuDTO) {
        return new GeneralResponse();
    }

    @Override
    public GeneralResponse deleteMenu(long id) {
        GeneralResponse generalResponse = new GeneralResponse();

        if (menuRepository.existsById(id)) {
            menuRepository.deleteById(id);
            generalResponse.setMessage("Menu deleted correctly");
            return generalResponse;
        } else {
            throw new CustomException("Menu not found", HttpStatus.BAD_REQUEST);
        }
    }

    /*@Override
    public Mono<GetResponse<Menu>> getFlowName(String flowName) {
        return Mono.fromSupplier(() -> {
            log.info(flowName);
            List<Menu> menus = menuRepository.getByFlowName(flowName);
            if (menus.isEmpty()) {
                throw new CustomException("No existe menu con flowName= " + flowName, HttpStatus.BAD_REQUEST);
            }

            return GetResponse.<Menu>builder()
                    .list(menus)
                    .build();
        });
    }

    @Override
    public Mono<GetResponse<Menu>> getByFlag(String flag) {
        return Mono.fromSupplier(() -> {
            log.info(flag);
            List<Menu> menus = menuRepository.getByFlag(flag);
            if (menus == null || menus.isEmpty()) {
                throw new CustomException("No existe menu con flag: " + flag, HttpStatus.BAD_REQUEST);
            }

            return GetResponse.<Menu>builder()
                    .list(menus)
                    .build();
        });
    }*/
}
