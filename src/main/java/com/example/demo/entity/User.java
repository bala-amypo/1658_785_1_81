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
package  com.example.demo.entity;
import java.util.Data;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Column;
import jakarta.persistence.PrePersist;



@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="assests")
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
        @JoinColumn(name="user_id")

    private LocalDateTime createdAt;
@PrePersist
public void onCreate(){
    if(this.status==null)
    this.status="Available";
    if(this.createAt==null)
    this.createAt=LocalDateTime.now();
}
}