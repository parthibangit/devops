package commonUtility;

import java.io.FileReader;
import java.io.Reader;

import org.json.simple.parser.JSONParser;
import org.yaml.snakeyaml.parser.ParserException;

public class JsonReader
{

	static String path="C:\\Selenium files\\Projects\\DevOpsPractice\\TestData\\login.json";
	
	public static void main(String[] args) throws ParserException, Exception
	{
		System.out.println(jsonReader("username", "itlogin"));
	}
	
	public static String jsonReader(String key, String env) throws Exception, ParserException
	{
		Reader reader = new FileReader(path);
		JSONParser parser= new JSONParser();
		org.json.simple.JSONArray array= (org.json.simple.JSONArray) parser.parse(reader);
	
		for (Object object : array) 
		{
			
            return getValue((org.json.simple.JSONObject) object, key, env);			
		}
			
		return null;		
	}
	
	
	public static String getValue(org.json.simple.JSONObject object, String key, String env)
	{
		org.json.simple.JSONObject userDetails=(org.json.simple.JSONObject) object.get(env);			
		String value=(String) userDetails.get(key);
		return value;
	}
			
}
