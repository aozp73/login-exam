package shop.mtcoding.login_exam.handler.ex;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class CustomException extends RuntimeException {

    private HttpStatus status;
    private String url = "";

    public CustomException(String msg, HttpStatus status) {
        super(msg);
        this.status = status;
    }

    public CustomException(String msg) {
        this(msg, HttpStatus.BAD_REQUEST);
    }

    public CustomException(String msg, String url) {
        this(msg, HttpStatus.BAD_REQUEST);
        this.url = url;
    }
}
