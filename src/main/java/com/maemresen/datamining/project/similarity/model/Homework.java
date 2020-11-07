package com.maemresen.datamining.project.similarity.model;

import java.util.ArrayList;
import java.util.List;

/**
 * A Homework that contains answers of students...
 * 
 * @author Emre Sen - Apr 1, 2019
 * @contact maemresen07@gmail.com
 *
 */
public class Homework {

	private String homeworkName;
	private List<Answer> answerList;

	public Homework() {
		answerList = new ArrayList<>();
	}

	public String getHomeworkName() {
		return homeworkName;
	}

	public void setHomeworkName(String homeworkName) {
		this.homeworkName = homeworkName;
	}

	public List<Answer> getAnswerList() {
		return answerList;
	}

	/**/
	public boolean addAnswer(String studentId, String answerText) {
		return addAnswer(new Answer(studentId, answerText));
	}

	public boolean addAnswer(Answer answer) {
		return answerList.add(answer);
	}

	@Override
	public String toString() {
		return "StudentHw [homeworkName=" + homeworkName + ", studentHwAnswerList=" + answerList + "]";
	}

}
