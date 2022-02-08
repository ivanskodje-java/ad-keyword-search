package no.nav.kodeoppgave.adkeywordsearch.adapter.out.arbeidsplassen.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ArbeidsplassenModel {

  private List<AdModel> content;
  private boolean last;
}
