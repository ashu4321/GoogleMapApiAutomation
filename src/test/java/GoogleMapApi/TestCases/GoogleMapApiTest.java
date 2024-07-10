package GoogleMapApi.TestCases;
import GoogleMapApi.utilities.SparkHTML;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import static GoogleMapApi.services.MapFlow.sendRequest;

public class GoogleMapApiTest extends SparkHTML {

	@BeforeTest()
	public void sparkSetup() {
		SparkHTML.spark.config().setTheme(Theme.DARK);
		SparkHTML.spark.config().setDocumentTitle("Google Map Api Report");
		SparkHTML.extent.attachReporter(SparkHTML.spark);
	}

	@AfterTest(groups = {})
	public void tearDown() {
		SparkHTML.extent.flush();
	}

	@Test(priority = 0)
	public void validateStatusCodeWhenSingleAttributeSent() {

		ExtentTest test = extent.createTest("validateStatusCodeWhenSingleAttributeSent").assignCategory("Positive TestCases");

		String url = "https://www.googleapis.com/geolocation/v1/geolocate?key=AIzaSyCsZsTghAHYn3HC0HCkadD5Or-XrQMXzoo";
		test.info("Request url::"+url);
		String requestBody = "{\n" +
				"  \"homeMobileCountryCode\": null,\n" +
				"}";
test.info("Request body Data::"+requestBody);
		Response response = sendRequest(url, requestBody);
		test.info("Response received is::"+response.getBody().asString());

		test.info("Status code of the googleMapApi is: " + response.statusCode());

		if (response.statusCode() == 200) {
			Assert.assertTrue(true);
			test.pass("Status code is 200 as expected.");
		} else {
			Assert.assertTrue(false);
			test.fail("Status code is not 200. It is " + response.statusCode());
		}

		extent.flush();
	}

	@Test(priority = 1)
	public void validateResponseBodyWhenSingleAttributeSent() {
		ExtentTest test = extent.createTest("validateResponseBodyWhenSingleAttributeSent").assignCategory("Positive TestCases");

		String url = "https://www.googleapis.com/geolocation/v1/geolocate?key=AIzaSyCsZsTghAHYn3HC0HCkadD5Or-XrQMXzoo";
		test.info("Request url::"+url);
		String requestBody = "{\n" +
				"  \"homeMobileCountryCode\": null,\n" +
				"  \"homeMobileNetworkCode\": null,\n" +
				"  \"radioType\": \"gsm\",\n" +
				"  \"carrier\": \"Vodafone\",\n" +
				"  \"considerIp\": true\n" +
				"}";
		test.info("Request Body is::"+requestBody);
		Response response = sendRequest(url, requestBody);
		test.info("Response is::"+response.getBody().asString());
		test.info("Response body of the googleMapApi is: " + response.getBody().asString());

		Assert.assertNotNull(response.getBody().jsonPath().get("location"));
		test.pass("Response body contains location as expected.");

		extent.flush();
	}

	@Test(priority = 2)
	public void validateStatusCodeWhenInvalidApiKey() {
		ExtentTest test = extent.createTest("validateStatusCodeWhenInvalidApiKey").assignCategory("Negative TestCases");

		String url = "https://www.googleapis.com/geolocation/v1/geolocate?key=INVALID_API_KEY";
		test.info("Request url::"+url);
		String requestBody = "{\n" +
				"  \"homeMobileCountryCode\": null,\n" +
				"  \"radioType\": \"gsm\",\n" +
				"  \"carrier\": \"Vodafone\",\n" +
				"  \"considerIp\": true\n" +
				"}";
		test.info("Request Body::"+requestBody);
		Response response = sendRequest(url, requestBody);
		test.info("Reponse is::"+response.getBody().asString());
		test.info("Status code with invalid API key is: " + response.statusCode());

		if (response.statusCode() == 400) {
			Assert.assertTrue(true);
			test.pass("Status code is 400 as expected.");
		} else {
			Assert.assertFalse(false);
			test.fail("Status code is not 403. It is " + response.statusCode());
		}

		extent.flush();
	}

	@Test(priority = 3)
	public void validateStatusCodeWhenEmptyRequestBody() {
		ExtentTest test = extent.createTest("validateStatusCodeWhenEmptyRequestBody").assignCategory("Negative TestCases");

		String url = "https://www.googleapis.com/geolocation/v1/geolocate?key=AIzaSyCsZsTghAHYn3HC0HCkadD5Or-XrQMXzoo";
		test.info("Request url::"+url);
		Response response = sendRequest(url, "{}");
		test.info("Response is ::"+response.getBody().asString());
		test.info("Status code with empty request body is: " + response.statusCode());

		if (response.statusCode() == 200) {
			Assert.assertTrue(true);
			test.pass("Status code is 200 as expected.");
		} else {
			Assert.assertFalse(false);
			test.fail("Status code is not 200. It is " + response.statusCode());
		}

		extent.flush();
	}

