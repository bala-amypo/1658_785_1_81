package com.example.demo.entity;

  
@Entity
public class LifecycleEvent{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
@MantToOne
    private Asset asset;
    private String eventType;
    private String eventDescription;
    private LocalDateTime eventDate;
    @ManyToOne
    private User performedBy;  
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
import jakarta.persistence.Column;
import jakarta.persistence.PrePersist;



@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="users")
p@Entity
public class LifecycleEvent{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
@MantToOne
    private Asset asset;
    private String eventType;
    private String eventDescription;
    private LocalDateTime eventDate;
    @ManyToOne
    private User performedBy;  

@PrePersist
public void onCreate(){
    if(this.role==null)
    this.rolr="USER";
    if(this.createAt==null)
    this.createAt=LocalDateTime.now();
}
}