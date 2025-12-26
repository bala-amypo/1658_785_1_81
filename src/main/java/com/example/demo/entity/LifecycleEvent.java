@Entity
public class LifecycleEvent {

    private String eventType;
    private String eventDescription;

    @ManyToOne
    private Asset asset;

    @ManyToOne
    private User performedBy;

    public String getEventType() { return eventType; }
    public String getEventDescription() { return eventDescription; }

    public void setAsset(Asset asset) { this.asset = asset; }
    public void setPerformedBy(User user) { this.performedBy = user; }
}