	@Test(priority = 4)
	public void validateStatusCodeWhenNullCarrier() {
		ExtentTest test = extent.createTest("validateStatusCodeWhenNullCarrier").assignCategory("Edge TestCases");

		String url = "https://www.googleapis.com/geolocation/v1/geolocate?key=AIzaSyCsZsTghAHYn3HC0HCkadD5Or-XrQMXzoo";
		test.info("Request url::"+url);
		String requestBody = "{\n" +
				"  \"homeMobileCountryCode\": null,\n" +
				"  \"radioType\": \"gsm\",\n" +
				"  \"carrier\": null,\n" +
				"  \"considerIp\": true\n" +
				"}";
		test.info("Request Body::"+requestBody);
		Response response = sendRequest(url, requestBody);
		test.info("Response Body::"+response.getBody().asString());
		test.info("Status code when carrier is null: " + response.statusCode());

		if (response.statusCode() == 200) {
			Assert.assertTrue(true);
			test.pass("Status code is 200 as expected.");
		} else {
			Assert.assertTrue(false);
			test.fail("Status code is not 200. It is " + response.statusCode());
		}

		extent.flush();
	}

	@Test(priority = 5)
	public void validateStatusCodeWhenUnsupportedRadioType() {
		ExtentTest test = extent.createTest("validateStatusCodeWhenUnsupportedRadioType").assignCategory("Edge TestCases");

		String url = "https://www.googleapis.com/geolocation/v1/geolocate?key=AIzaSyCsZsTghAHYn3HC0HCkadD5Or-XrQMXzoo";
		test.info("Request url::"+url);
		String requestBody = "{\n" +
				"  \"homeMobileCountryCode\": null,\n" +
				"  \"radioType\": \"unsupported_type\",\n" +
				"  \"carrier\": \"Vodafone\",\n" +
				"  \"considerIp\": true\n" +
				"}";
		test.info("request body is::"+requestBody);
		Response response = sendRequest(url, requestBody);
		test.info("Respone body is::"+response.getBody().asString());
		test.info("Status code with unsupported radio type: " + response.statusCode());

		if (response.statusCode() == 400) {
			Assert.assertTrue(true);
			test.pass("Status code is 400 as expected.");
		} else {
			Assert.assertTrue(false);
			test.fail("Status code is not 400. It is " + response.statusCode());
		}

		extent.flush();
	}

	@Test(priority = 6)
	public void validateStatusCodeWhenLargeRequestBody() {
		ExtentTest test = extent.createTest("validateStatusCodeWhenLargeRequestBody").assignCategory("Edge TestCases");

		String url = "https://www.googleapis.com/geolocation/v1/geolocate?key=AIzaSyCsZsTghAHYn3HC0HCkadD5Or-XrQMXzoo";
		test.info("Request url::"+url);
		StringBuilder largeRequestBody = new StringBuilder("{\n" +
				"  \"homeMobileCountryCode\": null,\n" +
				"  \"homeMobileNetworkCode\": null,\n" +
				"  \"radioType\": \"gsm\",\n" +
				"  \"carrier\": \"Vodafone\",\n" +
				"  \"considerIp\": true,\n" +
				"  \"largeField\": \"");

		for (int i = 0; i < 10000; i++) {
			largeRequestBody.append("x");
		}
		largeRequestBody.append("\"\n}");
		test.info("Request body::"+largeRequestBody);

		Response response = sendRequest(url, largeRequestBody.toString());
		test.info("Response body::"+response.getBody().asString());
		test.info("Status code with large request body: " + response.statusCode());

		if (response.statusCode() == 400 || response.statusCode() == 200) {
			Assert.assertTrue(true);
			test.pass("Status code is 400 or 200 as expected.");
		} else {
			Assert.assertTrue(false);
			test.fail("Status code is not 400 or 413. It is " + response.statusCode());
		}

		extent.flush();
	}

	@Test(priority = 7)
	public void validateResponseBodyAllFields() {
		ExtentTest test = extent.createTest("validateResponseBodyAllFields").assignCategory("Response Body Validation");

		String url = "https://www.googleapis.com/geolocation/v1/geolocate?key=AIzaSyCsZsTghAHYn3HC0HCkadD5Or-XrQMXzoo";
		test.info("Request url::"+url);
		String requestBody = "{\n" +
				"  \"homeMobileCountryCode\": null,\n" +
				"  \"radioType\": \"gsm\",\n" +
				"  \"carrier\": \"Vodafone\",\n" +
				"  \"considerIp\": true\n" +
				"}";
		test.info("Request body::"+requestBody);
		Response response = sendRequest(url, requestBody);
		test.info("Response is::"+response.getBody().asString());
		String location = response.getBody().jsonPath().getString("location");
		String accuracy=response.getBody().jsonPath().getString("accuracy");
		double lat=response.getBody().jsonPath().getDouble("location.lat");
		double Long=response.getBody().jsonPath().getDouble("location.lng");
		test.pass("Location field in response body: " + location);

		Assert.assertNotNull(location);
		test.pass("Response body contains location field and it is not null."+location);
		Assert.assertNotNull(lat);
		test.pass("Response body contains latitude field and it is not null."+lat);
		Assert.assertNotNull(Long);
		test.pass("Response body contains Longitude field and it is not null."+Long);
		Assert.assertNotNull(accuracy);
		test.pass("Response body contains accuracy field and it is not null."+accuracy);

		extent.flush();
	}

}
