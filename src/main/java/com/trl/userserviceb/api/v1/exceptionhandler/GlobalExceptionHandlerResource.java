package com.trl.userserviceb.api.v1.exceptionhandler;

import com.trl.userserviceb.core.model.ApiErrorDto;
import com.trl.userserviceb.core.service.DateTimeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Collection;
import java.util.stream.Collectors;

import static com.trl.userserviceb.util.WebUtil.getFullRequestUri;

@RestControllerAdvice
public class GlobalExceptionHandlerResource extends ResponseEntityExceptionHandler {

    private static final Logger LOG = LoggerFactory.getLogger(GlobalExceptionHandlerResource.class);

    private final DateTimeService dateTimeService;

    public GlobalExceptionHandlerResource(DateTimeService dateTimeService) {
        this.dateTimeService = dateTimeService;
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ApiErrorDto> handleConstraintViolationException(ConstraintViolationException e) {
        LOG.warn("In handleConstraintViolationException - {}", e.getMessage());

        ApiErrorDto error = createApiError(buildMessageFromConstraintViolations(e.getConstraintViolations()));

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    private String buildMessageFromConstraintViolations(Collection<ConstraintViolation<?>> violations) {
        return violations.stream().map(ConstraintViolation::getMessage).collect(Collectors.joining(", "));
    }

    private ApiErrorDto createApiError(String errorMessage) {
        return new ApiErrorDto.Builder()
                .withTimestamp(dateTimeService.now())
                .withErrorMessage(errorMessage)
                .withPath(getFullRequestUri())
                .build();
    }

}
