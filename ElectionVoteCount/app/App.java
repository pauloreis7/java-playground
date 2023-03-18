package ElectionVoteCount.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import ElectionVoteCount.entities.BallotBoxRegister;

public class App {
  public static void main(String[] args) {
    Locale.setDefault(Locale.US);

    final String csvPath = "ElectionVoteCount/data/votes.csv";

    final Map<BallotBoxRegister, Integer> votes = new HashMap<>();

    try (BufferedReader bufferedReader = new BufferedReader(new FileReader(csvPath))) {
      String line = bufferedReader.readLine();

      while (line != null) {
        final String[] fields = line.split(",");
        final String candidateName = fields[0];
        final int candidateVotesCount = Integer.parseInt(fields[1]);

        final BallotBoxRegister ballotBoxRegister = new BallotBoxRegister(candidateName, candidateVotesCount);

        final boolean checkVoteExists = votes.containsKey(ballotBoxRegister);

        if (checkVoteExists) {
          final int vote = votes.get(ballotBoxRegister);

          votes.put(ballotBoxRegister, candidateVotesCount + vote);
        } else {
          votes.put(ballotBoxRegister, candidateVotesCount);
        }

        line = bufferedReader.readLine();
      }

      for (BallotBoxRegister vote : votes.keySet()) {
        final int voteAmount = votes.get(vote);

        System.out.println(vote.getCandidate() + ": " + voteAmount);
      }

    } catch (IOException e) {
      System.out.println("Error: " + e.getMessage());
    }
  }
}
