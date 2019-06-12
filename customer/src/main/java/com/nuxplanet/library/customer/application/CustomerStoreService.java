package com.nuxplanet.library.customer.application;

import com.nuxplanet.library.common.customer.CustomerId;
import com.nuxplanet.library.customer.CustomerStore;
import com.nuxplanet.library.customer.command.CreateCustomerCommand;
import com.nuxplanet.library.customer.dto.CustomerDetails;
import com.nuxplanet.library.customer.infrastructure.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author oleciwoj
 */
@Service
@AllArgsConstructor
class CustomerStoreService implements CustomerStore  {

    private final CustomerRepository repository;

    @Override
    public CustomerId add(CreateCustomerCommand command) {
        return repository.save(command);
    }

    @Override
    public Optional<CustomerDetails> get(CustomerId id) {
        return repository.get(id);
    }
}
