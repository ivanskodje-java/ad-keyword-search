package no.nav.kodeoppgave.adkeywordsearch.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Map;
import org.junit.jupiter.api.Test;

class AdReportWeeklyTest {

  @Test
  void adReportWeekly_keywordMentionIsNull() {
    AdReportWeekly adReportWeekly = new AdReportWeekly();

    assertNull(adReportWeekly.getKeywordMentions());
  }

  @Test
  void adReportWeekly_keywordMentionHasOneJava() {
    AdReportWeekly adReportWeekly = new AdReportWeekly();

    adReportWeekly.addKeywordMention("java");

    Map<String, Integer> keywordMentions = adReportWeekly.getKeywordMentions();
    assertNotNull(keywordMentions);
    assertThat(keywordMentions).containsKey("java");
    assertThat(keywordMentions.get("java")).isOne();
  }

  @Test
  void adReportWeekly_keywordMentionHasOneJava_andTwoKotlin() {
    AdReportWeekly adReportWeekly = new AdReportWeekly();

    adReportWeekly.addKeywordMention("java");
    adReportWeekly.addKeywordMention("kotlin");
    adReportWeekly.addKeywordMention("kotlin");

    Map<String, Integer> keywordMentions = adReportWeekly.getKeywordMentions();
    assertNotNull(keywordMentions);
    assertThat(keywordMentions).containsKey("java").containsKey("kotlin");
    assertThat(keywordMentions.get("java")).isOne();
    assertThat(keywordMentions.get("kotlin")).isEqualTo(2);
  }
}