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
@Table(name="transfer_records")
public class TransferRecord{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private Asset asset;
    private String fromDepartment;
    private String toDepartment;
    private LocalDate transferDate;
    private User approveBy;  


}
