package com.util;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static com.apis.service.SpecBuilder.getRequestSpec;
import static com.apis.service.SpecBuilder.getResponseSpec;
import static io.restassured.RestAssured.given;
//import static io.restassured.config.LogConfig.logConfig;
//import static io.restassured.config.RestAssuredConfig.config;

public class WebServiceUtil
{
    public static Response post(Object reqBody,String token,String path, String testCaseName)
    {
        return RestAssured.
                given(getRequestSpec(testCaseName)).
                //config(config().logConfig(logConfig().blacklistHeaders(null))).
                        body(reqBody).
                auth().oauth2(token).
                when().
                post(path).
                then().
                spec(getResponseSpec()).
                extract().
                response()
                ;
    }

    public static Response get(String path, String token, String testCaseName)
    {
        return given(getRequestSpec(testCaseName)).
                auth().oauth2(token).
                when().get(path).
                then().spec(getResponseSpec()).
                extract().
                response();
    }

    public static Response update(String path, String token, Object requestPlaylist, String testCaseName)
    {
        return given(getRequestSpec(testCaseName)).
                auth().oauth2(token).
                body(requestPlaylist).
                when().put(path).
                then().spec(getResponseSpec()).
                extract().
                response();
    }
}
