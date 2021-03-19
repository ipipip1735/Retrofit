package task;

import entities.RR;
import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.adapter.rxjava2.Result;
import retrofit2.http.*;
import task.Task;

/**
 * Created by Administrator on 2021/1/13 14:49.
 */
public interface TaskService {

        //获取用户
        @FormUrlEncoded
        @Headers({"Authorization: Basic RDgyRjgxMzRFMDFEMTFFOUE0RjM1MDQ2NUQ1NjAxQ0U6OTUyNjNFQTBFMDFFMTFFOUE0RjM1MDQ2NUQ1NjAxQ0U=", "Content-Type:application/x-www-form-urlencoded"})
        @POST("oauth/token")
        Call<UserInfo> getUserInfo(@Field("username") String userName,
                                        @Field("password") String password,
                                        @Field("grant_type") String grant_type);


        //实时飞行数据
        @POST("prodfm/api/uavRealTimeDataTransfer")
        Call<ResponseBody> updateRealUAVData(@Body RequestBody requestBody,
                                             @Query("access_token") String access_token);


        //获取任务状态
        @GET("prodpc/api/mission/{status}/{taskType}")
        Call<ResponseBody> misson(@Path("status") String status,
                                  @Path("taskType") int taskType,
                                  @Header("Authorization") String authorization);

        //获取全景任务状态
        @GET("/prodmd/api/panpoint/panoramaPoint")
        Call<ResponseBody> panoramaPoint();

        //更新全景任务状态
        @POST("/prodmd/api/panpoint/saveAndUpdate")
        Call<ResponseBody> updatePanorama(@Body RequestBody requestBody);


        //更新任务状态
        @POST("prodfm/api/updateMissionState")
//        @POST("prodfm/api/flightRoute")
        Call<ResponseBody> updateMissionState(@Body RequestBody requestBody,
                                              @Query("access_token") String access_token);

        //更新路由
        @POST("prodmd/api/flightRoute")
        Call<ResponseBody> flightRoute(@Body RequestBody requestBody);


        //获取任务
        @GET("prodmd/api/project")
        Call<ResponseBody> project();


        //更新项目
        @POST("prodmd/api/projects")
        Call<ResponseBody> projects(@Body RequestBody requestBody);
//        Observable<Result<ResponseBody>> projects(@Body RequestBody requestBody);
//        Observable<RR> projects(@Body RequestBody requestBody);

        //更新项目
        @POST("prodmd/api/blocks")
        Call<ResponseBody> blocks(@Body RequestBody requestBody);



        //上传预览图
        @Multipart
        @POST("prodfm/api/uavShotRealTimeDataTransfer")
        Call<ResponseBody> postPreview(
                @Part("userName") RequestBody userName,
                @Part("taskId") RequestBody taskId,
                @Part("altitude") double altitude,
                @Part("latitude") double latitude,
                @Part("longitude") double longitude,
                @Part("yawAngle") double yawAngle,
                @Part MultipartBody.Part part,
                @Query("access_token") String access_token);


        //上传日志图
        @Multipart
        @POST("prodpc/api/appLogFileUpload")
        Call<ResponseBody> appLogFileUpload(@Part MultipartBody.Part part);

}
