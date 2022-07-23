package genrericUtilty;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class fileInput {
	@Test
	public String propertiesFile(String string) throws IOException {
		FileInputStream fis =new FileInputStream("./Propery.properties");
		Properties p =new Properties();
		p.load(fis);
		return p.getProperty(string);
	}
}
