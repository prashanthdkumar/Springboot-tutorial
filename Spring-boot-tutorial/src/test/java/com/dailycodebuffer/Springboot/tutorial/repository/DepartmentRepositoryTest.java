package com.dailycodebuffer.Springboot.tutorial.repository;

import com.dailycodebuffer.Springboot.tutorial.entity.Department;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class DepartmentRepositoryTest {
    
    @Autowired
    private DepartmentRepository departmentRepository;
    
    @Autowired
    private TestEntityManager testEntityManager;
    
    @BeforeEach
    void setUp() {
        Department department = Department.builder()
            .departmentName("Mechanical Engineering")
            .departmentCode("ME")
            .departmentAddress("Delhi")
            .build();
        
        testEntityManager.persist(department);
    }
    
    @Test
    @DisplayName("findById success test case")
    void whenFindById_thenReturnDepartment() {
        Department department = departmentRepository.findById(1L).get();
        Assertions.assertEquals("Mechanical Engineering", department.getDepartmentName());
    }
}