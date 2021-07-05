package utils;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class Requests {
    private int id;
    private String key;

    public Requests() {
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void getIdFromResponse() {
        Response response = given()
                .contentType(ContentType.JSON)
                .get("https://www.1secmail.com/api/v1/?action=getMessages&login=z4yr1d3&domain=esiix.com");
        JsonPath jsonPathEvaluator = response.jsonPath();
        ArrayList<Integer> list = jsonPathEvaluator.get("id");
        setId(list.get(0));
    }

    public void getEmailBody() {
        String response = given()
                .contentType(ContentType.JSON)
                .get("https://www.1secmail.com/api/v1/?action=readMessage&login=z4yr1d3&domain=esiix.com&id=" + getId())
                .then().extract().response().asString();
        setKey(response.substring(3388, 3424));
    }
}