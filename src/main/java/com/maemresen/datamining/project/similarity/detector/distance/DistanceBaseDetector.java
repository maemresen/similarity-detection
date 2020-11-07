package com.maemresen.datamining.project.similarity.detector.distance;

import com.maemresen.datamining.project.similarity.detector.CheatDetector;
import com.maemresen.datamining.project.similarity.model.Answer;

/**
 * 
 * @author Emre Sen - Apr 1, 2019
 * @contact maemresen07@gmail.com
 *
 */
public abstract class DistanceBaseDetector extends CheatDetector {

	public DistanceBaseDetector(String detectorName) {
		super(detectorName);
	}

	protected double value(Answer ans1, Answer ans2) {
		return distance(ans1, ans2);
	}

	protected abstract double distance(Answer ans1, Answer ans2);
}
