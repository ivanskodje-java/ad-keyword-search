package no.nav.kodeoppgave.adkeywordsearch.application;

import java.sql.Date;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import no.nav.kodeoppgave.adkeywordsearch.application.aop.UseCase;
import no.nav.kodeoppgave.adkeywordsearch.domain.Ad;
import no.nav.kodeoppgave.adkeywordsearch.domain.AdReportWeekly;
import no.nav.kodeoppgave.adkeywordsearch.domain.AdSearch;


@Slf4j
@UseCase
@RequiredArgsConstructor
class GenerateAdReportWeeklyUseCase {

  private static final String KEYWORD_KOTLIN = "kotlin";
  private static final String KEYWORD_JAVA = "java";
  private static final int DAYS_UNTIL_NEXT_MONDAY = 7;
  private static final int DAYS_UNTIL_NEXT_SUNDAY = 6;

  private final AdSearch adSearch;

  public List<AdReportWeekly> generateWeeklyAdReportForSixLastMonths() {
    List<AdReportWeekly> adReportWeeklyList = new ArrayList<>();
    appendToAdReportForEachWeek(adReportWeeklyList);
    return adReportWeeklyList;
  }

  private void appendToAdReportForEachWeek(List<AdReportWeekly> adReportWeeklyList) {
    LocalDate today = LocalDate.now();
    LocalDate mondaySixMonthsAgo = getMondaySixMonthsAgo(today);

    for (LocalDate monday = mondaySixMonthsAgo; monday.isBefore(today); monday = monday.plusDays(DAYS_UNTIL_NEXT_MONDAY)) {
      AdReportWeekly adReportWeekly = createAdReportWeekly(monday);

      Iterator<List<Ad>> adsIterator = getAdsForWeekStart(monday);
      adsIterator.forEachRemaining(ads -> addCountedKeywordsForAdReportWeekly(adReportWeekly, ads));

      adReportWeeklyList.add(adReportWeekly);
    }
  }

  private Iterator<List<Ad>> getAdsForWeekStart(LocalDate monday) {
    return adSearch.getAdsForInclusiveDateRange(monday, monday.plusDays(DAYS_UNTIL_NEXT_SUNDAY));
  }

  private void addCountedKeywordsForAdReportWeekly(AdReportWeekly adReportWeekly, List<Ad> ads) {
    for (Ad ad : ads) {
      String title = ad.getTitle().toLowerCase();
      String description = ad.getDescription().toLowerCase();
      if (title.contains(KEYWORD_KOTLIN) || description.contains(KEYWORD_KOTLIN)) {
        adReportWeekly.addKeywordMention(KEYWORD_KOTLIN);
      }
      if (title.contains(KEYWORD_JAVA) || description.contains(KEYWORD_JAVA)) {
        adReportWeekly.addKeywordMention(KEYWORD_JAVA);
      }
    }
  }

  private AdReportWeekly createAdReportWeekly(LocalDate monday) {
    Calendar calendar = getCalendarForTheWeek(monday);
    return AdReportWeekly.builder()
        .year(calendar.get(Calendar.YEAR))
        .month(calendar.get(Calendar.MONTH))
        .weekNumber(calendar.get(Calendar.WEEK_OF_YEAR))
        .firstDayOfWeek(monday)
        .lastDayOfWeek(monday.plusDays(DAYS_UNTIL_NEXT_SUNDAY))
        .build();
  }

  private Calendar getCalendarForTheWeek(LocalDate monday) {
    Calendar calendar = Calendar.getInstance(Locale.forLanguageTag("nb-NO"));
    calendar.setTime(Date.valueOf(monday));
    return calendar;
  }

  private LocalDate getMondaySixMonthsAgo(LocalDate today) {
    LocalDate sixMonthsAgo = today.minusMonths(6);
    return getFirstDayOfWeek(sixMonthsAgo);
  }

  private LocalDate getFirstDayOfWeek(LocalDate day) {
    return day.with(TemporalAdjusters.previous(DayOfWeek.MONDAY));
  }
}
