package com.maemresen.datamining.project.similarity.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.function.BiConsumer;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * To parsing excel documents...
 * 
 * @author Emre Sen - Apr 1, 2019
 * @contact maemresen07@gmail.com
 *
 */
public class ExcelDocumentParser {

	private static final Logger LOGGER = LoggerFactory.getLogger(ExcelDocumentParser.class);

	/**
	 * Iterating over all the rows in a sheet
	 * 
	 * @param sheetIndex
	 * @param excelFilePath
	 * @param rowConsumer
	 */
	public static void iterateOverRows(int sheetIndex, String excelFilePath, BiConsumer<Integer, Row> rowConsumer) {
		try (Workbook workbook = WorkbookFactory.create(
				ExcelDocumentParser.class.getResourceAsStream(excelFilePath)
				)) {

			// Getting the Sheet at index zero
			Sheet sheet = workbook.getSheetAt(sheetIndex);

			// obtain a rowIterator and columnIterator and iterate over them
			LOGGER.info("Start Iterating over Rows using Iterator");
			Iterator<Row> rowIterator = sheet.rowIterator();
			int rowIndex = 0;
			while (rowIterator.hasNext()) {
				rowConsumer.accept(rowIndex, rowIterator.next());
				rowIndex++;
			}
		} catch (EncryptedDocumentException | InvalidFormatException | IOException exception) {
			LOGGER.error("An Error Occured while parsing file: " + excelFilePath, exception);
		}

	}
}
