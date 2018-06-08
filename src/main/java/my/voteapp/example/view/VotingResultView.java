package my.voteapp.example.view;

import org.primefaces.model.chart.PieChartModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import my.voteapp.example.model.Vote;
import my.voteapp.example.repository.VotesRepository;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**Bean for votingresults.xhtml*/

@Component("votingResultView")
@ViewScoped
public class VotingResultView implements Serializable {

    @Autowired
    private VotesRepository votesRepository;

    private PieChartModel votingResultModel;

    public PieChartModel getVotingResultModel() {
        return votingResultModel;
    }

    public void setVotingResultModel(PieChartModel votingResultModel) {
        this.votingResultModel = votingResultModel;
    }

    /** Load all votes, group by vote option name with counting, and set model for pieChart */
    @PostConstruct
    public void init(){
            Map<String, Number> mapForChartModel;
            List<Vote> voteList = votesRepository.findAll();
            mapForChartModel = voteList.stream()
                    .collect(Collectors.groupingBy(elem -> elem.getVoteOption().getName()))
                    .entrySet()
                    .stream()
                    .map(entry -> new AbstractMap.SimpleEntry<String, Number>(entry.getKey(), entry.getValue().size()))
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
            votingResultModel = new PieChartModel();
            votingResultModel.setData(mapForChartModel);
            votingResultModel.setLegendPosition("e");
            votingResultModel.setShowDataLabels(true);
    }
}
