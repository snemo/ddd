package com.nuxplanet.library.customer.infrastructure

import com.nuxplanet.library.common.customer.CustomerId
import com.nuxplanet.library.customer.command.CreateCustomerCommand
import com.nuxplanet.library.customer.dto.CustomerDetails

/**
 *
 * @author oleciwoj
 */
class CustomerRepositoryStub implements CustomerRepository {

    Map<CustomerId, CustomerDetails> store = new HashMap<>()

    @Override
    synchronized CustomerId save(CreateCustomerCommand command) {
        def id = CustomerId.generate()
        store.put(id, convert(id, command))
        id
    }

    @Override
    synchronized Optional<CustomerDetails> get(CustomerId id) {
        Optional.ofNullable(store.get(id))
    }

    CustomerDetails convert(CustomerId id, CreateCustomerCommand command) {
        return CustomerDetails.builder()
                .id(id)
                .firstName(command.firstName)
                .lastName(command.lastName)
                .build()
    }
}
