package Actions;

import ObjectData.RequestObject.RequestAccountBooks;
import ObjectData.RequestObject.RequestAccountBook;
import ObjectData.ResponseObject.ResponseAccountBooksSuccess;
import ObjectData.ResponseObject.ResponseAccountSuccess;
import RestClient.ResponseStatus;
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

        ResponseAccountBooksSuccess responseAccountBooksSuccess = response.body().as(ResponseAccountBooksSuccess.class);
        responseAccountBooksSuccess.validateNotNullFields();
        responseAccountBooksSuccess.validateBooks(requestAccountBooks.getCollectionOfIsbns());
    }

    public void updateSpecificBookFromAccount(String token, RequestAccountBook requestBody, String actualIsbn) {
        Response response = bookStoreServiceImpl.updateSpecificBook(requestBody, token, actualIsbn);
        Assert.assertEquals(response.getStatusCode(), ResponseStatus.SC_OK);

        ResponseAccountSuccess responseAccountSuccess = response.body().as(ResponseAccountSuccess.class);
        responseAccountSuccess.validateNotNullFields();
        responseAccountSuccess.validateBookPresence(requestBody.getIsbn());
    }

    public void deleteSpecificBookFromAccount(String token, RequestAccountBook requestBody) {
        Response response = bookStoreServiceImpl.deleteSpecificBook(requestBody, token);
        Assert.assertEquals(response.getStatusCode(), ResponseStatus.SC_NO_CONTENT);
    }

    public void deleteBooksFromAccount(String token, String userId) {
        Response response = bookStoreServiceImpl.deleteBooks(token, userId);
        Assert.assertEquals(response.getStatusCode(), ResponseStatus.SC_NO_CONTENT);
    }
}
