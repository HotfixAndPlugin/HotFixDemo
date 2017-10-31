package com.lewish.start.tinkerdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.lewish.start.tinkerdemo.tinker.TinkerManager;

import java.io.File;

/**
 * author: sundong
 * created at 2017/7/14 14:32
 */
public class MainActivity extends AppCompatActivity {
    private static final String FILE_END = ".apk";
    private String mPatchDir;
    private Button mBtnBugFixTest;
    private Button mBtnLoadApatch;
    private TextView mTv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPatchDir = getExternalCacheDir().getAbsolutePath() + "/tpatch/";
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
                TinkerManager.loadPatch(getPatchName());
            }
        });
        mTv = (TextView)findViewById(R.id.mTv);
        mTv.setText("图片二333");
    }

    private String getPatchName() {
        return mPatchDir.concat("tinkerPatch").concat(FILE_END);
    }
}
