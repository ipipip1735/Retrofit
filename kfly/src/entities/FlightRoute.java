package entities;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2021/1/5 9:21.
 */
public class FlightRoute {
    public String id;
    public String name;
    public double area;
    public String user;
//    public List<Coordinate> coordinate;
    public String coordinate;
    public String enable;
    public float flyHeight;
    public float lineOverlap;
    public float speed;
    public float headingOverlap;
    public float rotatePitch;
    public Date creatTime;
    public List<WayPoint> wayPointList;

    @Override
    public String toString() {
        return "FlightRouteVOS{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", area=" + area +
                ", user='" + user + '\'' +
                ", coordinate='" + coordinate + '\'' +
                ", enable='" + enable + '\'' +
                ", flyHeight=" + flyHeight +
                ", lineOverlap=" + lineOverlap +
                ", speed=" + speed +
                ", headingOverlap=" + headingOverlap +
                ", rotatePitch=" + rotatePitch +
                ", creatTime=" + creatTime +
                ", wayPointVOList=" + wayPointList +
                '}';
    }
}
