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
import jakarta.persistence.Enumerated;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="users")
public class User{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
        @Enumerated(EnumType.STRING)

    @Column(unique=true,nullable=false)
    private String fullName;
    private String email;
    private String department;
    private LocalDate role;
    private String password;
    private LocalDateTime createAt;


@PrePersist
public void onCreate(){
    if(this.role==null)
    this.rolr="USER";
    if(this.createAt==null)
    this.createAt=LocalDateTime.now();
}
}