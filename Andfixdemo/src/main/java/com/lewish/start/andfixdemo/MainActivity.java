package com.lewish.start.andfixdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;

/**
 * author: sundong
 * created at 2017/7/12 15:46
 */
public class MainActivity extends AppCompatActivity {
    private static final String FILE_END = ".apatch";
    private String mPatchDir;
    private Button mBtnBugFixTest;
    private Button mBtnLoadApatch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPatchDir = getExternalCacheDir().getAbsolutePath() + "/apatch/";
        File file = new File(mPatchDir);
        if (!file.exists()) {
            file.mkdir();
        }

        mBtnBugFixTest = (Button) findViewById(R.id.mBtnBugFixTest);
        mBtnLoadApatch = (Button) findViewById(R.id.mBtnLoadApatch);

        mBtnBugFixTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = null;
                Toast.makeText(MainActivity.this, null, Toast.LENGTH_SHORT).show();
            }
        });

        mBtnLoadApatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AndFixManager.getInstance().addPatch(getPatchName());
            }
        });
    }

    private String getPatchName() {
        return mPatchDir.concat("imooc").concat(FILE_END);
    }

}
