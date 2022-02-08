package no.nav.kodeoppgave.adkeywordsearch.application.exception.config;

import java.util.Map;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.error.ErrorAttributeOptions.Include;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.web.context.request.WebRequest;

class CustomErrorAttributes extends DefaultErrorAttributes {

  @Override
  public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions errorAttributeOptions) {
    Map<String, Object> errorAttributes = super.getErrorAttributes(webRequest, ErrorAttributeOptions.of(Include.MESSAGE));
    int httpStatus = (int) errorAttributes.getOrDefault("status", 500);
    return Map.of("HTTP Status", httpStatus);
  }
}
