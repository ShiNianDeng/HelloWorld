package lxc.com.example.helloworld.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import lxc.com.example.helloworld.R;
import lxc.com.example.helloworld.adapter.FruitAdapter;
import lxc.com.example.helloworld.constants.FruitConstants;
import lxc.com.example.helloworld.model.Fruit;

public class LinearActivity extends BaseActivity {
    private static final String TAG = "LinearActivity";
    private List<Fruit> fList = FruitConstants.getfList();
    private RecyclerView rvLinear;
    RecyclerView.LayoutManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear);
        initView();
        initData();

    }

    private void initData() {

    }

    private void initView() {
        //创建一个水平方向的线性布局
//        manager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);

        //创建一个垂直方向的线性布局
        manager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,true);
        rvLinear = fd(R.id.rv_linear);
        rvLinear.setLayoutManager(manager);
        rvLinear.setAdapter(new FruitAdapter(this,fList,rvLinear,FruitAdapter.DIRECTION_LINEAR));
    }
}