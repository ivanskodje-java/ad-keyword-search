package no.nav.kodeoppgave.adkeywordsearch.application.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum AppErrorCode implements ErrorCode {

  INTERNAL_SERVER_ERROR(500, "Internal Server Error"),
  AUTH_HEADER_MISSING(401, "Authentication header is missing");

  private int httpStatusCode;
  private String reason;
}
