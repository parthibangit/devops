package commonUtility;

import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JsonReader
{

	static String path="C:\\Selenium files\\Projects\\DevOpsPractice\\TestData\\login.json";
	
	public static void main(String[] args) throws Exception

	{
		
		//System.out.println(jsonReader("username"));
		JsonElement element=jsonReader("username");
	   System.out.println(element.toString());
		
	}
	
	
	
	public static JsonElement jsonReader(String key) throws Exception
	{
		
		//BufferedReader reader= new BufferedReader(new FileReader(path));
		Map<String, JsonElement> map = new HashMap<>();
		
		JsonParser parser= new JsonParser();
		Object obj=parser.parse(new FileReader(path));
		JsonObject jsonObj=(JsonObject)obj;
		JsonObject parentObject=(JsonObject)jsonObj.get("uatlogin");
		System.out.println("Login details: " + parentObject.get("username"));
		
		for(Entry<String, JsonElement> values : parentObject.entrySet())
		{
			map.put(values.getKey(), values.getValue());
			
			if(map.containsKey(key)==true)
			{
				return map.get(key);
			}
		}
		
		return null;
		
	}
		
}
