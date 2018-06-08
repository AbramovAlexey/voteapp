package my.voteapp.example.view;

import my.voteapp.example.model.VoteOption;
import my.voteapp.example.repository.VoteOptionRepository;
import my.voteapp.example.repository.VotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import my.voteapp.example.model.Vote;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;

/**Bean for voting.xhtml*/

@Component("voteOptionView")
@ViewScoped
public class VoteOptionView implements Serializable {

    @Autowired
    private VoteOptionRepository voteOptionRepository;

    @Autowired
    private VotesRepository voteRepository;

    private Long selectedOptionId;

    private List<VoteOption> voteOptionList;

    /** Load vote options and set default index in selectOneRadio component */
    @PostConstruct
    public void init() {
        voteOptionList = voteOptionRepository.findAll();
        if (voteOptionList.size() > 0)
        selectedOptionId = voteOptionList.get(0).getId();
    }

    public String submitVote(){
        VoteOption voteOption;
        Vote nextVote;
        nextVote = new Vote();
        voteOption = new VoteOption();
        voteOption.setId(getSelectedOptionId());
        nextVote.setVoteOption(voteOption);
        voteRepository.save(nextVote);
       return "votingresults?faces-redirect=true";
    }

    public void setVoteOptionList(List<VoteOption> voteOptionList) {
        this.voteOptionList = voteOptionList;
    }

    public List<VoteOption> getVoteOptionList(){
        return  voteOptionList;
    }

    public Long getSelectedOptionId() {
        return selectedOptionId;
    }

    public void setSelectedOptionId(Long selectedOptionId) {
        this.selectedOptionId = selectedOptionId;
    }
}
