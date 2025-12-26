@Entity
public class Asset {

    @Id
    @GeneratedValue
    private Long id;

    private String assetTag;
    private String status;

    @ManyToOne
    private User currentHolder;

    // getters/setters
    public Long getId() { return id; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public User getCurrentHolder() { return currentHolder; }
    public void setCurrentHolder(User currentHolder) {
        this.currentHolder = currentHolder;
    }
}
