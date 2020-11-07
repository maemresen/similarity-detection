package com.maemresen.datamining.project.similarity.model;

/**
 * Answer of students given to a Homework...
 * 
 * @author Emre Sen - Apr 1, 2019
 * @contact maemresen07@gmail.com
 *
 */
public class Answer {

	private String studentId;
	private String answerText;

	public Answer() {
		// TODO Auto-generated constructor stub
	}

	public Answer(String studentId, String answerText) {
		super();
		this.studentId = studentId;
		this.answerText = answerText;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getAnswerText() {
		return answerText;
	}

	public void setAnswerText(String answerText) {
		this.answerText = answerText;
	}

	@Override
	public String toString() {
		return "Answer [studentId=" + studentId + ", answerText=" + answerText + "]";
	}

}
