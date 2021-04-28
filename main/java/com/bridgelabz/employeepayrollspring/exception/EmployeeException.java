package com.bridgelabz.employeepayrollspring.exception;

import com.bridgelabz.employeepayrollspring.DTO.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class EmployeeException extends RuntimeException{

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDTO> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException exception){
        List<ObjectError> errorList=exception.getBindingResult().getAllErrors();
        List<String> errMsg =errorList.stream()
                .map(objectError -> objectError.getDefaultMessage())
                .collect(Collectors.toList());
        ResponseDTO responseDTO =
                new ResponseDTO("Exception while processing the Rest request",errMsg);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.BAD_REQUEST);
        }
}

//@ControllerAdvice
//public class EmployeeControllerValidation extends ResponseEntityExceptionHandler {
//
//    @Override
//    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
//                                                                  HttpHeaders headers,
//                                                                  HttpStatus status,
//                                                                  WebRequest request) {
//        String errorMsg = ex.getBindingResult().getAllErrors().get(0).getDefaultMessage();
//        return new ResponseEntity<>(
//                new ResponseDTO(null, errorMsg),
//                HttpStatus.BAD_REQUEST);
//    }
//}



//    private final exceptionType type;
//
//    public EmployeeException(exceptionType type,String message) {
//        super(message);
//        this.type = type;
//    }
//
//public enum exceptionType {
//    EMPLOYEE_NOT_FOUND,
//}