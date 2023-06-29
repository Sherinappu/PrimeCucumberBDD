package BestBuy.bestbuyapi;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import payload.Payload;
import pojo.Productreq;
import pojoData.Addpdtreq;
import pojo.ProductRes;
import pojo.GetpdtRes;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import java.util.HashMap;

import org.testng.Assert;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class EcomApi {

	public static void main(String[] args) throws IOException {
		
		
		/*RequestSpecification req = 
				new RequestSpecBuilder().setBaseUri("http://localhost:3030")
				.setContentType(ContentType.JSON).build();
		
		Addpdtreq addpdtreq = new Addpdtreq();
    addpdtreq.setDescription("laptop");
	addpdtreq.setImage("www.file.com");
	addpdtreq.setManufacturer("HP");
	addpdtreq.setModel("2021-1/19");
	addpdtreq.setName("HP lap");
	addpdtreq.setPrice(35000);
	addpdtreq.setShipping(500);
	addpdtreq.setType("computer");
	addpdtreq.setUrl("www.hp.com");
	addpdtreq.setUpc("ax123");
	
		RequestSpecification addreq = given().log().all().spec(requestSpecification()w
		).body(payload.Addpdtreq());
		
		ProductRes productRes = addreq.when().post("products").then().log().all().extract().as(ProductRes.class);
		System.out.println(productRes.getId());
		System.out.println(productRes.getDescription());
		System.out.println(productRes.getModel());
		System.out.println(productRes.getPrice());
		Assert.assertEquals(productRes.getManufacturer(),"HP");
		*/
		
		//get a typical pdt
		/*RequestSpecification getapdtreq = 
				new RequestSpecBuilder().setBaseUri("http://localhost:3030")
				.setContentType(ContentType.JSON).build();
		
		RequestSpecification getapdtreqst = given().log().all().spec(getapdtreq);
		String response1 = getapdtreqst.when().get("products/9999690").then().log().all().extract().asString();
		JsonPath js = new JsonPath(response1);
		String idval = js.get("name").toString();
		System.out.println(idval);
		*/
		//patch update of pdt
		/*
		 
		RequestSpecification patchapdtreq = 
				new RequestSpecBuilder().setBaseUri("http://localhost:3030")
				.setContentType(ContentType.JSON).build(); 
		String locn = "D:\\Jobs\\automation\\Testdata\\getdata.json";
		File file = new File(locn);
		RequestSpecification patchapdtreqst = given().log().all().spec(patchapdtreq).body(file);
		String response2 = patchapdtreqst.when().get("products/9999690").then().log().all().extract().asString();
		JsonPath js2 = new JsonPath(response2);
		String idval2 = js2.get("name").toString();
		System.out.println(idval2);
		*/
		ObjectMapper objectMapper = new ObjectMapper();
		//del a pdt
		RequestSpecification delapdtreq = 
				new RequestSpecBuilder().setBaseUri("http://localhost:3030")
				.setContentType(ContentType.JSON).build(); 
		
		RequestSpecification delapdtreqst = given().log().all().spec(delapdtreq);
		String responsedel = delapdtreqst.when().delete("products/9999690").then().log().all().extract().asString();
		HashMap<String, String> resultMap = new HashMap<String, String>();
		
		try {
	         resultMap = objectMapper.readValue(responsedel, new TypeReference<HashMap<String, String>>() {
	         });
	     } catch (JsonMappingException e) {
	         e.printStackTrace();
	     } catch (JsonProcessingException e) {
	         e.printStackTrace();
	     }
		System.out.println(resultMap);
		System.out.println(resultMap.get("name"));
		
		//get all pdt with limit and skip
		
		
		/*
		
		RequestSpecification getreq = 
				new RequestSpecBuilder().setBaseUri("http://localhost:3030")
				.setContentType(ContentType.JSON).addQueryParam("$limit",2).addQueryParam("$skip",2).build();
		
		RequestSpecification getreqst = given().log().all().spec(getreq);
		//GetpdtRes getpdtRes = getreqst.when().get("products").then().log().all().extract().as(GetpdtRes.class);
		String response = getreqst.when().get("products").then().log().all().extract().asString();
		JsonNode jsonTree = objectMapper.readTree(response);
		System.out.println(jsonTree.at("/data/0/categories/1/id").asText());
		System.out.println(jsonTree.get("data").get(0).get("upc").asText());
	}
	*/

    }
}

