package com.example.demo.dto;

public class AssetStatusUpdateDTO {

    private String status;

    public AssetStatusUpdateDTO() {
    }

    public AssetStatusUpdateDTO(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
