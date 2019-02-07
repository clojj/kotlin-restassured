package app.functions

import app.TestBase
import app.util.ObjectMapperConfigurator
import app.util.objectMapperFactory
import com.fasterxml.jackson.module.kotlin.readValue
import io.restassured.RestAssured
import io.restassured.builder.RequestSpecBuilder
import io.restassured.http.ContentType
import io.restassured.path.json.JsonPath

object PostmanEchoServiceFunctions {

    private val postmanEchoServiceSpec = RequestSpecBuilder()
        .setContentType("application/json;charset=UTF-8")
        .setAccept("application/json")
        .build()

    fun postWithEcho(): EchoObject {
        val response: String = RestAssured
                .given()
                .spec(postmanEchoServiceSpec).log().all()
                .body(EchoObject("111", "aaa"))
                .post("https://postman-echo.com/post")
                .then()
                .contentType(ContentType.JSON)
                .statusCode(200)
                .extract().response().asString()
        print(response)
        return JsonPath.from(response).using(objectMapperFactory).getObject("data", EchoObject::class.java)
    }


}