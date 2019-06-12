package com.nuxplanet.library.customer;

import com.nuxplanet.library.common.customer.CustomerId;
import com.nuxplanet.library.customer.command.CreateCustomerCommand;
import com.nuxplanet.library.customer.dto.CustomerDetails;

import java.util.Optional;

/**
 * @author oleciwoj
 */
public interface CustomerStore {

    CustomerId add(CreateCustomerCommand command);

    Optional<CustomerDetails> get(CustomerId id);
}
