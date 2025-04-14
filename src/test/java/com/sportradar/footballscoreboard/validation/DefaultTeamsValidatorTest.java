package com.sportradar.footballscoreboard.validation;

public class DefaultTeamsValidatorTest extends AbstractTeamsValidatorTest {

    @Override
    protected TeamsValidator provideTeamsValidator() {
        return new DefaultTeamsValidator();
    }
}