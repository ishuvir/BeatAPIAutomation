package APITest;

import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import RequestValidations.API_Validations;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Get_SingleEmployeeValidation_Test extends API_Validations {
	public String EndpointURI="http://dummy.restapiexample.com/api/v1";
	int statusc;
	API_Validations Valid=new API_Validations();
	 int EmpID=2;

	@BeforeMethod
	public void initialization() {
		initSetup(EndpointURI);
		RequestSetup("GET");
	ResponseSetup("GET","/employee/"+EmpID);

		
	}

	@Test
	public void Statuscode_GetRequest() {
//	 ExtentTest t5=extent.createTest("Employee End Point Status code validations","GetRequest");
//	t5.log(Status.INFO, "StatusCode Validation");
		try {
		statuscodeValidation();	
//	   t5.log(Status.PASS, "Status code validation is Pass");
	}  catch(Exception e) {
//		t5.log(Status.FAIL, "Status code validation is failed");
		e.printStackTrace();
	}
		}
		

	@Test
	public void StatusLine_GetRequest() {
//		 ExtentTest t=extent.createTest("Employee End Point Status Line validations","GetRequest");
//			t.log(Status.INFO, "StatusLine Validation");
			try {
		statusLineValidation();	
//	 t.log(Status.PASS, "Status line validation is Pass");
	 
	}
			 catch(Exception e) {
//					t.log(Status.FAIL, "Status Line validation is failed");
					e.printStackTrace();
				}
			}

	@Test
	public void payload_GetRequest() {
	//	 ExtentTest t=extent.createTest("Employee End Point Payload JSON validations","GetRequest");
	//	t.log(Status.INFO, "PayLoad Validation");
		try {
		resPayloadValidation();
//	   t.log(Status.PASS, "Response payload syntax is displayed");
	}
		 catch(Exception e) {
//				t.log(Status.FAIL, "Payload validation is failed");
				e.printStackTrace();
			}}

	@Test
	public void headervalidation() {
//		 ExtentTest t=extent.createTest("Employee End Point Header validations","GetRequest");	
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
	@Test
	public void PerfResponseTimevalidation() {
	//	 ExtentTest t=extent.createTest("Employee Endpoint Performance time validations","GetRequest");	
	//	t.log(Status.INFO, "Response time validation");
		try {
			responseTimeValid();
//	   t.log(Status.PASS, "Performance:Response time validation is Pass");
	}
		catch(Exception e) {
//			t.log(Status.FAIL, " Performance:Response time validation is Fail");	
	   e.printStackTrace();
		}
		
	}

	@AfterClass
	public void afterTest (){
	    //Reset Values
		
		RestAssured.reset();
	  
	}	
	}

