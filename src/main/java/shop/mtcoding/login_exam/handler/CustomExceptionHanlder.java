package shop.mtcoding.login_exam.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import shop.mtcoding.login_exam.dto.ResponseDto;
import shop.mtcoding.login_exam.handler.ex.CustomApiException;
import shop.mtcoding.login_exam.handler.ex.CustomException;
import shop.mtcoding.login_exam.util.Script;

@RestControllerAdvice
public class CustomExceptionHanlder {

    // NullPointException <- RuntimeException
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<?> customException(CustomException e) {
        String responseBody = "";
        if (!e.getUrl().equals("")) {
            responseBody = Script.back(e.getMessage(), e.getUrl());
            return new ResponseEntity<>(responseBody, e.getStatus());
        }
        responseBody = Script.back(e.getMessage());
        return new ResponseEntity<>(responseBody, e.getStatus());
    }

    @ExceptionHandler(CustomApiException.class)
    public ResponseEntity<?> customApiException(CustomApiException e) {
        return new ResponseEntity<>(new ResponseDto<>(-1, e.getMessage(), null), e.getStatus());
    }

}
