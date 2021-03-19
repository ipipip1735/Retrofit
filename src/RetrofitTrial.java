import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.reactivex.Observable;
import okhttp3.*;
import okio.*;
import retrofit2.*;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.adapter.rxjava2.Result;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2020/11/9 8:54.
 */
public class RetrofitTrial {

    public static void main(String[] args) {
        RetrofitTrial retrofitTrial = new RetrofitTrial();

//        retrofitTrial.get();
//        retrofitTrial.getHttp();
//        retrofitTrial.getQuery();
//        retrofitTrial.getQueryMap();
//        retrofitTrial.getWithStream();
//        retrofitTrial.getWithTag();
        retrofitTrial.getWithClient();

//        retrofitTrial.postField();
//        retrofitTrial.postForm();
//        retrofitTrial.postMultipart();

//        retrofitTrial.headers();

//        retrofitTrial.getWithClient();

//        retrofitTrial.converter();
//        retrofitTrial.adapter();

    }

    private void getWithClient() {

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public okhttp3.Response intercept(Chain chain) throws IOException {
                        return chain.proceed(chain.request());
                    }
                })
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost/")
                .client(okHttpClient)
                .build();

    }

    private void getWithTag() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost/")
                .build();

        TheService service = retrofit.create(TheService.class);

        Object object = new Object();
        Call<ResponseBody> call = service.getTag(object);
        System.out.println("request is " + call.request());

        Request request = call.request();
        if (request.tag().equals(object))
            call.cancel();

    }

    private void getWithStream() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://docs.oracle.com/")
                .build();

        TheService service = retrofit.create(TheService.class);
        Call<ResponseBody> call = service.getStream();
        try {
            ResponseBody responseBody = call.execute().body();
            System.out.println("responseBody = " + responseBody);
            InputStream inputStream = responseBody.byteStream();
            System.out.println("inputStream.available() is " + inputStream.available());

            byte[] bytes = new byte[1024];
            int n = 0;
            while ((n = inputStream.read(bytes)) != -1) {
                System.out.println(new String(bytes, 0, n));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void getHttp() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost/")
                .build();

        TheService service = retrofit.create(TheService.class);
//        Call<ResponseBody> call = service.getHttp();
        Call<ResponseBody> call = service.getHttp("get.php");
        try {
            System.out.println(call.execute().body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private void postField() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost/")
                .build();

        TheService service = retrofit.create(TheService.class);
        Call<ResponseBody> call = service.postField("111");
        try {
            System.out.println(call.execute().body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void headers() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost/")
                .build();


        TheService service = retrofit.create(TheService.class);
        Call<ResponseBody> call = service.getWithHeaders();
        System.out.println(call.request().url());
        try {
            System.out.println(call.execute().body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void postMultipart() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost/")
                .build();

        RequestBody description = RequestBody.create(MediaType.parse("text/plain"), ByteString.encodeUtf8("ooo"));
//        MultipartBody.Part descriptionPart = MultipartBody.Part.createFormData("xxx", "yyy");

        RequestBody photo = MultipartBody.create(MediaType.parse("image/jpeg"), new File("res/a.jpg"));
        MultipartBody.Part photoPart = MultipartBody.Part.createFormData("photo", "b.jpg", photo);


        //分段上传
//        RequestBody photo = new RequestBody() {
//            @Override
//            public MediaType contentType() {
//                return MediaType.parse("image/jpeg");
//            }
//
//            @Override
//            public void writeTo(BufferedSink sink) throws IOException {
//                BufferedSource bufferedSource = Okio.buffer(Okio.source(new File("res/a.jpg")));
//                sink.writeAll(bufferedSource);
//            }
//        };


        TheService service = retrofit.create(TheService.class);
        Call<ResponseBody> call = service.postMultipart(photoPart, description);
        try {
            System.out.println(call.execute().body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private void postForm() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost/")
                .build();

        RequestBody requestBody = new FormBody.Builder()
                .add("one", "111")
                .addEncoded("two", "!@#$%^&*()_<>?")
                .build();

        TheService service = retrofit.create(TheService.class);
        Call<ResponseBody> call = service.postForm(requestBody);
        try {
            System.out.println(call.execute().body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void getQueryMap() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost/")
                .build();

        Map<String, String> map = new HashMap<>();
        map.put("one", "111");

        TheService service = retrofit.create(TheService.class);
        Call<ResponseBody> call = service.getQueryMap(map);
        System.out.println(call.request().url());
        try {
            System.out.println(call.execute().body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void getQuery() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost/")
                .build();

        TheService service = retrofit.create(TheService.class);
//        Call<ResponseBody> call = service.getQuery("111");
        Call<ResponseBody> call = service.getQueryName("aaa");
        System.out.println(call.request().url());
        try {
            System.out.println(call.execute().body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void converter() {


        //方式一：使用内置转换器
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd HH:mm:ss")
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost")
                .addConverterFactory(GsonConverterFactory.create())
//                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        TheService server = retrofit.create(TheService.class);

//        Call<List> callGet = server.getGson();//GET请求时将返回的JSON字符串转换为JAVA对象
//        try {
//            List list = callGet.execute().body();
//            System.out.println(list);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        Call<ResponseBody> callPost = server.postJson(new User("Bob", 18));//POST请求时将JAVA对象转换为JSON发送
        try {
            System.out.println(callPost.execute().body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }


        //方式二：自定义转换器
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("http://localhost")
//                .addConverterFactory(new Converter.Factory() {
//                    @Override
//                    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
//                        System.out.println("~~responseBodyConverter~~");
//                        System.out.println("retrofit is " + retrofit);
//                        System.out.println("type is " + type);
//                        for (int i = 0; i < annotations.length; i++) {
//                            System.out.println(annotations[i]);
//                        }
//
//                        if (type == String.class)
//                            return new Converter<ResponseBody, String>() {
//                                @Override
//                                public String convert(ResponseBody value) throws IOException {
//                                    System.out.println("~~convert~~");
//                                    return value.string();
//                                }
//                            };
//
//                        return super.responseBodyConverter(type, annotations, retrofit);
//                    }
//
//                    @Override
//                    public Converter<?, RequestBody> requestBodyConverter(Type type, Annotation[] parameterAnnotations, Annotation[] methodAnnotations, Retrofit retrofit) {
//                        System.out.println("~~requestBodyConverter~~");
//                        return super.requestBodyConverter(type, parameterAnnotations, methodAnnotations, retrofit);
//                    }
//
//                    @Override
//                    public Converter<?, String> stringConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
//                        System.out.println("~~stringConverter~~");
//                        return super.stringConverter(type, annotations, retrofit);
//                    }
//                })
//                .build();
//
//
//        TheService service = retrofit.create(TheService.class);
//        Call<String> call = service.getCallString();
//        try {
//            Response<String> response = call.execute();
//            String body = response.body();
//            System.out.println(body);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }

    private void adapter() {

        //方式一：使用内置适配器
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost/")
//                .baseUrl("https://docs.oracle.com/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(io()))
                .build();

        TheService service = retrofit.create(TheService.class);
        Observable<Result<ResponseBody>> resultObservable = service.getRx();
        resultObservable.subscribe(
                responseBodyResult -> {
                    System.out.println("~~onNext~~");
                    System.out.println("responseBodyResult = " + responseBodyResult);

                    if (responseBodyResult.isError()) {
                        Throwable throwable = responseBodyResult.error();
                        System.out.println(throwable);
                        return;
                    }
                    Response<ResponseBody> responseBodyResponse = responseBodyResult.response();
                    System.out.println(responseBodyResponse.headers());
                    System.out.println(responseBodyResponse.body().string());

                },
                throwable -> {
                    System.out.println("~~onError~~");
                    System.out.println("throwable = " + throwable);
                    throwable.printStackTrace();
                });


        //方式二：自定义适配器
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("http://localhost/")
//                .addCallAdapterFactory(new CallAdapter.Factory() {
//                    @Override
//                    public CallAdapter<?, ?> get(Type returnType, Annotation[] annotations, Retrofit retrofit) {
//                        System.out.println("~~Factory.get~~");
//                        System.out.println("retrofit is " + retrofit);
//                        System.out.println("returnType is " + returnType);
//                        Arrays.stream(annotations).sequential().forEach(System.out::println);
//
//
//                        return new CallAdapter<ResponseBody, String>() {
//                            @Override
//                            public Type responseType() {
//                                System.out.println("~~CallAdapter.responseType~~");
//
//                                return ResponseBody.class;
//                            }
//
//                            @Override
//                            public String adapt(Call<ResponseBody> call) {
//                                System.out.println("~~CallAdapter.adapt~~");
//
//                                try {
//                                    System.out.println("request is " + call.request());
//                                    String body = call.execute().body().string();
//                                    return body;
//                                } catch (IOException e) {
//                                    e.printStackTrace();
//                                }
//
//                                return "Error!";
//                            }
//                        };
//                    }
//                })
//                .build();
//
//        TheService service = retrofit.create(TheService.class);
//        String body = service.getString("333");
//        System.out.println(body);

    }

    private void get() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://docs.oracle.com/")
                .build();

        TheService service = retrofit.create(TheService.class);
        Call<ResponseBody> call = service.getResponseBody();
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                System.out.println("~~onResponse~~");
                System.out.println("response is " + response);
                System.out.println("request is " + call.request());

                try {
                    System.out.println(response.body().string());

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                System.out.println("~~onFailure~~");
                t.printStackTrace();
            }
        });

    }
}
