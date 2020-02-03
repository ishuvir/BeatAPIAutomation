package RequestValidations;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.ReportConfigurator;
import com.aventstack.extentreports.Status;

import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ResponseBody;

public class API_Validations extends Common {
	
	
	public void statuscodeValidation() {

		int statusc=res.getStatusCode();
    System.out.println("Status code is:"+statusc);
	    Assert.assertEquals(statusc,200);
	//   t.info("Response code is validated as correct"+statusc);
	}
	
	public void statuscodePutValidation() {
		
		int statusc=res.getStatusCode();
		
    System.out.println("Status code is:"+statusc);
    if(statusc==200 ||statusc==201)
    {
    	Assert.assertEquals(statusc,200);
    	System.out.println("Valid Employee data Updated");
    	System.out.println("Status Code ="+statusc);
	}
    else if(statusc==400 ||statusc==401) {
    	System.out.println("InValid Employee data :Update failed");
    	System.out.println("Status Code ="+statusc);
    }
    
	}
	
	
	public void statusLineValidation() {
		String statusL=res.getStatusLine();
    	System.out.println("Status line is:"+statusL);
	    Assert.assertEquals(statusL,"HTTP/1.1 200 OK");	
//    t.info("Response line is validated as correct" +statusL);
	    
	    
	    if(statusL.contains("200"))
	    {
	    	Assert.assertEquals(statusL,"HTTP/1.1 200 OK");	
	    	System.out.println("Valid Employee data Updated");
	    	System.out.println("Status line is:"+statusL);
		}
	    else if(statusL.contains("401")) {
	    	Assert.assertEquals(statusL,"401 Unauthorized");
	    	System.out.println("InValid Employee data :Update failed");
	    	System.out.println("Status Code ="+statusL);
	    }
	}
	
    public void resPayloadValidation() {
		String resBody=res.getBody().asString();
	System.out.println(resBody);	
	
	JsonPath jspath=res.jsonPath();
	String Successmessage= jspath.get("status");
	System.out.println("Status tag value in Response body="+Successmessage);
	if(res.getStatusCode()==200) {
    Assert.assertEquals(Successmessage, "success");
//		t.info("Response body employee data is dispalyed"+resBody);
} else 
	Assert.assertEquals(Successmessage, "failed");
    }
    
    public void resBodyValidation(int EmpActual){
   	resPayloadValidation();
  //Response tag validations
  	boolean EmpSalaryTagExist= res.asString().contains("employee_salary");
  	System.out.println("Does Response contain Employee Salary?:"+EmpSalaryTagExist);
  	Assert.assertTrue(EmpSalaryTagExist);
  	boolean EmpNameTagExist= res.asString().contains("employee_name");
  	System.out.println("Does Response contain Employee Name?:"+EmpNameTagExist);
  	Assert.assertTrue(EmpNameTagExist);
  	boolean EmpAgeTagExist= res.asString().contains("employee_age");
  	System.out.println("Does Response contain Employee Age?:"+EmpAgeTagExist);
  	Assert.assertTrue(EmpAgeTagExist);
  
    	JsonPath jspath=res.jsonPath();
    	//Success message validation
   String Successmessage= jspath.get("status");
    Assert.assertEquals(Successmessage, "success");
    //Total employee count 
     List<String> idcount=jspath.get("data");
   int EmpCount=  idcount.size();
   System.out.println("Total number of Employee ="+EmpCount);
    Assert.assertEquals(EmpCount, EmpActual);
   //List of Employee Name
    String Employee_Name= res.jsonPath().getString("data.employee_name");
    System.out.println("Employee Names are"+Employee_Name);
    //Employee details are populated
    for(int i=0;i<EmpCount;i++) {    
    List<Map<String, String>> employe = res.jsonPath().getList("data");
    System.out.println("Employee id= "+employe.get(i).get("id")+" "+",Employee Name= "+employe.get(i).get("employee_name")+" "
    +",Employee salary="+employe.get(i).get("employee_salary")+"  "+",Employee age="+employe.get(i).get("employee_age"));
      
    }     }
    
    public void resBodyCreateValidation(String EmpName, String Method)
    {     
    	String resBody=res.getBody().asString();
    	System.out.println(resBody);
    	if(res.getStatusCode()==200) {
    		if(Method=="POST") {
    	String Employee_ID= res.jsonPath().getString("data.id");
    	System.out.println("Employee ID Generated is :"+Employee_ID);
    	System.out.println("Employee name ="+EmpName);
    	boolean value=resBody.contains(EmpName);
        Assert.assertTrue(value);
        System.out.println("Response body contains Employee Name");
    } else {
    	String Employee_ID= res.jsonPath().getString("data.id");
    	System.out.println("Employee ID Generated is :"+Employee_ID);
    	System.out.println("Employee name ="+EmpName);
    }
    	}
    	else
    	{
    		boolean value=resBody.contains("Record does not found.");
    		Assert.assertTrue(value);
            System.out.println("Response body contains :Record does not found");
    		
    	}
    }
    
    public void resBodyDeleteValidation() {
    	String resBody=res.getBody().asString();
    	System.out.println(resBody);
    	
    	//Success message validation	
    	JsonPath jspath=res.jsonPath();
    	String Successmessage= jspath.get("status");
  
    	if (Successmessage.equalsIgnoreCase("success")) {
    	Assert.assertEquals(Successmessage, "success");
    	System.out.println("Status tag value in Response body="+Successmessage);
    	String DeleteMessage= res.jsonPath().getString("message");
    	System.out.println("Employee ID Generated is :"+DeleteMessage);
        Assert.assertEquals(DeleteMessage, "successfully! deleted Records");
    	}
    	else{
    		Assert.assertEquals(Successmessage, "failed");
        	System.out.println("Status tag value in Response body="+Successmessage);
        	String DeleteMessage= res.jsonPath().getString("message");
        	System.out.println("Employee ID Generated is :"+DeleteMessage);
            Assert.assertEquals(DeleteMessage, "Error! Not able to delete record");
    	}
    }
    
    public void resHeadervalidation(String Headvalidation) {
    	Headers head=res.headers();
    int headercount=head.size();
  
    System.out.println("Total number of header in Response are"+headercount);
		for(Header all:head) {
			System.out.println("Header name="+all.getName()+",Header value ="+all.getValue());
		}
		if(head.getValue("Content-Type").contains("application/json")) {
			System.out.println("Content-Type header is validated");
		}
		else
		{
			System.out.println("Content-Type header validation is failed");
		}
	
}
    
    public void responseTimeValid() throws Exception {
    	long restime=res.getTimeIn(TimeUnit.MILLISECONDS);
    	System.out.println("Response time is"+restime);
    	Assert.assertTrue(restime<5000);
    	
    	}
    
    
}
	
	
    
    


