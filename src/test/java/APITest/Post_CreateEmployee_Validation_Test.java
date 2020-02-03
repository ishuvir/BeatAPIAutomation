package APITest;

import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import RequestValidations.API_Validations;
import io.restassured.RestAssured;

public class Post_CreateEmployee_Validation_Test extends API_Validations {
	public String EndpointURI="http://dummy.restapiexample.com/api/v1";
	int statusc;
	API_Validations Valid=new API_Validations();
	String PostEmpName="TestyNLq";
	String PostEmpSalary="4000";
	String PostEmpAge="33";


	@BeforeMethod
	public void initialization() {
		initSetup(EndpointURI);
		RequestSetup("POST",PostEmpName,PostEmpSalary,PostEmpAge);
		ResponseSetup("POST","/create");
	}
	
	@Test
	public void Statuscode_POSTRequest() {
//		 ExtentTest t=extent.createTest("Employee Create Status code validations","PostRequest");
//		t.log(Status.INFO, "StatusCode Validation");
		
		try {
		statuscodeValidation();	
//	   t.log(Status.PASS, "Status code validation is Pass");
	}  catch(Exception e) {
//		t.log(Status.FAIL, "Status code validation is failed");
		e.printStackTrace();
	}
		}
	@Test
	public void StatusLine_POSTRequest() {
//		 ExtentTest t=extent.createTest("Employee Create Status Line validations","GetRequest");
//			t.log(Status.INFO, "StatusLine Validation");
			try {
		statusLineValidation();	
//	 t.log(Status.PASS, "Status line validation is Pass");
	 
	}
			 catch(Exception e) {
	//				t.log(Status.FAIL, "Status Line validation is failed");
					e.printStackTrace();
				}
			}
	@Test
	public void payload_BodyPOSTRequest() {
//		 ExtentTest t=extent.createTest("Employee Create Payload JSON validations","POST Request");
//		t.log(Status.INFO, "PayLoad Validation & Response body validation");
		try {
			resPayloadValidation();
	//   t.log(Status.PASS, "Response payload Success Message is displayed");
	}
		 catch(Exception e) {
	//			t.log(Status.FAIL, "Payload validation is failed");
				e.printStackTrace();
			}}
	
	@Test
	public void bodyvalidation_POSTRequest() {
//		 ExtentTest t=extent.createTest("Employee Response Body Validations","POSTRequest");	
//		t.log(Status.INFO, "Response Body Validation");
		try {String Method="POST";
			resBodyCreateValidation(PostEmpName,Method);
//	   t.log(Status.PASS, "Response Body validation is Pass");
	} catch(Exception e) {
//		t.log(Status.FAIL, "Response Body validation is failed");
		e.printStackTrace();
	}
	}
	
	@Test
	public void CreateResponseTimevalidation() {
//		 ExtentTest t=extent.createTest("Employee Endpoint Performance time validations","POST Request");	
//		t.log(Status.INFO, "Response time Validation");
		try {
			responseTimeValid();
//	   t.log(Status.PASS, "Performance:Response time validation is Pass");
	}
		catch(Exception e) {
//			t.log(Status.FAIL, " Performance:Response time validation is Fail");	
	   e.printStackTrace();
		}
		
	}
	
	@Test
	public void headervalidation() {
//		 ExtentTest t=extent.createTest("Employee End Point Header validations","PostRequest");	
//		t.log(Status.INFO, "Header Validation");
		try {
		resHeadervalidation("Content-Type");
//	   t.log(Status.PASS, "Header validation is Pass");
	}
		catch(Exception e) {
//			t.log(Status.FAIL, "Header validation is Fail");	
	   e.printStackTrace();
		}
		
	}
	@AfterClass
	public void afterTest (){
	    //Reset Values
		
		RestAssured.reset();
	  
	}
	
}
