package ObjectData.ResponseObject;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import org.testng.Assert;

@Getter
public class ResponseTokenSuccess implements ResponseNotNull {

    @JsonProperty("token")
    private String token;
    @JsonProperty("expires")
    private String expires;
    @JsonProperty("result")
    private String result;
    @JsonProperty("status")
    private String status;

    @Override
    public void validateNotNullFields() {
        Assert.assertNotNull(token);
        Assert.assertNotNull(expires);
        Assert.assertNotNull(result);
        Assert.assertNotNull(status);
    }
}
