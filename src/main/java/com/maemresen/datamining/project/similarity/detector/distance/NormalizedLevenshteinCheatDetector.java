package com.maemresen.datamining.project.similarity.detector.distance;

import com.maemresen.datamining.project.similarity.model.Answer;

import info.debatty.java.stringsimilarity.NormalizedLevenshtein;

/**
 * 
 * @author Emre Sen - Apr 1, 2019
 * @contact maemresen07@gmail.com
 *
 */
public class NormalizedLevenshteinCheatDetector extends DistanceBaseDetector{

	public NormalizedLevenshteinCheatDetector() {
		super("NormalizedLevenshtein Based Cheat Detector");
	}

	@Override
	protected double distance(Answer ans1, Answer ans2) {
		NormalizedLevenshtein l = new NormalizedLevenshtein();
		return l.distance(ans1.getAnswerText(), ans2.getAnswerText());
	}
}
