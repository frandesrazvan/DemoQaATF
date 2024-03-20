package ObjectData.ResponseObject;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseTokenSuccess {

    @JsonProperty("token")
    private String token;
    @JsonProperty("expires")
    private String expires;
    @JsonProperty("result")
    private String result;
    @JsonProperty("status")
    private String status;

    public String getToken() {
        return token;
    }

    public String getExpires() {
        return expires;
    }

    public String getResult() {
        return result;
    }

    public String getStatus() {
        return status;
    }
}
