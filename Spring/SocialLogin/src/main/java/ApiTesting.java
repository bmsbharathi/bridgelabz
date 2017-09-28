import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.TestCase;

public class ApiTesting extends TestCase {

	@Test
	public void apiTesting() {
		System.out.println("Heloo");

		RestAssured.baseURI = "https://accounts.google.com/o/oauth2/auth?scope=profile email&redirect_uri=http://localhost:8080/MVC2/callBack&response_type=code&client_id=210547452486-1lin2i9diu2gjbtvp2vubq89042lie45.apps.googleusercontent.com&approval_prompt=force";
		RequestSpecification httpRequest = RestAssured.given();

		Response response = httpRequest.request(Method.GET);
		
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is =>  " + responseBody);
	}
}