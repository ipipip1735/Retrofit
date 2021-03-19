package entities;

import java.util.List;

/**
 * Created by Administrator on 2021/1/13 14:55.
 */
public class Mission {
    public String id;//主键id
    public String flightRoutId;//对应的航线id
    public String flightRoutName;//对应的航线名称
    public String flyTaskName;//飞行任务名称
    public String creatTime;//对应的期数时间
    public String period;//对应的期数
    public float flyHeight;//飞行高度
    public float lineOverlap;//旁向重叠率
    public float speed;//飞行速度
    public float headingOverlap;//航向重叠率
    public float rotatePitch;//相机倾斜角
    public String coordinate;
    public List<WayPoint> wayPointList;
    public String state = "00"; //任务状态
    public boolean enable = false;//有效标识
    public String user;//用户名
}
