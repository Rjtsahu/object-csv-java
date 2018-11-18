package com.sahurjt.objectcsv;

import java.util.List;

public class Start {
	// private static final String FILE_PATH_1 = ".\\sample.csv";
	private static final String FILE_PATH_2 = ".\\matches.csv";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			testProject();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void testProject() throws ObjectCsvException {
		CsvHolder<SampleMatchModel> holder = ObjectCsv.getInstance().from(FILE_PATH_2).with(CsvDelimiter.TAB)
				.getCsvHolderforClass(SampleMatchModel.class);

		List<SampleMatchModel> models = holder.getCsvRecords();

		System.out.println(holder.getContent());
		for (SampleMatchModel m : models) {
			// System.out.println(m);
		}
	}

}
