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
@Table(name = "Skills")
public class Skills {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "SkillsID")
    private int SkillsID;
    @Column(name = "name")
    private String name;


    @ManyToOne
    @JoinColumn(name = "FreelancerID", referencedColumnName = "FreelancerID")
    private Freelancer freelancer;

    public Skills() {
    }

    public int getSkillsID() {
        return SkillsID;
    }

    public void setSkillsID(int SkillsID) {
        this.SkillsID = SkillsID;
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public Freelancer getFreelancer() {
        return freelancer;
    }

    public void setFreelancer(Freelancer freelancer) {
        this.freelancer = freelancer;
    }
}
