package no.nav.kodeoppgave.adkeywordsearch.application.exception.config;

import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class ErrorAttributesConfiguration {

  @Bean
  public ErrorAttributes errorAttributes() {
    return new CustomErrorAttributes();
  }
}