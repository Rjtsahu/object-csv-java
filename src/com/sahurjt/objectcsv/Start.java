package com.sahurjt.objectcsv;

import java.util.List;

public class Start {
	// private static final String FILE_PATH =
	// "C:\\Users\\Rajat-PC\\eclipse-workspace\\object-csv\\sample.csv";
	private static final String FILE_PATH = "C:\\Users\\Rajat-PC\\Downloads\\matches.csv";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			List<String> data = FileHelper.readFileByLine(FILE_PATH);
			System.out.println(data);

			// testAnnotation();

			// testProject(data);
			testProject1(data);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void testProject(List<String> lines) throws GenericModelMappingException {
		CsvHolder<SampleModel> holder = ObjectCsv.getInstance().from(lines).getCsvHolderforClass(SampleModel.class);

		List<SampleModel> models = holder.getCsvRecords();

		for (SampleModel m : models) {
			System.out.println(m);
		}
	}

	private static void testProject1(List<String> lines) throws GenericModelMappingException {
		CsvHolder<SampleMatchModel> holder = ObjectCsv.getInstance().from(lines)
				.getCsvHolderforClass(SampleMatchModel.class);

		List<SampleMatchModel> models = holder.getCsvRecords();

		for (SampleMatchModel m : models) {
			 System.out.println(m);
		}
	}

}
