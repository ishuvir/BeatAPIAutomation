package RequestValidations;

import org.json.simple.JSONObject;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentTest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Common extends ExtentReporting {
	RequestSpecification req;
	Response res;
	
	public void initSetup(String Endpoint) {
		RestAssured.baseURI=Endpoint;
	}
	
	public void RequestSetup(String RequestMethod) {
		if (RequestMethod.equalsIgnoreCase("GET")) {
			 req=RestAssured.given();
		}
		else if (RequestMethod.equalsIgnoreCase("DELETE")) {
			 req=RestAssured.given();
			 req.header("Content-Type", "application/json");
		}
		
	}
	
	public void RequestSetupXML(String RequestMethod) {
		if (RequestMethod.equalsIgnoreCase("GET")) {
			 req=RestAssured.given().contentType(ContentType.XML);
		}
		else if (RequestMethod.equalsIgnoreCase("DELETE")) {
			 req=RestAssured.given();
			 req.header("Content-Type", "application/json");
		}
		
	}
	
	
	public void RequestSetup(String RequestMethod,String EmpName,String EmpSalary,String EmpAge) {
		req=RestAssured.given();
		JSONObject requestpara=new JSONObject();
	 if(RequestMethod.equalsIgnoreCase("POST")){
			requestpara.put("name", EmpName);
			requestpara.put("salary", EmpSalary);
			requestpara.put("age", EmpAge);
		req.header("Content-Type","application/json");
		req.body(requestpara.toJSONString());
		}
	 else if(RequestMethod.equalsIgnoreCase("PUT"))
	 {
		 requestpara.put("name", EmpName);
			requestpara.put("salary", EmpSalary);
			requestpara.put("age", EmpAge);
		req.header("Content-Type","application/json");
		req.body(requestpara.toJSONString());
	}
	
	}
	public void ResponseSetup(String RequestMethod ,String Route) {
		if (RequestMethod.equalsIgnoreCase("GET")) {
		res=req.request(Method.GET,Route);
	}
		else if (RequestMethod.equalsIgnoreCase("POST")) {
			res=req.request(Method.POST,Route);
		}
		
		else if (RequestMethod.equalsIgnoreCase("PUT")) {
			res=req.request(Method.PUT,Route);
		}
		else if (RequestMethod.equalsIgnoreCase("DELETE")) {
			res=req.request(Method.DELETE,Route);
		}
		
	}
	 
}

	
	

