package no.nav.kodeoppgave.adkeywordsearch.application.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(value = "ad-keyword-search")
public class AdKeywordSearchProperties {

  private int defaultPageSize;
}
