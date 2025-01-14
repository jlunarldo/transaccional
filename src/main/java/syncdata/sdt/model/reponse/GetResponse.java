package syncdata.sdt.model.reponse;


import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
@Getter
@Setter
@Builder
@Slf4j
@NoArgsConstructor
@AllArgsConstructor
public class GetResponse<T> {

    private T object;

    private List<T> list;


    //private StatusResponse
}
