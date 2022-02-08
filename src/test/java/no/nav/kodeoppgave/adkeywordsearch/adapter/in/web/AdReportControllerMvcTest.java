package no.nav.kodeoppgave.adkeywordsearch.adapter.in.web;

import static org.mockito.Mockito.verify;

import no.nav.kodeoppgave.adkeywordsearch.application.AdReportUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = AdReportController.class)
class AdReportControllerMvcTest {

  @MockBean
  AdReportUseCase adReportUseCase;

  @Autowired
  private MockMvc mockMvc;

  @Test
  void validInput_adReportUseCaseRuns_returns200() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/ad/weekly-report")
            .contentType(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(MockMvcResultMatchers.status().isOk());

    verify(adReportUseCase).generateWeeklyAdReportForSixLastMonths();
  }
}