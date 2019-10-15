package top.moxingwang.simplemock.test.service;


import top.moxingwang.simplemock.core.SimpleMockConstant;

public class HttpClientTest {
    public static String main(String[] args) {
        try {
            String str = org.apache.http.util.EntityUtils.toString(org.apache.http.impl.client.HttpClients.createDefault().execute(new org.apache.http.client.methods.HttpGet(System.getProperty(SimpleMockConstant.SIMPLE_MOCK_VM_SERVER_URL))).getEntity(), "UTF-8");
            System.out.println(str);
            if (null != str && str.length() > 0) {
                return str;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "OK";
    }
}
