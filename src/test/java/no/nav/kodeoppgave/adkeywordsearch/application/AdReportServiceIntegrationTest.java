package no.nav.kodeoppgave.adkeywordsearch.application;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import no.nav.kodeoppgave.adkeywordsearch.domain.AdReportWeekly;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

@Disabled("For manual testing")
@Slf4j
@SpringBootTest
@ComponentScan("no.nav.kodeoppgave.adkeywordsearch")
class AdReportServiceIntegrationTest {

  @Autowired
  private AdReportReportService adReportService;

  @Test
  void getNumberOfAdsWithKotlinOrJavaForLastHalfYear() {
    List<AdReportWeekly> result = adReportService.generateWeeklyAdReportForSixLastMonths();
    log.info("result size {}", result);
    assertNotNull(result);
  }
}