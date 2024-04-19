package Tests;

import Actions.AccountActions;
import ObjectData.RequestObject.RequestAccount;
import ObjectData.ResponseObject.ResponseAccountSuccess;
import ObjectData.ResponseObject.ResponseTokenSuccess;
import PropertyUtility.PropertyUtility;

import org.testng.annotations.Test;

public class CreateAccountTest {

    public String userId;
    public String token;
    public RequestAccount requestAccountBody;
    public AccountActions accountActions;

    @Test
    public void testMethod(){
        System.out.println("Step 1: Create new account");
        createAccount();

        System.out.println("\nStep 2: Generate new token");
        generateToken();

        System.out.println("\nStep 3: Get new account");
        getSpecificAccount();

        System.out.println("\nStep 4: Delete the newly created account");
        deleteSpecificAccount();

        System.out.println("\nStep 5: Check if newly deleted account was deleted");
        getSpecificAccount();
    }

    public void createAccount() {
//        //configurarile pentru client
//        RequestSpecification requestSpecification = RestAssured.given();
//        requestSpecification.baseUri("https://demoqa.com");
//        requestSpecification.contentType("application/json");
//
//        //definim request-ul
//        PropertyUtility propertyUtility = new PropertyUtility("RequestData/createAccountData");
//        requestAccountBody = new RequestAccount(propertyUtility.getAllData());
//        requestSpecification.body(requestAccountBody);
//
//        //interactionam cu respone-ul
//        Response response = requestSpecification.post("/Account/v1/User");
//        System.out.println(response.getStatusCode());
//        Assert.assertEquals(response.getStatusCode(), ResponseStatus.SC_CREATED);
//        System.out.println(response.getStatusLine());
//
//        //validam response body-ul
//        ResponseAccountSuccess responseAccountBody = response.body().as(ResponseAccountSuccess.class);
//        System.out.println(responseAccountBody.getUserID());
//        userId = responseAccountBody.getUserID();
//        Assert.assertEquals(responseAccountBody.getUsername(), requestAccountBody.getUserName());

        accountActions = new AccountActions();
        PropertyUtility propertyUtility = new PropertyUtility("RequestData/createAccountData");
        requestAccountBody = new RequestAccount(propertyUtility.getAllData());
        ResponseAccountSuccess responseAccountBody = accountActions.createNewAccount(requestAccountBody);
        userId = responseAccountBody.getUserID();
    }

    public void generateToken() {
//        RequestSpecification requestSpecification = RestAssured.given();
//        requestSpecification.baseUri("https://demoqa.com");
//        requestSpecification.contentType("application/json");
//
//        requestSpecification.body(requestAccountBody);
//
//        Response response = requestSpecification.post("/Account/v1/GenerateToken");
//        System.out.println(response.getStatusCode());
//        Assert.assertEquals(response.getStatusCode(), ResponseStatus.SC_OK);
//        System.out.println(response.getStatusLine());
//
//        ResponseTokenSuccess responseTokenSuccess = response.body().as(ResponseTokenSuccess.class);
//        System.out.println(responseTokenSuccess.getToken());
//        token = responseTokenSuccess.getToken();
//        Assert.assertEquals(responseTokenSuccess.getStatus(), "Success");
//        Assert.assertEquals(responseTokenSuccess.getResult(), "User authorized successfully.");

        ResponseTokenSuccess responseTokenSuccess = accountActions.generateToken(requestAccountBody);
        token = responseTokenSuccess.getToken();
    }

    public void getSpecificAccount() {
//        RequestSpecification requestSpecification = RestAssured.given();
//        requestSpecification.baseUri("https://demoqa.com");
//        requestSpecification.contentType("application/json");
//        requestSpecification.header("Authorization", "Bearer " + token); // autorizarea
//
//        Response response = requestSpecification.get("/Account/v1/User/"+ userId);
//        System.out.println(response.getStatusCode());
//        Assert.assertEquals(response.getStatusCode(), ResponseStatus.SC_OK);
//        System.out.println(response.getStatusLine());
//
//        ResponseAccountGetSuccess responseAccountGetSuccess = response.body().as(ResponseAccountGetSuccess.class);
//        Assert.assertEquals(responseAccountGetSuccess.getUsername(), requestAccountBody.getUserName());

        accountActions.getSpecificAccount(token, userId, requestAccountBody);
    }

    public void deleteSpecificAccount() {
        accountActions.deleteSpecificAccount(token, userId);
    }
}
