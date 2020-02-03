package APITest;

import org.testng.annotations.Test;
import org.testng.ITestContext;
import org.testng.Reporter;
import org.testng.TestRunner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import RequestValidations.API_Validations;
import io.restassured.RestAssured;

public class DELETE_Employee_Validation_Test extends API_Validations {
	public String EndpointURI="http://dummy.restapiexample.com/api/v1";
	int statusc;
	API_Validations Valid=new API_Validations();
	int empID=44;
	
	
	
@BeforeMethod
public void initialization() {
	initSetup(EndpointURI);
	RequestSetup("DELETE");
	ResponseSetup("DELETE","/delete/"+ empID);
}

@Test
public void Statuscode_DeleteRequest() {
	Reporter.log("Statuscode_DeleteRequest Test Execution Started");
	// ExtentTest Delete1=extent.createTest("Delete Request Status code validation");
	 Reporter.log("StatusCode Validation");
	try {
	statuscodeValidation();	
	Reporter.log("Status code validation is Pass");
}  catch(Exception e) {
	Reporter.log("Status code validation is failed");
	e.printStackTrace();
}
	}
@Test
public void StatusLine_DeleteRequest() {
	Reporter.log("StatusLine DeleteRequest Test Execution Started");
//	 ExtentTest t1=extent.createTest("Employee Create Status Line validations","Delete Request");
		Reporter.log("StatusLine Validation");
		try {
	statusLineValidation();	
  Reporter.log("Status line validation is Pass");
 
}
		 catch(Exception e) {
				Reporter.log("Status Line validation is failed");
				e.printStackTrace();
			}
		}

@Test
public void bodyvalidation_POSTRequest() {
	Reporter.log("Payload _DeleteRequest Test Execution Started");
//	 ExtentTest t2=extent.createTest("Employee Response Body Validations","POSTRequest");	
	Reporter.log("Response Body Validation");
	try {
	resBodyDeleteValidation();
   Reporter.log("Response Body validation is Pass");
} catch(Exception e) {
	Reporter.log("Response Body validation is failed");
	e.printStackTrace();
}
}

@Test
public void CreateResponseTimevalidation() {
	Reporter.log("Response Time_DeleteRequest Test Execution Started");
//	 ExtentTest t3=extent.createTest("Employee Endpoint Performance time validations","Delete Request");	
	Reporter.log("Response time Validation");
	try {
		responseTimeValid();
   Reporter.log("Performance:Response time validation is Pass");
}
	catch(Exception e) {
		Reporter.log(" Performance:Response time validation is Fail");	
   e.printStackTrace();
	}
	
}

@Test
public void headervalidation() {
	Reporter.log("Header_DeleteRequest Test Execution Started");
//	 ExtentTest t4=extent.createTest("Employee End Point Header validations","Delete Request");	
	Reporter.log("Header Validation");
	try {
	resHeadervalidation("Content-Type");
   Reporter.log("Header validation is Pass");
}
	catch(Exception e) {
	Reporter.log("Header validation is Fail");	
   e.printStackTrace();
	}
	
}

@AfterClass
public void afterTest (){
    //Reset Values
	
	RestAssured.reset();
  
}

}
