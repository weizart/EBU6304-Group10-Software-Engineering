package gui.student.modules;

/**
 * The type Module.
 */
public class Module {
    private String id;
    private String name;    // 课程名称
    private String teacher; // 老师
    private float score;    // 成绩
    private int level;  // 等级
    private String term;   // 学期
    private String progress;   // 进度

    /**
     * Instantiates a new Module.
     *
     * @param id       the id
     * @param name     the name
     * @param teacher  the teacher
     * @param term     the term
     * @param level    the level
     * @param score    the score
     * @param progress the progress
     */
    public Module(String id, String name, String teacher, String term, int level, float score, String progress) {
        this.id = id;
        this.name = name;
        this.teacher = teacher;
        this.score = score;
        this.level = level;
        this.term = term;
        this.progress = progress;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets teacher.
     *
     * @return the teacher
     */
    public String getTeacher() {
        return teacher;
    }

    /**
     * Sets teacher.
     *
     * @param teacher the teacher
     */
    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    /**
     * Gets score.
     *
     * @return the score
     */
    public float getScore() {
        return score;
    }

    /**
     * Sets score.
     *
     * @param score the score
     */
    public void setScore(float score) {
        this.score = score;
    }

    /**
     * Gets level.
     *
     * @return the level
     */
    public int getLevel() {
        return level;
    }

    /**
     * Sets level.
     *
     * @param level the level
     */
    public void setLevel(int level) {
        this.level = level;
    }

    /**
     * Gets term.
     *
     * @return the term
     */
    public String getTerm() {
        return term;
    }

    /**
     * Sets term.
     *
     * @param term the term
     */
    public void setTerm(String term) {
        this.term = term;
    }

    /**
     * Gets progress.
     *
     * @return the progress
     */
    public String getProgress() {
        return progress;
    }

    /**
     * Sets progress.
     *
     * @param progress the progress
     */
    public void setProgress(String progress) {
        this.progress = progress;
    }
}
