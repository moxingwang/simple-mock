package top.moxingwang.simplemock.client;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpClientTest {
    public static void main(String[] args) {
        try {
            String str = EntityUtils.toString(HttpClients.createDefault().execute(new HttpGet("https://www.baidu.com/")).getEntity(), "UTF-8");
            System.out.println(str);
        } catch (Exception e) {

        }

    }
}
