package entities;

import com.google.gson.annotations.JsonAdapter;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2021/1/5 9:23.
 */
public class Project {
    public String id;
    public String name;
    public String regionCode;
    public String introduce;
    public float area;
    public String user;
    public String block;
    public Date createTime;
    public boolean enable;
    public float flyHeight;
    public float speed;
    public float lineOverlap;
    public float headingOverlap;
    public float rotatePitch;
    public List<Block> blockVOS;


    @Override
    public String toString() {
        return "Project{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", regionCode='" + regionCode + '\'' +
                ", introduce='" + introduce + '\'' +
                ", area='" + area + '\'' +
                ", user='" + user + '\'' +
                ", block='" + block + '\'' +
                ", enable=" + enable +
                ", flyHeight=" + flyHeight +
                ", lineOverlap=" + lineOverlap +
                ", speed=" + speed +
                ", headingOverlap=" + headingOverlap +
                ", rotatePitch=" + rotatePitch +
                '}';
    }
}
