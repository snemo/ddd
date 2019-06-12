package com.nuxplanet.library.customer.dto;

import com.nuxplanet.db.generated.tables.records.CustomersRecord;
import com.nuxplanet.library.common.customer.CustomerId;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Value;
import lombok.experimental.FieldDefaults;

/**
 * @author oleciwoj
 */
@Value
@Builder
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CustomerDetails {
    CustomerId id;
    String firstName;
    String lastName;

    public static CustomerDetails of(CustomersRecord record) {
        return builder()
                .id(CustomerId.of(record.getId()))
                .firstName(record.getFirstname())
                .lastName(record.getLastname())
                .build();
    }
}
