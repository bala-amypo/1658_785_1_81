package com.example.demo.entity;

@Entity
@Table(name="users")
public class User{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(unique=true,nullable=false)
    private String fullName;
    private String email;
    private String department;
    private LocalDate role;
    private String password;
    private LocalDateTime createAt;
}