package Service.ServiceImplementation;

import ObjectData.RequestObject.RequestAccountBooks;
import ObjectData.RequestObject.RequestAccountBook;
import Service.ApiService.BookstoreApiService;
import Service.InterfaceService.BookStoreServiceInterface;
import io.restassured.response.Response;

public class BookStoreServiceImpl implements BookStoreServiceInterface {

    private BookstoreApiService bookstoreApiService;

    @Override
    public Response addBooksToAccount(RequestAccountBooks body, String token) {
        bookstoreApiService = new BookstoreApiService();

        return bookstoreApiService.post(body, "/BookStore/v1/Books", token);
    }

    @Override
    public Response updateSpecificBook(RequestAccountBook body, String token, String actualIsbn) {
        bookstoreApiService = new BookstoreApiService();
        String url = "BookStore/v1/Books/" + actualIsbn;

        return bookstoreApiService.put(body, url, token);
    }

    @Override
    public Response deleteSpecificBook(RequestAccountBook body, String token) {
        bookstoreApiService = new BookstoreApiService();

        return bookstoreApiService.delete(body, token, "/BookStore/v1/Book");

    }

    @Override
    public Response deleteBooks(String token, String userId) {
        bookstoreApiService = new BookstoreApiService();
        String url = "BookStore/v1/Books?UserId=" + userId;

        return bookstoreApiService.delete(token, url);

    }
}
