package no.nav.kodeoppgave.adkeywordsearch.application;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import no.nav.kodeoppgave.adkeywordsearch.domain.AdReportWeekly;
import no.nav.kodeoppgave.adkeywordsearch.util.aop.LogRunTime;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
class AdReportReportService implements AdReportUseCase {

  private final GenerateAdReportWeeklyUseCase generateAdReportWeeklyUseCase;

  @LogRunTime
  @Override
  public List<AdReportWeekly> generateWeeklyAdReportForSixLastMonths() {
    return generateAdReportWeeklyUseCase.generateWeeklyAdReportForSixLastMonths();
  }
}
