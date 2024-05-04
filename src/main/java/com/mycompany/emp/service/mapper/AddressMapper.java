package com.mycompany.emp.service.mapper;

import com.mycompany.emp.domain.Address;
import com.mycompany.emp.domain.Employee;
import com.mycompany.emp.service.dto.AddressDTO;
import com.mycompany.emp.service.dto.EmployeeDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Address} and its DTO {@link AddressDTO}.
 */
@Mapper(componentModel = "spring")
public interface AddressMapper extends EntityMapper<AddressDTO, Address> {
    @Mapping(target = "employee", source = "employee", qualifiedByName = "employeeId")
    AddressDTO toDto(Address s);

    @Named("employeeId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    EmployeeDTO toDtoEmployeeId(Employee employee);
}
