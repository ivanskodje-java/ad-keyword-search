package no.nav.kodeoppgave.adkeywordsearch.adapter.out.arbeidsplassen.config;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;
import no.nav.kodeoppgave.adkeywordsearch.application.exception.AppErrorCode;
import no.nav.kodeoppgave.adkeywordsearch.application.exception.AppException;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Slf4j
class FeignInterceptor implements RequestInterceptor {

  private static final String AUTH_HEADER = "Authorization";

  @Override
  public void apply(RequestTemplate requestTemplate) {
    String token = getBearerTokenHeader();
    requestTemplate.header(AUTH_HEADER, token);
  }

  private String getBearerTokenHeader() {
    ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
    if (nonNull(requestAttributes)) {
      var request = requestAttributes.getRequest();
      String token = request.getHeader(AUTH_HEADER);
      if (isNull(token)) {
        log.debug("Token was not set in header");
        throw new AppException(AppErrorCode.AUTH_HEADER_MISSING);
      }
      return token;
    }
    throw new AppException(AppErrorCode.INTERNAL_SERVER_ERROR);
  }
}
