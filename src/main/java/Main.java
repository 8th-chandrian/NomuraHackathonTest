import Domain.Security;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static final String BASE_IEX_URL = "https://api.iextrading.com/1.0";

    public static void main(String[] args) throws Exception {
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet getData = new HttpGet(BASE_IEX_URL + "/tops?symbols=SNAP,FB,AAPL");
        HttpResponse response = client.execute(getData);

        String jsonResponse = readResponseFromInputStream(response.getEntity().getContent());

        ObjectMapper mapper = new ObjectMapper();
        List<Security> responseData = Arrays.asList(mapper.readValue(jsonResponse, Security[].class));

        for(Security s : responseData){
            System.out.println(s);
        }
    }

    public static String readResponseFromInputStream(InputStream inputStream) throws IOException {
        ByteArrayOutputStream result = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int length;
        while ((length = inputStream.read(buffer)) != -1) {
            result.write(buffer, 0, length);
        }

        return result.toString("UTF-8");
    }
}
