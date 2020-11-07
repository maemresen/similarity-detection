package com.maemresen.datamining.project.similarity.model;

/**
 * The result of similarity comparison based on an algorithm of two strings...
 * 
 * @author Emre Sen - Apr 2, 2019
 * @contact maemresen07@gmail.com
 *
 */
public class CheatDetectionResult {

	private final String detectionAlgorithm;
	private final Answer answer1;
	private final Answer answer2;
	private final double value;

	public CheatDetectionResult(String detectionAlgorithm, Answer answer1, Answer answer2, double value) {
		super();
		this.detectionAlgorithm = detectionAlgorithm;
		this.answer1 = answer1;
		this.answer2 = answer2;
		this.value = value;
	}

	public String getDetectionAlgorithm() {
		return detectionAlgorithm;
	}

	public Answer getAnswer1() {
		return answer1;
	}

	public Answer getAnswer2() {
		return answer2;
	}

	public double getValue() {
		return value;
	}

}
