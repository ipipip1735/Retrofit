package util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.Math.cos;
import static java.lang.Math.max;

/**
 * Created by Administrator on 2020/11/23 9:04.
 */
public class Calculator {

    private List<JingWeidu> mControlPoint;

    public static void main(String[] args) {


        Calculator calculator = new Calculator();

        Random random = new Random();
        float flyHeight = max(50, random.nextFloat() * 100);
        float horizontalOverlap = random.nextFloat();


        List<JingWeidu> controlPoint = new ArrayList<>();
        controlPoint.add(new JingWeidu(30.575666978599266d, 114.32350428721729d));
        controlPoint.add(new JingWeidu(30.57689776902491d,114.32521897815217d));
        controlPoint.add(new JingWeidu(30.573878650630384d,114.32880615366622d));
        controlPoint.add(new JingWeidu(30.572595262323304d,114.3276384806983d));
        controlPoint.add(new JingWeidu(30.575666978599266d,114.32350428721729d));


        System.out.println("controlPoint = " + controlPoint);
        System.out.println("flyHeight = " + flyHeight);
        System.out.println("horizontalOverlap = " + horizontalOverlap);


        List<JingWeidu> jingWeidus = calculator.calculationRoute(controlPoint, flyHeight, horizontalOverlap);

        System.out.println(jingWeidus.size() + "|" + jingWeidus);






    }


    static class JingWeidu {
        double latitude;
        double longitude;

        public JingWeidu(double latitude, double longitude) {
            this.latitude = latitude;
            this.longitude = longitude;
        }

        @Override
        public String toString() {
            return "LatLng{" +
                    "latitude=" + latitude +
                    ", longitude=" + longitude +
                    '}';
        }
    }


    /**
     * 计算同步航线
     *
     * @param polygon 同步数据
     * @return 航线
     */
    public List<JingWeidu> calculationSynchronizeRoute(List<JingWeidu> polygon,
                                                       int flyHeight,
                                                       float horizontalOverlap) {
        ;//= new BaseFlySettingEntity();

        mControlPoint = polygon;
        return calculationRoute(mControlPoint,  flyHeight, horizontalOverlap);
    }


    /**
     * 计算航线
     *
     * @param controlPoint         控制点list
     * @param flyHeight            飞行高度
     * @param horizontalOverlap     旁向重叠率
     * @return  任务点
     */
    public List<JingWeidu> calculationRoute(List<JingWeidu> controlPoint,
                                            float flyHeight,
                                            float horizontalOverlap) {
        double caLineGap = (getLineGap(flyHeight, 84, horizontalOverlap) / (111000 * cos(0.001)));
        return getLwaypointList(controlPoint, caLineGap);
    }



