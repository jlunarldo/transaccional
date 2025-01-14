package syncdata.sdt.exception;


import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import syncdata.sdt.model.reponse.ErrorResponse;

@ControllerAdvice
public class GlobalException extends RuntimeException {

@ExceptionHandler(CustomException.class)
    public ResponseEntity<ErrorResponse> handleGeneralException (CustomException ex){

    ErrorResponse errorResponse= new ErrorResponse();

    errorResponse.setErrorCode(1002);
    errorResponse.setDetail(ex.getMessage());
    return new ResponseEntity<>(errorResponse, ex.getStatus());
    }


}


