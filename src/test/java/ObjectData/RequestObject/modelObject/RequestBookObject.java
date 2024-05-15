package ObjectData.RequestObject.modelObject;

import ObjectData.ResponseObject.ResponseNotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.testng.Assert;

@AllArgsConstructor
@Data
public class RequestBookObject implements ResponseNotNull {

    private String isbn;

    @Override
    public void validateNotNullFields() {
        Assert.assertNotNull(isbn);
    }
}
