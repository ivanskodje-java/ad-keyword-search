package no.nav.kodeoppgave.adkeywordsearch.application.exception;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class AppException extends RuntimeException {

  private final ErrorCode errorCode;

  public AppException(ErrorCode errorCode) {
    this.errorCode = errorCode;
    logAppException();
  }

  private void logAppException() {
    if (is5xxError()) {
      log.error(buildErrorMessage());
    } else {
      log.debug(buildErrorMessage());
    }
  }

  private boolean is5xxError() {
    return 500 <= errorCode.getHttpStatusCode() && errorCode.getHttpStatusCode() < 600;
  }

  private String buildErrorMessage() {
    return String.format("AppException [%s] %s", errorCode.getHttpStatusCode(), errorCode.getReason());
  }
}
