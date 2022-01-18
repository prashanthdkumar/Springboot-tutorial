package com.dailycodebuffer.Springboot.tutorial.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Negative;
import javax.validation.constraints.NegativeOrZero;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

@Entity
public class Department {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long departmentId;
    
    @NotBlank(message = "Please Add Department Name.")
    /*@Length(max = 5, min = 2)
    @Size(min = 0, max = 10)
    @Email
    @Positive
    @Negative
    @PositiveOrZero
    @NegativeOrZero
    @Future
    @FutureOrPresent
    @Past
    @PastOrPresent*/
    private String departmentName;
    private String departmentAddress;
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
    
    public String getDepartmentAddress() {
        return departmentAddress;
    }
    
    public void setDepartmentAddress(String departmentAddress) {
        this.departmentAddress = departmentAddress;
    }
    
    public String getDepartmentCode() {
        return departmentCode;
    }
    
    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }
    
    public Department(Long departmentId, String departmentName, String departmentAddress, String departmentCode) {
        this.departmentId = departmentId;
       this.departmentName = departmentName;
        this.departmentAddress = departmentAddress;
        this.departmentCode = departmentCode;
    }
    
    public Department() {
    }
    
    @Override
    public String toString() {
        return "Department{" +
            "departmentId=" + departmentId +
            ", departmentName='" + departmentName + '\'' +
            ", departmentAddress='" + departmentAddress + '\'' +
            ", departmentCode='" + departmentCode + '\'' +
            '}';
    }
}
