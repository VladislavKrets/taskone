package omnia.task.one;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lollipop on 26.06.2017.
 */
public class HttpMethods {

    private static final String BASE_URL;
    private static final String TOKEN_KEY;
    private static CloseableHttpClient httpClient;

    static {
        BASE_URL = "http://api.omnia.online/3.0/";
        TOKEN_KEY = "";
        httpClient = HttpClients.createDefault();
    }


    public static String methodGet(String query) throws IOException {
        HttpGet httpGet = new HttpGet(BASE_URL + query);
        httpGet.addHeader("API-Key", TOKEN_KEY);
        return getResponse(httpGet);
    }

    public static String methodPost(String query, List<NameValuePair> nameValuePairs) throws IOException {
        HttpPost httpPost = new HttpPost(BASE_URL + query);
        httpPost.addHeader("API-Key", TOKEN_KEY);
        httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
        return getResponse(httpPost);
    }
    private static String getResponse(HttpRequestBase requestBase) throws IOException {
        CloseableHttpResponse response = httpClient.execute(requestBase);
        BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "UTF-8"));
        String answer = reader.readLine();
        reader.close();
        response.close();
        return answer;
    }

}
