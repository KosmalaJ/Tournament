package hello.model;

import javax.persistence.*;

@Entity
@Table
public class Phase {

    @Id
   @GeneratedValue(strategy =  GenerationType.AUTO)
   @Column(name="idPhase")
   private int id;
    @Column(name="phasename")
    private String name;
    @Column(name="phasenumber")
    private int number;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="idTournament")
    private Tournament tournament;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Tournament getTournament() {
        return tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }
}
