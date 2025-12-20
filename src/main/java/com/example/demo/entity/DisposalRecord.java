package  com.example.demo.entity;
import java.util.Data;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import jakarta.persistence.PrePersist;



@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="disposal_records")
public class DisposalRecord{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Asset asset;
    private String disposalMethod;
    private LocalDate disposalDate;
    private User approvedBy;  
    private String notes;
    private LocalDateTime createA

@PrePersist
public void onCreate(){
    if(this.evenDate==null)
    this.eventDate=LocalDateTime.now();
}
}