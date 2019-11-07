package top.moxingwang.simplemock.test.service;

public class OrderService {
    public String createOrder(String sku, String openId) {
        String goodsList = getGoodsDetail(sku);

        String userInfo = getUserInfo(openId);

        System.out.println(goodsList + "-" + userInfo);

        return "new order";
    }

    public String getGoodsDetail(String sku) {

        return "goods info";
    }

    public String getUserInfo(String openId) {

        return "user info";
    }
}
