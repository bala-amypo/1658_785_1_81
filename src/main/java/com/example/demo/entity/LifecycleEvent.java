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
@Table(name="lifecycle_events")
public class LifecycleEvent{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private Asset asset;
    private String eventType;
    private String eventDescription;
    private LocalDateTime eventDate;
    private User performedBy;  

@PrePersist
public void onCreate(){
    if(this.evenDate==null)
    this.eventDate=LocalDateTime.now();
}
}