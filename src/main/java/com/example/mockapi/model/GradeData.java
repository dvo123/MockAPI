package com.example.mockapi.model;

/**
 * Model representing grade information received from or sent to the mock API.
 */
public class GradeData {

    private int grade;
    private String grade_expected;
    private String grade_msg;
    private int obj_id;
    private int mark_flag;
    private String grade_id;
    private int workspace_id;
    private int highlight;

    /**
     * Gets the grade value.
     *
     * @return the grade
     */
    public int getGrade() {
        return grade;
    }

    /**
     * Sets the grade value.
     *
     * @param grade the grade to set
     */
    public void setGrade(int grade) {
        this.grade = grade;
    }

    /**
     * Gets the expected grade description.
     *
     * @return expected grade
     */
    public String getGrade_expected() {
        return grade_expected;
    }

    /**
     * Sets the expected grade description.
     *
     * @param grade_expected expected grade
     */
    public void setGrade_expected(String grade_expected) {
        this.grade_expected = grade_expected;
    }

    /**
     * Gets the grade message.
     *
     * @return grade message
     */
    public String getGrade_msg() {
        return grade_msg;
    }

    /**
     * Sets the grade message.
     *
     * @param grade_msg grade message
     */
    public void setGrade_msg(String grade_msg) {
        this.grade_msg = grade_msg;
    }

    /**
     * Gets the object ID.
     *
     * @return object ID
     */
    public int getObj_id() {
        return obj_id;
    }

    /**
     * Sets the object ID.
     *
     * @param obj_id object ID
     */
    public void setObj_id(int obj_id) {
        this.obj_id = obj_id;
    }

    /**
     * Gets the mark flag.
     *
     * @return mark flag
     */
    public int getMark_flag() {
        return mark_flag;
    }

    /**
     * Sets the mark flag.
     *
     * @param mark_flag mark flag
     */
    public void setMark_flag(int mark_flag) {
        this.mark_flag = mark_flag;
    }

    /**
     * Gets the grade ID.
     *
     * @return grade ID
     */
    public String getGrade_id() {
        return grade_id;
    }

    /**
     * Sets the grade ID.
     *
     * @param grade_id grade ID
     */
    public void setGrade_id(String grade_id) {
        this.grade_id = grade_id;
    }

    /**
     * Gets the workspace ID.
     *
     * @return workspace ID
     */
    public int getWorkspace_id() {
        return workspace_id;
    }

    /**
     * Sets the workspace ID.
     *
     * @param workspace_id workspace ID
     */
    public void setWorkspace_id(int workspace_id) {
        this.workspace_id = workspace_id;
    }

    /**
     * Gets the highlight value.
     *
     * @return highlight
     */
    public int getHighlight() {
        return highlight;
    }

    /**
     * Sets the highlight value.
     *
     * @param highlight highlight
     */
    public void setHighlight(int highlight) {
        this.highlight = highlight;
    }
}
