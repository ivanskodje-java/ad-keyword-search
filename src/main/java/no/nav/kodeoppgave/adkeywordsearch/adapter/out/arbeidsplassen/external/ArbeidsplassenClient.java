package no.nav.kodeoppgave.adkeywordsearch.adapter.out.arbeidsplassen.external;

import io.github.resilience4j.retry.annotation.Retry;
import no.nav.kodeoppgave.adkeywordsearch.adapter.out.arbeidsplassen.config.FeignConfig;
import no.nav.kodeoppgave.adkeywordsearch.adapter.out.arbeidsplassen.model.ArbeidsplassenModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "arbeidsplassen", url = "${feign.arbeidsplassen.url}", decode404 = true, configuration = FeignConfig.class)
public interface ArbeidsplassenClient {

  @Retry(name = "arbeidsplassen-client")
  @GetMapping(value = "/public-feed/api/v1/ads")
  ArbeidsplassenModel getAdsForDateRange(
      @RequestParam("published") String publishedRange,
      @RequestParam("page") int page,
      @RequestParam("size") int size);
}
