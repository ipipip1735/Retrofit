package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Administrator on 2021/1/5 17:22.
 */
public class ResultDataBean {
    /**
     * id : 1569402506064211302
     * taskName : 网格1
     * missionType : 0
     * userName : chenng
     * altitude : 0.0
     * headingOverlap : 85.0
     * lineOverlap : 85.0
     * rotatePitch : 0.0
     * speed : 0.0
     * shootInterval : 0
     * headAngle : 0.0
     * labelItemId : 402881eb6d676604016d67adba160032
     * createTime : 2019-09-25T09:08:25.000+0000
     * missionStartTime : null
     * missionEndTime : null
     * wayPointVOs : null
     * verPointVOs : null
     * distance : 0.0
     * area : 0.0
     * startPointLatitude : 0.0
     * startPointLongitude : 0.0
     * weatherHumidity : null
     * pm25 : null
     * weatherWindDirection : null
     * weatherWindPower : null
     * pageNo : null
     * state : 00
     * wayPointList : [{"id":"402881f46b6dbe7d016b6dc1b6cf0005","order":1,"belongLineType":0,"altitude":0,"latitude":30.579762,"longitude":114.317284,"heading":0,"cornerRadius":0},{"id":"402881f46b6dbe7d016b6dc1b6cf0006","order":2,"belongLineType":0,"altitude":0,"latitude":30.579762,"longitude":114.317139,"heading":0,"cornerRadius":0},{"id":"402881f46b6dbe7d016b6dc1b6cf0007","order":3,"belongLineType":0,"altitude":0,"latitude":30.579762,"longitude":114.316996,"heading":0,"cornerRadius":0},{"id":"402881f46b6dbe7d016b6dc1b6cf0008","order":4,"belongLineType":0,"altitude":0,"latitude":30.579763,"longitude":114.316851,"heading":0,"cornerRadius":0},{"id":"402881f46b6dbe7d016b6dc1b6d00009","order":5,"belongLineType":0,"altitude":0,"latitude":30.579763,"longitude":114.316707,"heading":0,"cornerRadius":0},{"id":"402881f46b6dbe7d016b6dc1b6d0000a","order":6,"belongLineType":0,"altitude":0,"latitude":30.579763,"longitude":114.316562,"heading":0,"cornerRadius":0},{"id":"402881f46b6dbe7d016b6dc1b6d0000b","order":7,"belongLineType":0,"altitude":0,"latitude":30.579763,"longitude":114.316418,"heading":0,"cornerRadius":0},{"id":"402881f46b6dbe7d016b6dc1b6d0000c","order":8,"belongLineType":0,"altitude":0,"latitude":30.579764,"longitude":114.316274,"heading":0,"cornerRadius":0},{"id":"402881f46b6dbe7d016b6dc1b6d0000d","order":9,"belongLineType":0,"altitude":0,"latitude":30.579764,"longitude":114.316129,"heading":0,"cornerRadius":0},{"id":"402881f46b6dbe7d016b6dc1b6d0000e","order":10,"belongLineType":0,"altitude":0,"latitude":30.579764,"longitude":114.315984,"heading":0,"cornerRadius":0},{"id":"402881f46b6dbe7d016b6dc1b6d0000f","order":11,"belongLineType":0,"altitude":0,"latitude":30.579764,"longitude":114.315841,"heading":0,"cornerRadius":0},{"id":"402881f46b6dbe7d016b6dc1b6d00010","order":12,"belongLineType":0,"altitude":0,"latitude":30.579765,"longitude":114.315696,"heading":0,"cornerRadius":0},{"id":"402881f46b6dbe7d016b6dc1b6d00011","order":13,"belongLineType":0,"altitude":0,"latitude":30.579765,"longitude":114.315552,"heading":0,"cornerRadius":0},{"id":"402881f46b6dbe7d016b6dc1b6d00012","order":14,"belongLineType":0,"altitude":0,"latitude":30.579763,"longitude":114.315393,"heading":0,"cornerRadius":0},{"id":"402881f46b6dbe7d016b6dc1b6d00013","order":15,"belongLineType":0,"altitude":0,"latitude":30.579519,"longitude":114.315362,"heading":0,"cornerRadius":0},{"id":"402881f46b6dbe7d016b6dc1b6d00014","order":16,"belongLineType":0,"altitude":0,"latitude":30.579519,"longitude":114.315507,"heading":0,"cornerRadius":0},{"id":"402881f46b6dbe7d016b6dc1b6d00015","order":17,"belongLineType":0,"altitude":0,"latitude":30.579519,"longitude":114.315651,"heading":0,"cornerRadius":0},{"id":"402881f46b6dbe7d016b6dc1b6d10016","order":18,"belongLineType":0,"altitude":0,"latitude":30.579519,"longitude":114.315796,"heading":0,"cornerRadius":0},{"id":"402881f46b6dbe7d016b6dc1b6d10017","order":19,"belongLineType":0,"altitude":0,"latitude":30.579518,"longitude":114.315939,"heading":0,"cornerRadius":0},{"id":"402881f46b6dbe7d016b6dc1b6d10018","order":20,"belongLineType":0,"altitude":0,"latitude":30.579518,"longitude":114.316084,"heading":0,"cornerRadius":0},{"id":"402881f46b6dbe7d016b6dc1b6d10019","order":21,"belongLineType":0,"altitude":0,"latitude":30.579518,"longitude":114.316228,"heading":0,"cornerRadius":0},{"id":"402881f46b6dbe7d016b6dc1b6d1001a","order":22,"belongLineType":0,"altitude":0,"latitude":30.579518,"longitude":114.316373,"heading":0,"cornerRadius":0},{"id":"402881f46b6dbe7d016b6dc1b6d1001b","order":23,"belongLineType":0,"altitude":0,"latitude":30.579517,"longitude":114.316517,"heading":0,"cornerRadius":0},{"id":"402881f46b6dbe7d016b6dc1b6d1001c","order":24,"belongLineType":0,"altitude":0,"latitude":30.579517,"longitude":114.316661,"heading":0,"cornerRadius":0}]
     * polygonVerDtos : [{"id":"402881eb6d67ad75016d67adcb520001","order":0,"latitude":30.623004450586915,"longitude":114.36585892651365},{"id":"402881eb6d67ad75016d67adcb520002","order":0,"latitude":30.62311524132248,"longitude":114.36843384716795},{"id":"402881eb6d67ad75016d67adcb530003","order":0,"latitude":30.62141643611013,"longitude":114.368262185791},{"id":"402881eb6d67ad75016d67adcb540004","order":0,"latitude":30.621564159486095,"longitude":114.36633099530027}]
     * multiLine : false
     */

