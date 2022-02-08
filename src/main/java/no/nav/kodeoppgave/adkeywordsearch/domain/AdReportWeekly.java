package no.nav.kodeoppgave.adkeywordsearch.domain;

import static java.util.Objects.isNull;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdReportWeekly {

  private int year;
  private int month;
  private int weekNumber;
  private LocalDate firstDayOfWeek;
  private LocalDate lastDayOfWeek;
  private Map<String, Integer> keywordMentions;

  public void addKeywordMention(String keyword) {
    initKeywordMentionsIfNull();
    keywordMentions.put(keyword, getIncrementedMentionCount(keyword));
  }

  private int getIncrementedMentionCount(String keyword) {
    int mentionCount = 0;
    if (keywordMentions.containsKey(keyword)) {
      mentionCount = keywordMentions.get(keyword);
    }
    return ++mentionCount;
  }

  private void initKeywordMentionsIfNull() {
    if (isNull(keywordMentions)) {
      keywordMentions = new HashMap<>();
    }
  }
}
