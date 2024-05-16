package service.serviceImplementation;

import objectData.requestObject.RequestAccount;
import service.apiService.AccountApiService;
import service.endpoints.AccountEndpoints;
import service.interfaceService.AccountServiceInterface;
import io.restassured.response.Response;

public class AccountServiceImpl implements AccountServiceInterface {

    // facem o instanta de ApiService ca sa putem accesa metodele generale(din CommonApiService)
    private final AccountApiService accountApiService;

    public AccountServiceImpl() {
        accountApiService = new AccountApiService();
    }

    @Override
    public Response createAccount(RequestAccount body) {
        return accountApiService.post(body, AccountEndpoints.ACCOUNT_CREATE);
    }

    @Override
    public Response generateAccountToken(RequestAccount body) {
        return accountApiService.post(body, AccountEndpoints.ACCOUNT_TOKEN);
    }

    @Override
    public Response getSpecificAccount(String token, String userId) {
        String endPoint = AccountEndpoints.ACCOUNT_GET + userId;

        return accountApiService.get(token, endPoint);
    }

    @Override
    public Response deleteSpecificAccount(String token, String userId) {
        String endPoint = AccountEndpoints.ACCOUNT_DELETE + userId;

        return accountApiService.delete(token, endPoint);
    }
}
