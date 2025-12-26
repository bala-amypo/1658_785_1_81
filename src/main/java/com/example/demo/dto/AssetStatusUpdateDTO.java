package com.example.demo.dto;

import lombok.Data;

@Data
public class AssetStatusUpdateRequest {
    private String status;
    private String remarks;
}