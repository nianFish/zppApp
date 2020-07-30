package com.zp.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

public class MainActivity extends AppCompatActivity {

    private static final String app_Id = "wx549521ab3bceac53";  // 应用AppId wx549521ab3bceac53
    private static final String req_userName = "gh_224759c4aeef";   // 小程序原始  id  gh_224759c4aeef

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bt = findViewById(R.id.bt_userInfo);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, UserInfoActivity.class));
            }
        });

        bt = findViewById(R.id.bt_enterMiniProgram);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String toMiniProgramPath = "pages/naturo/naturo";
                launchMiniProgram(toMiniProgramPath);
            }
        });
    }

    private void launchMiniProgram(String path) {
        IWXAPI api = WXAPIFactory.createWXAPI(this, app_Id);
        WXLaunchMiniProgram.Req req = new WXLaunchMiniProgram.Req();
        req.userName = req_userName;   // 小程序原始id
        req.path = path;    //拉起小程序页面的可带参路径，不填默认拉起小程序首页
        req.miniprogramType = WXLaunchMiniProgram.Req.MINIPTOGRAM_TYPE_RELEASE;
        api.sendReq(req);
    }
}