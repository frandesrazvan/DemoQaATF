package ObjectData.ResponseObject;

import ObjectData.BookObject;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

@Getter
public class ResponseAccountGetSuccess {

    @JsonProperty("userId") // aici e cu d mic
    private String userId;
    @JsonProperty("username")
    private String username;
    @JsonProperty("books")
    private List<BookObject> books;
}
