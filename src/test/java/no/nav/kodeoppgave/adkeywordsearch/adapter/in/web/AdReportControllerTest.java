package no.nav.kodeoppgave.adkeywordsearch.adapter.in.web;

import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.List;
import no.nav.kodeoppgave.adkeywordsearch.application.AdReportUseCase;
import no.nav.kodeoppgave.adkeywordsearch.domain.AdReportWeekly;
import no.nav.kodeoppgave.adkeywordsearch.domain.mock.MockAdReportWeekly;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class AdReportControllerTest {

  @Mock
  private AdReportUseCase adReportUseCase;

  @InjectMocks
  private AdReportController adReportController;

  @Test
  void test() {
    List<AdReportWeekly> mockAdReportWeeklyList = MockAdReportWeekly.buildList();

    when(adReportUseCase.generateWeeklyAdReportForSixLastMonths()).thenReturn(mockAdReportWeeklyList);

    List<AdReportWeeklyView> result = adReportController.getAdReportWeekly();

    Assertions.assertThat(result).hasSize(2);

    AdReportWeekly firstExpectedResult = mockAdReportWeeklyList.get(0);
    AdReportWeeklyView firstResultAdReportWeeklyView = result.get(0);
    Assertions.assertThat(firstResultAdReportWeeklyView).isNotNull();
    Assertions.assertThat(firstResultAdReportWeeklyView.getYear()).isEqualTo(firstExpectedResult.getYear());
    Assertions.assertThat(firstResultAdReportWeeklyView.getMonth()).isEqualTo(firstExpectedResult.getMonth());
    Assertions.assertThat(firstResultAdReportWeeklyView.getWeekNumber()).isEqualTo(firstExpectedResult.getWeekNumber());
    Assertions.assertThat(firstResultAdReportWeeklyView.getFirstDayOfWeek()).isEqualTo(firstExpectedResult.getFirstDayOfWeek());
    Assertions.assertThat(firstResultAdReportWeeklyView.getLastDayOfWeek()).isEqualTo(firstExpectedResult.getLastDayOfWeek());

    AdReportWeekly secondExpectedResult = mockAdReportWeeklyList.get(1);
    AdReportWeeklyView secondResultAdReportWeeklyView = result.get(1);
    Assertions.assertThat(secondResultAdReportWeeklyView.getYear()).isEqualTo(secondExpectedResult.getYear());
    Assertions.assertThat(secondResultAdReportWeeklyView.getMonth()).isEqualTo(secondExpectedResult.getMonth());
    Assertions.assertThat(secondResultAdReportWeeklyView.getWeekNumber()).isEqualTo(secondExpectedResult.getWeekNumber());
    Assertions.assertThat(secondResultAdReportWeeklyView.getFirstDayOfWeek()).isEqualTo(secondExpectedResult.getFirstDayOfWeek());
    Assertions.assertThat(secondResultAdReportWeeklyView.getLastDayOfWeek()).isEqualTo(secondExpectedResult.getLastDayOfWeek());
  }
}