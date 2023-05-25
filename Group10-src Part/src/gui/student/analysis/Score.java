package gui.student.analysis;

/**
 * The type Score.
 */
public class Score implements Comparable<Score> {
    private String module;
    private int score;
    private int rank;

    /**
     * Instantiates a new Score.
     *
     * @param module the module
     * @param score  the score
     * @param rank   the rank
     */
    public Score(String module, int score, int rank) {
        this.module = module;
        this.score = score;
        this.rank = rank;
    }

    /**
     * Gets module.
     *
     * @return the module
     */
    public String getModule() {
        return module;
    }

    /**
     * Sets module.
     *
     * @param module the module
     */
    public void setModule(String module) {
        this.module = module;
    }

    /**
     * Gets score.
     *
     * @return the score
     */
    public int getScore() {
        return score;
    }

    /**
     * Sets score.
     *
     * @param score the score
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * Gets rank.
     *
     * @return the rank
     */
    public int getRank() {
        return rank;
    }

    /**
     * Sets rank.
     *
     * @param rank the rank
     */
    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public int compareTo(Score o) {
        if(this.getScore() > o.getScore()){
            return -1;
        }else if (this.getScore() == o.getScore()){
            return 0;
        }
        return 1;
    }
}
