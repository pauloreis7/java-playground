package ElectionVoteCount.entities;

public class BallotBoxRegister {
  private final String candidate;
  private final int voteCount;

  public BallotBoxRegister(final String candidate, final int voteCount) {
    this.candidate = candidate;
    this.voteCount = voteCount;
  }

  public String getCandidate() {
    return candidate;
  }

  public int getVoteCount() {
    return voteCount;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((candidate == null) ? 0 : candidate.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    BallotBoxRegister other = (BallotBoxRegister) obj;
    if (candidate == null) {
      if (other.candidate != null)
        return false;
    } else if (!candidate.equals(other.candidate))
      return false;
    return true;
  }
}
