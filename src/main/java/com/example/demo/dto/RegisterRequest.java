package com.example.demo.dto;

public class RegisterRequest {

    private String fullName;
    private String email;
    private String department;
    private String password;

    public RegisterRequest() {}

    public String getFullName() { return fullName; }
    public String getEmail() { return email; }
    public String getDepartment() { return department; }
    public String getPassword() { return password; }

    public void setFullName(String fullName) { this.fullName = fullName; }
    public void setEmail(String email) { this.email = email; }
    public void setDepartment(String department) { this.department = department; }
    public void setPassword(String password) { this.password = password; }
}
