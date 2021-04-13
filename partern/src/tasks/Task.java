package tasks;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import entities.IronDayAndMonthData;
import okhttp3.*;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2021/2/22 16:01.
 */
public class Task {

    private static final int DEFAULT_TIME_OUT = 5;//超时时间
    private static final int DEFAULT_READ_TIME_OUT = 5;//读取时间
    private static final int DEFAULT_WRITE_TIME_OUT = 5;//读取时间

    private static final MediaType JSON_MEDIA_TYPE = MediaType.parse("application/json; charset=utf-8");

    //real
//    private static final String ROOT_HTTP_URL_1 = "http://www.51taodj.com:3001/";//http://node2.51taodj.com:800;
//    private static final String ROOT_HTTP_URL_2 = "http://finance.51taodj.com/";
//    private static final String ROOT_HTTP_URL_3 = "http://gateway.51taodj.com:9000/";
//    private static final String ROOT_HTTP_URL_4 = "http://47.111.22.162:9000/";


    //test
//    private static final String ROOT_HTTP_URL_1 = "http://114.55.253.161:8001/";
//    private static final String ROOT_HTTP_URL_2 = "http://test-finance2.51taodj.com:8080/";
//    private static final String ROOT_HTTP_URL_3 = "http://47.111.22.162:9000/";

    //创客3.0售后
    private static final String ROOT_HTTP_URL_1 = "http://114.55.253.161:8001/";
    private static final String ROOT_HTTP_URL_2 = "http://test-finance2.51taodj.com:8080/";
    private static final String ROOT_HTTP_URL_3 = "http://47.111.22.162:9000/";


    Retrofit retrofit;
    Gson gson;


