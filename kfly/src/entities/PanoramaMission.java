package entities;

import java.util.Date;

/**
 * Created by Administrator on 2021/2/4 8:49.
 */
public class PanoramaMission {
    public String id;
    public String name;
    public Date createTime;
    public String point;
    public float flightHeight;


    @Override
    public String toString() {
        return "PanoramaMission{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", createTime=" + createTime +
                ", point='" + point + '\'' +
                ", flightHeight=" + flightHeight +
                '}';
    }
}
