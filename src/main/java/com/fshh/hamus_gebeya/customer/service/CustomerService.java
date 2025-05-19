package com.fshh.hamus_gebeya.customer.service;

import com.fshh.hamus_gebeya.customer.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {

    CustomerDTO createCustomer(CustomerDTO customerDTO);
    CustomerDTO getCustomerById(Long id);
    List<CustomerDTO> getAllCustomers();
    CustomerDTO updateCustomer(Long id, CustomerDTO customerDTO);
    void deleteCustomer(Long id);

    CustomerDTO activateCustomer(Long id);
    CustomerDTO deactivateCustomer(Long id, String remark);

}