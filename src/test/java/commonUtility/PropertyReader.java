package commonUtility;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;


public class PropertyReader 
{
   
   static String path="C:\\Selenium files\\Projects\\DevOpsPractice\\Properties\\Config.properties";
  // static String path="/DevOpsPractice/Properties/Config.properties";
	
	
	
	public static String getValue(String key) throws Exception
	{
		
		BufferedReader reader=new BufferedReader(new FileReader(path));
		Properties properties=new Properties();
		Map<String, String> map=new HashMap<String, String>();
		
		try 
		{
			//properties.load(PropertyReader.class.getResourceAsStream("/DevOpsPractice/Properties/Config.properties"));
			properties.load(reader);
		}
		catch (Exception e) 
		{
			
			System.out.println("Property file not loaded properly");
			
		}
		
		for(Entry<Object, Object> object:properties.entrySet())
		{
			
			map.put((String)object.getKey(), (String)object.getValue());
			
			if(map.containsKey(key) == true)
			{
				return map.get(key);
			}
			
		}
		
		return null;
		
	}
	
	
	public static void main(String[] args) throws Exception
	{
		System.out.println("URL is " + getValue("chromedriver") );
	}
	
	
}
