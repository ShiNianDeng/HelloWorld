package lxc.com.example.helloworld.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import lxc.com.example.helloworld.R;

public class RecyclerViewDemoActivity extends BaseActivity implements View.OnClickListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_demo);
        initView();

    }

    private void initView() {
        fd(R.id.btn_staggered).setOnClickListener(this);
        fd(R.id.btn_grid).setOnClickListener(this);
        fd(R.id.btn_linear).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent i = null;
        switch (view.getId()){
            case R.id.btn_staggered:
                i = new Intent(this,StaggeredAcvitity.class);
                break;
            case R.id.btn_grid:i = new Intent(this,GridActivity.class);
                break;
            case R.id.btn_linear:i = new Intent(this,LinearActivity.class);
                break;
            default:
                break;
        }
        startActivity(i);
    }
}