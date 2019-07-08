package com.bawei.rikao11;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;

import com.bawei.rikao11.fragment.FragMent;
import com.bawei.rikao11.fragment.FragMent1;
import com.bawei.rikao11.fragment.FragMent2;
import com.bawei.rikao11.fragment.FragMent3;
import com.bawei.rikao11.fragment.FragMent4;

public class MainActivity extends AppCompatActivity {
    private FragmentManager manager;
    private FragMent fragMent;
    private FragMent1 fragMent1;
    private FragMent2 fragMent2;
    private FragMent3 fragMent3;
    private FragMent4 fragMent4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager = getSupportFragmentManager();
        fragMent = new FragMent();
        fragMent1 = new FragMent1();
        fragMent2 = new FragMent2();
        fragMent3 = new FragMent3();
        fragMent4 = new FragMent4();
        manager.beginTransaction()
                .add(R.id.frag,fragMent)
                .add(R.id.frag,fragMent1)
                .add(R.id.frag,fragMent2)
                .add(R.id.frag,fragMent3)
                .add(R.id.frag,fragMent4)
                .show(fragMent)
                .hide(fragMent1)
                .hide(fragMent2)
                .hide(fragMent3)
                .hide(fragMent4)
                .commit();
        RadioGroup group = findViewById(R.id.group);
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                FragmentTransaction transaction = manager.beginTransaction();
                switch (checkedId){
                    case R.id.but:
                        transaction.show(fragMent)
                                .hide(fragMent1)
                                .hide(fragMent2)
                                .hide(fragMent3)
                                .hide(fragMent4);
                        break;
                    case R.id.but1:
                        transaction.show(fragMent1)
                                .hide(fragMent)
                                .hide(fragMent2)
                                .hide(fragMent3)
                                .hide(fragMent4);
                        break;
                    case R.id.but2:
                        transaction.show(fragMent2)
                                .hide(fragMent1)
                                .hide(fragMent)
                                .hide(fragMent3)
                                .hide(fragMent4);
                        break;
                    case R.id.but3:
                        transaction.show(fragMent3)
                                .hide(fragMent1)
                                .hide(fragMent2)
                                .hide(fragMent)
                                .hide(fragMent4);
                        break;
                    case R.id.but4:
                        transaction.show(fragMent4)
                                .hide(fragMent1)
                                .hide(fragMent2)
                                .hide(fragMent3)
                                .hide(fragMent);
                        break;
                }
                transaction.commit();
            }
        });
    }
}
