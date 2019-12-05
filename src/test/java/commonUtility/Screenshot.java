package commonUtility;

import static commonUtility.PropertyReader.getValue;
import java.io.File;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Screenshot 
{
	
	

	public static String takeScreenshot(WebDriver driver, String shotName) throws Exception
	{
		
		
		TakesScreenshot tc= ((TakesScreenshot)driver);
		File source = tc.getScreenshotAs(OutputType.FILE);
		String destination=getValue("screenshotpath");
		//Files.deleteIfExists(Paths.get(destination));
		File dest=new File(destination+ shotName + ".png");
		
		if(dest.exists())
		{
			dest.delete();
		}
		
		FileHandler.copy(source, dest);
		return destination;
		
	}
	
}
