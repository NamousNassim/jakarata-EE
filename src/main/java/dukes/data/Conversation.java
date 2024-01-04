package dukes.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;

@Entity
@Table(name = "Conversation")
public class Conversation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ConversationID")
    private int ConversationID;

    @ManyToOne
    @JoinColumn(name = "ClientID", referencedColumnName = "ClientID")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "FreelancerID", referencedColumnName = "FreelancerID")
    private Freelancer freelancer;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "StartTime", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date startTime;

    public Conversation() {
    }

    public int getConversationID() {
        return ConversationID;
    }

    public void setConversationID(int ConversationID) {
        this.ConversationID = ConversationID;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Freelancer getFreelancer() {
        return freelancer;
    }

    public void setFreelancer(Freelancer freelancer) {
        this.freelancer = freelancer;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;

}
}
