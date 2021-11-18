package lxc.com.example.helloworld.activity;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import lxc.com.example.helloworld.R;
import lxc.com.example.helloworld.adapter.FruitAdapter;
import lxc.com.example.helloworld.constants.FruitConstants;

public class GridActivity extends BaseActivity {
    private RecyclerView.LayoutManager manager ;
    private RecyclerView rvGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);

        initView();
    }

    private void initView() {
        manager = new GridLayoutManager(this,4);
        rvGrid = fd(R.id.rv_grid);
        rvGrid.setAdapter(new FruitAdapter(this, FruitConstants.getfList(),rvGrid, FruitAdapter.DIRECTION_GRID));
        rvGrid.setLayoutManager(manager);
    }
}