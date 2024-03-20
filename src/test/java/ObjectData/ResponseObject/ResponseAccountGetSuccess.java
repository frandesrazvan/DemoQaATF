package ObjectData.ResponseObject;

import ObjectData.BookObject;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ResponseAccountGetSuccess {

    @JsonProperty("userId") // aici e cu d mic
    private String userId;
    @JsonProperty("username")
    private String username;
    @JsonProperty("books")
    private List<BookObject> books;

    public String getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public List<BookObject> getBooks() {
        return books;
    }
}
