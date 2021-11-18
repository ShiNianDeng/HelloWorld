package lxc.com.example.helloworld.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

import lxc.com.example.helloworld.R;
import lxc.com.example.helloworld.adapter.FruitAdapter;
import lxc.com.example.helloworld.constants.FruitConstants;

public class StaggeredAcvitity extends BaseActivity {

    private RecyclerView rvStaggered;
    private RecyclerView.LayoutManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staggered_acvitity);
        initView();
    }

    private void initView() {
        manager = new StaggeredGridLayoutManager(3,RecyclerView.VERTICAL);
        rvStaggered = fd(R.id.rv_staggered);
        rvStaggered.setLayoutManager(manager);
        rvStaggered.setAdapter(new FruitAdapter(this, FruitConstants.getfList(),rvStaggered,FruitAdapter.DIRECTION_STAGGERED));
    }
}