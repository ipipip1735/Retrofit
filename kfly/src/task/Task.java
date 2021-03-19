package task;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import entities.*;
import okhttp3.*;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.*;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import static java.util.zip.ZipOutputStream.DEFLATED;

/**
 * Created by Administrator on 2020/11/17 13:25.
 */
public class Task {

//    String SERVER_TEST_ADDRESS = "http://192.168.1.117:8000/msauthserver/";
//    String TASK_SERVER_ADDRESS = "http://192.168.1.117:8000/";
//    String REAL_SERVER_TEST_ADDRESS = "http://192.168.1.117:8000/";
//    String USER_TOKEN = "http://192.168.0.117:8000/msauthserver/oauth/token";

//    String SERVER_TEST_ADDRESS = "http://192.168.1.110:9004/msauthserver/";
//    String TASK_SERVER_ADDRESS = "http://192.168.1.110:9004/";
//    String REAL_SERVER_TEST_ADDRESS = "http://192.168.1.110:9004/";
//    String USER_TOKEN = "http://192.168.0.110:9004/msauthserver/oauth/token";

    public String SERVER_TEST_ADDRESS = "http://k2u0a1f7u.kfgeo.com/msauthserver/";
    public String TASK_SERVER_ADDRESS = "http://k2u0a1f7u.kfgeo.com/";
    public String REAL_SERVER_TEST_ADDRESS = "http://k2u0a1f7u.kfgeo.com/";
    public String USER_TOKEN = "http://k2u0a1f7u.kfgeo.com/msauthserver/oauth/token";

    //安奇本机
//    public String SERVER_TEST_ADDRESS = "http://k2u0a1f7u.kfgeo.com/msauthserver/";
//    public String TASK_SERVER_ADDRESS = "http://192.168.1.118:9002/";
//    public String REAL_SERVER_TEST_ADDRESS = "http://192.168.1.118:9002/";
//    public String USER_TOKEN = "http://192.168.1.118:9002/msauthserver/oauth/token";


    //反向代理
//    public String SERVER_TEST_ADDRESS = "http://192.168.1.106/msauthserver/";
//    public String TASK_SERVER_ADDRESS = "http://192.168.1.106/";
//    public String REAL_SERVER_TEST_ADDRESS = "http://192.168.1.106/";
//    public String USER_TOKEN = "http://192.168.1.106/msauthserver/oauth/token";

    String TEST_TOKEN = "3255e7e9-a486-4128-8215-7222fa0934a5";

    Retrofit retrofit;
    Gson gson = new Gson();

    public static void main(String[] args) {

        Task task = new Task();
//
//
        UserInfo userInfo = task.authority();
//
//        task.misson(userInfo.token_type + " " + userInfo.access_token);
//        task.upload(userInfo.access_token);//上传飞行数据
//        task.uploadPrivew(userInfo);//上传预览图
//        task.updateMission(userInfo.access_token);//更新飞行状态
//        task.project(userInfo.access_token);//获取项目

//        task.getPanorama();//全景
//        task.updatePanorama();//全景


//        task.projects(userInfo.userName);//更新/新增项目
//        task.blocks(userInfo.userName, "2c9081e5771a14c1017722638f46002b");//更新/新增街区
//        task.flightRoute(userInfo.userName, "2c9081e57727d8940177295c8e250065");//更新/新增航线\

//        task.appLogFileUpload(task.zipLog(new File("res/")));//上传日志

//        String json = "[{\"id\":\"2c9081e576423f2e01764696f249014b\",\"name\":\"[test]20201209-1\",\"regionCode\":null,\"createTime\":\"2020-12-09 16:21:06\",\"introduce\":null,\"area\":39822.098225419104,\"user\":\"liuyang\",\"block\":\"0\",\"blockVOS\":[{\"id\":\"2c9081e576423f2e0176469ef596015e\",\"name\":\"喻家湖\",\"introduce\":null,\"area\":39822.098225419104,\"coordinate\":\"[[[114.32564249205014,30.57429791682726],[114.3272688730612,30.57575092711261],[114.3287260114816,30.574801517018408],[114.32690974817457,30.573265949297415],[114.32564249205014,30.57429791682726]]]\",\"user\":\"liuyang\",\"enable\":false,\"flightRouteVOS\":[{\"id\":\"2c9081e576423f2e0176469f1f9e015f\",\"name\":\"网格1\",\"area\":33092.40043998572,\"user\":\"liuyang\",\"coordinate\":\"[[[114.32576632820361,30.574318556255456],[114.32723584992065,30.57560645166952],[114.32858153576139,30.57478087759021],[114.32693451559926,30.57334850673306],[114.32576632820361,30.574318556255456]]]\",\"wayPointVOList\":[{\"id\":\"2c9081e576423f2e017646d20d0301b5\",\"order\":1,\"latitude\":30.574519963558703,\"longitude\":114.32828152220809},{\"id\":\"2c9081e576423f2e017646d20d0301b6\",\"order\":2,\"latitude\":30.574519963558703,\"longitude\":114.32599613910507},{\"id\":\"2c9081e576423f2e017646d20d0301b7\",\"order\":3,\"latitude\":30.573433475447896,\"longitude\":114.32683219156381},{\"id\":\"2c9081e576423f2e017646d20d0301b8\",\"order\":4,\"latitude\":30.573433475447896,\"longitude\":114.32703221738214}],\"enable\":false,\"flyHeight\":102.0,\"lineOverlap\":0.5,\"creatTime\":\"2020-12-09\",\"speed\":5.0,\"headingOverlap\":0.7,\"rotatePitch\":90.0}]}],\"enable\":false,\"flyHeight\":150.0,\"lineOverlap\":0.7,\"speed\":5.0,\"headingOverlap\":0.7,\"rotatePitch\":90.0}]";
//        Type type = new TypeToken<List<Project>>() {}.getType();
//
//        Gson gson = new GsonBuilder()
//                .setDateFormat("yyyy-MM-dd HH:mm:ss")
//                .create();
//
//        List<Project> projects = gson.fromJson(json, type);
//        System.out.println(projects);

    }

