package tasks;

import entities.AfterSaleInfoData;
import entities.BaseResponse;
import io.reactivex.Observable;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by Administrator on 2021/1/13 14:49.
 */
public interface TaskService {

    @Headers({"url_type:xuming"})
    @POST("tdj-partner/partner/version/check")
    Call<ResponseBody> version_check(@Body RequestBody body);



    //***[创客3.0]售后*****************************************************
    /**
     * 指派售后列表
     * @param body：JSON数据(userId, tab:0=补货/1=换货/2=退货)
     * @return
     */
    @POST("tdj-partner/partner/afterSalesApplication/getafterSalesTask")
    Call<BaseResponse<AfterSaleInfoData>> getafterSalesTaskWithCall(@Body RequestBody body);
    @POST("tdj-partner/partner/afterSalesApplication/getafterSalesTask")
    Observable<BaseResponse<AfterSaleInfoData>> getafterSalesTask(@Body RequestBody body);



}
