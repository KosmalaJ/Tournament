package hello.service;

import hello.model.Phase;
import hello.model.Tournament;
import hello.model.User;
import hello.repository.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("tournamentService")
public class TournamentServiceImpl implements TournamentService
{
    @Autowired
private TournamentRepository tournamentRepository;
    @Override
    public List<Tournament> findAllTournaments() {
        return tournamentRepository.findAll();
    }
    public void saveTournament(Tournament tournament, User owner)
    {
        int n=0;
        List<Phase> temp= new ArrayList<Phase>();
        if(tournament.getMaxUsers()==4)
    {
        n=2;
    }
    else if(tournament.getMaxUsers()==8)
        {
            n=3;
        }
     for(Integer i=0;i<n;i++)
     { Phase phase = new Phase();
     phase.setNumber(i);
     phase.setName("faza "+i.toString());
     phase.setTournament(tournament);
         temp.add(phase);
     }
     tournament.setPhases(temp);
        tournament.setOwner(owner);
      tournament.setStatus(0);
      tournamentRepository.save(tournament);
        }
        @Override
    public Tournament findTournamentById(int id)
        {
                    Tournament tournament =tournamentRepository.findById(id);
                    return tournament;

        }

}
