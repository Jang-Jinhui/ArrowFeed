package com.protory.arrow.feed.domain;

import java.io.Serializable;

public interface Model<ID> extends Serializable{
    ID getId();

    String getContent();
}