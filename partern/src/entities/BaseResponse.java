package entities;

/**
 * Created by wyh on 2021/3/18.
 */
public class BaseResponse<T> {

    public int err = 0;
    public T data = null;
    public String error = "";
    public String msg = "";
    public String errorCode = "";

    @Override
    public String toString() {
        return "AfterSalesRequest{" +
                "err=" + err +
                ", data=" + data +
                ", error='" + error + '\'' +
                ", msg='" + msg + '\'' +
                ", errorCode='" + errorCode + '\'' +
                '}';
    }
}
