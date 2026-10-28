package Helper;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

public class Config {
	public static WebDriver driver ;

	public static void maxwin() {
		driver.manage().window().maximize();
	}


	public static  void attent(int s) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(s));
	}

}
