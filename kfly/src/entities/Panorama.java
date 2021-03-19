package entities;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2021/2/1 10:44.
 */
public class Panorama {

    //@Id
    //@Column(nullable = false, columnDefinition = "varchar(32) comment '标记主键'")
    //@GenericGenerator(name = "uuidGenerator", strategy = "uuid")
    //@GeneratedValue(generator = "uuidGenerator")
    //@ApiModelProperty("全景id")
    private String id;

    //@Column(nullable = false, columnDefinition = "varchar(255) comment '全景名称'")
    //@ApiModelProperty("全景名称")
    private String name;

    //@Column(nullable = true, columnDefinition = "varchar(255) comment '全景图存储路径'")
    //@ApiModelProperty("全景图存储路径")
    private String absolutePath;

    //@Column(nullable = true, columnDefinition = "varchar(255) comment '全景图访问地址'")
    //@ApiModelProperty("全景图访问地址")
    private String address;

    //@Column(nullable = true, columnDefinition = "varchar(255) comment '全景图缩略图访问地址'")
    //@ApiModelProperty("全景图缩略图访问地址")
    private String thumbnailAddress;

    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    //@CreatedDate
    //@Column(nullable = true, columnDefinition = "datetime comment '创建时间'")
    //@ApiModelProperty("全景图创建时间")
    private Date createTime;

    //@Column(nullable = true, columnDefinition = "double comment '全景正北朝向校准参数'")
    //@ApiModelProperty("全景正北朝向校准参数")
    private Double calibrationParam = 0.00;

    //@Column(nullable = false, columnDefinition = "varchar(80) comment '全景点在地图上的经纬度坐标'")
    //@ApiModelProperty("全景点在地图上的经纬度坐标（[114.233...,30.526...]）")
    private String center = "114.233,30.526";

    //@Column(nullable = true, columnDefinition = "varchar(255) comment '全景对应项目'")
    //@ApiModelProperty("全景所属的项目id")
    private String projectId;

    //@Column(nullable = true, columnDefinition = "varchar(1000) comment '全景对应的栅格图层id'")
    //@ApiModelProperty("全景对应的栅格图层id字符串以逗号分隔（id,id,id）")
    private String tifLayer;

    //@Column(nullable = true, columnDefinition = "varchar(1000) comment '全景对应的矢量图层id'")
    //@ApiModelProperty("全景对应的矢量图层id字符串以逗号分隔（id,id,id）")
    private String shpLayer;

    //@Column(nullable = true, columnDefinition = "varchar(255) comment '全景对应的街区id'")
    //@ApiModelProperty("全景对应的街区字符串以逗号分隔（id,id,id）")
    private String blockIds;

    //@Column(nullable = true, columnDefinition = "varchar(255) comment '全景对应街区的期'")
    //@ApiModelProperty("对应街区的那一期")
    private String period;

    //@Transient
    private List<Marker> markersVO;

}
