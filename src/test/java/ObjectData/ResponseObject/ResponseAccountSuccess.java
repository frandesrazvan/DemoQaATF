package ObjectData.ResponseObject;

import ObjectData.ResponseObject.modelObject.ResponseBookObject;
import ObjectData.ResponseNotNull;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import org.testng.Assert;

import java.util.List;

@Getter
public class ResponseAccountSuccess implements ResponseNotNull {

    @JsonProperty("userID")
    private String userID;
    @JsonProperty("username")
    private String username;
    @JsonProperty("books")
    private List<ResponseBookObject> books;

    @Override
    public void validateNotNullFields() {
        Assert.assertNotNull(userID);
        Assert.assertNotNull(username);
        for(ResponseBookObject responseBookObject : books){
            responseBookObject.validateNotNullFields();
        }
    }
}
