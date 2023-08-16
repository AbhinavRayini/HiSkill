package com.hv.hiskill.dto;

public class EmployeeDto {
    private Long empId;
    private String empName;

    public EmployeeDto(Long empId, String empName) {
        this.empId = empId;
        this.empName = empName;
    }

    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    @Override
    public String toString() {
        return "employeedto{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                '}';
    }

    public EmployeeDto() {
    }
}
