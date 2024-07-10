package GoogleMapApi.services;



import GoogleMapApi.utilities.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class MapFlow extends APIEndPoints


{


	public static Response sendRequest(String url, String requestBody) {
	return RestAssured
			.given()
			.header("Content-Type", "application/json")
			.body(requestBody)
			.post(url);
}
	

}
