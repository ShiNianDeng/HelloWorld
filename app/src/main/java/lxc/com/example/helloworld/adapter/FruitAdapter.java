package lxc.com.example.helloworld.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import lxc.com.example.helloworld.R;
import lxc.com.example.helloworld.model.Fruit;

public class FruitAdapter extends RecyclerView.Adapter {
    public static int DIRECTION_LINEAR = 1;
    public static int DIRECTION_GRID = 2;
    public static int DIRECTION_STAGGERED = 3;

    private List<Fruit> fList;
    private Context context;
    private RecyclerView recyclerView;
    private int layoutDirection;//RecyclerView的布局类型

    public FruitAdapter(Context context, List<Fruit> fList, RecyclerView recyclerView, int direction) {
        this.context = context;
        this.fList = fList;
        this.recyclerView = recyclerView;
        layoutDirection = direction;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewHolder  h = null;
        switch (viewType) {
            case 1:
                h = new ViewHolder(LayoutInflater.from(context).inflate(R.layout.fruit_lin_ver_item, parent, false));
            case 2:
                h =  new ViewHolder(LayoutInflater.from(context).inflate(R.layout.fruit_grid_ver_item, parent, false));
            case 3:
                h =  new ViewHolder(LayoutInflater.from(context).inflate(R.layout.fruit_staggered_ver_item, parent, false));
            default:
                break;
        }
        if(h==null){
            h = new ViewHolder(LayoutInflater.from(context).inflate(R.layout.fruit_lin_ver_item, parent, false));
        }
        h.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //定义View的点击事件
            }
        });

        return h;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Fruit fruit = fList.get(position);
        ViewHolder h = (ViewHolder) holder;
        h.ivImg.setImageResource(fruit.getFruitId());
        h.tvName.setText(fruit.getFruitName());
        h.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "点击了"+fruit.getFruitId()+":"+fruit.getFruitName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        if (fList != null) {
            return fList.size();
        } else {
            return 0;
        }
    }


    @Override
    public int getItemViewType(int position) {
        if (layoutDirection != 0) {
            return layoutDirection;
        }
        return super.getItemViewType(position);
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        View itemView;
        ImageView ivImg;
        TextView tvName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;
            ivImg = itemView.findViewById(R.id.iv_img);
            tvName = itemView.findViewById(R.id.tv_fruit_name);
        }
    }
}
