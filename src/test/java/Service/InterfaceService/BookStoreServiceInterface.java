package Service.InterfaceService;

import ObjectData.RequestObject.RequestAccountBooks;
import ObjectData.RequestObject.RequestAccountBook;
import io.restassured.response.Response;

public interface BookStoreServiceInterface {

    // Aceasta interfata reprezinta actiunile pe care serviciul BookStore le poate face
    Response addBooksToAccount(RequestAccountBooks body, String token);
    //DE IMPLEMENTAT DATA VIITOARE
    Response updateSpecificBook(RequestAccountBook body, String token, String actualIsbn);
    Response deleteSpecificBook(RequestAccountBook body, String token);
    Response deleteBooks(String token, String userId);
}
