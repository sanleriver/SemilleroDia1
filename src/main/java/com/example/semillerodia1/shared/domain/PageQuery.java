package com.example.semillerodia1.shared.domain;

import org.apache.commons.lang3.Validate;

public class PageQuery {
    private final Limit limit;
    private final Skip skip;

    public PageQuery(Limit limit, Skip skip) {
        this.limit = Validate.notNull(limit);
        this.skip = Validate.notNull(skip);
    }

    public Limit getLimit() {
        return limit;
    }

    public Skip getSkip() {
        return skip;
    }
}
