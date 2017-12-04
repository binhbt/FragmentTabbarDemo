package com.bip.fragmenttabbar;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    private ImageButton btnMessage, btnContact, btnTimeline, btnSetting;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnMessage = (ImageButton) findViewById(R.id.btn_message);
        btnContact = (ImageButton) findViewById(R.id.btn_contacts);
        btnTimeline = (ImageButton) findViewById(R.id.btn_timeline);
        btnSetting = (ImageButton) findViewById(R.id.btn_setting);

        //Set su kien click
        btnMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showFragment(new MessageFragment());
                btnMessage.setImageResource(R.drawable.icn_tab_message_o);
                btnContact.setImageResource(R.drawable.ic_contact_selector);
                btnTimeline.setImageResource(R.drawable.ic_timeline_selector);
                btnSetting.setImageResource(R.drawable.ic_setting_selector);
            }
        });
        btnContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showFragment(new ContactFragment());
                btnMessage.setImageResource(R.drawable.ic_message_selector);
                btnContact.setImageResource(R.drawable.icn_tab_group_o);
                btnTimeline.setImageResource(R.drawable.ic_timeline_selector);
                btnSetting.setImageResource(R.drawable.ic_setting_selector);
            }
        });
        btnTimeline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showFragment(new TimelineFragment());
                btnMessage.setImageResource(R.drawable.ic_message_selector);
                btnContact.setImageResource(R.drawable.ic_contact_selector);
                btnTimeline.setImageResource(R.drawable.icn_tab_social_o);
                btnSetting.setImageResource(R.drawable.ic_setting_selector);
            }
        });
        btnSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showFragment(new SettingFragment());
                btnMessage.setImageResource(R.drawable.ic_message_selector);
                btnContact.setImageResource(R.drawable.ic_contact_selector);
                btnTimeline.setImageResource(R.drawable.ic_timeline_selector);
                btnSetting.setImageResource(R.drawable.icn_tab_discover_o);
            }
        });
    }
    private void showFragment(Fragment fragment){
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //Khoi tao fragment
        //Gan Fragment vao View cos id la fragment_container
        fragmentTransaction.replace(R.id.frame_content, fragment);
        //co the add vao backstak hoac khong
        //fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }
}
