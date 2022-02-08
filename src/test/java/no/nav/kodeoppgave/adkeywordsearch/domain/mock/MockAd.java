package no.nav.kodeoppgave.adkeywordsearch.domain.mock;

import java.util.List;
import no.nav.kodeoppgave.adkeywordsearch.domain.Ad;

public class MockAd {

  public static List<Ad> buildList() {
    return List.of(Ad.builder()
            .title("Konsulent søkes")
            .description("En solid konsulent søkes til en Java jobb!")
            .build(),
        Ad.builder()
            .title("Jobbtilbud")
            .description("En jobb beskrivelse hær")
            .build());
  }
}
