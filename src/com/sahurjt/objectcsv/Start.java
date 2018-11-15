package com.sahurjt.objectcsv;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

public class Start {

	private static final String FILE_PATH = "C:\\Users\\Rajat-PC\\eclipse-workspace\\object-csv\\sample.csv";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			List<String> data = FileHelper.readFileByLine(FILE_PATH);
			System.out.println(data);
			
			testAnnotation();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void testAnnotation() {
		try {
			GenericModelAdapter<SampleModel> holder = new GenericModelAdapter<SampleModel>(SampleModel.class);
			Dictionary<String, String> data = new Hashtable<String, String>();
// Txn Date, Value Date, Reference No, Description, Debit Amount, Credit Amount, Running Balance
			data.put("Txn Date", "txn date");
			data.put("Reference No", "110");
			data.put("Description", "some detail");
			data.put("Running Balance", "100.12");

			holder.setDictionary(data);
			holder.MapDictionaryToObject();

			SampleModel result = holder.getModelInstance();
			System.out.println(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
