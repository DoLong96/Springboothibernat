package com.example.demo2.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class EmployeeRequest {

    @NotBlank(message = "name must be not blank")
    @Size(max = 45, message = "name must be have length lower 45 character")
    private String name;

    @NotNull(message = "age must be have value")
    @Positive(message = "age must be greater than 0")
    private int age;
    public EmployeeRequest() {
    }

    public EmployeeRequest(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
