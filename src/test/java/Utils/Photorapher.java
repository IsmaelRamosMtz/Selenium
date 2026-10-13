package Utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Photorapher {

	private WebDriver driver;
	private final String path = "src/test/resources/screenshots";

	public Photorapher(WebDriver driver) {
		this.driver = driver;
	}

	public void takePhoto(String pictureName) throws IOException {
		File screenshotDirectory = new File(path);
		Files.createDirectories(screenshotDirectory.toPath());

		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destination = new File(screenshotDirectory, pictureName + ".png");

		FileHandler.copy(source, destination);
	}

}
