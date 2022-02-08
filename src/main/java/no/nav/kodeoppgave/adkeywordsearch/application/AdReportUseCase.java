package no.nav.kodeoppgave.adkeywordsearch.application;

import java.util.List;
import no.nav.kodeoppgave.adkeywordsearch.domain.AdReportWeekly;

public interface AdReportUseCase {

  List<AdReportWeekly> generateWeeklyAdReportForSixLastMonths();
}
