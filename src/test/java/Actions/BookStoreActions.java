package Actions;

import ObjectData.RequestObject.RequestAccountBooks;
import RestClient.ResponseStatus;
import Service.ServiceImplementation.AccountServiceImpl;
import Service.ServiceImplementation.BookStoreServiceImpl;
import io.restassured.response.Response;
import org.testng.Assert;

public class BookStoreActions {

    private BookStoreServiceImpl bookStoreServiceImpl;

    public BookStoreActions() {
        bookStoreServiceImpl = new BookStoreServiceImpl();
    }

    public void addBooksToAccount(String token, RequestAccountBooks requestAccountBooks) {
        Response response = bookStoreServiceImpl.addBooksToAccount(requestAccountBooks, token);

        Assert.assertEquals(response.getStatusCode(), ResponseStatus.SC_CREATED);

    }
}
