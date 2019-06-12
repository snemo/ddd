package com.nuxplanet.library.common.stock;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.UUID;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * @author oleciwoj
 */
@ToString
@EqualsAndHashCode
public class StockId {
    private final String id;

    private StockId(String id) {
        this.id = id;
    }

    @JsonValue
    public String id() {
        return id;
    }

    public static StockId generate() {
        return new StockId(UUID.randomUUID().toString());
    }

    @JsonCreator
    public static StockId of(String id) {
        checkNotNull(id, "Stock ID cannot be null");
        checkArgument(id.length() == 36, "Stock ID has invalid size %s", id);
        return new StockId(id);
    }
}
