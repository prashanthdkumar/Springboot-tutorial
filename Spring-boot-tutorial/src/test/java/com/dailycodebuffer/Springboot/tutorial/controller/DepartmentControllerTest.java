package com.dailycodebuffer.Springboot.tutorial.controller;

import com.dailycodebuffer.Springboot.tutorial.entity.Department;
import com.dailycodebuffer.Springboot.tutorial.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {
    
    @Autowired
    private MockMvc mockMvc;
    
    @MockBean
    private DepartmentService departmentService;
    
    private Department department;
    
    @BeforeEach
    void setUp() {
        department = Department.builder()
            .departmentAddress("Banglore")
            .departmentCode("ECE")
            .departmentName("ECE-01")
            .departmentId(1L)
            .build();
    }
    
    @Test
    @DisplayName("Save Department Successully")
    void saveDepartment() throws Exception {
        Department inputDepartment = Department.builder()
            .departmentAddress("Banglore")
            .departmentCode("ECE")
            .departmentName("ECE-01")
            .build();
    
        when(departmentService.saveDepartment(inputDepartment))
            .thenReturn(department);
        
        // Call the Post Request endpoint using mockMvc
        mockMvc.perform(post("/departments")
            .contentType(MediaType.APPLICATION_JSON)
            .content("{\n" +
                "    \"departmentName\": \"ECE-01\",\n" +
                "    \"departmentAddress\": \"Banglore\",\n" +
                "    \"departmentCode\": \"ECE\"\n" +
                "}"))
            .andExpect(status().isOk());
    }
    
    @Test
    @DisplayName("fetchDepartmentById tested successfully")
    void fetchDepartmentById() throws Exception {
        when(departmentService.fetchDepartmentById(1L))
            .thenReturn(department);
        
        mockMvc.perform(get("/departments/1")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.departmentName")
                .value(department.getDepartmentName()));
    }
}