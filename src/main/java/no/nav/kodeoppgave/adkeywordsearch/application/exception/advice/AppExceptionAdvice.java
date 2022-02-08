package no.nav.kodeoppgave.adkeywordsearch.application.exception.advice;

import no.nav.kodeoppgave.adkeywordsearch.application.exception.AppException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
class AppExceptionAdvice {

  @ExceptionHandler(AppException.class)
  private ResponseEntity<AppExceptionResponse> appExceptionAdvice(AppException appException) {
    AppExceptionResponse response = new AppExceptionResponse(appException.getErrorCode());
    return ResponseEntity.status(response.getHttpStatusCode()).body(response);
  }
}
