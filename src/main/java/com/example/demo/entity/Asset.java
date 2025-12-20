package  com.example.demo.entity;

@Entity
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
}
}