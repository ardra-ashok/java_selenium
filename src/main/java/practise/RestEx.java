package practise;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class RestEx {

    public void restEx(){
        String baseURI = "https://rahulshettyacademy.com";
        RequestSpecification req = new RequestSpecBuilder().setBaseUri(baseURI).setContentType("application/json").build();
        ResponseSpecification res = new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();


    }
}