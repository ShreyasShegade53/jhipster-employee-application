package com.mycompany.emp.service.mapper;

import static com.mycompany.emp.domain.EmployeeAsserts.*;
import static com.mycompany.emp.domain.EmployeeTestSamples.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmployeeMapperTest {

    private EmployeeMapper employeeMapper;

    @BeforeEach
    void setUp() {
        employeeMapper = new EmployeeMapperImpl();
    }

    @Test
    void shouldConvertToDtoAndBack() {
        var expected = getEmployeeSample1();
        var actual = employeeMapper.toEntity(employeeMapper.toDto(expected));
        assertEmployeeAllPropertiesEquals(expected, actual);
    }
}
