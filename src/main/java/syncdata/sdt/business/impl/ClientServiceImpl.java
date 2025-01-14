package syncdata.sdt.business.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import syncdata.sdt.business.dto.ClientDTO;
import syncdata.sdt.business.entities.Client;
import syncdata.sdt.business.repository.ClientRepository;
import syncdata.sdt.business.service.ClientService;
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
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientRepository clientRepository;

    @Override
    public GeneralResponse saveClient(ClientDTO clientDTO){

        Client client= GeneralMapper.mapper(Client.class, clientDTO);
        client.setRegisterDate(Timestamp.valueOf(LocalDateTime.now()));
        client.setFlag(1);
        clientRepository.save(client);

        return new GeneralResponse();
    }



    @Override
    public Mono<GetResponse<Client>> getClientResponse(long id){
        return Mono.fromSupplier(()->{

            Optional<Client> clientOptional= clientRepository.findById(id);

            if(!clientOptional.isPresent()){
                throw new GeneralException("No existe usuario");
            }
            Client client= clientOptional.get();
            return GetResponse.<Client>builder()
                    .object(client)
                    .build();

        });
    }


    @Override
    public Mono<GetResponse<Client>> gelAllClient(){
        return Mono.fromSupplier(()->{

            List<Client> listClient= clientRepository.findAll();

            return GetResponse.<Client>builder().
                    list(listClient).
                    build();

        });

    }

    @Override
    public GeneralResponse updateClient(ClientDTO clientDTO){

        return new GeneralResponse();
    }

    @Override
    public GeneralResponse deleteClient(long id){
        GeneralResponse generalResponse = new GeneralResponse();

        if( clientRepository.existsById(id)) {

            clientRepository.deleteById(id);
            generalResponse.setMessage("User se ha eliminado correctamente ");
            return generalResponse;
        }else{
            generalResponse.setMessage("No se ha encontrado User");
            return generalResponse;
        }

    }
}
