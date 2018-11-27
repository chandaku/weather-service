package com.mercer.assignment.weatherservice.handler;

import com.mercer.assignment.weatherservice.exception.LocationNoFoundException;
import com.mercer.assignment.weatherservice.exception.ParamNotFoundException;
import com.mercer.assignment.weatherservice.exception.PathNotFoundException;
import org.springframework.http.HttpStatus;
import reactor.core.publisher.Mono;

class ThrowableTranslator {

    private final HttpStatus httpStatus;
    private final String message;

    private ThrowableTranslator(final Throwable throwable) {
        this.httpStatus = getStatus(throwable);
        this.message = throwable.getMessage();
    }

    private HttpStatus getStatus(final Throwable error) {
        if (error instanceof PathNotFoundException) {
            return HttpStatus.NOT_FOUND;
        }else if (error instanceof ParamNotFoundException) {
            return HttpStatus.BAD_REQUEST;
        } else if (error instanceof LocationNoFoundException) {
            return HttpStatus.NOT_FOUND;
        } else {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }

    HttpStatus getHttpStatus() {
        return httpStatus;
    }

    String getMessage() {
        return message;
    }

    static <T extends Throwable> Mono<ThrowableTranslator> translate(final Mono<T> throwable) {
        return throwable.flatMap(error -> Mono.just(new ThrowableTranslator(error)));
    }
}