    /**
     * @param vertexList 多边形顶点
     * @return
     */
    private List<JingWeidu> getLwaypointList(List<JingWeidu> vertexList, double caLineGap) {
        List<JingWeidu> lwaypointList = new ArrayList<>();
        if (null == vertexList || vertexList.size() == 0) {
            return null;
        }
        //最大值、最小值
        double xmax, xmin;
        xmax = xmin = vertexList.get(0).longitude;
        //斜率
        double slope = 0;
        for (int i = 0; i < vertexList.size(); i++) {
            if (vertexList.get(i).longitude > xmax) {
                xmax = vertexList.get(i).longitude;
            }
            if (vertexList.get(i).longitude < xmin) {
                xmin = vertexList.get(i).longitude;
            }
        }
        double xl = xmin - (xmax - xmin) / 2;
        //创建过各顶点的直线
        List<Double> ylpointList = new ArrayList<Double>();//过各顶点直线的y值集合
        for (int i = 0; i < vertexList.size(); i++) {
            double yv = slope * (xl - vertexList.get(i).longitude) + vertexList.get(i).latitude;
            ylpointList.add(yv);
        }

        if (ylpointList.size() == 0) {
            return null;
        }

        double ylmax, ylmin;
        ylmax = ylmin = ylpointList.get(0);

        //求直线与xl的交点最大值、最小值
        for (int j = 0; j < ylpointList.size(); j++) {
            if (ylpointList.get(j) > ylmax) {
                ylmax = ylpointList.get(j);
            }
            if (ylpointList.get(j) < ylmin) {
                ylmin = ylpointList.get(j);
            }
        }
        int hnum = 1;

        if (ylpointList.size() > 0) {
            hnum = (int) Math.floor((ylmax - ylmin) / caLineGap);//求得航带数
        }

        List<JingWeidu> crosspointList = new ArrayList<>();//直线跟多边形交点

        for (int sk = 1; sk <= hnum; sk++) {
            for (int n = 0; n < vertexList.size(); n++) {
                if (n == vertexList.size() - 1) {
                    //航线与边的左右端
                    double s1, s2;
                    double ly = slope * (xmin - xl) + ylmax - sk * caLineGap;
                    double ry = slope * (xmax - xl) + ylmax - sk * caLineGap;
                    JingWeidu left = new JingWeidu(ly, xmin);
                    JingWeidu right = new JingWeidu(ry, xmax);
                    //多边形相邻顶点
                    s1 = crossPoint(left, vertexList.get(0), right);
                    s2 = crossPoint(left, vertexList.get(n), right);
                    if (s1 * s2 <= 0) {
                        double wpx = (s2 * vertexList.get(0).longitude - s1 * vertexList.get(n).longitude) / (s2 - s1);
                        double wpy = (s2 * vertexList.get(0).latitude - s1 * vertexList.get(n).latitude) / (s2 - s1);
                        JingWeidu lrwaypoint = (new JingWeidu(wpy, wpx));
                        crosspointList.add(lrwaypoint);
                    }
                } else {
                    double s3, s4;
                    double ly = slope * (xmin - xl) + ylmax - sk * caLineGap;
                    double ry = slope * (xmax - xl) + ylmax - sk * caLineGap;
                    JingWeidu left = new JingWeidu(ly, xmin);
                    JingWeidu right = new JingWeidu(ry, xmax);
                    s3 = crossPoint(left, vertexList.get(n), right);
                    s4 = crossPoint(left, vertexList.get(n + 1), right);
                    if (s3 * s4 <= 0) {
                        double wpx = (s4 * vertexList.get(n).longitude - s3 * vertexList.get(n + 1).longitude) / (s4 - s3);
                        double wpy = (s4 * vertexList.get(n).latitude - s3 * vertexList.get(n + 1).latitude) / (s4 - s3);
                        JingWeidu lrwaypoint = (new JingWeidu(wpy, wpx));
                        crosspointList.add(lrwaypoint);
                    }
                }
            }
            if (crosspointList.size() > 0) {
                if (sk % 2 == 1) {

                    if (crosspointList.get(0).longitude > crosspointList.get(1).longitude) {
                        lwaypointList.add(crosspointList.get(0));
                        lwaypointList.add(crosspointList.get(1));
                    } else {
                        lwaypointList.add(crosspointList.get(1));
                        lwaypointList.add(crosspointList.get(0));
                    }
                    crosspointList.removeAll(crosspointList);
                } else {


                    if (crosspointList.get(0).longitude > crosspointList.get(1).longitude) {
                        lwaypointList.add(crosspointList.get(1));
                        lwaypointList.add(crosspointList.get(0));
                    } else {
                        lwaypointList.add(crosspointList.get(0));
                        lwaypointList.add(crosspointList.get(1));
                    }
                    crosspointList.removeAll(crosspointList);
                }
            }
        }

        return lwaypointList;
    }


    private double crossPoint(JingWeidu a, JingWeidu b, JingWeidu c) {
        return (b.longitude - a.longitude) * (c.latitude - a.latitude) - (b.latitude - a.latitude) * (c.longitude - a.longitude);
    }

    /**
     * @param flyHeight    飞行高度
     * @param fov          无人机广角
     * @param line_overlap 航向重叠率
     * @return 返回航线间距
     */
    private double getLineGap(float flyHeight, float fov, float line_overlap) {
        //航线间距
        float m_lineGap = (float) (2 * flyHeight * Math.tan(Math.toRadians(fov / 2)) * (1 - line_overlap));
        BigDecimal bigDecimal = new BigDecimal(String.valueOf(m_lineGap));
        return bigDecimal.doubleValue();
    }

}
