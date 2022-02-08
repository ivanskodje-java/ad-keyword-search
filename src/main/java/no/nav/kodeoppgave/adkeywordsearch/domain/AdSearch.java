package no.nav.kodeoppgave.adkeywordsearch.domain;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;

public interface AdSearch {

  Iterator<List<Ad>> getAdsForInclusiveDateRange(LocalDate dayStart, LocalDate dayEnd);
}
