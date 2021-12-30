package cucumber.utils;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.http.Headers;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;
import static org.apache.http.params.CoreConnectionPNames.CONNECTION_TIMEOUT;
import static org.apache.http.params.CoreConnectionPNames.SO_TIMEOUT;

public class RestUtils {
    private static RequestSpecification specs;
    private static final RestAssuredConfig config;
    private static final Integer TIMEOUT = 5000;
    static {
        RestAssured.useRelaxedHTTPSValidation();
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        config = RestAssured.config
                .httpClient(HttpClientConfig.httpClientConfig()
                        .setParam(CONNECTION_TIMEOUT, TIMEOUT)
                        .setParam(SO_TIMEOUT, TIMEOUT));
    }
    public static Response httpPost(String json, String url, String cookies, Headers headers) {
        return given()
                .spec(getAllureSpecs())
                .headers(headers)
                .header("Cookie", cookies)
                .body(json)
                .post(url);
    }
    public static Headers createDefaultHeaders() {
        return new Headers(new Header("Content-type", "application/json"),
                new Header("User-Agent", ""),
                new Header("Accept", "*/*"),
                new Header("Accept-Encoding", "gzip, deflate, br"),
                new Header("Connection", "keep-alive"));
    }
    public static RequestSpecification getAllureSpecs() {
        if (specs == null) {

            specs = new RequestSpecBuilder()
                    .addFilter(new RequestLoggingFilter())
                    .addFilter(new ResponseLoggingFilter())
                    .addFilter(new AllureRestAssured())
                    .setConfig(config)
                    .setRelaxedHTTPSValidation()
                    .build();
        }
        return specs;
    }
}
