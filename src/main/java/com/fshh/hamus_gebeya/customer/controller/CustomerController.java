package com.fshh.hamus_gebeya.customer.controller;

import com.fshh.hamus_gebeya.customer.dto.CustomerDTO;
import com.fshh.hamus_gebeya.customer.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<CustomerDTO> createCustomer(@RequestBody CustomerDTO customerDTO) {
        CustomerDTO createdCustomer= customerService.createCustomer(customerDTO);
        return ResponseEntity.ok(createdCustomer);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> getCustomer(@PathVariable Long id){
        CustomerDTO customerDTO=customerService.getCustomerById(id);
        return ResponseEntity.ok(customerDTO);
    }

    @GetMapping
    public ResponseEntity<List<CustomerDTO>> getAllCustomers(){
        return ResponseEntity.ok(customerService.getAllCustomers());
    }

    @PutMapping("{id}")
    public ResponseEntity<CustomerDTO> updateCustomer(@PathVariable Long id, @RequestBody CustomerDTO customerDTO){
        CustomerDTO updatedCustomer= customerService.updateCustomer(id, customerDTO);
        return ResponseEntity.ok(updatedCustomer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id){
        customerService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping ("/{id}/activate")
    public ResponseEntity<CustomerDTO> activateCustomer(@PathVariable Long id){
        CustomerDTO customerDTO =customerService.activateCustomer(id);
        return ResponseEntity.ok(customerDTO);
    }

    @PutMapping("/{id}/deactivate")
    public ResponseEntity<CustomerDTO> deactivateCustomer(@PathVariable Long id, @RequestBody String remark) {
        CustomerDTO customerDTO = customerService.deactivateCustomer(id, remark);
        return ResponseEntity.ok(customerDTO);
    }
}
