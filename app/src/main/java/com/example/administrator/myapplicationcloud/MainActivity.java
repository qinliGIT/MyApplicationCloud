package com.example.administrator.myapplicationcloud;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import net.youmi.android.AdManager;
import net.youmi.android.listener.Interface_ActivityListener;
import net.youmi.android.normal.common.ErrorCode;
import net.youmi.android.normal.spot.SplashViewSettings;
import net.youmi.android.normal.spot.SpotListener;
import net.youmi.android.normal.spot.SpotManager;
import net.youmi.android.normal.video.VideoAdListener;
import net.youmi.android.normal.video.VideoAdManager;
import net.youmi.android.normal.video.VideoAdSettings;
import net.youmi.android.offers.OffersManager;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "youmi-demo";

    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
//        AVObject testObject = new AVObject("slqObject");//后台创建一个表名为testObject
//        testObject.put("name", "qinli");//向表中添加一列，列名为name
//        testObject.saveInBackground();//在后台进行保存

        //创建txt表
//        AVObject avobj = new AVObject("data");
//        avobj.put("id","583e4ae5128fe1006bf74b74");
//        avobj.put("txt","这是一段测试文档,xinzengshuju");
//        avobj.saveInBackground();
//
//        //根据id查询TXT
//        AVQuery<AVObject> query = AVQuery.getQuery("data");
//        query.whereEqualTo("id", "583e4ae5128fe1006bf74b74");
//        query.findInBackground(new FindCallback<AVObject>() {
//            public void done(List<AVObject> sList, AVException e) {
//                if (e == null) {
//                    Toast.makeText(MainActivity.this,sList.get(0).getString("txt"),Toast.LENGTH_LONG).show();
//                } else {
//                    e.printStackTrace();
//                }
//            }
//        });
//    }

//        AVQuery<AVObject> avQuery = new AVQuery<>("slqObject");
//        avQuery.orderByDescending("createdAt");//按日期升序
//        avQuery.include("name");
//        avQuery.findInBackground(new FindCallback<AVObject>() {
//            @Override
//            public void done(List<AVObject> list, AVException e) {
//                if (e == null) {
////                    mList.addAll(list);
////                    mRecyclerAdapter.notifyDataSetChanged();
//                } else {
//                    e.printStackTrace();
//                }
//            }
//        });
        // 初始化接口，应用启动的时候调用(appId, appSecret, isTestModel, isEnableYoumiLog)
        AdManager.getInstance(this).init("14b7f3f361dcbdc7", "ff7d3400960e03ac", false, true);
        // 如果使用积分广告，请务必调用积分广告的初始化接口:
        OffersManager.getInstance(this).onAppLaunch();


        // 调用方式一：直接打开全屏积分墙
//         OffersManager.getInstance(this).showOffersWall();

        // 调用方式二：直接打开全屏积分墙，并且监听积分墙退出的事件onDestory
        OffersManager.getInstance(this).showOffersWall(new Interface_ActivityListener() {

            /**
             * 当积分墙销毁的时候，即积分墙的Activity调用了onDestory的时候回调
             */
            @Override
            public void onActivityDestroy(Context context) {
                Toast.makeText(context, "全屏积分墙退出了", Toast.LENGTH_SHORT).show();
            }
        });

    }

}
