package top.moxingwang.simplemock.client;


public class HttpClientTest {
    public static void main(String[] args) {
        try {
            String str = org.apache.http.util.EntityUtils.toString(org.apache.http.impl.client.HttpClients.createDefault().execute(new org.apache.http.client.methods.HttpGet("https://www.baidu.com/")).getEntity(), "UTF-8");
            System.out.println(str);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
