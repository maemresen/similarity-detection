package com.maemresen.datamining.project.similarity.detector.distance;

import com.maemresen.datamining.project.similarity.model.Answer;

import info.debatty.java.stringsimilarity.Jaccard;

/**
 * 
 * @author Emre Sen - Apr 1, 2019
 * @contact maemresen07@gmail.com
 *
 */
public class JaccardCheatDetector extends DistanceBaseDetector{

	public JaccardCheatDetector() {
		super("Jaccard Chead Detector");
	}

	@Override
	protected double distance(Answer ans1, Answer ans2) {
		// Let's work with sequences of 2 characters...
		Jaccard jaccard = new Jaccard();
		return jaccard.distance(ans1.getAnswerText(), ans2.getAnswerText());
	}

}
