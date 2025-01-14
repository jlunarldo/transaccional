package syncdata.sdt.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serial;

@AllArgsConstructor
@Getter
public class GeneralException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;
    private final String msg;



}
