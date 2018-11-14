package com.sahurjt.objectcsv;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

import com.sahurjt.objectcsv.annotations.CsvModel;
import com.sahurjt.objectcsv.annotations.CsvParameter;

public class Start {

	private static final String FILE_PATH = "C:\\Users\\Rajat-PC\\eclipse-workspace\\object-csv\\sample.csv";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			List<String> data = FileHelper.readFileByLine(FILE_PATH);

			BasicCsvHolder<CsvHelper> a = new BasicCsvHolder<CsvHelper>(new CsvHelper());
			// a.Test(data);

			CsvHelper hel = a.TestGeneric(CsvHelper.class);
			System.out.print("in main: " + hel.PropertyName);

			List<Dictionary<String, String>> content = a.getContent();
			// System.out.print(content);

			for (Method f : BasicCsvHolder.class.getMethods()) {
				// System.out.println(f);
			}
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
