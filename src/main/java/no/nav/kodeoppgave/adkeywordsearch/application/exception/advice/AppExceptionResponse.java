package no.nav.kodeoppgave.adkeywordsearch.application.exception.advice;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import no.nav.kodeoppgave.adkeywordsearch.application.exception.ErrorCode;

@Getter
@RequiredArgsConstructor
class AppExceptionResponse {

  private final int httpStatusCode;
  private final String reason;

  public AppExceptionResponse(ErrorCode errorCode) {
    this.httpStatusCode = errorCode.getHttpStatusCode();
    this.reason = errorCode.getReason();
  }
}
