package me.kanezheng.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by
 *
 * @author kane
 * @date 2018/8/22
 */

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MicroServiceNotFoundException extends RuntimeException {
    public MicroServiceNotFoundException(String exception) {
        super(exception);
    }
}
