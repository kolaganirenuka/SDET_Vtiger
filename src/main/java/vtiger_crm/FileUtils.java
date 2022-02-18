package vtiger_crm;

import java.io.FileInputStream;
import java.util.Properties;

public class FileUtils {
	
	public String readdataprop(String key) throws Throwable {
		FileInputStream fis=new FileInputStream(IAutoconstants.propfilepath);
	Properties prop=new Properties();
	prop.load(fis);
	return prop.getProperty(key);
	}
	public String readdataprop(String path, String key) throws Throwable {
		FileInputStream fis=new FileInputStream(IAutoconstants.propfilepath);
	Properties prop=new Properties();
	prop.load(fis);
	return prop.getProperty(key);
	}
	

}
