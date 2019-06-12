package com.nuxplanet.library.customer.infrastructure;

import com.nuxplanet.library.common.customer.CustomerId;
import com.nuxplanet.library.customer.command.CreateCustomerCommand;
import com.nuxplanet.library.customer.dto.CustomerDetails;

import java.util.Optional;

/**
 * @author oleciwoj
 */
public interface CustomerRepository {

    CustomerId save(CreateCustomerCommand command);

    Optional<CustomerDetails> get(CustomerId id);
}
