package my.voteapp.example.model;

import javax.persistence.*;

@Entity(name="VOTE")
public class Vote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vote_option_id", referencedColumnName = "id")
    private VoteOption voteOption;

    public Vote() {}

    public Vote(Long id, VoteOption voteOption) {
        this.id = id;
        this.voteOption = voteOption;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public VoteOption getVoteOption() {
        return voteOption;
    }

    public void setVoteOption(VoteOption voteOption) {
        this.voteOption = voteOption;
    }
}
