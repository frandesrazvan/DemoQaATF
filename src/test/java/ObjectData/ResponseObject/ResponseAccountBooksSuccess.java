package ObjectData.ResponseObject;

import ObjectData.BookObject;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ResponseAccountBooksSuccess {

    @JsonProperty("userId") // aici e cu d mic
    private String userId;
    @JsonProperty("username")
    private String username;
    @JsonProperty("books")
    private List<BookObject> books;

}
