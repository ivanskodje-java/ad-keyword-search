package no.nav.kodeoppgave.adkeywordsearch.domain.mock;

import java.time.LocalDate;
import java.util.List;
import no.nav.kodeoppgave.adkeywordsearch.domain.AdReportWeekly;

public class MockAdReportWeekly {

  public static List<AdReportWeekly> buildList() {
    return List.of(
        AdReportWeekly.builder()
            .year(2021)
            .month(7)
            .weekNumber(31)
            .firstDayOfWeek(LocalDate.of(2021, 8, 2))
            .lastDayOfWeek(LocalDate.of(2021, 8, 8))
            .build(),
        AdReportWeekly.builder()
            .year(2021)
            .month(7)
            .weekNumber(32)
            .firstDayOfWeek(LocalDate.of(2021, 8, 9))
            .lastDayOfWeek(LocalDate.of(2021, 8, 15))
            .build());
  }

}
