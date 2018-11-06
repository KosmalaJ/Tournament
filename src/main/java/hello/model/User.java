package hello.model;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
//dodac pole username
    @Column(name="username")
    private String username;
    @Column(name = "email")
    private String email;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "password")
    private String password;

    @Column(name = "active")
    private int active;

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name="user_role", joinColumns=@JoinColumn(name="user_id"), inverseJoinColumns=@JoinColumn(name="role_id"))
    private Set<Role> roles;

    @ManyToMany(mappedBy = "users")
    private  Set<Tournament> tournaments;
    @OneToMany(mappedBy = "user1")
    private  Set<Game> gamesHome;
    @OneToMany(mappedBy = "user2")
    private  Set<Game> gamesAway;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<Tournament> getTournaments() {
        return tournaments;
    }

    public void setTournaments(Set<Tournament> tournaments) {
        this.tournaments = tournaments;
    }

    public Set<Game> getGamesHome() {
        return gamesHome;
    }

    public void setGamesHome(Set<Game> gamesHome) {
        this.gamesHome = gamesHome;
    }

    public Set<Game> getGamesAway() {
        return gamesAway;
    }

    public void setGamesAway(Set<Game> gamesAway) {
        this.gamesAway = gamesAway;
    }
}