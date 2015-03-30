package com.poo.lolicon;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONReader implements IJSONReader {

	private JSONObject jsonObject;
	
	public JSONReader(String filePath) throws FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(new FileReader(filePath));
        this.jsonObject = (JSONObject) obj;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> readJSONArray(String arrayObject, String... fields) {
		List<Object[]> list = new ArrayList<Object[]>();
		
        JSONArray companyList = (JSONArray) jsonObject.get(arrayObject);

        Iterator<JSONObject> iterator = companyList.iterator();
        while (iterator.hasNext()) {
        	Object[] objArray = new Object[fields.length];
        	list.add(objArray);
        	JSONObject jsonObj = iterator.next();
        	
        	for (int i = 0; i < fields.length; i++) {
        		Object obj = jsonObj.get(fields[i]);
        		objArray[i] = obj;
        	}
        }
        return list;
	}
}
