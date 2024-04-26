package ObjectData.ResponseObject;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class ResponseTokenSuccess {

    @JsonProperty("token")
    private String token;
    @JsonProperty("expires")
    private String expires;
    @JsonProperty("result")
    private String result;
    @JsonProperty("status")
    private String status;
}
