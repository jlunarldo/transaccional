package syncdata.sdt.model.reponse;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ErrorResponse {

    private int errorCode;

    private String detail;

}
