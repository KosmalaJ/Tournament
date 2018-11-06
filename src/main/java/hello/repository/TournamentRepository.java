package hello.repository;

import hello.model.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("tournamentRepository")
public interface TournamentRepository extends JpaRepository<Tournament,Integer>
{
    @Override
    List<Tournament> findAll();
    Tournament findById(int id);
}
