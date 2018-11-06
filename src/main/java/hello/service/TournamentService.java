package hello.service;

import hello.model.Tournament;
import hello.model.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface TournamentService {
    public List<Tournament> findAllTournaments();
    public void saveTournament(Tournament tournament, User owner);
    public Tournament findTournamentById(int id);
}
