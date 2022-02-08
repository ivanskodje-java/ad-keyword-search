package no.nav.kodeoppgave.adkeywordsearch.application.exception;

public interface ErrorCode {

  int getHttpStatusCode();

  String getReason();

}
