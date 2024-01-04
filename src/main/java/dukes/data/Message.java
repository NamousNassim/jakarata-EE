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
@Table(name = "Message")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "MessageID")
    private int MessageID;

    @Column(name="Content")
    private String Content;

    @ManyToOne
    @JoinColumn(name = "ConversationID", referencedColumnName = "ConversationID")
    private Conversation conversation;

    @ManyToOne
    @JoinColumn(name = "UserID", referencedColumnName = "UserID")
    private User user;

    @Column(name = "SendTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sendTime;

    public Message() {
    }

    public int getMessageID() {
        return MessageID;
    }


    public void setMessageID(int MessageID) {
        this.MessageID = MessageID;
    }

    public String getContent() {
        return Content;
    }

    
    public void setContent(String Content) {
        this.Content = Content;
    }

    public Conversation getConversation() {
        return conversation;
    }

    public void setConversation(Conversation conversation) {
        this.conversation = conversation;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;

}
}
