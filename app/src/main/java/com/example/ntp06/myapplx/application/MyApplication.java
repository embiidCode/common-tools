package com.example.ntp06.myapplx.application;

import android.app.Application;
import android.util.Log;

import com.baidubce.auth.DefaultBceCredentials;
import com.baidubce.services.bos.BosClient;
import com.baidubce.services.bos.BosClientConfiguration;
import com.baidubce.services.bos.model.CreateBucketResponse;
import com.baidubce.services.bos.model.PutObjectResponse;
import com.baidubce.util.BLog;
import com.example.ntp06.myapplx.sqlite.DatabaseHelper;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        DatabaseHelper.getInstance(this);
        initBOS();
    }

    /**
     * 初始化BOS
     */
    private void initBOS(){
        BLog.enableLog();
        BosClientConfiguration config = new BosClientConfiguration();
        config.setCredentials(new DefaultBceCredentials("27b2bf585dc9475aa4630cd9525f0c88", "3fee9f8d5962444c8ef67610be050da5"));   //您的AK/SK
        config.setEndpoint("ai-bucket-1.bj.bcebos.com");    //传入Bucket所在区域域名
        final BosClient client = new BosClient(config);

        new Thread(new Runnable() {

            @Override
            public void run() {

                String bucketName = "ai-bucket-4";
//                boolean exists = client.doesBucketExist("ai-bucket-1");
//                Log.d("why","exists = " + exists);
                try {
                    //创建Bucket
//                    CreateBucketResponse response = client.createBucket(""); //新建一个Bucket并指定Bucket名称
//                    System.out.println(response.getLocation());
//                    System.out.println(response.getName());

                    //上传Object
                    PutObjectResponse putObjectFromFileResponse = client.putObject(bucketName,"str1222", "测试数据1222222222");
                    System.out.println(putObjectFromFileResponse.getETag());

                } catch (Exception e) {
                }
            }
        }).start();

    }

}
