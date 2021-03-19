package tasks;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entities.AfterSaleInfoData;
import entities.Response;
import okhttp3.*;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import java.io.IOException;
import java.util.HashMap;
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
        task.config();


        task.getafterSalesTask();//售后(0=补货/1=换货/2=退货)
    }

    private void getafterSalesTask() {


        Map<String, Integer> map = new HashMap<>();
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
                .getafterSalesTaskWithRx(requestBody)
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
