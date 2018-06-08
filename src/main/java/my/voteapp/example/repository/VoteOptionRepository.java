package my.voteapp.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import my.voteapp.example.model.VoteOption;

@Repository
public interface VoteOptionRepository extends JpaRepository<VoteOption,Long> {
}
