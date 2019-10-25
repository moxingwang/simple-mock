package top.moxingwang.simplemock.test.service;


public class HttpClientTest {
    public static void main(String[] args) {
        try {
            String mockUrl = "http://localhost:8080/simple-mock/mock/string/java.lang.reflect.Method.userInfo";


            String str = org.apache.http.util.EntityUtils.toString(org.apache.http.impl.client.HttpClients.createDefault().execute(new org.apache.http.client.methods.HttpGet(mockUrl)).getEntity(), "UTF-8");

            System.out.println(str);
            if (null != str && str.length() > 0) {
                System.out.println(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
