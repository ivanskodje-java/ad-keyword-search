package no.nav.kodeoppgave.adkeywordsearch.adapter.out.arbeidsplassen.config;

import feign.RequestInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;

@Slf4j
public class FeignConfig {

  @Bean
  public RequestInterceptor requestInterceptor() {
    return new FeignInterceptor();
  }

}
