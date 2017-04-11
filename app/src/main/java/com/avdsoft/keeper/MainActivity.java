package com.avdsoft.keeper;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;

import com.avdsoft.keeper.fragments.StartFragment;

public class MainActivity extends AppCompatActivity {
//    private final int ARRAY_SIZE = 24;
//    private List<TaskModel> taskModels = new ArrayList<>();
//    private ListView listView;
    public static ConstraintLayout main_container;

//    private void initArrayModel(int size) {
//        for (int i = 0; i < size; i++) {
//            taskModels.add(new TaskModel(i + " : 00 ", " test" + i));
//        }
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        main_container = (ConstraintLayout) findViewById(R.id.main_wrapper);
        new StartFragment().replaceFragment(this, main_container);
    }


}
