package no.nav.kodeoppgave.adkeywordsearch;

import java.time.ZoneOffset;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;
import lombok.extern.slf4j.Slf4j;
import no.nav.kodeoppgave.adkeywordsearch.application.properties.AdKeywordSearchProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;

@Slf4j
@EnableFeignClients
@SpringBootApplication(exclude = {
    org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class}
)
@EnableConfigurationProperties({AdKeywordSearchProperties.class})
public class Main {

  public static void main(String[] args) {
    setupTimeZone();
    SpringApplication springApplication = new SpringApplication(Main.class);
    populateDefaultProperties(springApplication);
    springApplication.run(args);
  }

  private static void setupTimeZone() {
    TimeZone.setDefault(TimeZone.getTimeZone(ZoneOffset.UTC));
    log.info("Default time zone set to UTC");
  }

  private static void populateDefaultProperties(SpringApplication springApplication) {
    Map<String, Object> properties = new HashMap<>();
    properties.put("spring.profiles.default", "dev");
    springApplication.setDefaultProperties(properties);
  }

}
