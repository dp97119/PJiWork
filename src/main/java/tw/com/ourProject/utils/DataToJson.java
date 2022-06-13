package tw.com.ourProject.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class DataToJson {

	public JSONObject convert(String data) {
		JSONArray jsonArray = JSONObject.parseArray(data);
		JSONObject obj = null;

		for (int i = 0; i < jsonArray.size(); i++) {
			obj = jsonArray.getJSONObject(i);
		}
		return obj ;
	}
}
