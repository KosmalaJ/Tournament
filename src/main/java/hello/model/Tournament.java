package hello.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="tournament")
public class Tournament {
    @Id
    @Column(name = "idTournament")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name="status")
    private int status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="idOwner")
    private User owner;

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name="user_tournament", joinColumns=@JoinColumn(name="idTournament"), inverseJoinColumns=@JoinColumn(name="idUser"))
    private Set<User> users;

    @OneToMany(
            mappedBy = "tournament",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Phase> phases;

    @Column(name = "maxUsers")
    private int maxUsers;
    @Column(name="name")
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public List<Phase> getPhases() {
        return phases;
    }

    public void setPhases(List<Phase> phases) {
        this.phases = phases;
    }

    public int getMaxUsers() {
        return maxUsers;
    }

    public void setMaxUsers(int maxUsers) {
        this.maxUsers = maxUsers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
