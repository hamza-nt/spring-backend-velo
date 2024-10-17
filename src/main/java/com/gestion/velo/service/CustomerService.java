package com.gestion.velo.service;

import com.gestion.velo.dto.CustomerDTO;
import com.gestion.velo.entity.Customer;
import com.gestion.velo.mapper.CustomerMapper;
import com.gestion.velo.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customersRepo;
    private final CustomerMapper customerMapper = CustomerMapper.INSTANCE;

    public CustomerDTO addCustomer(CustomerDTO customerDTO) {
        Customer customer = customerMapper.customerDTOToCustomer(customerDTO);
        return customerMapper.customerToCustomerDTO(customersRepo.save(customer));
    }

    public CustomerDTO updateCustomer(Integer id, CustomerDTO customerDTO) {
        if (!customersRepo.existsById(id)) {
            return null;
        }
        Customer customer = customerMapper.customerDTOToCustomer(customerDTO);
        customer.setCustomerId(id);
        return customerMapper.customerToCustomerDTO(customersRepo.save(customer));
    }

    public void deleteCustomer(int customerId) {
        customersRepo.deleteById(customerId);
    }

    public CustomerDTO findCustomerById(int customerId) {
        Optional<Customer> customerOptional = customersRepo.findById(customerId);
        return customerOptional.map(customerMapper::customerToCustomerDTO).orElse(null);
    }

    public List<CustomerDTO> findAllCustomers() {
        List<Customer> customers = customersRepo.findAll();
        return customerMapper.customersToCustomerDTOs(customers);
    }

    public List<CustomerDTO> findCustomersByCityOrZipCode(String city, String zipCode) {
        List<Customer> customers;
        if (city != null && zipCode != null) {
            customers = customersRepo.findByCityAndZipCode(city, zipCode);
        } else if (city != null) {
            customers = customersRepo.findByCity(city);
        } else if (zipCode != null) {
            customers = customersRepo.findByZipCode(zipCode);
        } else {
            customers = customersRepo.findAll();
        }
        return customerMapper.customersToCustomerDTOs(customers);
    }
}