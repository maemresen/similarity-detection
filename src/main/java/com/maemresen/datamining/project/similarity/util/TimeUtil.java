package com.maemresen.datamining.project.similarity.util;

import java.time.Instant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.maemresen.datamining.project.similarity.detector.CheatDetector;

/**
 * Consists of helper methods relatedwith time...
 *  
 * @author Emre Sen - Apr 1, 2019
 * @contact maemresen07@gmail.com
 *
 */
public class TimeUtil {

	private static final Logger LOGGER = LoggerFactory.getLogger(CheatDetector.class);

	public static void stopWatch(Runnable runnable) {

		long startTime = Instant.now().toEpochMilli();

		runnable.run();

		long endTime = Instant.now().toEpochMilli();

		long timeElapsed = endTime - startTime;

		LOGGER.info("Execution time in milliseconds: " + timeElapsed);
		
	}

}
