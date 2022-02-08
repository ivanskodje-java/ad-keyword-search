package no.nav.kodeoppgave.adkeywordsearch.adapter.out.arbeidsplassen;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import no.nav.kodeoppgave.adkeywordsearch.adapter.out.arbeidsplassen.external.ArbeidsplassenClient;
import no.nav.kodeoppgave.adkeywordsearch.adapter.out.arbeidsplassen.model.AdModel;
import no.nav.kodeoppgave.adkeywordsearch.adapter.out.arbeidsplassen.model.ArbeidsplassenModel;
import no.nav.kodeoppgave.adkeywordsearch.application.properties.AdKeywordSearchProperties;
import no.nav.kodeoppgave.adkeywordsearch.domain.Ad;
import no.nav.kodeoppgave.adkeywordsearch.domain.AdSearch;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class AdSearchAdapter implements AdSearch {

  private final ArbeidsplassenClient arbeidsplassenClient;
  private final AdKeywordSearchProperties adKeywordSearchProperties;

  @Override
  public Iterator<List<Ad>> getAdsForInclusiveDateRange(
      @DateTimeFormat(iso = ISO.DATE) LocalDate dayStart,
      @DateTimeFormat(iso = ISO.DATE) LocalDate dayEnd) {

    String dateFilter = getInclusiveDateFilter(dayStart, dayEnd);
    int pageSize = adKeywordSearchProperties.getDefaultPageSize();
    return new AdIterator(dateFilter, pageSize);
  }

  private String getInclusiveDateFilter(LocalDate dayStart, LocalDate dayEnd) {
    return "(" + dayStart + "," + dayEnd + ")";
  }


  private class AdIterator implements Iterator<List<Ad>> {

    private final int size;
    private final String dateFilter;
    private int page;
    private boolean hasNext = true;

    public AdIterator(String dateFilter, int pageSize) {
      this.dateFilter = dateFilter;
      page = 0;
      size = pageSize;
    }

    @Override
    public boolean hasNext() {
      return hasNext;
    }

    @Override
    public List<Ad> next() {

      if (!hasNext()) {
        throw new NoSuchElementException("Last Ad page reached");
      }

      ArbeidsplassenModel model = arbeidsplassenClient.getAdsForDateRange(dateFilter, page, size);

      hasNext = !model.isLast();
      page++;

      return mapModelToAdList(model);
    }

    public List<Ad> mapModelToAdList(ArbeidsplassenModel arbeidsplassenModel) {
      List<AdModel> adModelList = arbeidsplassenModel.getContent();
      return adModelList.stream().map(this::mapAdModelToAd).toList();
    }

    private Ad mapAdModelToAd(AdModel adModel) {
      return Ad.builder().title(adModel.getTitle()).description(adModel.getDescription()).build();
    }
  }

}
