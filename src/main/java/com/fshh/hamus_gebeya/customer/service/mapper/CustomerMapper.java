package com.fshh.hamus_gebeya.customer.service.mapper;

import com.fshh.hamus_gebeya.customer.dto.CustomerDTO;
import com.fshh.hamus_gebeya.customer.model.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    CustomerDTO toDTO(Customer customer);
    Customer toEntity(CustomerDTO customerDTO);
}
