package com.maemresen.datamining.project.similarity.util;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.maemresen.datamining.project.similarity.App;
import com.maemresen.datamining.project.similarity.model.Homework;

/**
 * To loading models (Homework and its answers) from excel document...
 * 
 * @author Emre Sen - Apr 1, 2019
 * @contact maemresen07@gmail.com
 *
 */
public class DataLoader {

	private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

	public static Homework loadStudentHw(String studentName, String excelFilePath) {
		return loadStudentHw(studentName, 0, excelFilePath);
	}

	public static Homework loadStudentHw(String homeworkName, int sheetIndex, String excelFilePath) {

		Homework homework = new Homework();
		homework.setHomeworkName(homeworkName);
		DataFormatter formatter = new DataFormatter();
		ExcelDocumentParser.iterateOverRows(sheetIndex, excelFilePath, (index, row) -> {
			if (index == 0) {
				return;
			}
			String studentId = formatter.formatCellValue(row.getCell(0));
			String answerText = formatter.formatCellValue(row.getCell(1));
			homework.addAnswer(studentId, answerText);

			LOGGER.trace("StudentId=[{}], AnswerText=[{}]", studentId, answerText);

		});

		// LOGGER.info(studentHw.toString());
		return homework;
	}

}
