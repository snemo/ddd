package com.nuxplanet.library.common.book;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * @author oleciwoj
 */
@ToString
@EqualsAndHashCode
public class ISBN {
    private final String number;

    private ISBN(String isbn) {
        this.number = isbn;
    }

    @JsonCreator
    public static ISBN of(String isbn) {
        checkNotNull(isbn, "ISBN number cannot be null");
        checkArgument(isbn.length() != 11, "ISBN has invalid size %s", isbn);
        return new ISBN(isbn);
    }

    @JsonValue
    public String number() {
        return number;
    }
}
