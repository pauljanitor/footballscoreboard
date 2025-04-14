package com.sportradar.footballscoreboard.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Getter
@RequiredArgsConstructor
public class MatchId {
    private final UUID id;

    public static MatchId generateMatchId() {
        return new MatchId(UUID.randomUUID());
    }
}
