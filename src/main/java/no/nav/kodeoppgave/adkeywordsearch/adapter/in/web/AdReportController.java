package no.nav.kodeoppgave.adkeywordsearch.adapter.in.web;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import no.nav.kodeoppgave.adkeywordsearch.application.AdReportUseCase;
import no.nav.kodeoppgave.adkeywordsearch.domain.AdReportWeekly;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ad")
public class AdReportController {

  private final AdReportUseCase adReportUseCase;

  @GetMapping("/weekly-report")
  public List<AdReportWeeklyView> getAdReportWeekly() {
    List<AdReportWeekly> adReportWeeklies = adReportUseCase.generateWeeklyAdReportForSixLastMonths();
    return adReportWeeklies.stream().map(AdReportWeeklyView::from).toList();
  }
}