    private String id;
    private String flyTaskName;
    private int taskType;
    private String userName;
    private double altitude;
    private double headingOverlap;
    private double lineOverlap;
    private double rotatePitch;
    private double speed;
    private int shootInterval;
    private double headAngle;
    private String labelItemId;
    private String createTime;
    private Object missionStartTime;
    private Object missionEndTime;
    private Object wayPointVOs;
    private Object verPointVOs;
    private double distance;
    private double area;
    private double startPointLatitude;
    private double startPointLongitude;
    private Object weatherHumidity;
    private Object pm25;
    private Object weatherWindDirection;
    private Object weatherWindPower;
    private Object pageNo;
    private String state;
    private boolean multiLine;
    private List<WayPointListBean> wayPointList;
    private List<PolygonVerDtosBean> polygonVerDtos;
    private int goHomeAltitude;

    public double getFlyHeight() {
        return flyHeight;
    }

    public void setFlyHeight(double flyHeight) {
        this.flyHeight = flyHeight;
    }

    private double flyHeight;

    public String getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(String coordinate) {
        this.coordinate = coordinate;
    }

    private String coordinate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFlyTaskName() {
        return flyTaskName;
    }

    public void setFlyTaskName(String flyTaskName) {
        this.flyTaskName = flyTaskName;
    }

    public int getTaskType() {
        return taskType;
    }

