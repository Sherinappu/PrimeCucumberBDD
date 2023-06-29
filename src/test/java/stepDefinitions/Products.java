package stepDefinitions;

import genericLibrary.CommonMehods;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import payload.Payload;
import pojoData.Addpdtresp;
import static org.junit.Assert.*;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class Products extends CommonMehods{
	Payload payload = new Payload();
	RequestSpecification addreq;
	ResponseSpecification resspec;
	Addpdtresp addpdtresp;
	@Given("Add product payload is provided")
	public void add_product_payload_is_provided() throws IOException {
		addreq = given().log().all().spec(requestSpecification())
				.body(payload.Addpdtpayload());
	    
	}
	@When("User calls Add product API using POST call")
	public void user_calls_add_product_api_using_post_call() {
		
		this.addpdtresp=addreq.when().post("products")
				.then().spec(responseSpecification()).log().all()
				.extract().as(Addpdtresp.class);
		
	}
	
	@Then("Verify Product with id pdtid is added")
	public void verify_product_with_id_pdtid_is_added() {
	    System.out.println("Product with ID " + addpdtresp.getId() + " is added");
	}
	
	@Then("Verify url is proper")
	public void verify_url_is_proper() {
	    assertEquals(addpdtresp.getUrl(),"www.hp.com");
	}


	

}
