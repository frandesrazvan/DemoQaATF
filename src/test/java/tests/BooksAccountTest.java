package tests;

import actions.AccountActions;
import actions.BookStoreActions;
import objectData.requestObject.RequestAccount;
import objectData.requestObject.RequestAccountBooks;
import objectData.requestObject.RequestAccountBook;
import objectData.responseObject.ResponseAccountSuccess;
import objectData.responseObject.ResponseTokenSuccess;
import propertyUtility.PropertyUtility;
import extentUtility.ExtentUtility;
import extentUtility.ReportStep;
import hooks.Hooks;
import org.testng.annotations.Test;

import java.util.HashMap;

public class BooksAccountTest extends Hooks {
    public String userId;
    public String token;
    public RequestAccount requestAccountBody;
    public AccountActions accountActions;
    public BookStoreActions bookStoreActions;
    public RequestAccountBooks requestAccountBooks;
    public RequestAccountBook requestAccountBook;

    @Test
    public void method() {
        System.out.println("Step 1: Create new account");
        createAccount();
        ExtentUtility.attachReportLog(ReportStep.PASS_STEP, "The user creates a new account with success");

        System.out.println("\nStep 2: Generate new token");
        generateToken();
        ExtentUtility.attachReportLog(ReportStep.PASS_STEP, "The user generates a token for new account with success");

        System.out.println("\nStep 3: Get new account");
        getSpecificAccount();
        ExtentUtility.attachReportLog(ReportStep.PASS_STEP, "The user validates the presence of new account with success");

        System.out.println("\nStep 4: Add books to account");
        addBooksToAccount();

        System.out.println("\nStep 5: Get new account with books");
        getSpecificAccount();
        ExtentUtility.attachReportLog(ReportStep.PASS_STEP, "The user validates the presence of new account with success");

        System.out.println("\nStep 6: Update specific book from account");
        updateSpecificBook();
        ExtentUtility.attachReportLog(ReportStep.PASS_STEP, "The user modifies an existing book with success");

        System.out.println("\nStep 7: Delete specific book from account");
        deleteSpecificBook();
        ExtentUtility.attachReportLog(ReportStep.PASS_STEP, "The user deletes an existing book with success");

        System.out.println("\nStep 8: Get new account with books");
        getSpecificAccount();
        ExtentUtility.attachReportLog(ReportStep.PASS_STEP, "The user validates the presence of new account with success");

        System.out.println("\nStep 9: Delete account books");
        deleteAccountBooks();
        ExtentUtility.attachReportLog(ReportStep.PASS_STEP, "The user deletes all the books from account with success");

        System.out.println("\nStep 10: Get new account with books");
        getSpecificAccount();
        ExtentUtility.attachReportLog(ReportStep.PASS_STEP, "The user validates the presence of new account with success");

        System.out.println("\nStep 11: Delete the newly created account");
        deleteSpecificAccount();
        ExtentUtility.attachReportLog(ReportStep.PASS_STEP,"The user deletes the new account with success");

        System.out.println("\nStep 12: Check if newly deleted account was deleted");
        getSpecificAccount();
        ExtentUtility.attachReportLog(ReportStep.PASS_STEP,"The user validates the presence of deleted account with success");
    }

    public void createAccount() {
        accountActions = new AccountActions();
        propertyUtility = new PropertyUtility("requestData/createAccountData");
        requestAccountBody = new RequestAccount(propertyUtility.getAllData());
        ResponseAccountSuccess responseAccountBody = accountActions.createNewAccount(requestAccountBody);
        userId = responseAccountBody.getUserID();
    }

    public void generateToken() {
        ResponseTokenSuccess responseTokenSuccess = accountActions.generateToken(requestAccountBody);
        token = responseTokenSuccess.getToken();
    }

    public void getSpecificAccount() {
        accountActions.getSpecificAccount(token, userId, requestAccountBody);
    }

    public void updateSpecificBook() {
        propertyUtility = new PropertyUtility("requestData/booksAccountData");
        HashMap<String, String> testData = propertyUtility.getAllData();

        String expectedIsbn = testData.get("expectedIsbn");
        String actualIsbn = testData.get("actualIsbn");

        testData.put("userId", userId);
        testData.put("isbn", expectedIsbn);
        requestAccountBook = new RequestAccountBook(testData);

        bookStoreActions.updateSpecificBookFromAccount(token, requestAccountBook, actualIsbn);
    }

    public void deleteSpecificBook() {
        bookStoreActions.deleteSpecificBookFromAccount(token, requestAccountBook);
    }

    public void deleteAccountBooks() {
        bookStoreActions.deleteBooksFromAccount(token, userId);
    }

    public void addBooksToAccount() {
        propertyUtility = new PropertyUtility("requestData/booksAccountData");
        HashMap<String, String> testData = propertyUtility.getAllData();
        testData.put("userId", userId);
        requestAccountBooks = new RequestAccountBooks(testData);

        bookStoreActions = new BookStoreActions();
        bookStoreActions.addBooksToAccount(token, requestAccountBooks);
    }

    public void deleteSpecificAccount() {
        accountActions.deleteSpecificAccount(token, userId);
    }
}
