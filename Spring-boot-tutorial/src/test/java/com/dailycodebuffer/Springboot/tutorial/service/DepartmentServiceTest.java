package com.dailycodebuffer.Springboot.tutorial.service;

import com.dailycodebuffer.Springboot.tutorial.entity.Department;
import com.dailycodebuffer.Springboot.tutorial.repository.DepartmentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
class DepartmentServiceTest {
    
    @Autowired
    private DepartmentService departmentService;
    
    @MockBean
    private DepartmentRepository departmentRepository;
    
    @BeforeEach
    void setUp() {
        Department department = Department.builder()
            .departmentName("IT")
            .departmentAddress("Hyderabad")
            .departmentCode("IT")
            .departmentId(1L)
            .build();
    
        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("IT"))
            .thenReturn(department);
    }
    
    @Test
    @DisplayName("Get data based on Valid Department Name")
    void whenValidDepartmentName_thenDepartmentShouldFound() {
        String departmentName = "IT";
        Department found = departmentService.fetchDepartmentByName(departmentName);
    
        Assertions.assertEquals(departmentName, found.getDepartmentName());
    }
    
    @Test
    @DisplayName("Disabled Test Case")
    @Disabled
    void disabledTestCase() {
        Assertions.assertTrue(true);
    }
}