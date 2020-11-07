package com.maemresen.datamining.project.similarity;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.maemresen.datamining.project.similarity.detector.CheatDetector;
import com.maemresen.datamining.project.similarity.detector.distance.JaccardCheatDetector;
import com.maemresen.datamining.project.similarity.detector.distance.NormalizedLevenshteinCheatDetector;
import com.maemresen.datamining.project.similarity.model.CheatDetectionResult;
import com.maemresen.datamining.project.similarity.model.Homework;
import com.maemresen.datamining.project.similarity.util.DataLoader;
import com.maemresen.datamining.project.similarity.util.TimeUtil;

import gnu.getopt.Getopt;

/**
 * Entry point of application.
 *
 * @author Emre Sen - Apr 1, 2019
 * @contact maemresen07@gmail.com
 */
public class App {

    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    private static boolean detailed = false;
    private static double cheatThreashold = 0.4;


    public static boolean isDetailed() {
        return detailed;
    }


    public static void main(String[] argv) {

        Getopt g = new Getopt("testprog", argv, "hdt:");

        int c;
        while ((c = g.getopt()) != -1) {
            switch (c) {
                case 'h':
                    LOGGER.info("\n\n Usage: java -jar similarity.jar [-d] [-t <cheat_threshold>]"
                            + "\n\n\t -d\tDetailed printout. To print each distance found"
                            + "\n\n\t -t\tCheat Threashold, if two answers has distince lower than threashold than it is a cheat."
                            + "\n\t   \tDefault Value: 0.4");

                    System.exit(0);
                case 'd':
                    detailed = true;
                    break;
                case 't':
                    try {
                        cheatThreashold = Double.parseDouble(g.getOptarg());
                    } catch (NumberFormatException ex) {
                        LOGGER.error("Invalid Format");
                        System.exit(1);
                    }

                    break;
                case '?':
                    LOGGER.error("Invalid Argument");
                    System.exit(1);
                    break;
                //
                default:
            }
        }

        List<Homework> homeworkList = Arrays.asList(
                // initialize each homework
                DataLoader.loadStudentHw("HW1", "/hwdata/hwdata1.xls"),
                DataLoader.loadStudentHw("HW2", "/hwdata/hwdata2.xls"),
                DataLoader.loadStudentHw("HW3", "/hwdata/hwdata3.xls"));

        // Different Implementations of CheatDetector with different similarity
        // algorithms to test
        List<CheatDetector> cheatDetectorList = Arrays.asList(
                new NormalizedLevenshteinCheatDetector()
                , new JaccardCheatDetector()
        );

        homeworkList.forEach((homework) -> { // iterate over each homework
            LOGGER.info("===================================================");
            LOGGER.info("Homework: {}", homework.getHomeworkName());
            LOGGER.info("===================================================");

            cheatDetectorList.forEach((cheatDetector) -> { // iterate over each
                // cheat detector
                // defined above to
                // test
                TimeUtil.stopWatch(() -> {
                    LOGGER.info("");
                    LOGGER.info(cheatDetector.getDetectorName());
                    LOGGER.info("--------------------------------------------");
                    LOGGER.info("Calculating Distances");
                    LOGGER.info("--------------------------------------------");
                    List<CheatDetectionResult> cheatDetectionResultList = cheatDetector.calculateDistances(homework);
                    LOGGER.info("--------------------------------------------");
                    LOGGER.info("Filtering Cheats");
                    LOGGER.info("--------------------------------------------");

                    cheatDetectionResultList.stream() // get stream of the result
                            // list

                            // apply filter (eliminate values greater than
                            // cheatThreashold)
                            .filter(cheatDetectorResult -> cheatDetectorResult.getValue() < cheatThreashold)

                            // collect filtered results as list
                            .collect(Collectors.toList())

                            // iterate over each
                            .forEach((cheatDetectionResult) -> {
                                LOGGER.info("Cheat Detected: Distance=[{}], Student1Id=[{}], Student2Id=[{}]",
                                        cheatDetectionResult.getValue(), cheatDetectionResult.getAnswer1().getStudentId(),
                                        cheatDetectionResult.getAnswer2().getStudentId());
                            });
                    LOGGER.info("--------------------------------------------");
                });
                LOGGER.info("");
            });
            LOGGER.info("");
        });

    }

}
