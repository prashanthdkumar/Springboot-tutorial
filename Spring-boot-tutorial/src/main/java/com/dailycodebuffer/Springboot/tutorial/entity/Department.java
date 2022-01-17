package com.dailycodebuffer.Springboot.tutorial.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Department {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long departmentId;
    private String departmentName;
    private String departmetnAddress;
    private String departmentCode;
    
    public Long getDepartmentId() {
        return departmentId;
    }
    
    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }
    
    public String getDepartmentName() {
        return departmentName;
    }
    
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
    
    public String getDepartmetnAddress() {
        return departmetnAddress;
    }
    
    public void setDepartmetnAddress(String departmetnAddress) {
        this.departmetnAddress = departmetnAddress;
    }
    
    public String getDepartmentCode() {
        return departmentCode;
    }
    
    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }
    
    public Department(Long departmentId, String departmentName, String departmetnAddress, String departmentCode) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.departmetnAddress = departmetnAddress;
        this.departmentCode = departmentCode;
    }
    
    public Department() {
    }
    
    @Override
    public String toString() {
        return "Department{" +
            "departmentId=" + departmentId +
            ", departmentName='" + departmentName + '\'' +
            ", departmetnAddress='" + departmetnAddress + '\'' +
            ", departmentCode='" + departmentCode + '\'' +
            '}';
    }
}
