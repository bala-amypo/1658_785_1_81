@Entity
public class TransferRecord {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Asset asset;

    @ManyToOne
    private User approvedBy;

    private LocalDate transferDate;

    public User getApprovedBy() { return approvedBy; }
    public void setApprovedBy(User approvedBy) {
        this.approvedBy = approvedBy;
    }

    public LocalDate getTransferDate() { return transferDate; }

    public void setAsset(Asset asset) {
        this.asset = asset;
    }
}
