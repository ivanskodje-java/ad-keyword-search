package no.nav.kodeoppgave.adkeywordsearch.adapter.out.arbeidsplassen.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdModel {

  private String title;
  private String description;
}
