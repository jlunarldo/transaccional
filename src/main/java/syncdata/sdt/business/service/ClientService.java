package syncdata.sdt.business.service;

import reactor.core.publisher.Mono;
import syncdata.sdt.business.dto.ClientDTO;
import syncdata.sdt.business.entities.Client;
import syncdata.sdt.model.reponse.GeneralResponse;
import syncdata.sdt.model.reponse.GetResponse;

public interface ClientService {
    GeneralResponse saveClient(ClientDTO clientDTO);

    public Mono<GetResponse<Client>> getClientResponse(long id);

    public Mono<GetResponse<Client>> gelAllClient();

    public GeneralResponse updateClient(ClientDTO clientDTO);

    GeneralResponse deleteClient(long id);
}
