package com.lanou3g.giltsay.ui.fragment.personfragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.lanou3g.giltsay.R;
import com.lanou3g.giltsay.ui.activity.PersonSettingActivity;
import com.lanou3g.giltsay.ui.adapter.MainPagerAdapter;
import com.lanou3g.giltsay.ui.fragment.absfragment.AbsBaseFragment;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.PlatformDb;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;
import cn.sharesdk.tencent.qq.QQ;
import de.hdodenhof.circleimageview.CircleImageView;


/**
 * Created by dllo on 16/9/8.
 * 个人页面
 */
public class PersonFragment extends AbsBaseFragment {
    private ImageView settingImg;
    private RadioGroup personRg;
    private CircleImageView logInImg;
    private TextView nameTv;

    public static PersonFragment newInstance() {
        Bundle args = new Bundle();
        PersonFragment fragment = new PersonFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_person;
    }

    @Override
    protected void initViews() {
        personRg = byView(R.id.person_rg);
//        personFrame = byView(R.id.person_frame);
        settingImg = byView(R.id.person_setting_img);
        logInImg = byView(R.id.person_sign_in_img);
        nameTv = byView(R.id.person_sign_in_name_tv);
    }

    @Override
    protected void initDatas() {

        personRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                FragmentManager manager = getChildFragmentManager();
                final FragmentTransaction transaction = manager.beginTransaction();
                switch (checkedId) {
                    case R.id.person_single_rb:
                        transaction.replace(R.id.person_frame, PersonSingleFragment.newInstance());
                        break;
                    case R.id.person_guides_rb:
                        transaction.replace(R.id.person_frame, PersonSingleFragment.newInstance());
                        break;
                }
                transaction.commit();
            }
        });
        personRg.check(R.id.person_single_rb);


        settingImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PersonSettingActivity.class);
                startActivity(intent);
            }
        });
        logInImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logIn();
            }
        });
    }

    private void logIn() {
        //获取第三方平台
        Platform platform = ShareSDK.getPlatform(context, QQ.NAME);
        //授权
        platform.authorize();
//        //获取用户信息
        platform.setPlatformActionListener(new PlatformActionListener() {
            @Override
            public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
                Toast.makeText(context, "完成", Toast.LENGTH_SHORT).show();
                //获取QQ的头像和名字
                PlatformDb db = platform.getDb();
                String name = db.getUserName();
                String icon = db.getUserIcon();
                nameTv.setText(name);
                Picasso.with(context).load(icon).into(logInImg);
            logInImg.setMinimumWidth(40);
                logInImg.setMinimumHeight(40);


            }

            @Override
            public void onError(Platform platform, int i, Throwable throwable) {
         Toast.makeText(context, "失败", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancel(Platform platform, int i) {
                Toast.makeText(context, "失败", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
