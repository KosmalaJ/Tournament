package hello.model;

import javax.persistence.*;

@Entity
@Table(name = "game")
public class Game {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    @Column(name="idGame")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="idPhase")
    private Phase phase;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="idUser1")
    private User user1;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="idUser2")
    private User user2;

    @Column(name="score1")
    private int score1;
    @Column(name="score2")
    private int score2;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Phase getPhase() {
        return phase;
    }

    public void setPhase(Phase phase) {
        this.phase = phase;
    }

    public User getUser1() {
        return user1;
    }

    public void setUser1(User user1) {
        this.user1 = user1;
    }

    public User getUser2() {
        return user2;
    }

    public void setUser2(User user2) {
        this.user2 = user2;
    }

    public int getScore1() {
        return score1;
    }

    public void setScore1(int score1) {
        this.score1 = score1;
    }

    public int getScore2() {
        return score2;
    }

    public void setScore2(int score2) {
        this.score2 = score2;
    }
}
