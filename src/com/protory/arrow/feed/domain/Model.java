package com.protory.arrow.feed.domain;

public interface Model<ID> {
    ID getId();
    String getContent();
}
