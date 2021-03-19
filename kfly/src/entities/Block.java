package entities;

import java.util.List;

/**
 * Created by Administrator on 2021/1/5 9:21.
 */
public class Block {
    public String id;
    public String projectId;
    public String name;
    public String introduce;
    public double area;
    public String coordinate;
//    public List<Coordinate> coordinate;
    public String user;
    public boolean enable;
    public List<FlightRoute> flightRouteVOS;

    @Override
    public String toString() {
        return "BlockVOS{" +
                "id='" + id + '\'' +
                ", projectId='" + projectId + '\'' +
                ", name='" + name + '\'' +
                ", introduce='" + introduce + '\'' +
                ", area=" + area +
                ", coordinate='" + coordinate + '\'' +
                ", user='" + user + '\'' +
                ", enable=" + enable +
                ", flightRouteVOS=" + flightRouteVOS +
                '}';
    }
}
