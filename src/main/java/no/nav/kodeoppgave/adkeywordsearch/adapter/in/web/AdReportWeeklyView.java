package no.nav.kodeoppgave.adkeywordsearch.adapter.in.web;

import java.time.LocalDate;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import no.nav.kodeoppgave.adkeywordsearch.domain.AdReportWeekly;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class AdReportWeeklyView {

  private int year;
  private int month;
  private int weekNumber;
  private LocalDate firstDayOfWeek;
  private LocalDate lastDayOfWeek;
  private Map<String, Integer> keywordMentions;

  public static AdReportWeeklyView from(AdReportWeekly adReportWeekly) {
    return AdReportWeeklyView.builder()
        .year(adReportWeekly.getYear())
        .month(adReportWeekly.getMonth())
        .weekNumber(adReportWeekly.getWeekNumber())
        .firstDayOfWeek(adReportWeekly.getFirstDayOfWeek())
        .lastDayOfWeek(adReportWeekly.getLastDayOfWeek())
        .keywordMentions(adReportWeekly.getKeywordMentions())
        .build();
  }
}
