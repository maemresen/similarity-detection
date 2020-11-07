package com.maemresen.datamining.project.similarity.detector;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.maemresen.datamining.project.similarity.App;
import com.maemresen.datamining.project.similarity.model.Answer;
import com.maemresen.datamining.project.similarity.model.CheatDetectionResult;
import com.maemresen.datamining.project.similarity.model.Homework;

/**
 * Cheat Detector to detect cheats on a Homework Cheat Detector uses similarity
 * algorithms to detect cheats
 * 
 * @author Emre Sen - Apr 1, 2019
 * @contact maemresen07@gmail.com
 *
 */
public abstract class CheatDetector {

	private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

	private final String detectorName;

	public CheatDetector(String detectorName) {
		this.detectorName = detectorName;
	}

	public String getDetectorName() {
		return detectorName;
	}

	public List<CheatDetectionResult> calculateDistances(Homework hw) {

		List<CheatDetectionResult> cheatDetectionResultList = new ArrayList<>();

		List<Answer> ansList = hw.getAnswerList();
		for (int i = 0; i < ansList.size(); i++) {
			Answer ans1 = ansList.get(i);
			for (int j = i + 1; j < ansList.size(); j++) {
				Answer ans2 = ansList.get(j);
				if (ans1.getStudentId() == ans2.getStudentId()) {
					continue;
				}
				double value = value(ans1, ans2);
				CheatDetectionResult cheatDetectionResult = new CheatDetectionResult(detectorName, ans1, ans2, value);
				cheatDetectionResultList.add(cheatDetectionResult);

				if (App.isDetailed()) {
					LOGGER.info("Calculated Distance=[{}], Student1Id=[{}], Student2Id=[{}]",
							cheatDetectionResult.getValue(), cheatDetectionResult.getAnswer1().getStudentId(),
							cheatDetectionResult.getAnswer2().getStudentId());
				}

			}
		}
		return cheatDetectionResultList;
	}

	protected abstract double value(Answer ans1, Answer ans2);

}
