package Service.ServiceImplementation;

import ObjectData.RequestObject.RequestAccount;
import Service.ApiService.AccountApiService;
import Service.InterfaceService.AccountServiceInterface;
import io.restassured.response.Response;

public class AccountServiceImpl implements AccountServiceInterface {

    // facem o instanta de ApiService ca sa putem accesa metodele generale(din CommonApiService)
    private AccountApiService accountApiService;

    @Override
    public Response createAccount(RequestAccount body) {
        accountApiService = new AccountApiService();

        return accountApiService.post(body, "/Account/v1/User");
    }

    @Override
    public Response generateAccountToken(RequestAccount body) {
        accountApiService = new AccountApiService();

        return accountApiService.post(body, "/Account/v1/GenerateToken");
    }

    @Override
    public Response getSpecificAccount(String token, String userId) {
        return null;
    }

    @Override
    public Response deleteSpecificAccount(String token, String userId) {
        return null;
    }
}
