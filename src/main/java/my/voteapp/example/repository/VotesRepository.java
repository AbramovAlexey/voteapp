package my.voteapp.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import my.voteapp.example.model.Vote;


@Repository
public interface VotesRepository extends JpaRepository<Vote,Long> {
}
