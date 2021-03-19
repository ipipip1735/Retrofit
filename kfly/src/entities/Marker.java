package entities;

import java.util.Date;

/**
 * Created by Administrator on 2021/2/1 10:46.
 */
public class Marker {
    //@Id
    //@Column(nullable = false, columnDefinition = "va
    // rchar(32) comment '标记主键'")
    //@GenericGenerator(name = "uuidGenerator", strategy = "uuid")
    //@GeneratedValue(generator = "uuidGenerator")
    private String id;

    //@Column(nullable = true, columnDefinition = "varchar(30) comment '标记类型'")
    //@ApiModelProperty("标记类型")
    private String type;

    //@Basic(fetch = FetchType.LAZY)
    //@Column(nullable = false, columnDefinition = "mediumtext comment '标记的内容信息'")
    //@ApiModelProperty("标记的内容信息")
    private String content;

    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    //@CreatedDate
    //@Column(nullable = true, columnDefinition = "datetime comment '创建时间'")
    private Date createTime;

    //@Transient
    private Panorama panoramaVO;
}
