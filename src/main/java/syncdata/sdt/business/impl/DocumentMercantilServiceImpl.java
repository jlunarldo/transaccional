package syncdata.sdt.business.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
/*import syncdata.sdt.business.dto.DocumentMercantilDTO;
import syncdata.sdt.business.entities.DocumentMercantil;
import syncdata.sdt.business.repository.DocumentMercantilRepository;
import syncdata.sdt.business.service.DocumentMercantilService;
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
public class DocumentMercantilServiceImpl implements DocumentMercantilService {

    @Autowired
    private DocumentMercantilRepository documentMercantilRepository;

    @Override
    public GeneralResponse saveDocumentMercantil(DocumentMercantilDTO documentMercantilDTO){

        DocumentMercantil documentMercantil = GeneralMapper.mapper(DocumentMercantil.class, documentMercantilDTO);
        documentMercantil.setRegisterDate(Timestamp.valueOf(LocalDateTime.now()));
        documentMercantil.setFlag(1);
        documentMercantilRepository.save(documentMercantil);

        return new GeneralResponse();
    }

    @Override
    public Mono<GetResponse<DocumentMercantil>> getDocumentMercantilResponse(long id){
        return Mono.fromSupplier(() -> {

            Optional<DocumentMercantil> documentMercantilOptional = documentMercantilRepository.findById(id);

            if (!documentMercantilOptional.isPresent()) {
                throw new GeneralException("No existe documento mercantil");
            }
            DocumentMercantil documentMercantil = documentMercantilOptional.get();
            return GetResponse.<DocumentMercantil>builder()
                    .object(documentMercantil)
                    .build();

        });
    }

    @Override
    public Mono<GetResponse<DocumentMercantil>> getAllDocumentMercantil(){
        return Mono.fromSupplier(() -> {

            List<DocumentMercantil> listDocumentMercantil = documentMercantilRepository.findAll();

            return GetResponse.<DocumentMercantil>builder()
                    .list(listDocumentMercantil)
                    .build();

        });
    }

    @Override
    public GeneralResponse updateDocumentMercantil(DocumentMercantilDTO documentMercantilDTO){

        return new GeneralResponse();
    }

    @Override
    public GeneralResponse deleteDocumentMercantil(long id){
        GeneralResponse generalResponse = new GeneralResponse();

        if (documentMercantilRepository.existsById(id)) {

            documentMercantilRepository.deleteById(id);
            generalResponse.setMessage("Documento mercantil se ha eliminado correctamente ");
            return generalResponse;
        } else {
            generalResponse.setMessage("No se ha encontrado documento mercantil");
            return generalResponse;
        }
    }
}
*/