    public static void main(String[] args) {

        Task task = new Task();
//        task.config();

//        task.getafterSalesTask();//售后(0=补货/1=换货/2=退货)


//        task.gson = new GsonBuilder()
//                .setDateFormat("yyyy-MM-dd HH:mm:ss")
//                .create();
//
//        Type type = new TypeToken<List<GoodsInfo>>() {
//        }.getType();
//        String json = "[{\"pName\":\"产地\",\"pValue\":\"浙江省金华市\"},{\"pName\":\"长度\",\"pValue\":\"1CM以下\"},{\"pName\":\"颜色\",\"pValue\":\"红色\"},{\"pName\":\"形状\",\"pValue\":\"方形\"},{\"pName\":\"包装\",\"pValue\":\"无包装\"},{\"pName\":\"根蒂\",\"pValue\":\"粗\"}]";
//        List<GoodsInfo> goodsInfoList = task.gson.fromJson(json, type);
//        System.out.println(goodsInfoList.size() + "|" + goodsInfoList);
//        goodsInfoList.remove(goodsInfoList.size()-1);
//        goodsInfoList.remove(goodsInfoList.size()-1);
////        goodsInfoList.remove(goodsInfoList.size()-1);
////        goodsInfoList.remove(goodsInfoList.size()-1);
////        goodsInfoList.remove(goodsInfoList.size()-1);
////        goodsInfoList.remove(goodsInfoList.size()-1);
//        System.out.println(goodsInfoList.size() + "|" + goodsInfoList);
//
//        StringBuffer stringBuffer;
//        for (int i = 0; i < goodsInfoList.size();) {
//            stringBuffer = new StringBuffer();
//            for (int j = 0; j < 3; j++) {
//                System.out.println("j = " + j);
//                stringBuffer.append(goodsInfoList.get(i++).pName + " ");
//                if ((i + 1 > goodsInfoList.size())) {
//                    break;
//                }
//            }
//            System.out.println("---" + stringBuffer.toString());
//        }
//        System.out.println("goodsInfoList = " + goodsInfoList.get(0).pName);


//        String str = "ok|一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十";
//        str = "ok|一二三";
//
//        for (int i = 0; i < str.length(); i += 11) {
//            if (i + 11 < str.length()) {
//                System.out.println(str.substring(i, i + 11));
//            } else {
//                System.out.println(str.substring(i, str.length()));
//            }
//        }

//        float offset_y = 2;
//        offset_y += 5 * 2 + 1;
//        System.out.println("offset_y = " + offset_y);

//        ok(1, 2);


//        String d = "2021-04-12";
//        System.out.println("~~~~~~~~~~~" + d.substring(d.length()-2, d.length()));
//
//
//        Calendar ca = Calendar.getInstance();
//        //  ca.setTimeInMillis(date);
//        //ca.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
//        System.out.println(ca.get(Calendar.DATE));


//        String s = "";
//
//        System.out.println(s.isEmpty());


        String s = "{\"amount\":0.000000, \"addAmount\":0, \"times\":0, \"afterSaleAmount\":0.000000, \"afterSaleTimes\":0, \"amountCommission\":0, \"registerNum\":0, \"callNum\":0, \"activeNum\":0, \"addActiveNum\":0, \"reviewNum\":0, \"firstOrderNum\":0, \"userNum\":0, \"orderNum\":0, \"noOrderNum\":0, \"examineNum\":0, \"nickName\":null, \"partnerId\":null, \"parentId\":null, \"grade\":null, \"gradeName\":null, \"averageAmount\":0.00, \"yesterdayActiveNum\":0, \"addMonthAmount\":0, \"monthAvgActiveNum\":0.0, \"categoryNum\":0, \"gradeChineseName\":null, \"totalNum\":0, \"teamViewList\":[{\"amount\":0.000000, \"addAmount\":0, \"times\":0, \"afterSaleAmount\":0.000000, \"afterSaleTimes\":0, \"amountCommission\":0, \"registerNum\":0, \"callNum\":0, \"activeNum\":0, \"addActiveNum\":0, \"reviewNum\":0, \"firstOrderNum\":0, \"userNum\":0, \"orderNum\":0, \"noOrderNum\":0, \"examineNum\":0, \"nickName\":\"12\", \"partnerId\":25749, \"parentId\":258333, \"grade\":3, \"gradeName\":\"\", \"averageAmount\":0.00, \"yesterdayActiveNum\":0, \"addMonthAmount\":0, \"monthAvgActiveNum\":0.0, \"categoryNum\":0, \"gradeChineseName\":\"BD\", \"totalNum\":0, \"teamViewList\":null }, {\"amount\":0.000000, \"addAmount\":0, \"times\":0, \"afterSaleAmount\":0.000000, \"afterSaleTimes\":0, \"amountCommission\":0, \"registerNum\":0, \"callNum\":0, \"activeNum\":0, \"addActiveNum\":0, \"reviewNum\":0, \"firstOrderNum\":0, \"userNum\":0, \"orderNum\":0, \"noOrderNum\":0, \"examineNum\":0, \"nickName\":\"13\", \"partnerId\":25753, \"parentId\":258333, \"grade\":2, \"gradeName\":\"BD\", \"averageAmount\":0.00, \"yesterdayActiveNum\":0, \"addMonthAmount\":0, \"monthAvgActiveNum\":0.0, \"categoryNum\":0, \"gradeChineseName\":\"M1\", \"totalNum\":0, \"teamViewList\":null }, {\"amount\":0.000000, \"addAmount\":0, \"times\":0, \"afterSaleAmount\":0.000000, \"afterSaleTimes\":0, \"amountCommission\":0, \"registerNum\":0, \"callNum\":0, \"activeNum\":0, \"addActiveNum\":0, \"reviewNum\":0, \"firstOrderNum\":0, \"userNum\":0, \"orderNum\":0, \"noOrderNum\":0, \"examineNum\":0, \"nickName\":\"1\", \"partnerId\":258278, \"parentId\":258333, \"grade\":1, \"gradeName\":\"M1\", \"averageAmount\":0.00, \"yesterdayActiveNum\":0, \"addMonthAmount\":0, \"monthAvgActiveNum\":0.0, \"categoryNum\":0, \"gradeChineseName\":\"M2\", \"totalNum\":0, \"teamViewList\":null }]}";
//        s = "{\"amount\":0.000000,\"addAmount\":0,\"times\":0,\"afterSaleAmount\":0.000000,\"afterSaleTimes\":0,\"amountCommission\":0,\"registerNum\":0,\"callNum\":0,\"activeNum\":0,\"addActiveNum\":0,\"reviewNum\":0,\"firstOrderNum\":0,\"userNum\":0,\"orderNum\":0,\"noOrderNum\":0,\"examineNum\":0,\"nickName\":null,\"partnerId\":null,\"parentId\":null,\"grade\":null,\"gradeName\":null,\"averageAmount\":0.00,\"yesterdayActiveNum\":0,\"addMonthAmount\":0,\"monthAvgActiveNum\":0.0,\"categoryNum\":0,\"gradeChineseName\":null,\"totalNum\":0}";
        System.out.println("s = " + s);
        Gson gson = new Gson();
        IronDayAndMonthData ironDayAndMonthData = gson.fromJson(s, IronDayAndMonthData.class);
//        System.out.println(ironDayAndMonthData.activeNum);

        System.out.println(ironDayAndMonthData.teamViewList.size());
        System.out.println(ironDayAndMonthData.teamViewList.get(0).addMonthAmount);


    }