    public void setTaskType(int taskType) {
        this.taskType = taskType;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public double getAltitude() {
        if(this.altitude<=0.0)
            this.altitude = this.flyHeight;
        return altitude;
    }

    public void setAltitude(double altitude) {
        this.altitude = altitude;
    }

    public double getHeadingOverlap() {
        return headingOverlap;
    }

    public void setHeadingOverlap(double headingOverlap) {
        this.headingOverlap = headingOverlap;
    }

    public double getLineOverlap() {
        return lineOverlap;
    }

    public void setLineOverlap(double lineOverlap) {
        this.lineOverlap = lineOverlap;
    }

    public double getRotatePitch() {
        return rotatePitch;
    }

    public void setRotatePitch(double rotatePitch) {
        this.rotatePitch = rotatePitch;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public int getShootInterval() {
        return shootInterval;
    }

    public void setShootInterval(int shootInterval) {
        this.shootInterval = shootInterval;
    }

    public double getHeadAngle() {
        return headAngle;
    }

    public void setHeadAngle(double headAngle) {
        this.headAngle = headAngle;
    }

    public String getLabelItemId() {
        return labelItemId;
    }

    public void setLabelItemId(String labelItemId) {
        this.labelItemId = labelItemId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Object getMissionStartTime() {
        return missionStartTime;
    }

    public void setMissionStartTime(Object missionStartTime) {
        this.missionStartTime = missionStartTime;
    }

    public int getGoHomeAltitude() {
        return goHomeAltitude;
    }

    public void setGoHomeAltitude(int goHomeAltitude) {
        this.goHomeAltitude = goHomeAltitude;
    }

    public Object getMissionEndTime() {
        return missionEndTime;
    }

    public void setMissionEndTime(Object missionEndTime) {
        this.missionEndTime = missionEndTime;
    }

    public Object getWayPointVOs() {
        return wayPointVOs;
    }

    public void setWayPointVOs(Object wayPointVOs) {
        this.wayPointVOs = wayPointVOs;
    }

    public Object getVerPointVOs() {
        return verPointVOs;
    }

    public void setVerPointVOs(Object verPointVOs) {
        this.verPointVOs = verPointVOs;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getStartPointLatitude() {
        return startPointLatitude;
    }

    public void setStartPointLatitude(double startPointLatitude) {
        this.startPointLatitude = startPointLatitude;
    }

    public double getStartPointLongitude() {
        return startPointLongitude;
    }

    public void setStartPointLongitude(double startPointLongitude) {
        this.startPointLongitude = startPointLongitude;
    }

    public Object getWeatherHumidity() {
        return weatherHumidity;
    }

    public void setWeatherHumidity(Object weatherHumidity) {
        this.weatherHumidity = weatherHumidity;
    }

    public Object getPm25() {
        return pm25;
    }

    public void setPm25(Object pm25) {
        this.pm25 = pm25;
    }

    public Object getWeatherWindDirection() {
        return weatherWindDirection;
    }

    public void setWeatherWindDirection(Object weatherWindDirection) {
        this.weatherWindDirection = weatherWindDirection;
    }

    public Object getWeatherWindPower() {
        return weatherWindPower;
    }

    public void setWeatherWindPower(Object weatherWindPower) {
        this.weatherWindPower = weatherWindPower;
    }

    public Object getPageNo() {
        return pageNo;
    }

    public void setPageNo(Object pageNo) {
        this.pageNo = pageNo;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public boolean isMultiLine() {
        return multiLine;
    }

    public void setMultiLine(boolean multiLine) {
        this.multiLine = multiLine;
    }

    public List<WayPointListBean> getWayPointList() {
        return wayPointList;
    }

    public void setWayPointList(List<WayPointListBean> wayPointList) {
        this.wayPointList = wayPointList;
    }

    public List<PolygonVerDtosBean> getPolygonVerDtos() {
        if(this.polygonVerDtos == null){
            List<ArrayList<ArrayList>> verDots = (List<ArrayList<ArrayList>>)GsonUtil.parseJsonToList(this.coordinate, ArrayList.class);
            this.polygonVerDtos = (List<PolygonVerDtosBean>) (verDots.get(0).stream().map(e->{
                PolygonVerDtosBean pvdb = new PolygonVerDtosBean();
                pvdb.setLongitude((double)e.get(0));
                pvdb.setLatitude((double)e.get(1));
                System.out.println("e = " + e);
                return pvdb;
            }).collect(Collectors.toList()));

        }
        return polygonVerDtos;
    }

    public void setPolygonVerDtos(List<PolygonVerDtosBean> polygonVerDtos) {
        this.polygonVerDtos = polygonVerDtos;
    }

    public static class WayPointListBean {
        /**
         * id : 402881f46b6dbe7d016b6dc1b6cf0005
         * order : 1
         * belongLineType : 0
         * altitude : 0
         * latitude : 30.579762
         * longitude : 114.317284
         * heading : 0
         * cornerRadius : 0
         */

        private String id;
        private int order;
        private int belongLineType;
        private int altitude;
        private double latitude;
        private double longitude;
        private int heading;
        private int cornerRadius;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public int getOrder() {
            return order;
        }

        public void setOrder(int order) {
            this.order = order;
        }

        public int getBelongLineType() {
            return belongLineType;
        }

        public void setBelongLineType(int belongLineType) {
            this.belongLineType = belongLineType;
        }

        public int getAltitude() {
            return altitude;
        }

        public void setAltitude(int altitude) {
            this.altitude = altitude;
        }

        public double getLatitude() {
            return latitude;
        }

        public void setLatitude(double latitude) {
            this.latitude = latitude;
        }

        public double getLongitude() {
            return longitude;
        }

        public void setLongitude(double longitude) {
            this.longitude = longitude;
        }

        public int getHeading() {
            return heading;
        }

        public void setHeading(int heading) {
            this.heading = heading;
        }

        public int getCornerRadius() {
            return cornerRadius;
        }

        public void setCornerRadius(int cornerRadius) {
            this.cornerRadius = cornerRadius;
        }
    }

    public static class PolygonVerDtosBean {
        /**
         * id : 402881eb6d67ad75016d67adcb520001
         * order : 0
         * latitude : 30.623004450586915
         * longitude : 114.36585892651365
         */

        private String id;
        private int order;
        private double latitude;
        private double longitude;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public int getOrder() {
            return order;
        }

        public void setOrder(int order) {
            this.order = order;
        }

        public double getLatitude() {
            return latitude;
        }

        public void setLatitude(double latitude) {
            this.latitude = latitude;
        }

        public double getLongitude() {
            return longitude;
        }

        public void setLongitude(double longitude) {
            this.longitude = longitude;
        }
    }

    @Override
    public String toString() {
        return "ResultDataBean{" +
                "id='" + id + '\'' +
                ", flyTaskName='" + flyTaskName + '\'' +
                ", taskType=" + taskType +
                ", userName='" + userName + '\'' +
                ", altitude=" + altitude +
                ", headingOverlap=" + headingOverlap +
                ", lineOverlap=" + lineOverlap +
                ", rotatePitch=" + rotatePitch +
                ", speed=" + speed +
                ", shootInterval=" + shootInterval +
                ", headAngle=" + headAngle +
                ", labelItemId='" + labelItemId + '\'' +
                ", createTime='" + createTime + '\'' +
                ", missionStartTime=" + missionStartTime +
                ", missionEndTime=" + missionEndTime +
                ", wayPointVOs=" + wayPointVOs +
                ", verPointVOs=" + verPointVOs +
                ", distance=" + distance +
                ", area=" + area +
                ", startPointLatitude=" + startPointLatitude +
                ", startPointLongitude=" + startPointLongitude +
                ", weatherHumidity=" + weatherHumidity +
                ", pm25=" + pm25 +
                ", weatherWindDirection=" + weatherWindDirection +
                ", weatherWindPower=" + weatherWindPower +
                ", pageNo=" + pageNo +
                ", state='" + state + '\'' +
                ", multiLine=" + multiLine +
                ", wayPointList=" + wayPointList.size() +
                ", polygonVerDtos=" + polygonVerDtos +
                ", goHomeAltitude=" + goHomeAltitude +
                ", flyHeight=" + flyHeight +
                ", coordinate='" + coordinate.length() + '\'' +
                '}';
    }
}
