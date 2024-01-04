package dukes.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Freelancer")
public class Freelancer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "FreelancerID")
    private int FreelancerID;

    @ManyToOne
    @JoinColumn(name = "UserID", referencedColumnName = "UserID")
    private User user;

    public Freelancer() {
    }

    public int getFreelancerID() {
        return FreelancerID;
    }

    public void setFreelancerID(int FreelancerID) {
        this.FreelancerID = FreelancerID;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
