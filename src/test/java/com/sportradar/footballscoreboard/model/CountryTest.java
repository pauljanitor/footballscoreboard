package com.sportradar.footballscoreboard.model;


import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CountryTest {

    @Test
    public void of_shouldCreateCountryWhenNameValid() {
        // given
        String name = "Germany";

        // when
        Country result = Country.of(name);

        // then
        assertThat(result.getName()).isEqualTo("Germany");
    }
}