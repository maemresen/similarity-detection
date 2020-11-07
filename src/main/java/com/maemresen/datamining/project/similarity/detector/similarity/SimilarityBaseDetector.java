package com.maemresen.datamining.project.similarity.detector.similarity;

import com.maemresen.datamining.project.similarity.detector.CheatDetector;
import com.maemresen.datamining.project.similarity.model.Answer;

/**
 * 
 * @author Emre Sen - Apr 1, 2019
 * @contact maemresen07@gmail.com
 *
 */
public abstract class SimilarityBaseDetector extends CheatDetector {

	public SimilarityBaseDetector(String detectorName) {
		super(detectorName);
	}

	protected double value(Answer ans1, Answer ans2) {
		return 1 - similarity(ans1, ans2);
	}

	protected abstract double similarity(Answer ans1, Answer ans2);
}
