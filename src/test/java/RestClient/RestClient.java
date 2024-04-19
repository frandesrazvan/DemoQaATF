package RestClient;

import XmlFile.GeneralXml;
import XmlFile.XmlNode.Configuration;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestClient {

    // layer 1: clasa unde sunt definite configurari la nivel de client
    // am de facut 2 actiuni:
    // 1. metoda care configureaza clientul
    // 2. metoda care returneaza un raspuns pe baza configurarilor de la client

    private RequestSpecification prepareClient(RequestSpecification requestSpecification) {
        Configuration configuration = GeneralXml.createConfig(Configuration.class);

        requestSpecification.baseUri(configuration.backendConfig.baseURL);
        requestSpecification.contentType(configuration.backendConfig.contentType);

        return requestSpecification;
    }

    public Response performRequest(String requestType, RequestSpecification requestSpecification, String endPoint) {
        return switch (requestType) {
            case RequestType.REQUEST_POST -> prepareClient(requestSpecification).post(endPoint);
            case RequestType.REQUEST_PUT -> prepareClient(requestSpecification).put(endPoint);
            case RequestType.REQUEST_DELETE -> prepareClient(requestSpecification).delete(endPoint);
            case RequestType.REQUEST_GET -> prepareClient(requestSpecification).get(endPoint);
            default -> null;
        };
    }
}
