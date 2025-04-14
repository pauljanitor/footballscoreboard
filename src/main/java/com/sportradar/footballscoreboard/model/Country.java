package com.sportradar.footballscoreboard.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Country {
    private final String name;

    static Country of(String name) {
        return null;
    }
}
