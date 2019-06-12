package com.nuxplanet.library.common.stock;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.UUID;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * @author oleciwoj
 */
public class ReservationId {
    private final String id;

    private ReservationId(String id) {
        this.id = id;
    }

    @JsonValue
    public String id() {
        return id;
    }

    public static ReservationId generate() {
        return new ReservationId(UUID.randomUUID().toString());
    }

    @JsonCreator
    public static ReservationId of(String id) {
        checkNotNull(id, "Reservation ID cannot be null");
        checkArgument(id.length() == 36, "Reservation ID has invalid size %s", id);
        return new ReservationId(id);
    }
}
