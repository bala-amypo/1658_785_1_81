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