    private static void ok(int i, int j) {

        if (i == 0) if (j > 0) {
            System.out.println("dd");
            System.out.println("jj");
        }
    }

    static class GoodsInfo {
        String pName;
        String pValue;
    }

    private void getafterSalesTask() {


        Map<String, Object> map = new HashMap<>();
        map.put("userId", 258787);
        map.put("tab", 0);
        String json = gson.toJson(map);
        System.out.println("json = " + json);

        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), json);


        //方式一
//        try {
//            retrofit2.Call<Response<AfterSaleInfoData>> afterSalesRequestCall = retrofit.create(TaskService.class)
//                    .getafterSalesTask(requestBody);
//            retrofit2.Response<Response<AfterSaleInfoData>> responseBodyResponse = afterSalesRequestCall.execute();
//
//            if (responseBodyResponse.isSuccessful()) {
//                Response<AfterSaleInfoData> response = responseBodyResponse.body();
//                System.out.println("OK - [" + responseBodyResponse.code() + "] " + response);
//
//                if (response.err != 0) {
//                    System.out.println(response.msg);
//                } else {
//                    System.out.println(response.data.huanOver_list.size() + "|huanOver_list= " + response.data.huanOver_list.get(0));
//                }
//
//            } else {
//                System.out.println("Fail - [" + responseBodyResponse.code() + "] " + responseBodyResponse.errorBody());
//            }
//        } catch (IOException e) {
//
//            System.out.println("Fail:" + e.getMessage() + "~~~~~");
//            e.printStackTrace();
//        }


        //方式二:使用RxJava
        retrofit.create(TaskService.class)
                .getafterSalesTask(requestBody)
                .subscribe(System.out::println, Throwable::printStackTrace);

    }

    private void config() {

        gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd HH:mm:ss")
                .create();

        //构建客户端
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(DEFAULT_READ_TIME_OUT, TimeUnit.SECONDS)
                .writeTimeout(DEFAULT_WRITE_TIME_OUT, TimeUnit.SECONDS)
//                .addNetworkInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .addNetworkInterceptor(new Interceptor() {
                    @Override
                    public okhttp3.Response intercept(Chain chain) throws IOException {

                        Request request = chain.request();
                        System.out.println("[Network Interceptor]url is " + request.url());

                        return chain.proceed(request);
                    }
                });


        //设置支持所有https请求
//        HttpsUtils.SSLParams sslParams = HttpsUtils.getSslSocketFactory(null, null, null);
//        builder.hostnameVerifier((hostname, session) -> true).sslSocketFactory(sslParams.sSLSocketFactory, sslParams.trustManager);

//        builder.cookieJar(new PersistentCookieJar(new SetCookieCache(), new SharedPrefsCookiePersistor(App.getInstance())));
//        builder.cookieJar(new CookieManger(UIUtils.getContext()));
//        addInterceptor(builder);


        retrofit = new Retrofit.Builder()
                .client(builder.build())
                .baseUrl(ROOT_HTTP_URL_3)
                .addConverterFactory(ScalarsConverterFactory.create())//String转换器
                .addConverterFactory(GsonConverterFactory.create(gson))//GSon转换器
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())//RxJava适配器
                .build();
    }
}
