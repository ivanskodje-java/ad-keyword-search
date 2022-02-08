package no.nav.kodeoppgave.adkeywordsearch.application;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Iterator;
import java.util.List;
import no.nav.kodeoppgave.adkeywordsearch.domain.Ad;
import no.nav.kodeoppgave.adkeywordsearch.domain.AdReportWeekly;
import no.nav.kodeoppgave.adkeywordsearch.domain.AdSearch;
import no.nav.kodeoppgave.adkeywordsearch.domain.mock.MockAd;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class GenerateAdReportWeeklyUseCaseTest {

  @InjectMocks
  private GenerateAdReportWeeklyUseCase generateAdReportWeeklyUseCase;

  @Mock
  private AdSearch adSearch;

  @Test
  void generateWeeklyAdReportForSixLastMonths_expectAdIteration_toContainJavaKeywordMention() {
    Iterator<List<Ad>> adIterator = List.of(MockAd.buildList()).iterator();
    when(adSearch.getAdsForInclusiveDateRange(any(), any())).thenReturn(adIterator);

    List<AdReportWeekly> result = generateAdReportWeeklyUseCase.generateWeeklyAdReportForSixLastMonths();

    assertThat(result).isNotNull();
    assertThat(result.get(0)).isNotNull();
    assertThat(result.get(0).getKeywordMentions()).containsKey("java");
  }
}