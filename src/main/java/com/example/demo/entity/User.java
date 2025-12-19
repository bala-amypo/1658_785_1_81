package com.example.demo.entity;

public class User{
    
@Entity
public class Asset{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(unique=true,nullable=false)
    private String assertTag;
    private String assertType;
    private String model;
    private LocalDate purchaseDate;
    private String status;
}