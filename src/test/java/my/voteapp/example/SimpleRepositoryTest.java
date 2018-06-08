package my.voteapp.example;

import my.voteapp.example.model.VoteOption;
import my.voteapp.example.repository.VoteOptionRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.Optional;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class SimpleRepositoryTest {

    @Autowired
    private VoteOptionRepository voteOptionRepository;

    @Test
    public void testDefaultVoteOption(){
        Optional<VoteOption> voteOption = Optional.of(voteOptionRepository.getOne(1L));
        assertEquals("Ricky",voteOption.get().getName());
    }

}
