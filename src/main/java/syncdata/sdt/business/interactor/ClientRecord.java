package syncdata.sdt.business.interactor;

import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Mono;
import syncdata.sdt.business.dto.ClientDTO;
import syncdata.sdt.business.entities.Client;
import syncdata.sdt.business.service.ClientService;
import syncdata.sdt.mapper.GeneralMapper;
import syncdata.sdt.model.reponse.GeneralResponse;
import syncdata.sdt.model.reponse.GetResponse;
import syncdata.sdt.model.request.ClientRequest;

public class ClientRecord {

   /* @Autowired
    private ClientService clientService;

    public GeneralResponse saveClientRequest(ClientRequest clientRequest){

        ClientDTO clientDTO= GeneralMapper.mapper(ClientDTO.class, clientRequest);

        return clientService.saveClient(clientDTO);

    }
    public Mono<GetResponse<Client>> getClientResponse(long id){

        return menuService.getClientResponse(id);
    }

    public Mono<GetResponse<Client>> getAllClient(){
        return clientService.gelAllClient();
    }
    public GeneralResponse deleteClientReponse(long id){
        return clientService.deleteClient(id);
    }*/
}
