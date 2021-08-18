package Skyscanner.EndtoEnd;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.yaml.snakeyaml.Yaml;

public class base {
	
	public static WebDriver driver;
	
	public static String obj(String key) throws IOException {
		
		FileInputStream fis = new FileInputStream(
				"/Users/Develop/Desktop/Appium/Workspace/Appium_basic/EndtoEnd/src/main/java/Skyscanner/EndtoEnd/Configuration/config.yaml");
		Yaml yaml = new Yaml();

		Map<String, String> data = yaml.load(fis);
		
		FileInputStream fip = new FileInputStream(data.get("objrepo"));
		
		Properties prop = new Properties();
		
		prop.load(fip);
		
		
		return prop.getProperty(key);
	}

	public static WebDriver init() throws FileNotFoundException {

		FileInputStream fis = new FileInputStream(
				"/Users/Develop/Desktop/Appium/Workspace/Appium_basic/EndtoEnd/src/main/java/Skyscanner/EndtoEnd/Configuration/config.yaml");
		Yaml yaml = new Yaml();

		Map<String, String> data = yaml.load(fis);
		
		System.out.println(data);

		if (data.get("Broswer").equals("chrome")) {

			String path = data.get("Driverspath") + "/" + "chromedriver";

			System.setProperty("webdriver.chrome.driver", path);
			driver = new ChromeDriver();

		} else if (data.get("Broswer").equals("firefox")) {

			String path = data.get("Driverspath") + "/" + "geckodriver";

			System.setProperty("webdriver.gecko.driver", path);

			driver = new FirefoxDriver();

		} else if (data.get("Broswer").equals("ie")) {

			String path = data.get("Driverfolder") + "/" + "IEDriverServer";

			System.setProperty("webdriver.ie.driver", path);
			driver = new InternetExplorerDriver();

		} else {
			
			String path = data.get("Driverspath") + "/" + "chromedriver";

			System.setProperty("webdriver.chrome.driver", path);
			driver = new ChromeDriver();


		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get(data.get("url"));
		
		return driver;

	}
}