    private void getPanorama() {

        retrofit = this.retrofit.newBuilder()
                .baseUrl(TASK_SERVER_ADDRESS)
                .build();
        Call<ResponseBody> call = retrofit.create(TaskService.class)
                .panoramaPoint();

        try {
            Response<ResponseBody> responseBodyResponse = call.execute();
            if (responseBodyResponse.isSuccessful()) {
                String json = responseBodyResponse.body().string();
                System.out.println("json = " + json);

                json = GsonUtil.getFieldValue(json, "data");
                System.out.println("json = " + json);


                Type type = new TypeToken<List<PanoramaMission>>() {}.getType();

                gson = gson.newBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
                List<PanoramaMission> missions = gson.fromJson(json, type);
                System.out.println(missions);


                String point = missions.get(0).point;
                System.out.println("point = " + point);

                point = point.substring(point.indexOf('[')+1, point.indexOf(']'));
                System.out.println("point = " + point);

                String[] p = point.split(",");
                System.out.println(p[0] + " - " + p[1]);



                if (responseBodyResponse.code() != 200) {
                    System.out.println("[" + responseBodyResponse.code() + "]" + responseBodyResponse.errorBody().string());
                    return;
                }

            } else {
                System.out.println(responseBodyResponse.errorBody().string());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void updatePanorama() {

        Map<String, Object> body = new HashMap<>();
//        body.put("blockId", UUID.randomUUID().toString().replace("-", "").substring(0, 30));
        body.put("blockId", "2c9081e5775c2a720177679f2262001e");
        body.put("name", "panorama-" + new Random().nextInt(100));
        body.put("point", "(1111,22222)");
        body.put("flightHeight", 30f);
        System.out.println("body = " + body);
        String json = gson.toJson(body);
        System.out.println("json = " + json);

        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), json);


        retrofit = this.retrofit.newBuilder()
                .baseUrl(TASK_SERVER_ADDRESS)
                .build();
        Call<ResponseBody> call = retrofit.create(TaskService.class)
                .updatePanorama(requestBody);

        try {
            Response<ResponseBody> responseBodyResponse = call.execute();
            if (responseBodyResponse.isSuccessful()) {
                json = responseBodyResponse.body().string();
                System.out.println("json = " + json);

                if (responseBodyResponse.code() != 200) {
                    System.out.println("[" + responseBodyResponse.code() + "]" + responseBodyResponse.errorBody().string());
                    return;
                }

            } else {
                System.out.println(responseBodyResponse.errorBody().string());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    private void appLogFileUpload(File file) {

        retrofit = this.retrofit.newBuilder()
                .baseUrl(TASK_SERVER_ADDRESS)
                .build();


        RequestBody body = RequestBody.create(MediaType.parse("application/zip"), file);
        MultipartBody.Part fileBody = MultipartBody.Part.createFormData("file", file.getName(), body);

        Call<ResponseBody> call = retrofit.create(TaskService.class)
                .appLogFileUpload(fileBody);

        try {
            Response<ResponseBody> responseBodyResponse = call.execute();
            if (responseBodyResponse.isSuccessful()) {
                String json = responseBodyResponse.body().string();
                System.out.println("json = " + json);

            } else {
                System.out.println("[" + responseBodyResponse.code() + "]" + responseBodyResponse.errorBody().string());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    private File zipLog(File file) {

        File[] files = file.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                System.out.println("pathname = " + pathname);
                return pathname.getName().startsWith("zip_");
            }
        });
        System.out.println(Arrays.asList(files));


        File outFile = new File(file, new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date()) + ".zip");
        try (FileOutputStream fileOutputStream = new FileOutputStream(outFile);
             BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
             ZipOutputStream zipOutputStream = new ZipOutputStream(bufferedOutputStream)) {

            zipOutputStream.setMethod(DEFLATED);//操作类型为压缩
            zipOutputStream.setLevel(9);//设置压缩级别，值越大压缩率越高，耗时越长

            //遍历压缩
            for (File f : files) {
                System.out.println("file = " + f);
                zipOutputStream.putNextEntry(new ZipEntry(f.getName()));//创建目标
                FileInputStream fileInputStream = new FileInputStream(f);
                BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
                int length;
                byte[] bytes = new byte[1024];
                while ((length = bufferedInputStream.read(bytes)) != -1) {//读取原生数据
                    zipOutputStream.write(bytes, 0, length);//压缩
                }
                zipOutputStream.closeEntry();//关闭目标但不关闭底层ZipOutputStream
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return outFile;
    }



    private void blocks(String userName, String projectId) {

//        BlockVOS block = new BlockVOS();
//        block.projectId = projectId;
//        block.name = "block-" + new Random().nextInt(100);
////        block.introduce = ;
////        block.area =;
//        block.coordinate = "[[[114.334189, 30.584596], [114.336129, 30.586244], [114.337943, 30.585187], [114.335608, 30.583492]]]";
//        block.user = userName;
////        block.enable = false;
////        block.flightRouteVOS = new ArrayList<>();
//
////        block.coordinate.add(new Coordinate(114.334189f, 30.584596f));
////        block.coordinate.add(new Coordinate(114.336129f, 30.586244f));
////        block.coordinate.add(new Coordinate(114.337943f, 30.585187f));
////        block.coordinate.add(new Coordinate(114.335608f, 30.583492f));
//        String json = gson.toJson(block);
//        System.out.println("json = " + json);


        Map<String, Object> body = new HashMap<>();
//        body.put("id", UUID.randomUUID().toString().replace("-", ""));
        body.put("projectId", projectId);
        body.put("name", "block" + new Random().nextInt(100));
        body.put("area", 0f);
        body.put("user", userName);
        body.put("coordinate", "[[[114.32564249205014,30.57429791682726],[114.3272688730612,30.57575092711261],[114.3287260114816,30.574801517018408],[114.32690974817457,30.573265949297415],[114.32564249205014,30.57429791682726]]]");
        System.out.println("body = " + body);
        String json = gson.toJson(body);
        System.out.println("json = " + json);

        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), json);


//        if (retrofit == null)
        retrofit = this.retrofit.newBuilder()
                .baseUrl(TASK_SERVER_ADDRESS)
                .build();
        Call<ResponseBody> call = retrofit.create(TaskService.class)
                .blocks(requestBody);

        try {
            Response<ResponseBody> responseBodyResponse = call.execute();
            System.out.println("~~~~~~Add Block code is " + responseBodyResponse.code());
            if (responseBodyResponse.isSuccessful()) {
                json = responseBodyResponse.body().string();
                System.out.println("json = " + json);

                if (responseBodyResponse.code() != 200) {
                    System.out.println("[" + responseBodyResponse.code() + "]" + responseBodyResponse.errorBody().string());
                    return;
                }

                json = GsonUtil.getFieldValue(json, "resultData");
                System.out.println("json = " + json);

                json = GsonUtil.getFieldValue(json, "id");
                System.out.println("id is " + json);

                flightRoute(userName, gson.fromJson(json, String.class));

            } else {
                System.out.println(responseBodyResponse.errorBody().string());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void projects(String userName) {

//        Project project = new Project();
////        project.id = UUID.randomUUID().toString().replace("-", "");
//        project.name = "[test]project-" + new Random().nextInt(100);
////        project.regionCode = ;
////        project.introduce = ;
//        project.area = 0;
//        project.user = userName;
//        project.block = "0";
//        project.createTime = new Date();
//        project.enable = false;
////        project.flyHeight = 123;
////        project.lineOverlap = 0.8f;
////        project.headingOverlap = 0.75f;
////        project.speed = 5;
////        project.rotatePitch = -90;
////        List<BlockVOS> blockVOS = new ArrayList<>();


        Map<String, Object> body = new HashMap<>();
//        body.put("id", UUID.randomUUID().toString().replace("-", ""));
        body.put("user", userName);
        body.put("name", "[app]project" + new Random().nextInt(100));
        System.out.println("body = " + body);
        String json = gson.toJson(body);
        System.out.println("json = " + json);


        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), json);

        retrofit = this.retrofit.newBuilder()
                .baseUrl(TASK_SERVER_ADDRESS)
                .build();


        //方式一:使用Call
        Call<ResponseBody> call = retrofit.create(TaskService.class)
                .projects(requestBody);

        try {
            Response<ResponseBody> responseBodyResponse = call.execute();
            System.out.println("~~~~~~Add Project code is " + responseBodyResponse.code());
            if (responseBodyResponse.isSuccessful()) {
                json = responseBodyResponse.body().string();
                System.out.println("json = " + json);

                if (responseBodyResponse.code() != 200) {
                    System.out.println("[Project error]" + responseBodyResponse.errorBody().string());
                    return;
                }

                json = GsonUtil.getFieldValue(json, "resultData");
                System.out.println("resultData is " + json);
                json = GsonUtil.getFieldValue(json, "id");
                System.out.println("id is " + json);

                blocks(userName, gson.fromJson(json, String.class));


            } else {
                System.out.println("[" + responseBodyResponse.code() + "]" + responseBodyResponse.errorBody().string());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        //方式二:使用Rx
//        Observable<Result<ResponseBody>> observable = retrofit.create(TaskService.class).projects(requestBody);
//        Observable<RR> observable = retrofit.create(TaskService.class).projects(requestBody);
//
//        observable.subscribe(responseBodyResult -> {
//            System.out.println("~~onNext~~");
//            System.out.println("responseBodyResult = " + responseBodyResult);
//            System.out.println(responseBodyResult);
//            System.out.println("id = " + responseBodyResult.resultData.id);
//            blocks(userName, responseBodyResult.resultData.id);
//        });


    }

    private void project(String access_token) {
        Retrofit retrofit = this.retrofit.newBuilder()
                .baseUrl(TASK_SERVER_ADDRESS)
                .build();

        Call<ResponseBody> call = retrofit.create(TaskService.class)
                .project();

        try {
            Response<ResponseBody> responseBodyResponse = call.execute();
            if (responseBodyResponse.isSuccessful()) {
                String json = responseBodyResponse.body().string();
                System.out.println("json = " + json);

//                Type type = new TypeToken<List<Project>>() {}.getType();
//                List<Project> projects = gson.fromJson(json, type);
//                System.out.println(projects);

            } else {
                System.out.println(responseBodyResponse.errorBody().string());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateMission(String access_token) {

        String CREATE = "00";
        String EXECYTEING = "01";
        String STOP = "02";
        String COMPLETE = "03";
        String CANCEL = "04";
        String DELETE = "05";

        Mission mission = new Mission();
//        mission.id = "202012091630022439143239";//喻家湖社区
        mission.id = "202102021429596566072835";//喻家湖社区
        mission.state = CREATE;
        mission.flyHeight = 102f;
        mission.lineOverlap = 0.50f;
//        mission.headingOverlap = 0.75f;
        mission.speed = 5f;


        String json = new Gson().toJson(mission);

//        Map<String, String> body = new HashMap<>();
//        body.put("id", mission.id);
//        body.put("state", mission.state);
//        String json = new Gson().toJson(body);


        System.out.println("json = " + json);

        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), json);

        Retrofit retrofit = this.retrofit.newBuilder()
                .baseUrl(TASK_SERVER_ADDRESS)
                .build();

        Call<ResponseBody> call = retrofit.create(TaskService.class)
                .updateMissionState(requestBody, access_token);

        try {
            Response<ResponseBody> responseBodyResponse = call.execute();
            if (responseBodyResponse.isSuccessful()) {
                System.out.println(responseBodyResponse.body().string());
            } else {
                System.out.println(responseBodyResponse.errorBody().string());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    private void flightRoute(String userName, String blockId) {

//        FlightRouteVOS flightRoute = new FlightRouteVOS();

//        flightRoute.id = ;
//        flightRoute.name = ;
//        flightRoute.area = ;
//        flightRoute.user = ;
//        flightRoute.coordinate = ;
//        flightRoute.enable = ;
//        flightRoute.flyHeight = ;
//        flightRoute.lineOverlap = ;
//        flightRoute.speed = ;
//        flightRoute.headingOverlap = ;
//        flightRoute.rotatePitch = ;
//        flightRoute.creatTime = ;
//        flightRoute.wayPointVOList = ;
//        String json = gson.toJson(project);
//        System.out.println("json = " + json);


        Map<String, Object> body = new HashMap<>();
        body.put("appId", UUID.randomUUID().toString().replace("-", ""));
        body.put("blockId", blockId);
        body.put("user", userName);
        body.put("name", "util" + new Random().nextInt(100));
        body.put("lineOverlap", 0.8f);
        body.put("headingOverlap", 0.75f);
        body.put("rotatePitch", 90.0f);
        body.put("speed", 5);
        body.put("flyHeight", 121);
//        body.put("coordinate", "[[[114.32724201464526,30.575629929334873],[114.32578371829668,30.574276510485234],[114.3268924230939,30.573352589765012],[114.3281709296838,30.575080571086918],[114.32724201464526,30.575629929334873]]]");
        body.put("coordinate", "[[[114.32564249205014,30.57429791682726],[114.3272688730612,30.57575092711261],[114.3287260114816,30.574801517018408],[114.32690974817457,30.573265949297415],[114.32564249205014,30.57429791682726]]]");
        body.put("area", 0);


        body.put("state", "03");

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        body.put("startTime", simpleDateFormat.format(new Date()));
        body.put("endTime", simpleDateFormat.format(new Date()));


        String json = new Gson().toJson(body);
        System.out.println("json = " + json);

        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), json);

        Retrofit retrofit = this.retrofit.newBuilder()
                .baseUrl(TASK_SERVER_ADDRESS)
                .build();

        Call<ResponseBody> call = retrofit.create(TaskService.class)
                .flightRoute(requestBody);


        try {
            Response<ResponseBody> responseBodyResponse = call.execute();
            System.out.println("~~~~~~Add Route code is " + responseBodyResponse.code());
            if (responseBodyResponse.isSuccessful()) {
                json = responseBodyResponse.body().string();
                System.out.println("json = " + json);

                if (responseBodyResponse.code() != 200) {
                    System.out.println("[" + responseBodyResponse.code() + "]" + responseBodyResponse.errorBody().string());
                    return;
                }


            } else {
                System.out.println(responseBodyResponse.errorBody().string());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private void uploadPrivew(UserInfo userInfo) {
        Retrofit retrofit = this.retrofit.newBuilder()
                .baseUrl(TASK_SERVER_ADDRESS)
                .build();


        String userName = userInfo.userName;
        String taskId = "402881ee74d22f740174d3e77d4900c1";
        double altitude = 99.9d;
        double latitude = 114.32475542153514d;
        double longitude = 30.577803082476777d;
        double yawAngle = -89.8d;
        String access_token = userInfo.access_token;

        RequestBody taskIdRequestBody = RequestBody.create(MediaType.parse("multipart/form-data"), taskId);
        RequestBody userNameRequestBody = RequestBody.create(MediaType.parse("multipart/form-data"), userName);

        File file = new File("res/a.jpg");
        RequestBody body = RequestBody.create(MediaType.parse("image/jpg"), file);
        MultipartBody.Part fileBody = MultipartBody.Part.createFormData("file", file.getName(), body);

        Call<ResponseBody> call = retrofit.create(TaskService.class).postPreview(userNameRequestBody, taskIdRequestBody, altitude, latitude, longitude, yawAngle, fileBody, access_token);

//        try {
//
//            Response<ResponseBody> response = call.execute();
//
//            if (response.code() == 200) {
//                System.out.println(response.body().string());
//                return;
//            }
//
//
//            System.out.println("[" + response.code() + "]" + call.request().url());
//            System.out.println("[" + response.code() + "]" + response.errorBody().string());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }

    private void upload(String access_token) {

        Retrofit retrofit = this.retrofit.newBuilder()
                .baseUrl(TASK_SERVER_ADDRESS)
                .build();

        String json = "{\"deviceId\":\"aabc685362e44b5f596aa59e\",\"longitude\":\"114.32728563116939\",\"yawAngle\":\"-89.9000015258789\",\"speedZ\":\"0.7\",\"taskName\":\"0927-联调测试_街区01_网格3_1期\",\"pictureSignal\":\"-1\",\"altitude\":\"3.0\",\"status\":\"01\",\"remoterControllerSignal\":\"100\",\"gps\":\"15\",\"latitude\":\"30.57454575433747\",\"speedY\":\"0.0\",\"batteryPercent\":\"77\",\"userName\":\"test1234\",\"lineYaw\":\"-154.89999389648438\",\"speedX\":\"0.0\",\"taskId\":\"402881ee74cd43540174cd52c27b0034\"}";
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), json);


//        Call<ResponseBody> call = retrofit.create(task.TaskService.class).updateRealUAVData(requestBody, TEST_TOKEN);
        Call<ResponseBody> call = retrofit.create(TaskService.class).updateRealUAVData(requestBody, access_token);

        try {

            Response<ResponseBody> response = call.execute();

            if (response.code() == 200) {
                System.out.println(response.body().string());
                return;
            }


            System.out.println("[" + response.code() + "]" + call.request().url());
            System.out.println("[" + response.code() + "]" + response.errorBody().string());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    private void misson(String authorization) {

        //解析数组
////        String json = "[{\"id\":\"202012091630022439143239\", \"createTime\":\"2020-12-09\", \"speed\":5.0, \"flyTaskName\":\"[test]20201209-1_喻家湖_网格1_1期\", \"flyHeight\":102.0, \"lineOverlap\":0.5, \"headingOverlap\":0.0, \"rotatePitch\":0.0, \"coordinate\":\"[[[114.32576632820361,30.574318556255456],[114.32723584992065,30.57560645166952],[114.32858153576139,30.57478087759021],[114.32693451559926,30.57334850673306],[114.32576632820361,30.574318556255456]]]\", \"wayPointList\":[{\"id\":\"2c9081e576423f2e017646d20d0301b5\", \"order\":1, \"latitude\":30.574519963558703, \"longitude\":114.32828152220809 }, {\"id\":\"2c9081e576423f2e017646d20d0301b6\", \"order\":2, \"latitude\":30.574519963558703, \"longitude\":114.32599613910507 }, {\"id\":\"2c9081e576423f2e017646d20d0301b7\", \"order\":3, \"latitude\":30.573433475447896, \"longitude\":114.32683219156381 }, {\"id\":\"2c9081e576423f2e017646d20d0301b8\", \"order\":4, \"latitude\":30.573433475447896, \"longitude\":114.32703221738214 } ] }, {\"id\":\"202012151102466799441774\", \"createTime\":\"2020-12-15\", \"speed\":5.0, \"flyTaskName\":\"数据测试_ceshi1_网格1_1期\", \"flyHeight\":300.0, \"lineOverlap\":0.7, \"headingOverlap\":0.7, \"rotatePitch\":90.0, \"coordinate\":\"[[[114.15606836131505,30.569853803041866],[114.15611127665929,30.56397440088122],[114.1622910862296,30.563931485536983],[114.16259149363927,30.570111295107296],[114.15606836131505,30.569853803041866]]]\", \"wayPointList\":[{\"id\":\"2c9081e5765ff92401766459aa9700e6\", \"order\":1, \"latitude\":30.568651179602462, \"longitude\":114.16252051580221 }, {\"id\":\"2c9081e5765ff92401766459aa9700e7\", \"order\":2, \"latitude\":30.56865117960246, \"longitude\":114.15607713958833 }, {\"id\":\"2c9081e5765ff92401766459aa9700e8\", \"order\":3, \"latitude\":30.56719106409763, \"longitude\":114.15608779736573 }, {\"id\":\"2c9081e5765ff92401766459aa9700e9\", \"order\":4, \"latitude\":30.56719106409763, \"longitude\":114.16244953796519 }, {\"id\":\"2c9081e5765ff92401766459aa9700ea\", \"order\":5, \"latitude\":30.565730948592797, \"longitude\":114.16237856012815 }, {\"id\":\"2c9081e5765ff92401766459aa9800eb\", \"order\":6, \"latitude\":30.565730948592797, \"longitude\":114.15609845514317 }, {\"id\":\"2c9081e5765ff92401766459aa9800ec\", \"order\":7, \"latitude\":30.56427083308797, \"longitude\":114.15610911292055 }, {\"id\":\"2c9081e5765ff92401766459aa9800ed\", \"order\":8, \"latitude\":30.564270833087967, \"longitude\":114.1623075822911 } ] }, {\"id\":\"202012151102533663579233\", \"createTime\":\"2020-12-15\", \"speed\":5.0, \"flyTaskName\":\"数据测试_ceshi1_网格2_1期\", \"flyHeight\":150.0, \"lineOverlap\":0.7, \"headingOverlap\":0.7, \"rotatePitch\":90.0, \"coordinate\":\"[[[114.16568139842443,30.569757874625342],[114.16559556773595,30.56435054125132],[114.1749511127799,30.564650948660987],[114.17413572123937,30.569672043936865],[114.16568139842443,30.569757874625342]]]\", \"wayPointList\":[{\"id\":\"2c9081e5765ff92401766459c4b700ef\", \"order\":1, \"latitude\":30.569027816872925, \"longitude\":114.17424033930959 }, {\"id\":\"2c9081e5765ff92401766459c4b700f0\", \"order\":2, \"latitude\":30.569027816872925, \"longitude\":114.16566981020614 }, {\"id\":\"2c9081e5765ff92401766459c4b700f1\", \"order\":3, \"latitude\":30.568297759120508, \"longitude\":114.16565822198784 }, {\"id\":\"2c9081e5765ff92401766459c4b700f2\", \"order\":4, \"latitude\":30.56829775912051, \"longitude\":114.17435889569673 }, {\"id\":\"2c9081e5765ff92401766459c4b700f3\", \"order\":5, \"latitude\":30.56756770136809, \"longitude\":114.17447745208386 }, {\"id\":\"2c9081e5765ff92401766459c4b700f4\", \"order\":6, \"latitude\":30.567567701368098, \"longitude\":114.16564663376954 }, {\"id\":\"2c9081e5765ff92401766459c4b700f5\", \"order\":7, \"latitude\":30.566837643615678, \"longitude\":114.16563504555124 }, {\"id\":\"2c9081e5765ff92401766459c4b700f6\", \"order\":8, \"latitude\":30.566837643615674, \"longitude\":114.17459600847101 }, {\"id\":\"2c9081e5765ff92401766459c4b800f7\", \"order\":9, \"latitude\":30.566107585863264, \"longitude\":114.17471456485816 }, {\"id\":\"2c9081e5765ff92401766459c4b800f8\", \"order\":10, \"latitude\":30.56610758586326, \"longitude\":114.16562345733297 }, {\"id\":\"2c9081e5765ff92401766459c4b800f9\", \"order\":11, \"latitude\":30.565377528110844, \"longitude\":114.16561186911467 }, {\"id\":\"2c9081e5765ff92401766459c4b800fa\", \"order\":12, \"latitude\":30.565377528110847, \"longitude\":114.1748331212453 }, {\"id\":\"2c9081e5765ff92401766459c4b800fb\", \"order\":13, \"latitude\":30.564647470358427, \"longitude\":114.17484278850017 }, {\"id\":\"2c9081e5765ff92401766459c4b800fc\", \"order\":14, \"latitude\":30.564647470358427, \"longitude\":114.16560028089638 } ] }, {\"id\":\"202012151104369368110403\", \"createTime\":\"2020-12-15\", \"speed\":5.0, \"flyTaskName\":\"数据测试_ceshi1_网格1_2期\", \"flyHeight\":300.0, \"lineOverlap\":0.7, \"headingOverlap\":0.7, \"rotatePitch\":90.0, \"coordinate\":\"[[[114.15606836131505,30.569853803041866],[114.15611127665929,30.56397440088122],[114.1622910862296,30.563931485536983],[114.16259149363927,30.570111295107296],[114.15606836131505,30.569853803041866]]]\", \"wayPointList\":[{\"id\":\"2c9081e5765ff9240176645b594800fe\", \"order\":1, \"latitude\":30.568651179602462, \"longitude\":114.16252051580221 }, {\"id\":\"2c9081e5765ff9240176645b594800ff\", \"order\":2, \"latitude\":30.56865117960246, \"longitude\":114.15607713958833 }, {\"id\":\"2c9081e5765ff9240176645b59490100\", \"order\":3, \"latitude\":30.56719106409763, \"longitude\":114.15608779736573 }, {\"id\":\"2c9081e5765ff9240176645b59490101\", \"order\":4, \"latitude\":30.56719106409763, \"longitude\":114.16244953796519 }, {\"id\":\"2c9081e5765ff9240176645b59490102\", \"order\":5, \"latitude\":30.565730948592797, \"longitude\":114.16237856012815 }, {\"id\":\"2c9081e5765ff9240176645b59490103\", \"order\":6, \"latitude\":30.565730948592797, \"longitude\":114.15609845514317 }, {\"id\":\"2c9081e5765ff9240176645b59490104\", \"order\":7, \"latitude\":30.56427083308797, \"longitude\":114.15610911292055 }, {\"id\":\"2c9081e5765ff9240176645b594a0105\", \"order\":8, \"latitude\":30.564270833087967, \"longitude\":114.1623075822911 } ] }, {\"id\":\"202012151104370045630287\", \"createTime\":\"2020-12-15\", \"speed\":5.0, \"flyTaskName\":\"数据测试_ceshi1_网格2_2期\", \"flyHeight\":150.0, \"lineOverlap\":0.7, \"headingOverlap\":0.7, \"rotatePitch\":90.0, \"coordinate\":\"[[[114.16568139842443,30.569757874625342],[114.16559556773595,30.56435054125132],[114.1749511127799,30.564650948660987],[114.17413572123937,30.569672043936865],[114.16568139842443,30.569757874625342]]]\", \"wayPointList\":[{\"id\":\"2c9081e5765ff9240176645b598c0106\", \"order\":1, \"latitude\":30.569027816872925, \"longitude\":114.17424033930959 }, {\"id\":\"2c9081e5765ff9240176645b598c0107\", \"order\":2, \"latitude\":30.569027816872925, \"longitude\":114.16566981020614 }, {\"id\":\"2c9081e5765ff9240176645b598c0108\", \"order\":3, \"latitude\":30.568297759120508, \"longitude\":114.16565822198784 }, {\"id\":\"2c9081e5765ff9240176645b598c0109\", \"order\":4, \"latitude\":30.56829775912051, \"longitude\":114.17435889569673 }, {\"id\":\"2c9081e5765ff9240176645b598d010a\", \"order\":5, \"latitude\":30.56756770136809, \"longitude\":114.17447745208386 }, {\"id\":\"2c9081e5765ff9240176645b598d010b\", \"order\":6, \"latitude\":30.567567701368098, \"longitude\":114.16564663376954 }, {\"id\":\"2c9081e5765ff9240176645b598d010c\", \"order\":7, \"latitude\":30.566837643615678, \"longitude\":114.16563504555124 }, {\"id\":\"2c9081e5765ff9240176645b598d010d\", \"order\":8, \"latitude\":30.566837643615674, \"longitude\":114.17459600847101 }, {\"id\":\"2c9081e5765ff9240176645b598d010e\", \"order\":9, \"latitude\":30.566107585863264, \"longitude\":114.17471456485816 }, {\"id\":\"2c9081e5765ff9240176645b598d010f\", \"order\":10, \"latitude\":30.56610758586326, \"longitude\":114.16562345733297 }, {\"id\":\"2c9081e5765ff9240176645b598d0110\", \"order\":11, \"latitude\":30.565377528110844, \"longitude\":114.16561186911467 }, {\"id\":\"2c9081e5765ff9240176645b598d0111\", \"order\":12, \"latitude\":30.565377528110847, \"longitude\":114.1748331212453 }, {\"id\":\"2c9081e5765ff9240176645b598d0112\", \"order\":13, \"latitude\":30.564647470358427, \"longitude\":114.17484278850017 }, {\"id\":\"2c9081e5765ff9240176645b598d0113\", \"order\":14, \"latitude\":30.564647470358427, \"longitude\":114.16560028089638 } ] }, {\"id\":\"202012151325427806655106\", \"createTime\":\"2020-12-15\", \"speed\":5.0, \"flyTaskName\":\"20201215测试1_黄金口工业园_网格1_1期\", \"flyHeight\":150.0, \"lineOverlap\":0.7, \"headingOverlap\":0.7, \"rotatePitch\":90.0, \"coordinate\":\"[[[114.14650182700547,30.573812230423382],[114.15220588820452,30.575767908548773],[114.1681229351695,30.574138176777613],[114.16627590582887,30.56745627651586],[114.14650182700547,30.573812230423382]]]\", \"wayPointList\":[{\"id\":\"2c9081e57664d161017664dc86fc0030\", \"order\":1, \"latitude\":30.57503785079636, \"longitude\":114.15933611891978 }, {\"id\":\"2c9081e57664d161017664dc86fd0031\", \"order\":2, \"latitude\":30.575037850796356, \"longitude\":114.15007655309331 }, {\"id\":\"2c9081e57664d161017664dc86fd0032\", \"order\":3, \"latitude\":30.57430779304394, \"longitude\":114.14794721798208 }, {\"id\":\"2c9081e57664d161017664dc86fd0033\", \"order\":4, \"latitude\":30.574307793043936, \"longitude\":114.16646634963504 }, {\"id\":\"2c9081e57664d161017664dc86fd0034\", \"order\":5, \"latitude\":30.573577735291526, \"longitude\":114.16796801638475 }, {\"id\":\"2c9081e57664d161017664dc86fd0035\", \"order\":6, \"latitude\":30.57357773529153, \"longitude\":114.14723136741567 }, {\"id\":\"2c9081e57664d161017664dc86fd0036\", \"order\":7, \"latitude\":30.57284767753911, \"longitude\":114.14950265820099 }, {\"id\":\"2c9081e57664d161017664dc86fd0037\", \"order\":8, \"latitude\":30.572847677539112, \"longitude\":114.16776621180276 }, {\"id\":\"2c9081e57664d161017664dc86fe0038\", \"order\":9, \"latitude\":30.572117619786688, \"longitude\":114.1675644072208 }, {\"id\":\"2c9081e57664d161017664dc86fe0039\", \"order\":10, \"latitude\":30.57211761978669, \"longitude\":114.15177394898627 }, {\"id\":\"2c9081e57664d161017664dc86fe003a\", \"order\":11, \"latitude\":30.57138756203428, \"longitude\":114.15404523977156 }, {\"id\":\"2c9081e57664d161017664dc86fe003b\", \"order\":12, \"latitude\":30.57138756203427, \"longitude\":114.16736260263882 }, {\"id\":\"2c9081e57664d161017664dc86fe003c\", \"order\":13, \"latitude\":30.570657504281854, \"longitude\":114.16716079805686 }, {\"id\":\"2c9081e57664d161017664dc86fe003d\", \"order\":14, \"latitude\":30.570657504281858, \"longitude\":114.15631653055688 }, {\"id\":\"2c9081e57664d161017664dc86fe003e\", \"order\":15, \"latitude\":30.569927446529444, \"longitude\":114.15858782134215 }, {\"id\":\"2c9081e57664d161017664dc86fe003f\", \"order\":16, \"latitude\":30.569927446529444, \"longitude\":114.16695899347489 }, {\"id\":\"2c9081e57664d161017664dc86fe0040\", \"order\":17, \"latitude\":30.569197388777024, \"longitude\":114.16675718889293 }, {\"id\":\"2c9081e57664d161017664dc86ff0041\", \"order\":18, \"latitude\":30.56919738877703, \"longitude\":114.16085911212745 }, {\"id\":\"2c9081e57664d161017664dc86ff0042\", \"order\":19, \"latitude\":30.56846733102461, \"longitude\":114.16313040291274 }, {\"id\":\"2c9081e57664d161017664dc86ff0043\", \"order\":20, \"latitude\":30.568467331024614, \"longitude\":114.16655538431097 }, {\"id\":\"2c9081e57664d161017664dc86ff0044\", \"order\":21, \"latitude\":30.567737273272197, \"longitude\":114.16635357972899 }, {\"id\":\"2c9081e57664d161017664dc86ff0045\", \"order\":22, \"latitude\":30.567737273272197, \"longitude\":114.16540169369806 } ] }, {\"id\":\"202012151325479388837191\", \"createTime\":\"2020-12-15\", \"speed\":5.0, \"flyTaskName\":\"20201215测试1_黄金口工业园_网格2_1期\", \"flyHeight\":150.0, \"lineOverlap\":0.7, \"headingOverlap\":0.7, \"rotatePitch\":90.0, \"coordinate\":\"[[[114.14737101728342,30.57104168641241],[114.16084346659167,30.559361942052437],[114.14650182700547,30.559090320090576],[114.14655615139783,30.56968357660311],[114.14737101728342,30.57104168641241]]]\", \"wayPointList\":[{\"id\":\"2c9081e57664d161017664dc9b220047\", \"order\":1, \"latitude\":30.570311628659997, \"longitude\":114.1482131304118 }, {\"id\":\"2c9081e57664d161017664dc9b220048\", \"order\":2, \"latitude\":30.570311628659994, \"longitude\":114.14693298263197 }, {\"id\":\"2c9081e57664d161017664dc9b220049\", \"order\":3, \"latitude\":30.56958157090757, \"longitude\":114.1465556282917 }, {\"id\":\"2c9081e57664d161017664dc9b22004a\", \"order\":4, \"latitude\":30.56958157090758, \"longitude\":114.14905524354015 }, {\"id\":\"2c9081e57664d161017664dc9b22004b\", \"order\":5, \"latitude\":30.568851513155163, \"longitude\":114.14989735666852 }, {\"id\":\"2c9081e57664d161017664dc9b23004c\", \"order\":6, \"latitude\":30.56885151315516, \"longitude\":114.14655188440578 }, {\"id\":\"2c9081e57664d161017664dc9b23004d\", \"order\":7, \"latitude\":30.56812145540275, \"longitude\":114.1465481405199 }, {\"id\":\"2c9081e57664d161017664dc9b23004e\", \"order\":8, \"latitude\":30.568121455402746, \"longitude\":114.15073946979689 }, {\"id\":\"2c9081e57664d161017664dc9b23004f\", \"order\":9, \"latitude\":30.56739139765033, \"longitude\":114.15158158292527 }, {\"id\":\"2c9081e57664d161017664dc9b230050\", \"order\":10, \"latitude\":30.567391397650326, \"longitude\":114.14654439663398 }, {\"id\":\"2c9081e57664d161017664dc9b230051\", \"order\":11, \"latitude\":30.566661339897916, \"longitude\":114.14654065274807 }, {\"id\":\"2c9081e57664d161017664dc9b230052\", \"order\":12, \"latitude\":30.56666133989791, \"longitude\":114.15242369605363 }, {\"id\":\"2c9081e57664d161017664dc9b230053\", \"order\":13, \"latitude\":30.5659312821455, \"longitude\":114.153265809182 }, {\"id\":\"2c9081e57664d161017664dc9b230054\", \"order\":14, \"latitude\":30.565931282145495, \"longitude\":114.14653690886216 }, {\"id\":\"2c9081e57664d161017664dc9b240055\", \"order\":15, \"latitude\":30.565201224393082, \"longitude\":114.14653316497626 }, {\"id\":\"2c9081e57664d161017664dc9b240056\", \"order\":16, \"latitude\":30.565201224393082, \"longitude\":114.15410792231036 }, {\"id\":\"2c9081e57664d161017664dc9b240057\", \"order\":17, \"latitude\":30.564471166640665, \"longitude\":114.15495003543873 }, {\"id\":\"2c9081e57664d161017664dc9b240058\", \"order\":18, \"latitude\":30.564471166640665, \"longitude\":114.14652942109032 }, {\"id\":\"2c9081e57664d161017664dc9b240059\", \"order\":19, \"latitude\":30.56374110888825, \"longitude\":114.14652567720441 }, {\"id\":\"2c9081e57664d161017664dc9b24005a\", \"order\":20, \"latitude\":30.563741108888248, \"longitude\":114.1557921485671 }, {\"id\":\"2c9081e57664d161017664dc9b24005b\", \"order\":21, \"latitude\":30.56301105113583, \"longitude\":114.15663426169549 }, {\"id\":\"2c9081e57664d161017664dc9b24005c\", \"order\":22, \"latitude\":30.563011051135835, \"longitude\":114.14652193331852 }, {\"id\":\"2c9081e57664d161017664dc9b24005d\", \"order\":23, \"latitude\":30.562280993383418, \"longitude\":114.14651818943261 }, {\"id\":\"2c9081e57664d161017664dc9b24005e\", \"order\":24, \"latitude\":30.56228099338341, \"longitude\":114.15747637482383 }, {\"id\":\"2c9081e57664d161017664dc9b25005f\", \"order\":25, \"latitude\":30.561550935631004, \"longitude\":114.15831848795222 }, {\"id\":\"2c9081e57664d161017664dc9b250060\", \"order\":26, \"latitude\":30.561550935631004, \"longitude\":114.1465144455467 }, {\"id\":\"2c9081e57664d161017664dc9b250061\", \"order\":27, \"latitude\":30.56082087787859, \"longitude\":114.14651070166079 }, {\"id\":\"2c9081e57664d161017664dc9b250062\", \"order\":28, \"latitude\":30.560820877878584, \"longitude\":114.15916060108059 }, {\"id\":\"2c9081e57664d161017664dc9b250063\", \"order\":29, \"latitude\":30.560090820126167, \"longitude\":114.16000271420893 }, {\"id\":\"2c9081e57664d161017664dc9b250064\", \"order\":30, \"latitude\":30.560090820126167, \"longitude\":114.14650695777487 }, {\"id\":\"2c9081e57664d161017664dc9b250065\", \"order\":31, \"latitude\":30.55936076237375, \"longitude\":114.14650321388896 }, {\"id\":\"2c9081e57664d161017664dc9b250066\", \"order\":32, \"latitude\":30.559360762373746, \"longitude\":114.16078117955698 } ] }, {\"id\":\"202012151325563887712803\", \"createTime\":\"2020-12-15\", \"speed\":5.0, \"flyTaskName\":\"20201215测试1_黄金口工业园_网格1_4期\", \"flyHeight\":150.0, \"lineOverlap\":0.7, \"headingOverlap\":0.7, \"rotatePitch\":90.0, \"coordinate\":\"[[[114.14650182700547,30.573812230423382],[114.15220588820452,30.575767908548773],[114.1681229351695,30.574138176777613],[114.16627590582887,30.56745627651586],[114.14650182700547,30.573812230423382]]]\", \"wayPointList\":[{\"id\":\"2c9081e57664d161017664dcbc250067\", \"order\":1, \"latitude\":30.57503785079636, \"longitude\":114.15933611891978 }, {\"id\":\"2c9081e57664d161017664dcbc250068\", \"order\":2, \"latitude\":30.575037850796356, \"longitude\":114.15007655309331 }, {\"id\":\"2c9081e57664d161017664dcbc250069\", \"order\":3, \"latitude\":30.57430779304394, \"longitude\":114.14794721798208 }, {\"id\":\"2c9081e57664d161017664dcbc25006a\", \"order\":4, \"latitude\":30.574307793043936, \"longitude\":114.16646634963504 }, {\"id\":\"2c9081e57664d161017664dcbc25006b\", \"order\":5, \"latitude\":30.573577735291526, \"longitude\":114.16796801638475 }, {\"id\":\"2c9081e57664d161017664dcbc25006c\", \"order\":6, \"latitude\":30.57357773529153, \"longitude\":114.14723136741567 }, {\"id\":\"2c9081e57664d161017664dcbc25006d\", \"order\":7, \"latitude\":30.57284767753911, \"longitude\":114.14950265820099 }, {\"id\":\"2c9081e57664d161017664dcbc25006e\", \"order\":8, \"latitude\":30.572847677539112, \"longitude\":114.16776621180276 }, {\"id\":\"2c9081e57664d161017664dcbc25006f\", \"order\":9, \"latitude\":30.572117619786688, \"longitude\":114.1675644072208 }, {\"id\":\"2c9081e57664d161017664dcbc260070\", \"order\":10, \"latitude\":30.57211761978669, \"longitude\":114.15177394898627 }, {\"id\":\"2c9081e57664d161017664dcbc260071\", \"order\":11, \"latitude\":30.57138756203428, \"longitude\":114.15404523977156 }, {\"id\":\"2c9081e57664d161017664dcbc260072\", \"order\":12, \"latitude\":30.57138756203427, \"longitude\":114.16736260263882 }, {\"id\":\"2c9081e57664d161017664dcbc260073\", \"order\":13, \"latitude\":30.570657504281854, \"longitude\":114.16716079805686 }, {\"id\":\"2c9081e57664d161017664dcbc260074\", \"order\":14, \"latitude\":30.570657504281858, \"longitude\":114.15631653055688 }, {\"id\":\"2c9081e57664d161017664dcbc260075\", \"order\":15, \"latitude\":30.569927446529444, \"longitude\":114.15858782134215 }, {\"id\":\"2c9081e57664d161017664dcbc260076\", \"order\":16, \"latitude\":30.569927446529444, \"longitude\":114.16695899347489 }, {\"id\":\"2c9081e57664d161017664dcbc260077\", \"order\":17, \"latitude\":30.569197388777024, \"longitude\":114.16675718889293 }, {\"id\":\"2c9081e57664d161017664dcbc260078\", \"order\":18, \"latitude\":30.56919738877703, \"longitude\":114.16085911212745 }, {\"id\":\"2c9081e57664d161017664dcbc270079\", \"order\":19, \"latitude\":30.56846733102461, \"longitude\":114.16313040291274 }, {\"id\":\"2c9081e57664d161017664dcbc27007a\", \"order\":20, \"latitude\":30.568467331024614, \"longitude\":114.16655538431097 }, {\"id\":\"2c9081e57664d161017664dcbc27007b\", \"order\":21, \"latitude\":30.567737273272197, \"longitude\":114.16635357972899 }, {\"id\":\"2c9081e57664d161017664dcbc27007c\", \"order\":22, \"latitude\":30.567737273272197, \"longitude\":114.16540169369806 } ] }, {\"id\":\"202012151325564863450954\", \"createTime\":\"2020-12-15\", \"speed\":5.0, \"flyTaskName\":\"20201215测试1_黄金口工业园_网格2_4期\", \"flyHeight\":150.0, \"lineOverlap\":0.7, \"headingOverlap\":0.7, \"rotatePitch\":90.0, \"coordinate\":\"[[[114.14737101728342,30.57104168641241],[114.16084346659167,30.559361942052437],[114.14650182700547,30.559090320090576],[114.14655615139783,30.56968357660311],[114.14737101728342,30.57104168641241]]]\", \"wayPointList\":[{\"id\":\"2c9081e57664d161017664dcbc87007d\", \"order\":1, \"latitude\":30.570311628659997, \"longitude\":114.1482131304118 }, {\"id\":\"2c9081e57664d161017664dcbc87007e\", \"order\":2, \"latitude\":30.570311628659994, \"longitude\":114.14693298263197 }, {\"id\":\"2c9081e57664d161017664dcbc87007f\", \"order\":3, \"latitude\":30.56958157090757, \"longitude\":114.1465556282917 }, {\"id\":\"2c9081e57664d161017664dcbc890080\", \"order\":4, \"latitude\":30.56958157090758, \"longitude\":114.14905524354015 }, {\"id\":\"2c9081e57664d161017664dcbc890081\", \"order\":5, \"latitude\":30.568851513155163, \"longitude\":114.14989735666852 }, {\"id\":\"2c9081e57664d161017664dcbc890082\", \"order\":6, \"latitude\":30.56885151315516, \"longitude\":114.14655188440578 }, {\"id\":\"2c9081e57664d161017664dcbc890083\", \"order\":7, \"latitude\":30.56812145540275, \"longitude\":114.1465481405199 }, {\"id\":\"2c9081e57664d161017664dcbc890084\", \"order\":8, \"latitude\":30.568121455402746, \"longitude\":114.15073946979689 }, {\"id\":\"2c9081e57664d161017664dcbc890085\", \"order\":9, \"latitude\":30.56739139765033, \"longitude\":114.15158158292527 }, {\"id\":\"2c9081e57664d161017664dcbc890086\", \"order\":10, \"latitude\":30.567391397650326, \"longitude\":114.14654439663398 }, {\"id\":\"2c9081e57664d161017664dcbc890087\", \"order\":11, \"latitude\":30.566661339897916, \"longitude\":114.14654065274807 }, {\"id\":\"2c9081e57664d161017664dcbc890088\", \"order\":12, \"latitude\":30.56666133989791, \"longitude\":114.15242369605363 }, {\"id\":\"2c9081e57664d161017664dcbc8a0089\", \"order\":13, \"latitude\":30.5659312821455, \"longitude\":114.153265809182 }, {\"id\":\"2c9081e57664d161017664dcbc8a008a\", \"order\":14, \"latitude\":30.565931282145495, \"longitude\":114.14653690886216 }, {\"id\":\"2c9081e57664d161017664dcbc8a008b\", \"order\":15, \"latitude\":30.565201224393082, \"longitude\":114.14653316497626 }, {\"id\":\"2c9081e57664d161017664dcbc8a008c\", \"order\":16, \"latitude\":30.565201224393082, \"longitude\":114.15410792231036 }, {\"id\":\"2c9081e57664d161017664dcbc8a008d\", \"order\":17, \"latitude\":30.564471166640665, \"longitude\":114.15495003543873 }, {\"id\":\"2c9081e57664d161017664dcbc8a008e\", \"order\":18, \"latitude\":30.564471166640665, \"longitude\":114.14652942109032 }, {\"id\":\"2c9081e57664d161017664dcbc8a008f\", \"order\":19, \"latitude\":30.56374110888825, \"longitude\":114.14652567720441 }, {\"id\":\"2c9081e57664d161017664dcbc8a0090\", \"order\":20, \"latitude\":30.563741108888248, \"longitude\":114.1557921485671 }, {\"id\":\"2c9081e57664d161017664dcbc8a0091\", \"order\":21, \"latitude\":30.56301105113583, \"longitude\":114.15663426169549 }, {\"id\":\"2c9081e57664d161017664dcbc8a0092\", \"order\":22, \"latitude\":30.563011051135835, \"longitude\":114.14652193331852 }, {\"id\":\"2c9081e57664d161017664dcbc8a0093\", \"order\":23, \"latitude\":30.562280993383418, \"longitude\":114.14651818943261 }, {\"id\":\"2c9081e57664d161017664dcbc8b0094\", \"order\":24, \"latitude\":30.56228099338341, \"longitude\":114.15747637482383 }, {\"id\":\"2c9081e57664d161017664dcbc8b0095\", \"order\":25, \"latitude\":30.561550935631004, \"longitude\":114.15831848795222 }, {\"id\":\"2c9081e57664d161017664dcbc8b0096\", \"order\":26, \"latitude\":30.561550935631004, \"longitude\":114.1465144455467 }, {\"id\":\"2c9081e57664d161017664dcbc8b0097\", \"order\":27, \"latitude\":30.56082087787859, \"longitude\":114.14651070166079 }, {\"id\":\"2c9081e57664d161017664dcbc8b0098\", \"order\":28, \"latitude\":30.560820877878584, \"longitude\":114.15916060108059 }, {\"id\":\"2c9081e57664d161017664dcbc8b0099\", \"order\":29, \"latitude\":30.560090820126167, \"longitude\":114.16000271420893 }, {\"id\":\"2c9081e57664d161017664dcbc8b009a\", \"order\":30, \"latitude\":30.560090820126167, \"longitude\":114.14650695777487 }, {\"id\":\"2c9081e57664d161017664dcbc8b009b\", \"order\":31, \"latitude\":30.55936076237375, \"longitude\":114.14650321388896 }, {\"id\":\"2c9081e57664d161017664dcbc8b009c\", \"order\":32, \"latitude\":30.559360762373746, \"longitude\":114.16078117955698 } ] }, {\"id\":\"202012151351272918623070\", \"createTime\":\"2020-12-15\", \"speed\":5.0, \"flyTaskName\":\"测试_工业园_网格1_1期\", \"flyHeight\":150.0, \"lineOverlap\":0.7, \"headingOverlap\":0.7, \"rotatePitch\":90.0, \"coordinate\":\"[[[114.15737772229716,30.544825161055602],[114.17213194526879,30.535441722178245],[114.1680575573352,30.53105866849211],[114.15540226148087,30.542541034486774],[114.15737772229716,30.544825161055602]]]\", \"wayPointList\":[{\"id\":\"2c9081e57664d161017664f4183b00d6\", \"order\":1, \"latitude\":30.544095103303185, \"longitude\":114.15852564205261 }, {\"id\":\"2c9081e57664d161017664f4183b00d7\", \"order\":2, \"latitude\":30.54409510330318, \"longitude\":114.15674632099775 }, {\"id\":\"2c9081e57664d161017664f4183c00d8\", \"order\":3, \"latitude\":30.543365045550765, \"longitude\":114.15611491969838 }, {\"id\":\"2c9081e57664d161017664f4183c00d9\", \"order\":4, \"latitude\":30.543365045550768, \"longitude\":114.15967356180806 }, {\"id\":\"2c9081e57664d161017664f4183c00da\", \"order\":5, \"latitude\":30.54263498779836, \"longitude\":114.16082148156349 }, {\"id\":\"2c9081e57664d161017664f4183c00db\", \"order\":6, \"latitude\":30.542634987798355, \"longitude\":114.15548351839898 }, {\"id\":\"2c9081e57664d161017664f4183c00dc\", \"order\":7, \"latitude\":30.541904930045938, \"longitude\":114.15610334433235 }, {\"id\":\"2c9081e57664d161017664f4183c00dd\", \"order\":8, \"latitude\":30.541904930045934, \"longitude\":114.16196940131893 }, {\"id\":\"2c9081e57664d161017664f4183c00de\", \"order\":9, \"latitude\":30.541174872293524, \"longitude\":114.16311732107438 }, {\"id\":\"2c9081e57664d161017664f4183c00df\", \"order\":10, \"latitude\":30.54117487229352, \"longitude\":114.15690797787666 }, {\"id\":\"2c9081e57664d161017664f4183c00e0\", \"order\":11, \"latitude\":30.540444814541107, \"longitude\":114.15771261142099 }, {\"id\":\"2c9081e57664d161017664f4183c00e1\", \"order\":12, \"latitude\":30.540444814541107, \"longitude\":114.16426524082985 }, {\"id\":\"2c9081e57664d161017664f4183d00e2\", \"order\":13, \"latitude\":30.53971475678869, \"longitude\":114.16541316058525 }, {\"id\":\"2c9081e57664d161017664f4183d00e3\", \"order\":14, \"latitude\":30.539714756788687, \"longitude\":114.15851724496532 }, {\"id\":\"2c9081e57664d161017664f4183d00e4\", \"order\":15, \"latitude\":30.538984699036277, \"longitude\":114.15932187850966 }, {\"id\":\"2c9081e57664d161017664f4183d00e5\", \"order\":16, \"latitude\":30.538984699036273, \"longitude\":114.16656108034071 }, {\"id\":\"2c9081e57664d161017664f4183d00e6\", \"order\":17, \"latitude\":30.538254641283856, \"longitude\":114.16770900009614 }, {\"id\":\"2c9081e57664d161017664f4183d00e7\", \"order\":18, \"latitude\":30.53825464128386, \"longitude\":114.16012651205398 }, {\"id\":\"2c9081e57664d161017664f4183d00e8\", \"order\":19, \"latitude\":30.53752458353144, \"longitude\":114.16093114559831 }, {\"id\":\"2c9081e57664d161017664f4183d00e9\", \"order\":20, \"latitude\":30.53752458353144, \"longitude\":114.16885691985158 }, {\"id\":\"2c9081e57664d161017664f4183d00ea\", \"order\":21, \"latitude\":30.536794525779023, \"longitude\":114.17000483960703 }, {\"id\":\"2c9081e57664d161017664f4183d00eb\", \"order\":22, \"latitude\":30.536794525779026, \"longitude\":114.16173577914265 }, {\"id\":\"2c9081e57664d161017664f4183d00ec\", \"order\":23, \"latitude\":30.536064468026606, \"longitude\":114.16254041268698 }, {\"id\":\"2c9081e57664d161017664f4183e00ed\", \"order\":24, \"latitude\":30.536064468026606, \"longitude\":114.1711527593625 }, {\"id\":\"2c9081e57664d161017664f4183e00ee\", \"order\":25, \"latitude\":30.535334410274196, \"longitude\":114.17203219054107 }, {\"id\":\"2c9081e57664d161017664f4183e00ef\", \"order\":26, \"latitude\":30.535334410274196, \"longitude\":114.16334504623131 }, {\"id\":\"2c9081e57664d161017664f4183e00f0\", \"order\":27, \"latitude\":30.534604352521775, \"longitude\":114.16414967977562 }, {\"id\":\"2c9081e57664d161017664f4183e00f1\", \"order\":28, \"latitude\":30.534604352521775, \"longitude\":114.17135354530643 }, {\"id\":\"2c9081e57664d161017664f4183e00f2\", \"order\":29, \"latitude\":30.533874294769358, \"longitude\":114.17067490007179 }, {\"id\":\"2c9081e57664d161017664f4183e00f3\", \"order\":30, \"latitude\":30.533874294769358, \"longitude\":114.16495431331997 }, {\"id\":\"2c9081e57664d161017664f4183f00f4\", \"order\":31, \"latitude\":30.533144237016945, \"longitude\":114.16575894686429 }, {\"id\":\"2c9081e57664d161017664f4183f00f5\", \"order\":32, \"latitude\":30.53314423701694, \"longitude\":114.16999625483716 }, {\"id\":\"2c9081e57664d161017664f4183f00f6\", \"order\":33, \"latitude\":30.532414179264528, \"longitude\":114.16931760960252 }, {\"id\":\"2c9081e57664d161017664f4183f00f7\", \"order\":34, \"latitude\":30.532414179264528, \"longitude\":114.1665635804086 }, {\"id\":\"2c9081e57664d161017664f4183f00f8\", \"order\":35, \"latitude\":30.531684121512107, \"longitude\":114.16736821395295 }, {\"id\":\"2c9081e57664d161017664f4183f00f9\", \"order\":36, \"latitude\":30.53168412151211, \"longitude\":114.16863896436787 } ] }, {\"id\":\"202012151351395183350813\", \"createTime\":\"2020-12-15\", \"speed\":5.0, \"flyTaskName\":\"测试_工业园_网格2_1期\", \"flyHeight\":150.0, \"lineOverlap\":0.7, \"headingOverlap\":0.7, \"rotatePitch\":90.0, \"coordinate\":\"[[[114.15410586532018,30.541800236680665],[114.16441530145516,30.529885738632444],[114.16058784612362,30.526922547408013],[114.15138960669779,30.539022244907763],[114.15410586532018,30.541800236680665]]]\", \"wayPointList\":[{\"id\":\"2c9081e57664d161017664f447fe00fb\", \"order\":1, \"latitude\":30.541070178928244, \"longitude\":114.15473757332356 }, {\"id\":\"2c9081e57664d161017664f447fe00fc\", \"order\":2, \"latitude\":30.541070178928244, \"longitude\":114.15339203107338 }, {\"id\":\"2c9081e57664d161017664f447fe00fd\", \"order\":3, \"latitude\":30.540340121175824, \"longitude\":114.15267819682657 }, {\"id\":\"2c9081e57664d161017664f447fe00fe\", \"order\":4, \"latitude\":30.54034012117583, \"longitude\":114.15536928132695 }, {\"id\":\"2c9081e57664d161017664f447fe00ff\", \"order\":5, \"latitude\":30.539610063423417, \"longitude\":114.15600098933032 }, {\"id\":\"2c9081e57664d161017664f447fe0100\", \"order\":6, \"latitude\":30.539610063423417, \"longitude\":114.15196436257976 }, {\"id\":\"2c9081e57664d161017664f447ff0101\", \"order\":7, \"latitude\":30.538880005671, \"longitude\":114.15149773754614 }, {\"id\":\"2c9081e57664d161017664f447ff0102\", \"order\":8, \"latitude\":30.538880005671004, \"longitude\":114.15663269733375 }, {\"id\":\"2c9081e57664d161017664f447ff0103\", \"order\":9, \"latitude\":30.538149947918583, \"longitude\":114.1572644053371 }, {\"id\":\"2c9081e57664d161017664f447ff0104\", \"order\":10, \"latitude\":30.538149947918583, \"longitude\":114.15205273042938 }, {\"id\":\"2c9081e57664d161017664f447ff0105\", \"order\":11, \"latitude\":30.537419890166166, \"longitude\":114.15260772331257 }, {\"id\":\"2c9081e57664d161017664f447ff0106\", \"order\":12, \"latitude\":30.53741989016617, \"longitude\":114.1578961133405 }, {\"id\":\"2c9081e57664d161017664f447ff0107\", \"order\":13, \"latitude\":30.536689832413757, \"longitude\":114.1585278213439 }, {\"id\":\"2c9081e57664d161017664f447ff0108\", \"order\":14, \"latitude\":30.53668983241375, \"longitude\":114.15316271619578 }, {\"id\":\"2c9081e57664d161017664f447ff0109\", \"order\":15, \"latitude\":30.535959774661336, \"longitude\":114.153717709079 }, {\"id\":\"2c9081e57664d161017664f447ff010a\", \"order\":16, \"latitude\":30.535959774661336, \"longitude\":114.15915952934726 }, {\"id\":\"2c9081e57664d161017664f44800010b\", \"order\":17, \"latitude\":30.535229716908923, \"longitude\":114.15979123735066 }, {\"id\":\"2c9081e57664d161017664f44800010c\", \"order\":18, \"latitude\":30.53522971690892, \"longitude\":114.15427270196221 }, {\"id\":\"2c9081e57664d161017664f44800010d\", \"order\":19, \"latitude\":30.5344996591565, \"longitude\":114.15482769484542 }, {\"id\":\"2c9081e57664d161017664f44800010e\", \"order\":20, \"latitude\":30.534499659156502, \"longitude\":114.16042294535404 }, {\"id\":\"2c9081e57664d161017664f44800010f\", \"order\":21, \"latitude\":30.53376960140409, \"longitude\":114.16105465335743 }, {\"id\":\"2c9081e57664d161017664f448000110\", \"order\":22, \"latitude\":30.53376960140408, \"longitude\":114.15538268772865 }, {\"id\":\"2c9081e57664d161017664f448000111\", \"order\":23, \"latitude\":30.533039543651668, \"longitude\":114.15593768061187 }, {\"id\":\"2c9081e57664d161017664f448000112\", \"order\":24, \"latitude\":30.533039543651668, \"longitude\":114.16168636136082 }, {\"id\":\"2c9081e57664d161017664f448000113\", \"order\":25, \"latitude\":30.53230948589926, \"longitude\":114.1623180693642 }, {\"id\":\"2c9081e57664d161017664f448000114\", \"order\":26, \"latitude\":30.53230948589926, \"longitude\":114.15649267349508 }, {\"id\":\"2c9081e57664d161017664f448000115\", \"order\":27, \"latitude\":30.531579428146838, \"longitude\":114.15704766637829 }, {\"id\":\"2c9081e57664d161017664f448010116\", \"order\":28, \"latitude\":30.53157942814684, \"longitude\":114.16294977736759 }, {\"id\":\"2c9081e57664d161017664f448010117\", \"order\":29, \"latitude\":30.53084937039442, \"longitude\":114.16358148537097 }, {\"id\":\"2c9081e57664d161017664f448010118\", \"order\":30, \"latitude\":30.53084937039442, \"longitude\":114.15760265926149 }, {\"id\":\"2c9081e57664d161017664f448010119\", \"order\":31, \"latitude\":30.530119312642004, \"longitude\":114.15815765214471 }, {\"id\":\"2c9081e57664d161017664f44801011a\", \"order\":32, \"latitude\":30.530119312642007, \"longitude\":114.16421319337437 }, {\"id\":\"2c9081e57664d161017664f44801011b\", \"order\":33, \"latitude\":30.529389254889594, \"longitude\":114.16377400995397 }, {\"id\":\"2c9081e57664d161017664f44801011c\", \"order\":34, \"latitude\":30.52938925488959, \"longitude\":114.15871264502795 }, {\"id\":\"2c9081e57664d161017664f44801011d\", \"order\":35, \"latitude\":30.528659197137177, \"longitude\":114.15926763791114 }, {\"id\":\"2c9081e57664d161017664f44801011e\", \"order\":36, \"latitude\":30.528659197137177, \"longitude\":114.16283101869044 }, {\"id\":\"2c9081e57664d161017664f44801011f\", \"order\":37, \"latitude\":30.527929139384756, \"longitude\":114.16188802742691 }, {\"id\":\"2c9081e57664d161017664f448010120\", \"order\":38, \"latitude\":30.527929139384753, \"longitude\":114.15982263079435 }, {\"id\":\"2c9081e57664d161017664f448020121\", \"order\":39, \"latitude\":30.527199081632336, \"longitude\":114.16037762367758 }, {\"id\":\"2c9081e57664d161017664f448020122\", \"order\":40, \"latitude\":30.527199081632343, \"longitude\":114.16094503616335 } ] }, {\"id\":\"202012151351490145742782\", \"createTime\":\"2020-12-15\", \"speed\":5.0, \"flyTaskName\":\"测试_工业园_网格1_2期\", \"flyHeight\":150.0, \"lineOverlap\":0.7, \"headingOverlap\":0.7, \"rotatePitch\":90.0, \"coordinate\":\"[[[114.15737772229716,30.544825161055602],[114.17213194526879,30.535441722178245],[114.1680575573352,30.53105866849211],[114.15540226148087,30.542541034486774],[114.15737772229716,30.544825161055602]]]\", \"wayPointList\":[{\"id\":\"2c9081e57664d161017664f46d160123\", \"order\":1, \"latitude\":30.544095103303185, \"longitude\":114.15852564205261 }, {\"id\":\"2c9081e57664d161017664f46d160124\", \"order\":2, \"latitude\":30.54409510330318, \"longitude\":114.15674632099775 }, {\"id\":\"2c9081e57664d161017664f46d160125\", \"order\":3, \"latitude\":30.543365045550765, \"longitude\":114.15611491969838 }, {\"id\":\"2c9081e57664d161017664f46d160126\", \"order\":4, \"latitude\":30.543365045550768, \"longitude\":114.15967356180806 }, {\"id\":\"2c9081e57664d161017664f46d170127\", \"order\":5, \"latitude\":30.54263498779836, \"longitude\":114.16082148156349 }, {\"id\":\"2c9081e57664d161017664f46d170128\", \"order\":6, \"latitude\":30.542634987798355, \"longitude\":114.15548351839898 }, {\"id\":\"2c9081e57664d161017664f46d170129\", \"order\":7, \"latitude\":30.541904930045938, \"longitude\":114.15610334433235 }, {\"id\":\"2c9081e57664d161017664f46d17012a\", \"order\":8, \"latitude\":30.541904930045934, \"longitude\":114.16196940131893 }, {\"id\":\"2c9081e57664d161017664f46d17012b\", \"order\":9, \"latitude\":30.541174872293524, \"longitude\":114.16311732107438 }, {\"id\":\"2c9081e57664d161017664f46d17012c\", \"order\":10, \"latitude\":30.54117487229352, \"longitude\":114.15690797787666 }, {\"id\":\"2c9081e57664d161017664f46d17012d\", \"order\":11, \"latitude\":30.540444814541107, \"longitude\":114.15771261142099 }, {\"id\":\"2c9081e57664d161017664f46d17012e\", \"order\":12, \"latitude\":30.540444814541107, \"longitude\":114.16426524082985 }, {\"id\":\"2c9081e57664d161017664f46d17012f\", \"order\":13, \"latitude\":30.53971475678869, \"longitude\":114.16541316058525 }, {\"id\":\"2c9081e57664d161017664f46d170130\", \"order\":14, \"latitude\":30.539714756788687, \"longitude\":114.15851724496532 }, {\"id\":\"2c9081e57664d161017664f46d170131\", \"order\":15, \"latitude\":30.538984699036277, \"longitude\":114.15932187850966 }, {\"id\":\"2c9081e57664d161017664f46d170132\", \"order\":16, \"latitude\":30.538984699036273, \"longitude\":114.16656108034071 }, {\"id\":\"2c9081e57664d161017664f46d180133\", \"order\":17, \"latitude\":30.538254641283856, \"longitude\":114.16770900009614 }, {\"id\":\"2c9081e57664d161017664f46d180134\", \"order\":18, \"latitude\":30.53825464128386, \"longitude\":114.16012651205398 }, {\"id\":\"2c9081e57664d161017664f46d180135\", \"order\":19, \"latitude\":30.53752458353144, \"longitude\":114.16093114559831 }, {\"id\":\"2c9081e57664d161017664f46d180136\", \"order\":20, \"latitude\":30.53752458353144, \"longitude\":114.16885691985158 }, {\"id\":\"2c9081e57664d161017664f46d180137\", \"order\":21, \"latitude\":30.536794525779023, \"longitude\":114.17000483960703 }, {\"id\":\"2c9081e57664d161017664f46d180138\", \"order\":22, \"latitude\":30.536794525779026, \"longitude\":114.16173577914265 }, {\"id\":\"2c9081e57664d161017664f46d180139\", \"order\":23, \"latitude\":30.536064468026606, \"longitude\":114.16254041268698 }, {\"id\":\"2c9081e57664d161017664f46d18013a\", \"order\":24, \"latitude\":30.536064468026606, \"longitude\":114.1711527593625 }, {\"id\":\"2c9081e57664d161017664f46d18013b\", \"order\":25, \"latitude\":30.535334410274196, \"longitude\":114.17203219054107 }, {\"id\":\"2c9081e57664d161017664f46d18013c\", \"order\":26, \"latitude\":30.535334410274196, \"longitude\":114.16334504623131 }, {\"id\":\"2c9081e57664d161017664f46d18013d\", \"order\":27, \"latitude\":30.534604352521775, \"longitude\":114.16414967977562 }, {\"id\":\"2c9081e57664d161017664f46d19013e\", \"order\":28, \"latitude\":30.534604352521775, \"longitude\":114.17135354530643 }, {\"id\":\"2c9081e57664d161017664f46d19013f\", \"order\":29, \"latitude\":30.533874294769358, \"longitude\":114.17067490007179 }, {\"id\":\"2c9081e57664d161017664f46d190140\", \"order\":30, \"latitude\":30.533874294769358, \"longitude\":114.16495431331997 }, {\"id\":\"2c9081e57664d161017664f46d190141\", \"order\":31, \"latitude\":30.533144237016945, \"longitude\":114.16575894686429 }, {\"id\":\"2c9081e57664d161017664f46d190142\", \"order\":32, \"latitude\":30.53314423701694, \"longitude\":114.16999625483716 }, {\"id\":\"2c9081e57664d161017664f46d190143\", \"order\":33, \"latitude\":30.532414179264528, \"longitude\":114.16931760960252 }, {\"id\":\"2c9081e57664d161017664f46d190144\", \"order\":34, \"latitude\":30.532414179264528, \"longitude\":114.1665635804086 }, {\"id\":\"2c9081e57664d161017664f46d190145\", \"order\":35, \"latitude\":30.531684121512107, \"longitude\":114.16736821395295 }, {\"id\":\"2c9081e57664d161017664f46d190146\", \"order\":36, \"latitude\":30.53168412151211, \"longitude\":114.16863896436787 } ] }, {\"id\":\"202012151351491046584786\", \"createTime\":\"2020-12-15\", \"speed\":5.0, \"flyTaskName\":\"测试_工业园_网格2_2期\", \"flyHeight\":150.0, \"lineOverlap\":0.7, \"headingOverlap\":0.7, \"rotatePitch\":90.0, \"coordinate\":\"[[[114.15410586532018,30.541800236680665],[114.16441530145516,30.529885738632444],[114.16058784612362,30.526922547408013],[114.15138960669779,30.539022244907763],[114.15410586532018,30.541800236680665]]]\", \"wayPointList\":[{\"id\":\"2c9081e57664d161017664f46d700147\", \"order\":1, \"latitude\":30.541070178928244, \"longitude\":114.15473757332356 }, {\"id\":\"2c9081e57664d161017664f46d710148\", \"order\":2, \"latitude\":30.541070178928244, \"longitude\":114.15339203107338 }, {\"id\":\"2c9081e57664d161017664f46d710149\", \"order\":3, \"latitude\":30.540340121175824, \"longitude\":114.15267819682657 }, {\"id\":\"2c9081e57664d161017664f46d71014a\", \"order\":4, \"latitude\":30.54034012117583, \"longitude\":114.15536928132695 }, {\"id\":\"2c9081e57664d161017664f46d71014b\", \"order\":5, \"latitude\":30.539610063423417, \"longitude\":114.15600098933032 }, {\"id\":\"2c9081e57664d161017664f46d71014c\", \"order\":6, \"latitude\":30.539610063423417, \"longitude\":114.15196436257976 }, {\"id\":\"2c9081e57664d161017664f46d71014d\", \"order\":7, \"latitude\":30.538880005671, \"longitude\":114.15149773754614 }, {\"id\":\"2c9081e57664d161017664f46d71014e\", \"order\":8, \"latitude\":30.538880005671004, \"longitude\":114.15663269733375 }, {\"id\":\"2c9081e57664d161017664f46d71014f\", \"order\":9, \"latitude\":30.538149947918583, \"longitude\":114.1572644053371 }, {\"id\":\"2c9081e57664d161017664f46d710150\", \"order\":10, \"latitude\":30.538149947918583, \"longitude\":114.15205273042938 }, {\"id\":\"2c9081e57664d161017664f46d710151\", \"order\":11, \"latitude\":30.537419890166166, \"longitude\":114.15260772331257 }, {\"id\":\"2c9081e57664d161017664f46d710152\", \"order\":12, \"latitude\":30.53741989016617, \"longitude\":114.1578961133405 }, {\"id\":\"2c9081e57664d161017664f46d720153\", \"order\":13, \"latitude\":30.536689832413757, \"longitude\":114.1585278213439 }, {\"id\":\"2c9081e57664d161017664f46d720154\", \"order\":14, \"latitude\":30.53668983241375, \"longitude\":114.15316271619578 }, {\"id\":\"2c9081e57664d161017664f46d720155\", \"order\":15, \"latitude\":30.535959774661336, \"longitude\":114.153717709079 }, {\"id\":\"2c9081e57664d161017664f46d720156\", \"order\":16, \"latitude\":30.535959774661336, \"longitude\":114.15915952934726 }, {\"id\":\"2c9081e57664d161017664f46d720157\", \"order\":17, \"latitude\":30.535229716908923, \"longitude\":114.15979123735066 }, {\"id\":\"2c9081e57664d161017664f46d720158\", \"order\":18, \"latitude\":30.53522971690892, \"longitude\":114.15427270196221 }, {\"id\":\"2c9081e57664d161017664f46d720159\", \"order\":19, \"latitude\":30.5344996591565, \"longitude\":114.15482769484542 }, {\"id\":\"2c9081e57664d161017664f46d72015a\", \"order\":20, \"latitude\":30.534499659156502, \"longitude\":114.16042294535404 }, {\"id\":\"2c9081e57664d161017664f46d72015b\", \"order\":21, \"latitude\":30.53376960140409, \"longitude\":114.16105465335743 }, {\"id\":\"2c9081e57664d161017664f46d72015c\", \"order\":22, \"latitude\":30.53376960140408, \"longitude\":114.15538268772865 }, {\"id\":\"2c9081e57664d161017664f46d72015d\", \"order\":23, \"latitude\":30.533039543651668, \"longitude\":114.15593768061187 }, {\"id\":\"2c9081e57664d161017664f46d73015e\", \"order\":24, \"latitude\":30.533039543651668, \"longitude\":114.16168636136082 }, {\"id\":\"2c9081e57664d161017664f46d73015f\", \"order\":25, \"latitude\":30.53230948589926, \"longitude\":114.1623180693642 }, {\"id\":\"2c9081e57664d161017664f46d730160\", \"order\":26, \"latitude\":30.53230948589926, \"longitude\":114.15649267349508 }, {\"id\":\"2c9081e57664d161017664f46d730161\", \"order\":27, \"latitude\":30.531579428146838, \"longitude\":114.15704766637829 }, {\"id\":\"2c9081e57664d161017664f46d730162\", \"order\":28, \"latitude\":30.53157942814684, \"longitude\":114.16294977736759 }, {\"id\":\"2c9081e57664d161017664f46d730163\", \"order\":29, \"latitude\":30.53084937039442, \"longitude\":114.16358148537097 }, {\"id\":\"2c9081e57664d161017664f46d730164\", \"order\":30, \"latitude\":30.53084937039442, \"longitude\":114.15760265926149 }, {\"id\":\"2c9081e57664d161017664f46d730165\", \"order\":31, \"latitude\":30.530119312642004, \"longitude\":114.15815765214471 }, {\"id\":\"2c9081e57664d161017664f46d730166\", \"order\":32, \"latitude\":30.530119312642007, \"longitude\":114.16421319337437 }, {\"id\":\"2c9081e57664d161017664f46d730167\", \"order\":33, \"latitude\":30.529389254889594, \"longitude\":114.16377400995397 }, {\"id\":\"2c9081e57664d161017664f46d730168\", \"order\":34, \"latitude\":30.52938925488959, \"longitude\":114.15871264502795 }, {\"id\":\"2c9081e57664d161017664f46d730169\", \"order\":35, \"latitude\":30.528659197137177, \"longitude\":114.15926763791114 }, {\"id\":\"2c9081e57664d161017664f46d74016a\", \"order\":36, \"latitude\":30.528659197137177, \"longitude\":114.16283101869044 }, {\"id\":\"2c9081e57664d161017664f46d74016b\", \"order\":37, \"latitude\":30.527929139384756, \"longitude\":114.16188802742691 }, {\"id\":\"2c9081e57664d161017664f46d74016c\", \"order\":38, \"latitude\":30.527929139384753, \"longitude\":114.15982263079435 }, {\"id\":\"2c9081e57664d161017664f46d74016d\", \"order\":39, \"latitude\":30.527199081632336, \"longitude\":114.16037762367758 }, {\"id\":\"2c9081e57664d161017664f46d74016e\", \"order\":40, \"latitude\":30.527199081632343, \"longitude\":114.16094503616335 } ] }, {\"id\":\"202012151542082977754605\", \"createTime\":\"2020-12-15\", \"speed\":5.0, \"flyTaskName\":\"20201215liuli_街区_网格4中切片2_1期\", \"flyHeight\":150.0, \"lineOverlap\":0.7, \"headingOverlap\":0.7, \"rotatePitch\":90.0, \"coordinate\":\"[[[114.1714749698966,30.558567067507198],[114.17628148845128,30.558567067507198],[114.17636731913976,30.5559921468529],[114.17164663127355,30.555863400820186],[114.1714749698966,30.558567067507198]]]\", \"wayPointList\":[{\"id\":\"2c9081e57664d1610176655a087a01b3\", \"order\":1, \"latitude\":30.55783700975478, \"longitude\":114.17630582370968 }, {\"id\":\"2c9081e57664d1610176655a087a01b4\", \"order\":2, \"latitude\":30.55783700975478, \"longitude\":114.17152132276976 }, {\"id\":\"2c9081e57664d1610176655a087b01b5\", \"order\":3, \"latitude\":30.557106952002364, \"longitude\":114.17156767564292 }, {\"id\":\"2c9081e57664d1610176655a087b01b6\", \"order\":4, \"latitude\":30.557106952002364, \"longitude\":114.17633015896811 }, {\"id\":\"2c9081e57664d1610176655a087b01b7\", \"order\":5, \"latitude\":30.55637689424995, \"longitude\":114.17635449422652 }, {\"id\":\"2c9081e57664d1610176655a087b01b8\", \"order\":6, \"latitude\":30.556376894249947, \"longitude\":114.1716140285161 } ] }, {\"id\":\"202012151543127178453696\", \"createTime\":\"2020-12-15\", \"speed\":5.0, \"flyTaskName\":\"20201215liuli_街区_网格4中切片2_2期\", \"flyHeight\":150.0, \"lineOverlap\":0.7, \"headingOverlap\":0.7, \"rotatePitch\":90.0, \"coordinate\":\"[[[114.1714749698966,30.558567067507198],[114.17628148845128,30.558567067507198],[114.17636731913976,30.5559921468529],[114.17164663127355,30.555863400820186],[114.1714749698966,30.558567067507198]]]\", \"wayPointList\":[{\"id\":\"2c9081e57664d1610176655a694e01b9\", \"order\":1, \"latitude\":30.55783700975478, \"longitude\":114.17630582370968 }, {\"id\":\"2c9081e57664d1610176655a694e01ba\", \"order\":2, \"latitude\":30.55783700975478, \"longitude\":114.17152132276976 }, {\"id\":\"2c9081e57664d1610176655a694e01bb\", \"order\":3, \"latitude\":30.557106952002364, \"longitude\":114.17156767564292 }, {\"id\":\"2c9081e57664d1610176655a694e01bc\", \"order\":4, \"latitude\":30.557106952002364, \"longitude\":114.17633015896811 }, {\"id\":\"2c9081e57664d1610176655a694e01bd\", \"order\":5, \"latitude\":30.55637689424995, \"longitude\":114.17635449422652 }, {\"id\":\"2c9081e57664d1610176655a694e01be\", \"order\":6, \"latitude\":30.556376894249947, \"longitude\":114.1716140285161 } ] }, {\"id\":\"202012151654223451600221\", \"createTime\":\"2020-12-15\", \"speed\":5.0, \"flyTaskName\":\"20201215liuli2_liu街区_网格4中切片2_1期\", \"flyHeight\":150.0, \"lineOverlap\":0.7, \"headingOverlap\":0.7, \"rotatePitch\":90.0, \"coordinate\":\"[[[114.14888649309812,30.5546542051666],[114.15334860609772,30.554253977473884],[114.15217346946805,30.551128795277595],[114.14791572805622,30.551844095834785],[114.14888649309812,30.5546542051666]]]\", \"wayPointList\":[{\"id\":\"2c9081e57664d1610176659b8f8901ca\", \"order\":1, \"latitude\":30.55392414741418, \"longitude\":114.1532245828055 }, {\"id\":\"2c9081e57664d1610176659b8f8901cb\", \"order\":2, \"latitude\":30.553924147414182, \"longitude\":114.1486342913291 }, {\"id\":\"2c9081e57664d1610176659b8f8901cc\", \"order\":3, \"latitude\":30.55319408966177, \"longitude\":114.1483820895601 }, {\"id\":\"2c9081e57664d1610176659b8f8901cd\", \"order\":4, \"latitude\":30.553194089661766, \"longitude\":114.15295006517654 }, {\"id\":\"2c9081e57664d1610176659b8f8901ce\", \"order\":5, \"latitude\":30.55246403190936, \"longitude\":114.15267554754757 }, {\"id\":\"2c9081e57664d1610176659b8f8901cf\", \"order\":6, \"latitude\":30.552464031909352, \"longitude\":114.14812988779107 }, {\"id\":\"2c9081e57664d1610176659b8f8901d0\", \"order\":7, \"latitude\":30.551733974156935, \"longitude\":114.1485712142339 }, {\"id\":\"2c9081e57664d1610176659b8f8901d1\", \"order\":8, \"latitude\":30.551733974156935, \"longitude\":114.1524010299186 } ] }, {\"id\":\"202012151654536947167070\", \"createTime\":\"2020-12-15\", \"speed\":5.0, \"flyTaskName\":\"20201215liuli2_liu街区_网格4中切片2_2期\", \"flyHeight\":150.0, \"lineOverlap\":0.7, \"headingOverlap\":0.7, \"rotatePitch\":90.0, \"coordinate\":\"[[[114.14888649309812,30.5546542051666],[114.15334860609772,30.554253977473884],[114.15217346946805,30.551128795277595],[114.14791572805622,30.551844095834785],[114.14888649309812,30.5546542051666]]]\", \"wayPointList\":[{\"id\":\"2c9081e57664d1610176659c09fe01d2\", \"order\":1, \"latitude\":30.55392414741418, \"longitude\":114.1532245828055 }, {\"id\":\"2c9081e57664d1610176659c09fe01d3\", \"order\":2, \"latitude\":30.553924147414182, \"longitude\":114.1486342913291 }, {\"id\":\"2c9081e57664d1610176659c09fe01d4\", \"order\":3, \"latitude\":30.55319408966177, \"longitude\":114.1483820895601 }, {\"id\":\"2c9081e57664d1610176659c09fe01d5\", \"order\":4, \"latitude\":30.553194089661766, \"longitude\":114.15295006517654 }, {\"id\":\"2c9081e57664d1610176659c09fe01d6\", \"order\":5, \"latitude\":30.55246403190936, \"longitude\":114.15267554754757 }, {\"id\":\"2c9081e57664d1610176659c09fe01d7\", \"order\":6, \"latitude\":30.552464031909352, \"longitude\":114.14812988779107 }, {\"id\":\"2c9081e57664d1610176659c09fe01d8\", \"order\":7, \"latitude\":30.551733974156935, \"longitude\":114.1485712142339 }, {\"id\":\"2c9081e57664d1610176659c09fe01d9\", \"order\":8, \"latitude\":30.551733974156935, \"longitude\":114.1524010299186 } ] }, {\"id\":\"202012151841567861146722\", \"createTime\":\"2020-12-15\", \"speed\":5.0, \"flyTaskName\":\"20201215ly_ly_网格1_1期\", \"flyHeight\":150.0, \"lineOverlap\":0.7, \"headingOverlap\":0.7, \"rotatePitch\":90.0, \"coordinate\":\"[[[114.13627925064237,30.565309439607837],[114.13623633529814,30.558314238496997],[114.1442615046707,30.558657561250904],[114.14396109726103,30.565695677705982],[114.13627925064237,30.565309439607837]]]\", \"wayPointList\":[{\"id\":\"2c9081e57664d161017665fe0c320270\", \"order\":1, \"latitude\":30.56496561995357, \"longitude\":114.14399225826266 }, {\"id\":\"2c9081e57664d161017665fe0c330271\", \"order\":2, \"latitude\":30.56496561995357, \"longitude\":114.13627714131934 }, {\"id\":\"2c9081e57664d161017665fe0c330272\", \"order\":3, \"latitude\":30.564235562201148, \"longitude\":114.13627266243743 }, {\"id\":\"2c9081e57664d161017665fe0c330273\", \"order\":4, \"latitude\":30.564235562201144, \"longitude\":114.14402341926429 }, {\"id\":\"2c9081e57664d161017665fe0c330274\", \"order\":5, \"latitude\":30.563505504448738, \"longitude\":114.14405458026592 }, {\"id\":\"2c9081e57664d161017665fe0c330275\", \"order\":6, \"latitude\":30.56350550444873, \"longitude\":114.1362681835555 }, {\"id\":\"2c9081e57664d161017665fe0c330276\", \"order\":7, \"latitude\":30.562775446696318, \"longitude\":114.1362637046736 }, {\"id\":\"2c9081e57664d161017665fe0c330277\", \"order\":8, \"latitude\":30.562775446696318, \"longitude\":114.14408574126755 }, {\"id\":\"2c9081e57664d161017665fe0c330278\", \"order\":9, \"latitude\":30.5620453889439, \"longitude\":114.14411690226918 }, {\"id\":\"2c9081e57664d161017665fe0c330279\", \"order\":10, \"latitude\":30.5620453889439, \"longitude\":114.13625922579166 }, {\"id\":\"2c9081e57664d161017665fe0c33027a\", \"order\":11, \"latitude\":30.561315331191484, \"longitude\":114.13625474690976 }, {\"id\":\"2c9081e57664d161017665fe0c33027b\", \"order\":12, \"latitude\":30.561315331191487, \"longitude\":114.14414806327078 }, {\"id\":\"2c9081e57664d161017665fe0c33027c\", \"order\":13, \"latitude\":30.560585273439067, \"longitude\":114.14417922427242 }, {\"id\":\"2c9081e57664d161017665fe0c33027d\", \"order\":14, \"latitude\":30.560585273439067, \"longitude\":114.13625026802785 }, {\"id\":\"2c9081e57664d161017665fe0c33027e\", \"order\":15, \"latitude\":30.559855215686653, \"longitude\":114.13624578914593 }, {\"id\":\"2c9081e57664d161017665fe0c33027f\", \"order\":16, \"latitude\":30.559855215686653, \"longitude\":114.14421038527404 }, {\"id\":\"2c9081e57664d161017665fe0c330280\", \"order\":17, \"latitude\":30.559125157934236, \"longitude\":114.14424154627568 }, {\"id\":\"2c9081e57664d161017665fe0c330281\", \"order\":18, \"latitude\":30.55912515793424, \"longitude\":114.13624131026401 }, {\"id\":\"2c9081e57664d161017665fe0c330282\", \"order\":19, \"latitude\":30.55839510018182, \"longitude\":114.13623683138209 }, {\"id\":\"2c9081e57664d161017665fe0c330283\", \"order\":20, \"latitude\":30.558395100181816, \"longitude\":114.13812647718085 } ] }, {\"id\":\"202012151842020285418210\", \"createTime\":\"2020-12-15\", \"speed\":5.0, \"flyTaskName\":\"20201215ly_ly_网格2_1期\", \"flyHeight\":150.0, \"lineOverlap\":0.7, \"headingOverlap\":0.7, \"rotatePitch\":90.0, \"coordinate\":\"[[[114.14726557876737,30.56573859305022],[114.14769473220976,30.55827132315276],[114.15803733017118,30.559215460726],[114.15687861587675,30.56676856131194],[114.14726557876737,30.56573859305022]]]\", \"wayPointList\":[{\"id\":\"2c9081e57664d161017665fe20ac0285\", \"order\":1, \"latitude\":30.566038503559522, \"longitude\":114.15699061337287 }, {\"id\":\"2c9081e57664d161017665fe20ac0286\", \"order\":2, \"latitude\":30.566038503559525, \"longitude\":114.15006474352086 }, {\"id\":\"2c9081e57664d161017665fe20ac0287\", \"order\":3, \"latitude\":30.56530844580711, \"longitude\":114.1472902998733 }, {\"id\":\"2c9081e57664d161017665fe20ac0288\", \"order\":4, \"latitude\":30.56530844580711, \"longitude\":114.15710261086898 }, {\"id\":\"2c9081e57664d161017665fe20ac0289\", \"order\":5, \"latitude\":30.564578388054695, \"longitude\":114.15721460836508 }, {\"id\":\"2c9081e57664d161017665fe20ac028a\", \"order\":6, \"latitude\":30.564578388054688, \"longitude\":114.1473322572154 }, {\"id\":\"2c9081e57664d161017665fe20ac028b\", \"order\":7, \"latitude\":30.563848330302278, \"longitude\":114.1473742145575 }, {\"id\":\"2c9081e57664d161017665fe20ac028c\", \"order\":8, \"latitude\":30.563848330302275, \"longitude\":114.15732660586119 }, {\"id\":\"2c9081e57664d161017665fe20ac028d\", \"order\":9, \"latitude\":30.563118272549858, \"longitude\":114.1574386033573 }, {\"id\":\"2c9081e57664d161017665fe20ac028e\", \"order\":10, \"latitude\":30.563118272549854, \"longitude\":114.14741617189958 }, {\"id\":\"2c9081e57664d161017665fe20ac028f\", \"order\":11, \"latitude\":30.56238821479744, \"longitude\":114.14745812924166 }, {\"id\":\"2c9081e57664d161017665fe20ac0290\", \"order\":12, \"latitude\":30.562388214797437, \"longitude\":114.15755060085341 }, {\"id\":\"2c9081e57664d161017665fe20ac0291\", \"order\":13, \"latitude\":30.561658157045024, \"longitude\":114.15766259834952 }, {\"id\":\"2c9081e57664d161017665fe20ac0292\", \"order\":14, \"latitude\":30.561658157045024, \"longitude\":114.14750008658376 }, {\"id\":\"2c9081e57664d161017665fe20ac0293\", \"order\":15, \"latitude\":30.56092809929261, \"longitude\":114.14754204392585 }, {\"id\":\"2c9081e57664d161017665fe20ac0294\", \"order\":16, \"latitude\":30.56092809929261, \"longitude\":114.15777459584561 }, {\"id\":\"2c9081e57664d161017665fe20ac0295\", \"order\":17, \"latitude\":30.560198041540193, \"longitude\":114.15788659334173 }, {\"id\":\"2c9081e57664d161017665fe20ad0296\", \"order\":18, \"latitude\":30.560198041540197, \"longitude\":114.14758400126796 }, {\"id\":\"2c9081e57664d161017665fe20ad0297\", \"order\":19, \"latitude\":30.559467983787776, \"longitude\":114.14762595861004 }, {\"id\":\"2c9081e57664d161017665fe20ad0298\", \"order\":20, \"latitude\":30.55946798378778, \"longitude\":114.15799859083786 }, {\"id\":\"2c9081e57664d161017665fe20ad0299\", \"order\":21, \"latitude\":30.55873792603536, \"longitude\":114.15280615469644 }, {\"id\":\"2c9081e57664d161017665fe20ad029a\", \"order\":22, \"latitude\":30.558737926035363, \"longitude\":114.14766791595213 } ] }, {\"id\":\"202012151842075453083803\", \"createTime\":\"2020-12-15\", \"speed\":5.0, \"flyTaskName\":\"20201215ly_ly_网格3_1期\", \"flyHeight\":150.0, \"lineOverlap\":0.7, \"headingOverlap\":0.7, \"rotatePitch\":90.0, \"coordinate\":\"[[[114.136751319429,30.556554709383228],[114.136751319429,30.549344931551197],[114.14477648880155,30.54973116964934],[114.14473357345732,30.556855116792896],[114.136751319429,30.556554709383228]]]\", \"wayPointList\":[{\"id\":\"2c9081e57664d161017665fe3639029c\", \"order\":1, \"latitude\":30.556125059040482, \"longitude\":114.14473797139559 }, {\"id\":\"2c9081e57664d161017665fe3639029d\", \"order\":2, \"latitude\":30.556125059040482, \"longitude\":114.136751319429 }, {\"id\":\"2c9081e57664d161017665fe3639029e\", \"order\":3, \"latitude\":30.555395001288062, \"longitude\":114.13675131942898 }, {\"id\":\"2c9081e57664d161017665fe3639029f\", \"order\":4, \"latitude\":30.555395001288066, \"longitude\":114.14474236933385 }, {\"id\":\"2c9081e57664d161017665fe363902a0\", \"order\":5, \"latitude\":30.55466494353565, \"longitude\":114.14474676727212 }, {\"id\":\"2c9081e57664d161017665fe363902a1\", \"order\":6, \"latitude\":30.554664943535645, \"longitude\":114.136751319429 }, {\"id\":\"2c9081e57664d161017665fe363902a2\", \"order\":7, \"latitude\":30.55393488578323, \"longitude\":114.136751319429 }, {\"id\":\"2c9081e57664d161017665fe363902a3\", \"order\":8, \"latitude\":30.55393488578323, \"longitude\":114.14475116521038 }, {\"id\":\"2c9081e57664d161017665fe363902a4\", \"order\":9, \"latitude\":30.553204828030818, \"longitude\":114.14475556314865 }, {\"id\":\"2c9081e57664d161017665fe363902a5\", \"order\":10, \"latitude\":30.553204828030815, \"longitude\":114.136751319429 }, {\"id\":\"2c9081e57664d161017665fe363902a6\", \"order\":11, \"latitude\":30.552474770278398, \"longitude\":114.13675131942901 }, {\"id\":\"2c9081e57664d161017665fe363902a7\", \"order\":12, \"latitude\":30.5524747702784, \"longitude\":114.14475996108693 }, {\"id\":\"2c9081e57664d161017665fe363902a8\", \"order\":13, \"latitude\":30.55174471252598, \"longitude\":114.14476435902519 }, {\"id\":\"2c9081e57664d161017665fe363902a9\", \"order\":14, \"latitude\":30.55174471252598, \"longitude\":114.136751319429 }, {\"id\":\"2c9081e57664d161017665fe363902aa\", \"order\":15, \"latitude\":30.551014654773567, \"longitude\":114.136751319429 }, {\"id\":\"2c9081e57664d161017665fe363902ab\", \"order\":16, \"latitude\":30.551014654773564, \"longitude\":114.14476875696346 }, {\"id\":\"2c9081e57664d161017665fe363902ac\", \"order\":17, \"latitude\":30.550284597021154, \"longitude\":114.14477315490174 }, {\"id\":\"2c9081e57664d161017665fe363902ad\", \"order\":18, \"latitude\":30.55028459702115, \"longitude\":114.13675131942901 }, {\"id\":\"2c9081e57664d161017665fe363902ae\", \"order\":19, \"latitude\":30.549554539268733, \"longitude\":114.136751319429 }, {\"id\":\"2c9081e57664d161017665fe363902af\", \"order\":20, \"latitude\":30.549554539268733, \"longitude\":114.14110650200446 } ] }, {\"id\":\"202012151842128451264418\", \"createTime\":\"2020-12-15\", \"speed\":5.0, \"flyTaskName\":\"20201215ly_ly_网格4_1期\", \"flyHeight\":150.0, \"lineOverlap\":0.7, \"headingOverlap\":0.7, \"rotatePitch\":90.0, \"coordinate\":\"[[[114.14820971634062,30.55728427023528],[114.1480809703079,30.550117407747486],[114.15769400741728,30.55054656118987],[114.1576081767288,30.557584677644947],[114.14820971634062,30.55728427023528]]]\", \"wayPointList\":[{\"id\":\"2c9081e57664d161017665fe4aed02b1\", \"order\":1, \"latitude\":30.55685461989253, \"longitude\":114.15761707987213 }, {\"id\":\"2c9081e57664d161017665fe4aed02b2\", \"order\":2, \"latitude\":30.556854619892526, \"longitude\":114.14820199807097 }, {\"id\":\"2c9081e57664d161017665fe4aed02b3\", \"order\":3, \"latitude\":30.556124562140113, \"longitude\":114.14818888326106 }, {\"id\":\"2c9081e57664d161017665fe4aed02b4\", \"order\":4, \"latitude\":30.556124562140116, \"longitude\":114.15762598301545 }, {\"id\":\"2c9081e57664d161017665fe4aed02b5\", \"order\":5, \"latitude\":30.555394504387703, \"longitude\":114.15763488615877 }, {\"id\":\"2c9081e57664d161017665fe4aed02b6\", \"order\":6, \"latitude\":30.555394504387703, \"longitude\":114.14817576845113 }, {\"id\":\"2c9081e57664d161017665fe4aed02b7\", \"order\":7, \"latitude\":30.55466444663528, \"longitude\":114.14816265364121 }, {\"id\":\"2c9081e57664d161017665fe4aed02b8\", \"order\":8, \"latitude\":30.554664446635282, \"longitude\":114.15764378930209 }, {\"id\":\"2c9081e57664d161017665fe4aed02b9\", \"order\":9, \"latitude\":30.55393438888287, \"longitude\":114.15765269244541 }, {\"id\":\"2c9081e57664d161017665fe4aee02ba\", \"order\":10, \"latitude\":30.55393438888287, \"longitude\":114.14814953883129 }, {\"id\":\"2c9081e57664d161017665fe4aee02bb\", \"order\":11, \"latitude\":30.553204331130452, \"longitude\":114.14813642402137 }, {\"id\":\"2c9081e57664d161017665fe4aee02bc\", \"order\":12, \"latitude\":30.55320433113045, \"longitude\":114.15766159558873 }, {\"id\":\"2c9081e57664d161017665fe4aee02bd\", \"order\":13, \"latitude\":30.55247427337803, \"longitude\":114.15767049873206 }, {\"id\":\"2c9081e57664d161017665fe4aee02be\", \"order\":14, \"latitude\":30.552474273378035, \"longitude\":114.14812330921144 }, {\"id\":\"2c9081e57664d161017665fe4aee02bf\", \"order\":15, \"latitude\":30.551744215625614, \"longitude\":114.14811019440153 }, {\"id\":\"2c9081e57664d161017665fe4aee02c0\", \"order\":16, \"latitude\":30.551744215625618, \"longitude\":114.15767940187538 }, {\"id\":\"2c9081e57664d161017665fe4aee02c1\", \"order\":17, \"latitude\":30.551014157873198, \"longitude\":114.1576883050187 }, {\"id\":\"2c9081e57664d161017665fe4aee02c2\", \"order\":18, \"latitude\":30.551014157873198, \"longitude\":114.14809707959161 }, {\"id\":\"2c9081e57664d161017665fe4aee02c3\", \"order\":19, \"latitude\":30.550284100120788, \"longitude\":114.14808396478169 }, {\"id\":\"2c9081e57664d161017665fe4aee02c4\", \"order\":20, \"latitude\":30.550284100120784, \"longitude\":114.15181487946978 } ] }, {\"id\":\"202012151842419271067738\", \"createTime\":\"2020-12-15\", \"speed\":5.0, \"flyTaskName\":\"20201215ly_ly_网格1_2期\", \"flyHeight\":150.0, \"lineOverlap\":0.7, \"headingOverlap\":0.7, \"rotatePitch\":90.0, \"coordinate\":\"[[[114.13627925064237,30.565309439607837],[114.13623633529814,30.558314238496997],[114.1442615046707,30.558657561250904],[114.14396109726103,30.565695677705982],[114.13627925064237,30.565309439607837]]]\", \"wayPointList\":[{\"id\":\"2c9081e57664d161017665febc8702c5\", \"order\":1, \"latitude\":30.56496561995357, \"longitude\":114.14399225826266 }, {\"id\":\"2c9081e57664d161017665febc8702c6\", \"order\":2, \"latitude\":30.56496561995357, \"longitude\":114.13627714131934 }, {\"id\":\"2c9081e57664d161017665febc8702c7\", \"order\":3, \"latitude\":30.564235562201148, \"longitude\":114.13627266243743 }, {\"id\":\"2c9081e57664d161017665febc8702c8\", \"order\":4, \"latitude\":30.564235562201144, \"longitude\":114.14402341926429 }, {\"id\":\"2c9081e57664d161017665febc8702c9\", \"order\":5, \"latitude\":30.563505504448738, \"longitude\":114.14405458026592 }, {\"id\":\"2c9081e57664d161017665febc8702ca\", \"order\":6, \"latitude\":30.56350550444873, \"longitude\":114.1362681835555 }, {\"id\":\"2c9081e57664d161017665febc8702cb\", \"order\":7, \"latitude\":30.562775446696318, \"longitude\":114.1362637046736 }, {\"id\":\"2c9081e57664d161017665febc8702cc\", \"order\":8, \"latitude\":30.562775446696318, \"longitude\":114.14408574126755 }, {\"id\":\"2c9081e57664d161017665febc8702cd\", \"order\":9, \"latitude\":30.5620453889439, \"longitude\":114.14411690226918 }, {\"id\":\"2c9081e57664d161017665febc8702ce\", \"order\":10, \"latitude\":30.5620453889439, \"longitude\":114.13625922579166 }, {\"id\":\"2c9081e57664d161017665febc8702cf\", \"order\":11, \"latitude\":30.561315331191484, \"longitude\":114.13625474690976 }, {\"id\":\"2c9081e57664d161017665febc8702d0\", \"order\":12, \"latitude\":30.561315331191487, \"longitude\":114.14414806327078 }, {\"id\":\"2c9081e57664d161017665febc8702d1\", \"order\":13, \"latitude\":30.560585273439067, \"longitude\":114.14417922427242 }, {\"id\":\"2c9081e57664d161017665febc8702d2\", \"order\":14, \"latitude\":30.560585273439067, \"longitude\":114.13625026802785 }, {\"id\":\"2c9081e57664d161017665febc8702d3\", \"order\":15, \"latitude\":30.559855215686653, \"longitude\":114.13624578914593 }, {\"id\":\"2c9081e57664d161017665febc8702d4\", \"order\":16, \"latitude\":30.559855215686653, \"longitude\":114.14421038527404 }, {\"id\":\"2c9081e57664d161017665febc8702d5\", \"order\":17, \"latitude\":30.559125157934236, \"longitude\":114.14424154627568 }, {\"id\":\"2c9081e57664d161017665febc8702d6\", \"order\":18, \"latitude\":30.55912515793424, \"longitude\":114.13624131026401 }, {\"id\":\"2c9081e57664d161017665febc8702d7\", \"order\":19, \"latitude\":30.55839510018182, \"longitude\":114.13623683138209 }, {\"id\":\"2c9081e57664d161017665febc8702d8\", \"order\":20, \"latitude\":30.558395100181816, \"longitude\":114.13812647718085 } ] }, {\"id\":\"202012151842419968607333\", \"createTime\":\"2020-12-15\", \"speed\":5.0, \"flyTaskName\":\"20201215ly_ly_网格2_2期\", \"flyHeight\":150.0, \"lineOverlap\":0.7, \"headingOverlap\":0.7, \"rotatePitch\":90.0, \"coordinate\":\"[[[114.14726557876737,30.56573859305022],[114.14769473220976,30.55827132315276],[114.15803733017118,30.559215460726],[114.15687861587675,30.56676856131194],[114.14726557876737,30.56573859305022]]]\", \"wayPointList\":[{\"id\":\"2c9081e57664d161017665febccc02d9\", \"order\":1, \"latitude\":30.566038503559522, \"longitude\":114.15699061337287 }, {\"id\":\"2c9081e57664d161017665febccc02da\", \"order\":2, \"latitude\":30.566038503559525, \"longitude\":114.15006474352086 }, {\"id\":\"2c9081e57664d161017665febccc02db\", \"order\":3, \"latitude\":30.56530844580711, \"longitude\":114.1472902998733 }, {\"id\":\"2c9081e57664d161017665febccc02dc\", \"order\":4, \"latitude\":30.56530844580711, \"longitude\":114.15710261086898 }, {\"id\":\"2c9081e57664d161017665febccc02dd\", \"order\":5, \"latitude\":30.564578388054695, \"longitude\":114.15721460836508 }, {\"id\":\"2c9081e57664d161017665febccc02de\", \"order\":6, \"latitude\":30.564578388054688, \"longitude\":114.1473322572154 }, {\"id\":\"2c9081e57664d161017665febccc02df\", \"order\":7, \"latitude\":30.563848330302278, \"longitude\":114.1473742145575 }, {\"id\":\"2c9081e57664d161017665febccc02e0\", \"order\":8, \"latitude\":30.563848330302275, \"longitude\":114.15732660586119 }, {\"id\":\"2c9081e57664d161017665febccc02e1\", \"order\":9, \"latitude\":30.563118272549858, \"longitude\":114.1574386033573 }, {\"id\":\"2c9081e57664d161017665febccc02e2\", \"order\":10, \"latitude\":30.563118272549854, \"longitude\":114.14741617189958 }, {\"id\":\"2c9081e57664d161017665febccc02e3\", \"order\":11, \"latitude\":30.56238821479744, \"longitude\":114.14745812924166 }, {\"id\":\"2c9081e57664d161017665febccc02e4\", \"order\":12, \"latitude\":30.562388214797437, \"longitude\":114.15755060085341 }, {\"id\":\"2c9081e57664d161017665febccc02e5\", \"order\":13, \"latitude\":30.561658157045024, \"longitude\":114.15766259834952 }, {\"id\":\"2c9081e57664d161017665febccc02e6\", \"order\":14, \"latitude\":30.561658157045024, \"longitude\":114.14750008658376 }, {\"id\":\"2c9081e57664d161017665febccc02e7\", \"order\":15, \"latitude\":30.56092809929261, \"longitude\":114.14754204392585 }, {\"id\":\"2c9081e57664d161017665febccc02e8\", \"order\":16, \"latitude\":30.56092809929261, \"longitude\":114.15777459584561 }, {\"id\":\"2c9081e57664d161017665febccc02e9\", \"order\":17, \"latitude\":30.560198041540193, \"longitude\":114.15788659334173 }, {\"id\":\"2c9081e57664d161017665febccd02ea\", \"order\":18, \"latitude\":30.560198041540197, \"longitude\":114.14758400126796 }, {\"id\":\"2c9081e57664d161017665febccd02eb\", \"order\":19, \"latitude\":30.559467983787776, \"longitude\":114.14762595861004 }, {\"id\":\"2c9081e57664d161017665febccd02ec\", \"order\":20, \"latitude\":30.55946798378778, \"longitude\":114.15799859083786 }, {\"id\":\"2c9081e57664d161017665febccd02ed\", \"order\":21, \"latitude\":30.55873792603536, \"longitude\":114.15280615469644 }, {\"id\":\"2c9081e57664d161017665febccd02ee\", \"order\":22, \"latitude\":30.558737926035363, \"longitude\":114.14766791595213 } ] }, {\"id\":\"202012151842420638207692\", \"createTime\":\"2020-12-15\", \"speed\":5.0, \"flyTaskName\":\"20201215ly_ly_网格3_2期\", \"flyHeight\":150.0, \"lineOverlap\":0.7, \"headingOverlap\":0.7, \"rotatePitch\":90.0, \"coordinate\":\"[[[114.136751319429,30.556554709383228],[114.136751319429,30.549344931551197],[114.14477648880155,30.54973116964934],[114.14473357345732,30.556855116792896],[114.136751319429,30.556554709383228]]]\", \"wayPointList\":[{\"id\":\"2c9081e57664d161017665febd0f02ef\", \"order\":1, \"latitude\":30.556125059040482, \"longitude\":114.14473797139559 }, {\"id\":\"2c9081e57664d161017665febd0f02f0\", \"order\":2, \"latitude\":30.556125059040482, \"longitude\":114.136751319429 }, {\"id\":\"2c9081e57664d161017665febd0f02f1\", \"order\":3, \"latitude\":30.555395001288062, \"longitude\":114.13675131942898 }, {\"id\":\"2c9081e57664d161017665febd0f02f2\", \"order\":4, \"latitude\":30.555395001288066, \"longitude\":114.14474236933385 }, {\"id\":\"2c9081e57664d161017665febd0f02f3\", \"order\":5, \"latitude\":30.55466494353565, \"longitude\":114.14474676727212 }, {\"id\":\"2c9081e57664d161017665febd0f02f4\", \"order\":6, \"latitude\":30.554664943535645, \"longitude\":114.136751319429 }, {\"id\":\"2c9081e57664d161017665febd0f02f5\", \"order\":7, \"latitude\":30.55393488578323, \"longitude\":114.136751319429 }, {\"id\":\"2c9081e57664d161017665febd0f02f6\", \"order\":8, \"latitude\":30.55393488578323, \"longitude\":114.14475116521038 }, {\"id\":\"2c9081e57664d161017665febd0f02f7\", \"order\":9, \"latitude\":30.553204828030818, \"longitude\":114.14475556314865 }, {\"id\":\"2c9081e57664d161017665febd0f02f8\", \"order\":10, \"latitude\":30.553204828030815, \"longitude\":114.136751319429 }, {\"id\":\"2c9081e57664d161017665febd0f02f9\", \"order\":11, \"latitude\":30.552474770278398, \"longitude\":114.13675131942901 }, {\"id\":\"2c9081e57664d161017665febd0f02fa\", \"order\":12, \"latitude\":30.5524747702784, \"longitude\":114.14475996108693 }, {\"id\":\"2c9081e57664d161017665febd0f02fb\", \"order\":13, \"latitude\":30.55174471252598, \"longitude\":114.14476435902519 }, {\"id\":\"2c9081e57664d161017665febd0f02fc\", \"order\":14, \"latitude\":30.55174471252598, \"longitude\":114.136751319429 }, {\"id\":\"2c9081e57664d161017665febd0f02fd\", \"order\":15, \"latitude\":30.551014654773567, \"longitude\":114.136751319429 }, {\"id\":\"2c9081e57664d161017665febd0f02fe\", \"order\":16, \"latitude\":30.551014654773564, \"longitude\":114.14476875696346 }, {\"id\":\"2c9081e57664d161017665febd0f02ff\", \"order\":17, \"latitude\":30.550284597021154, \"longitude\":114.14477315490174 }, {\"id\":\"2c9081e57664d161017665febd0f0300\", \"order\":18, \"latitude\":30.55028459702115, \"longitude\":114.13675131942901 }, {\"id\":\"2c9081e57664d161017665febd100301\", \"order\":19, \"latitude\":30.549554539268733, \"longitude\":114.136751319429 }, {\"id\":\"2c9081e57664d161017665febd100302\", \"order\":20, \"latitude\":30.549554539268733, \"longitude\":114.14110650200446 } ] }, {\"id\":\"202012151842421293329405\", \"createTime\":\"2020-12-15\", \"speed\":5.0, \"flyTaskName\":\"20201215ly_ly_网格4_2期\", \"flyHeight\":150.0, \"lineOverlap\":0.7, \"headingOverlap\":0.7, \"rotatePitch\":90.0, \"coordinate\":\"[[[114.14820971634062,30.55728427023528],[114.1480809703079,30.550117407747486],[114.15769400741728,30.55054656118987],[114.1576081767288,30.557584677644947],[114.14820971634062,30.55728427023528]]]\", \"wayPointList\":[{\"id\":\"2c9081e57664d161017665febd520303\", \"order\":1, \"latitude\":30.55685461989253, \"longitude\":114.15761707987213 }, {\"id\":\"2c9081e57664d161017665febd520304\", \"order\":2, \"latitude\":30.556854619892526, \"longitude\":114.14820199807097 }, {\"id\":\"2c9081e57664d161017665febd520305\", \"order\":3, \"latitude\":30.556124562140113, \"longitude\":114.14818888326106 }, {\"id\":\"2c9081e57664d161017665febd520306\", \"order\":4, \"latitude\":30.556124562140116, \"longitude\":114.15762598301545 }, {\"id\":\"2c9081e57664d161017665febd520307\", \"order\":5, \"latitude\":30.555394504387703, \"longitude\":114.15763488615877 }, {\"id\":\"2c9081e57664d161017665febd520308\", \"order\":6, \"latitude\":30.555394504387703, \"longitude\":114.14817576845113 }, {\"id\":\"2c9081e57664d161017665febd520309\", \"order\":7, \"latitude\":30.55466444663528, \"longitude\":114.14816265364121 }, {\"id\":\"2c9081e57664d161017665febd52030a\", \"order\":8, \"latitude\":30.554664446635282, \"longitude\":114.15764378930209 }, {\"id\":\"2c9081e57664d161017665febd52030b\", \"order\":9, \"latitude\":30.55393438888287, \"longitude\":114.15765269244541 }, {\"id\":\"2c9081e57664d161017665febd52030c\", \"order\":10, \"latitude\":30.55393438888287, \"longitude\":114.14814953883129 }, {\"id\":\"2c9081e57664d161017665febd52030d\", \"order\":11, \"latitude\":30.553204331130452, \"longitude\":114.14813642402137 }, {\"id\":\"2c9081e57664d161017665febd52030e\", \"order\":12, \"latitude\":30.55320433113045, \"longitude\":114.15766159558873 }, {\"id\":\"2c9081e57664d161017665febd52030f\", \"order\":13, \"latitude\":30.55247427337803, \"longitude\":114.15767049873206 }, {\"id\":\"2c9081e57664d161017665febd520310\", \"order\":14, \"latitude\":30.552474273378035, \"longitude\":114.14812330921144 }, {\"id\":\"2c9081e57664d161017665febd520311\", \"order\":15, \"latitude\":30.551744215625614, \"longitude\":114.14811019440153 }, {\"id\":\"2c9081e57664d161017665febd520312\", \"order\":16, \"latitude\":30.551744215625618, \"longitude\":114.15767940187538 }, {\"id\":\"2c9081e57664d161017665febd520313\", \"order\":17, \"latitude\":30.551014157873198, \"longitude\":114.1576883050187 }, {\"id\":\"2c9081e57664d161017665febd520314\", \"order\":18, \"latitude\":30.551014157873198, \"longitude\":114.14809707959161 }, {\"id\":\"2c9081e57664d161017665febd520315\", \"order\":19, \"latitude\":30.550284100120788, \"longitude\":114.14808396478169 }, {\"id\":\"2c9081e57664d161017665febd520316\", \"order\":20, \"latitude\":30.550284100120784, \"longitude\":114.15181487946978 } ] }, {\"id\":\"202101041346482437192559\", \"createTime\":\"2021-01-04\", \"speed\":5.0, \"flyTaskName\":\"20201216liu4_街区_网格1_3期\", \"flyHeight\":150.0, \"lineOverlap\":0.7, \"headingOverlap\":0.7, \"rotatePitch\":90.0, \"coordinate\":\"[[[114.16189866656855,30.563675388025487],[114.17022404811318,30.563375193979407],[114.16920338835651,30.554889708943538],[114.16009750229207,30.5562505886191],[114.16189866656855,30.563675388025487]]]\", \"wayPointList\":[{\"id\":\"2c9081e576984f580176cbef063501f3\", \"order\":1, \"latitude\":30.562945330273067, \"longitude\":114.17017234280887 }, {\"id\":\"2c9081e576984f580176cbef063501f4\", \"order\":2, \"latitude\":30.56294533027307, \"longitude\":114.16172156360973 }, {\"id\":\"2c9081e576984f580176cbef063501f5\", \"order\":3, \"latitude\":30.562215272520653, \"longitude\":114.16154446065093 }, {\"id\":\"2c9081e576984f580176cbef063501f6\", \"order\":4, \"latitude\":30.56221527252065, \"longitude\":114.17008452925847 }, {\"id\":\"2c9081e576984f580176cbef063501f7\", \"order\":5, \"latitude\":30.56148521476824, \"longitude\":114.16999671570807 }, {\"id\":\"2c9081e576984f580176cbef063501f8\", \"order\":6, \"latitude\":30.56148521476824, \"longitude\":114.16136735769211 }, {\"id\":\"2c9081e576984f580176cbef063501f9\", \"order\":7, \"latitude\":30.560755157015826, \"longitude\":114.16119025473331 }, {\"id\":\"2c9081e576984f580176cbef063501fa\", \"order\":8, \"latitude\":30.560755157015823, \"longitude\":114.16990890215766 }, {\"id\":\"2c9081e576984f580176cbef063501fb\", \"order\":9, \"latitude\":30.56002509926341, \"longitude\":114.16982108860725 }, {\"id\":\"2c9081e576984f580176cbef063501fc\", \"order\":10, \"latitude\":30.560025099263402, \"longitude\":114.16101315177453 }, {\"id\":\"2c9081e576984f580176cbef063601fd\", \"order\":11, \"latitude\":30.55929504151099, \"longitude\":114.16083604881572 }, {\"id\":\"2c9081e576984f580176cbef063601fe\", \"order\":12, \"latitude\":30.559295041510985, \"longitude\":114.16973327505683 }, {\"id\":\"2c9081e576984f580176cbef063601ff\", \"order\":13, \"latitude\":30.558564983758572, \"longitude\":114.16964546150645 }, {\"id\":\"2c9081e576984f580176cbef06360200\", \"order\":14, \"latitude\":30.558564983758572, \"longitude\":114.1606589458569 }, {\"id\":\"2c9081e576984f580176cbef06360201\", \"order\":15, \"latitude\":30.55783492600616, \"longitude\":114.16048184289808 }, {\"id\":\"2c9081e576984f580176cbef06360202\", \"order\":16, \"latitude\":30.557834926006162, \"longitude\":114.16955764795603 }, {\"id\":\"2c9081e576984f580176cbef06360203\", \"order\":17, \"latitude\":30.55710486825374, \"longitude\":114.16946983440562 }, {\"id\":\"2c9081e576984f580176cbef06360204\", \"order\":18, \"latitude\":30.557104868253738, \"longitude\":114.16030473993928 }, {\"id\":\"2c9081e576984f580176cbef06360205\", \"order\":19, \"latitude\":30.55637481050132, \"longitude\":114.16012763698049 }, {\"id\":\"2c9081e576984f580176cbef06360206\", \"order\":20, \"latitude\":30.556374810501325, \"longitude\":114.16938202085521 }, {\"id\":\"2c9081e576984f580176cbef06360207\", \"order\":21, \"latitude\":30.555644752748908, \"longitude\":114.1692942073048 }, {\"id\":\"2c9081e576984f580176cbef06360208\", \"order\":22, \"latitude\":30.555644752748908, \"longitude\":114.16415125701175 }, {\"id\":\"2c9081e576984f580176cbef06360209\", \"order\":23, \"latitude\":30.55491469499649, \"longitude\":114.16903620226691 }, {\"id\":\"2c9081e576984f580176cbef063c020a\", \"order\":24, \"latitude\":30.554914694996494, \"longitude\":114.16920639375438 } ] }, {\"id\":\"202101041347074594041844\", \"createTime\":\"2021-01-04\", \"speed\":5.0, \"flyTaskName\":\"wulidun_1_网格1_3期\", \"flyHeight\":150.0, \"lineOverlap\":0.7, \"headingOverlap\":0.7, \"rotatePitch\":90.0, \"coordinate\":\"[[[114.16503396111078,30.561824602572543],[114.16507687645502,30.55667476126395],[114.16851010399408,30.556588930575472],[114.16889634209222,30.56165294119559],[114.16503396111078,30.561824602572543]]]\", \"wayPointList\":[{\"id\":\"2c9081e576984f580176cbef5144020b\", \"order\":1, \"latitude\":30.561094544820126, \"longitude\":114.16885375253815 }, {\"id\":\"2c9081e576984f580176cbef5144020c\", \"order\":2, \"latitude\":30.561094544820126, \"longitude\":114.16504004492539 }, {\"id\":\"2c9081e576984f580176cbef5144020d\", \"order\":3, \"latitude\":30.560364487067705, \"longitude\":114.16504612873999 }, {\"id\":\"2c9081e576984f580176cbef5144020e\", \"order\":4, \"latitude\":30.56036448706771, \"longitude\":114.1687980701672 }, {\"id\":\"2c9081e576984f580176cbef5144020f\", \"order\":5, \"latitude\":30.55963442931529, \"longitude\":114.16874238779626 }, {\"id\":\"2c9081e576984f580176cbef51440210\", \"order\":6, \"latitude\":30.559634429315295, \"longitude\":114.16505221255458 }, {\"id\":\"2c9081e576984f580176cbef51440211\", \"order\":7, \"latitude\":30.55890437156288, \"longitude\":114.16505829636918 }, {\"id\":\"2c9081e576984f580176cbef51440212\", \"order\":8, \"latitude\":30.558904371562882, \"longitude\":114.16868670542533 }, {\"id\":\"2c9081e576984f580176cbef51440213\", \"order\":9, \"latitude\":30.558174313810458, \"longitude\":114.16863102305437 }, {\"id\":\"2c9081e576984f580176cbef51440214\", \"order\":10, \"latitude\":30.558174313810465, \"longitude\":114.16506438018378 }, {\"id\":\"2c9081e576984f580176cbef51440215\", \"order\":11, \"latitude\":30.55744425605804, \"longitude\":114.1650704639984 }, {\"id\":\"2c9081e576984f580176cbef51440216\", \"order\":12, \"latitude\":30.557444256058048, \"longitude\":114.16857534068343 }, {\"id\":\"2c9081e576984f580176cbef51440217\", \"order\":13, \"latitude\":30.556714198305624, \"longitude\":114.16851965831249 }, {\"id\":\"2c9081e576984f580176cbef51440218\", \"order\":14, \"latitude\":30.556714198305627, \"longitude\":114.165076547813 } ] }, {\"id\":\"202101050849410998476877\", \"createTime\":\"2021-01-05\", \"speed\":5.0, \"flyTaskName\":\"[test]20201209-1_考试院_网格1_1期\", \"flyHeight\":150.0, \"lineOverlap\":0.7, \"headingOverlap\":0.7, \"rotatePitch\":90.0, \"coordinate\":\"[[[114.32772932185284,30.575844080760966],[114.3284047964545,30.576427445127205],[114.3291314432183,30.575859432409608],[114.32842526531937,30.575235130141873],[114.32772932185284,30.575844080760966]]]\", \"wayPointList\":[{\"id\":\"2c9081e576984f580176d0055ceb021c\", \"order\":1, \"latitude\":30.575697387374785, \"longitude\":114.32894814639536 }, {\"id\":\"2c9081e576984f580176d0055ceb021d\", \"order\":2, \"latitude\":30.575697387374785, \"longitude\":114.32789697141338 } ] }, {\"id\":\"202101051624165155754562\", \"createTime\":\"2021-01-05\", \"speed\":5.0, \"flyTaskName\":\"20201230测试1_街区1_网格1_1期\", \"flyHeight\":150.0, \"lineOverlap\":0.7, \"headingOverlap\":0.7, \"rotatePitch\":90.0, \"coordinate\":\"[[[114.32513065251297,30.580498102761872],[114.32590582767718,30.58137709618194],[114.32801679616902,30.57969524285335],[114.32747002037775,30.578871619154256],[114.32513065251297,30.580498102761872]]]\", \"wayPointList\":[{\"id\":\"2c9081e576984f580176d1a58d830245\", \"order\":1, \"latitude\":30.58064703842953, \"longitude\":114.3268221554487 }, {\"id\":\"2c9081e576984f580176d1a58d830246\", \"order\":2, \"latitude\":30.580647038429518, \"longitude\":114.32526199733078 }, {\"id\":\"2c9081e576984f580176d1a58d830247\", \"order\":3, \"latitude\":30.579916980677105, \"longitude\":114.3259664791541 }, {\"id\":\"2c9081e576984f580176d1a58d830248\", \"order\":4, \"latitude\":30.579916980677105, \"longitude\":114.32773848322019 }, {\"id\":\"2c9081e576984f580176d1a58d830249\", \"order\":5, \"latitude\":30.579186922924688, \"longitude\":114.32767933983851 }, {\"id\":\"2c9081e576984f580176d1a58d83024a\", \"order\":6, \"latitude\":30.57918692292469, \"longitude\":114.32701651964477 } ] }, {\"id\":\"202101051624512984147237\", \"createTime\":\"2021-01-05\", \"speed\":5.0, \"flyTaskName\":\"20201230测试1_街区1_网格2_1期\", \"flyHeight\":150.0, \"lineOverlap\":0.7, \"headingOverlap\":0.7, \"rotatePitch\":90.0, \"coordinate\":\"[[[114.32605809423559,30.581390938554094],[114.32682634844605,30.582408355928074],[114.32895808026379,30.580823399436927],[114.32816214084433,30.57980598229529],[114.32605809423559,30.581390938554094]]]\", \"wayPointList\":[{\"id\":\"2c9081e576984f580176d1a61562024c\", \"order\":1, \"latitude\":30.581678298175657, \"longitude\":114.32780826015674 }, {\"id\":\"2c9081e576984f580176d1a61562024d\", \"order\":2, \"latitude\":30.581678298175657, \"longitude\":114.32627508014997 }, {\"id\":\"2c9081e576984f580176d1a61562024e\", \"order\":3, \"latitude\":30.580948240423236, \"longitude\":114.32664578080153 }, {\"id\":\"2c9081e576984f580176d1a61562024f\", \"order\":4, \"latitude\":30.580948240423236, \"longitude\":114.32879017186745 }, {\"id\":\"2c9081e576984f580176d1a615620250\", \"order\":5, \"latitude\":30.580218182670826, \"longitude\":114.32848461086589 }, {\"id\":\"2c9081e576984f580176d1a615620251\", \"order\":6, \"latitude\":30.58021818267083, \"longitude\":114.32761494037906 } ] } ]";
////        String json = "[{\"id\":\"202012091630022439143239\", \"createTime\":\"2020-12-09\", \"speed\":5.0, \"flyTaskName\":\"[test]20201209-1_喻家湖_网格1_1期\", \"flyHeight\":102.0, \"lineOverlap\":0.5, \"headingOverlap\":0.0, \"rotatePitch\":0.0, \"coordinate\":\"[[[114.32576632820361,30.574318556255456],[114.32723584992065,30.57560645166952],[114.32858153576139,30.57478087759021],[114.32693451559926,30.57334850673306],[114.32576632820361,30.574318556255456]]]\", \"wayPointList\":[{\"id\":\"2c9081e576423f2e017646d20d0301b5\", \"order\":1, \"latitude\":30.574519963558703, \"longitude\":114.32828152220809 }, {\"id\":\"2c9081e576423f2e017646d20d0301b6\", \"order\":2, \"latitude\":30.574519963558703, \"longitude\":114.32599613910507 }, {\"id\":\"2c9081e576423f2e017646d20d0301b7\", \"order\":3, \"latitude\":30.573433475447896, \"longitude\":114.32683219156381 }, {\"id\":\"2c9081e576423f2e017646d20d0301b8\", \"order\":4, \"latitude\":30.573433475447896, \"longitude\":114.32703221738214 } ] }, {\"id\":\"202012151102466799441774\", \"createTime\":\"2020-12-15\", \"speed\":5.0, \"flyTaskName\":\"数据测试_ceshi1_网格1_1期\", \"flyHeight\":300.0, \"lineOverlap\":0.7, \"headingOverlap\":0.7, \"rotatePitch\":90.0, \"coordinate\":\"[[[114.15606836131505,30.569853803041866],[114.15611127665929,30.56397440088122],[114.1622910862296,30.563931485536983],[114.16259149363927,30.570111295107296],[114.15606836131505,30.569853803041866]]]\", \"wayPointList\":[{\"id\":\"2c9081e5765ff92401766459aa9700e6\", \"order\":1, \"latitude\":30.568651179602462, \"longitude\":114.16252051580221 }, {\"id\":\"2c9081e5765ff92401766459aa9700e7\", \"order\":2, \"latitude\":30.56865117960246, \"longitude\":114.15607713958833 }, {\"id\":\"2c9081e5765ff92401766459aa9700e8\", \"order\":3, \"latitude\":30.56719106409763, \"longitude\":114.15608779736573 }, {\"id\":\"2c9081e5765ff92401766459aa9700e9\", \"order\":4, \"latitude\":30.56719106409763, \"longitude\":114.16244953796519 }, {\"id\":\"2c9081e5765ff92401766459aa9700ea\", \"order\":5, \"latitude\":30.565730948592797, \"longitude\":114.16237856012815 }, {\"id\":\"2c9081e5765ff92401766459aa9800eb\", \"order\":6, \"latitude\":30.565730948592797, \"longitude\":114.15609845514317 }, {\"id\":\"2c9081e5765ff92401766459aa9800ec\", \"order\":7, \"latitude\":30.56427083308797, \"longitude\":114.15610911292055 }, {\"id\":\"2c9081e5765ff92401766459aa9800ed\", \"order\":8, \"latitude\":30.564270833087967, \"longitude\":114.1623075822911 } ] } ]";
//        String json = "[{\"id\":\"202012151102466799441774\", \"createTime\":\"2020-12-15\", \"speed\":5.0, \"flyTaskName\":\"数据测试_ceshi1_网格1_1期\", \"flyHeight\":300.0, \"lineOverlap\":0.7, \"headingOverlap\":0.7, \"rotatePitch\":90.0, \"coordinate\":\"[[[114.15606836131505,30.569853803041866],[114.15611127665929,30.56397440088122],[114.1622910862296,30.563931485536983],[114.16259149363927,30.570111295107296],[114.15606836131505,30.569853803041866]]]\", \"wayPointList\":[{\"id\":\"2c9081e5765ff92401766459aa9700e6\", \"order\":1, \"latitude\":30.568651179602462, \"longitude\":114.16252051580221 }, {\"id\":\"2c9081e5765ff92401766459aa9700e7\", \"order\":2, \"latitude\":30.56865117960246, \"longitude\":114.15607713958833 }, {\"id\":\"2c9081e5765ff92401766459aa9700e8\", \"order\":3, \"latitude\":30.56719106409763, \"longitude\":114.15608779736573 }, {\"id\":\"2c9081e5765ff92401766459aa9700e9\", \"order\":4, \"latitude\":30.56719106409763, \"longitude\":114.16244953796519 }, {\"id\":\"2c9081e5765ff92401766459aa9700ea\", \"order\":5, \"latitude\":30.565730948592797, \"longitude\":114.16237856012815 }, {\"id\":\"2c9081e5765ff92401766459aa9800eb\", \"order\":6, \"latitude\":30.565730948592797, \"longitude\":114.15609845514317 }, {\"id\":\"2c9081e5765ff92401766459aa9800ec\", \"order\":7, \"latitude\":30.56427083308797, \"longitude\":114.15610911292055 }, {\"id\":\"2c9081e5765ff92401766459aa9800ed\", \"order\":8, \"latitude\":30.564270833087967, \"longitude\":114.1623075822911 } ] } ]";
//        Gson gson = new Gson();
//        Type fooType = new TypeToken<List<ResultDataBean>>() {}.getType();
//        List<ResultDataBean> resultDataBeans = gson.fromJson(json, fooType);
//        System.out.println("resultDataBean = " + resultDataBeans);
//        System.out.println(resultDataBeans.get(0).getFlyTaskName());


        //解析对象
////        String json = "{\"id\":\"202012091630022439143239\", \"createTime\":\"2020-12-09\", \"speed\":5.0, \"flyTaskName\":\"[test]20201209-1_喻家湖_网格1_1期\", \"flyHeight\":102.0, \"lineOverlap\":0.5, \"headingOverlap\":0.0, \"rotatePitch\":0.0, \"coordinate\":\"[[[114.32576632820361,30.574318556255456],[114.32723584992065,30.57560645166952],[114.32858153576139,30.57478087759021],[114.32693451559926,30.57334850673306],[114.32576632820361,30.574318556255456]]]\", \"wayPointList\":[{\"id\":\"2c9081e576423f2e017646d20d0301b5\", \"order\":1, \"latitude\":30.574519963558703, \"longitude\":114.32828152220809 }, {\"id\":\"2c9081e576423f2e017646d20d0301b6\", \"order\":2, \"latitude\":30.574519963558703, \"longitude\":114.32599613910507 }, {\"id\":\"2c9081e576423f2e017646d20d0301b7\", \"order\":3, \"latitude\":30.573433475447896, \"longitude\":114.32683219156381 }, {\"id\":\"2c9081e576423f2e017646d20d0301b8\", \"order\":4, \"latitude\":30.573433475447896, \"longitude\":114.32703221738214 } ] }";
//        String json = "{\"id\":\"202012151102466799441774\", \"createTime\":\"2020-12-15\", \"speed\":5.0, \"flyTaskName\":\"数据测试_ceshi1_网格1_1期\", \"flyHeight\":300.0, \"lineOverlap\":0.7, \"headingOverlap\":0.7, \"rotatePitch\":90.0, \"coordinate\":\"[[[114.15606836131505,30.569853803041866],[114.15611127665929,30.56397440088122],[114.1622910862296,30.563931485536983],[114.16259149363927,30.570111295107296],[114.15606836131505,30.569853803041866]]]\", \"wayPointList\":[{\"id\":\"2c9081e5765ff92401766459aa9700e6\", \"order\":1, \"latitude\":30.568651179602462, \"longitude\":114.16252051580221 }, {\"id\":\"2c9081e5765ff92401766459aa9700e7\", \"order\":2, \"latitude\":30.56865117960246, \"longitude\":114.15607713958833 }, {\"id\":\"2c9081e5765ff92401766459aa9700e8\", \"order\":3, \"latitude\":30.56719106409763, \"longitude\":114.15608779736573 }, {\"id\":\"2c9081e5765ff92401766459aa9700e9\", \"order\":4, \"latitude\":30.56719106409763, \"longitude\":114.16244953796519 }, {\"id\":\"2c9081e5765ff92401766459aa9700ea\", \"order\":5, \"latitude\":30.565730948592797, \"longitude\":114.16237856012815 }, {\"id\":\"2c9081e5765ff92401766459aa9800eb\", \"order\":6, \"latitude\":30.565730948592797, \"longitude\":114.15609845514317 }, {\"id\":\"2c9081e5765ff92401766459aa9800ec\", \"order\":7, \"latitude\":30.56427083308797, \"longitude\":114.15610911292055 }, {\"id\":\"2c9081e5765ff92401766459aa9800ed\", \"order\":8, \"latitude\":30.564270833087967, \"longitude\":114.1623075822911 } ] } ";
//        Gson gson = new Gson();
//        ResultDataBean resultDataBean = gson.fromJson(json, ResultDataBean.class);
//        System.out.println("resultDataBean = " + resultDataBean);
//        System.out.println(resultDataBean.getFlyTaskName());


        retrofit = retrofit.newBuilder()
                .baseUrl(TASK_SERVER_ADDRESS)
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                .addConverterFactory(GsonConverterFactory.create())
                .build();


        TaskService server = retrofit.create(TaskService.class);
        Call<ResponseBody> call = server.misson("00", 2, authorization);
        try {

            Response<ResponseBody> response = call.execute();

            if (response.code() == 200) {
                String result = response.body().string();
                System.out.println(result);
                result = GsonUtil.getFieldValue(result, "body");
                System.out.println(result);
                result = GsonUtil.getFieldValue(result, "resultData");
                System.out.println("resultData is " + result);


                Type fooType = new TypeToken<List<ResultDataBean>>() {
                }.getType();

                List<ResultDataBean> resultDataBeans = (List<ResultDataBean>) GsonUtil.parseJsonToList(result, fooType);
                System.out.println("resultDataBeans = " + resultDataBeans);


//                HashMap<String, HashMap<String, HashMap<String, ResultDataBean>>> project = new HashMap<>();
//                HashMap<String, List<ResultDataBean>> block = new HashMap<>();
                HashMap<String, List<ResultDataBean>> grid = new HashMap<>();
                Set<String> set = new HashSet<>();


                for (ResultDataBean resultDataBean : resultDataBeans) {
                    System.out.println("resultDataBean = " + resultDataBean);
                }

                resultDataBeans.stream().forEach(resultDataBean -> {
                    String taskName = resultDataBean.getFlyTaskName();
                    String[] temp = taskName.split("_");

                    if (set.contains(temp[0] + "_" + temp[1])) {
                        grid.get(temp[0] + "_" + temp[1]).add(resultDataBean);
                    } else {
                        set.add(temp[0] + "_" + temp[1]);
                        List<ResultDataBean> resultDatas = new ArrayList<>();
                        resultDatas.add(resultDataBean);
                        grid.put(temp[0] + "_" + temp[1], resultDatas);
                    }
                });


                for (String k : grid.keySet()) {
                    System.out.println(k + " is " + grid.get(k).size());
                    for (ResultDataBean resultDataBean : grid.get(k))
                        System.out.println("    " + resultDataBean.getFlyTaskName());
                }


                return;
            }
            System.out.println("[" + response.code() + "]" + call.request().url());
            System.out.println("[" + response.code() + "]" + response.errorBody().string());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    private UserInfo authority() {


        OkHttpClient okHttpClient = new OkHttpClient.Builder()
//                .addNetworkInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .addNetworkInterceptor(new Interceptor() {
                    @Override
                    public okhttp3.Response intercept(Chain chain) throws IOException {

                        Request request = chain.request();
                        System.out.println("[Network Interceptor]url is " + request.url());

                        return chain.proceed(request);
                    }
                })
                .build();

        retrofit = new Retrofit.Builder()
                .baseUrl(SERVER_TEST_ADDRESS)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(
                        GsonConverterFactory.create(
                                new GsonBuilder()
                                        .setDateFormat("yyyy-MM-dd HH:mm:ss")
                                        .create()))
                .build();
        TaskService server = retrofit.create(TaskService.class);

//        String userName = "test1234", password = "abcd1234";
//        String userName = "liuyang", password = "Ly201118";
//        String userName = "kfgeo", password = "Kfgeo20!";
//        String userName = "kfgeo", password = "123456";
//        String userName = "admin", password = "admin123";
        String userName = "lfm", password = "Lfm123";

        Call<UserInfo> call = server.getUserInfo(userName, password, "password");
        try {

            Response<UserInfo> response = call.execute();

            if (response.code() != 200) {
                System.out.println("[" + response.code() + "]" + response.errorBody().string());
                return null;
            }
            System.out.println(response.body());
            UserInfo userInfo = response.body();
            userInfo.userName = userName;
            userInfo.pwd = password;


            retrofit = retrofit.newBuilder()
                    .baseUrl(SERVER_TEST_ADDRESS)
                    .client(okHttpClient.newBuilder()
                            .addNetworkInterceptor(new Interceptor() {
                                @Override
                                public okhttp3.Response intercept(Chain chain) throws IOException {
                                    return chain.proceed(chain.request().newBuilder()
                                            .header("Authorization", "bearer  " + userInfo.access_token)
                                            .build());
                                }
                            })
                            .build())
                    .build();


            return response.body();


        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
