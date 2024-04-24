package ObjectData.RequestObject;

import ObjectData.ModelObject.BookObject;
import ObjectData.RequestPreparation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RequestAccountBooks implements RequestPreparation {

    private String userId;
    private List<BookObject> collectionOfIsbns;

    public RequestAccountBooks(HashMap<String, String> testData) {
        prepareObject(testData);
    }

    @Override
    public void prepareObject(HashMap<String, String> testData) {
        for (String key : testData.keySet()) {
            switch (key) {
                case "userId" -> setUserId(testData.get((key)));
                case "collectionOfIsbns" -> prepareBooks((testData.get(key)));
            }
        }
    }

    // Trebuie sa parse-am valoarea pentru carti intr-o lista de obiecte(BookObject)
    private void prepareBooks(String value) {
        collectionOfIsbns = new ArrayList<>();
        String[] books = value.split(",");

//        for (int i = 0; i < books.length; i++) {
//            collectionOfIsbns.add(new BookObject(books[i]));
//        }
        for (String book : books) {
            collectionOfIsbns.add(new BookObject(book));
        }
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<BookObject> getCollectionOfIsbns() {
        return collectionOfIsbns;
    }

    public void setCollectionOfIsbns(List<BookObject> collectionOfIsbns) {
        this.collectionOfIsbns = collectionOfIsbns;
    }
}
