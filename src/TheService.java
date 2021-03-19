import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.adapter.rxjava2.Result;
import retrofit2.http.*;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2020/11/9 8:58.
 */
public interface TheService {

    @GET("javase/8/docs/technotes/guides/language/generics.html")
    Call<ResponseBody> getResponseBody();

    @GET("get.php")
    Call<ResponseBody> getTag(@Tag Object object);

    @Streaming
    @GET("javase/8/docs/technotes/guides/language/generics.html")
    Call<ResponseBody> getStream();

    @GET("get.php")
    Call<String> getCallString();

//    @HTTP(method = "GET", hasBody = false, path = "get.php")
    @HTTP(method = "GET")
    Call<ResponseBody> getHttp(@Url String url);

    @GET("get.php")
    Observable<Result<ResponseBody>> getRx();

    @GET("get.php")
    Call<ResponseBody> getQuery(@Query("one") String one);

    @GET("get.php")
    Call<ResponseBody> getQueryName(@QueryName String one);

    @GET("get.php")
    Call<ResponseBody> getQueryMap(@QueryMap Map<String, String> querys);

    @GET("get.php")
    @Headers({"one:111", "two:222"})
    Call<ResponseBody> getWithHeaders();

    @FormUrlEncoded
    @POST("post.php")
    Call<ResponseBody> postField(@Field(value="name", encoded = true) String one);


    @POST("post.php")
    Call<ResponseBody> postForm(@Body RequestBody requestBody);

    @POST("postJson.php")
    Call<ResponseBody> postJson(@Body User user);

    @Multipart
    @POST("post.php")
    Call<ResponseBody> postMultipart(@Part MultipartBody.Part photo,
                                    @Part("ccc") RequestBody description);

    @GET("json.php")
    Call<List> getGson();


    @Headers({"one:111", "two:222"})
    @GET("get.php")
    String getString(@Header("three") String three);
}
