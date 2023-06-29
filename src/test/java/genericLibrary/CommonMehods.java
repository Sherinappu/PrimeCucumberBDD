package genericLibrary;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class CommonMehods {
	RequestSpecification req;
	ResponseSpecification resspec;
	PrintStream log; 
	
	public RequestSpecification requestSpecification() throws IOException {
		
		    this.log=new PrintStream(new FileOutputStream("Logging.txt"));
			req=new RequestSpecBuilder().setBaseUri(getGlobalValues("baseUrl"))
					.addFilter(RequestLoggingFilter.logRequestTo(log))
					.addFilter(ResponseLoggingFilter.logResponseTo(log))
					.setContentType(ContentType.JSON).build();
			return req;
	}
			
	public ResponseSpecification responseSpecification() {
			
			resspec = new ResponseSpecBuilder().expectStatusCode(201)
					.expectContentType(ContentType.JSON).build();
			return resspec;
}
	public static String getGlobalValues(String globvar) throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\eclipse\\automationlearn\\bestbuyapi\\src\\test\\java\\genericLibrary\\config.properties");
		prop.load(fis);
		return prop.getProperty(globvar);
		
	}
}
