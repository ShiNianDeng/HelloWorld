package lxc.com.example.helloworld.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.util.TypedValue;
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
    private static final String TAG = "FruitAdapter";

    public static int DIRECTION_LINEAR = 1;
    public static int DIRECTION_GRID = 2;
    public static int DIRECTION_STAGGERED = 3;

    private List<Fruit> fList;
    private Context context;
    private Resources resources;
    private RecyclerView recyclerView;
    private int layoutDirection;//RecyclerView的布局类型

    public FruitAdapter(Context context, List<Fruit> fList, RecyclerView recyclerView, int direction) {
        this.context = context;
        this.fList = fList;
        this.recyclerView = recyclerView;
        layoutDirection = direction;
        resources = context.getResources();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewHolder h = null;
        switch (viewType) {
            case 1:
                h = new ViewHolder(LayoutInflater.from(context).inflate(R.layout.fruit_lin_ver_item, parent, false));
                break;
            case 2:
                h = new ViewHolder(LayoutInflater.from(context).inflate(R.layout.fruit_grid_ver_item, parent, false));
                break;
            case 3:
                h = new ViewHolder(LayoutInflater.from(context).inflate(R.layout.fruit_staggered_ver_item, parent, false));
                break;
            default:
                break;
        }
        if (h == null) {
            h = new ViewHolder(LayoutInflater.from(context).inflate(R.layout.fruit_lin_ver_item, parent, false));
        }
        return h;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Fruit fruit = fList.get(position);
        Drawable d = resources.getDrawable(fruit.getFruitId());
        //将xml中的dp转化成setBounds()函数中的int值，因为这个函数只接受int值
        int imgSize = ((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 64, resources.getDisplayMetrics()));
        // 这一步必须要做,否则不会显示.
        d.setBounds(0, 0, imgSize, imgSize);
        ViewHolder h = (ViewHolder) holder;
        h.tvName.setText(fruit.getFruitName());
        if (layoutDirection == 1) {
            h.tvName.setCompoundDrawables(d, null, null, null);
        } else {
            h.tvName.setCompoundDrawables(null, d, null, null);
        }
        h.itemView.setOnClickListener(view ->
                Toast.makeText(context, "点击了" + fruit.getFruitId() + ":" + fruit.getFruitName(), Toast.LENGTH_SHORT).show()
        );
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
            Log.e(TAG, "getItemViewType: " + layoutDirection);
            return layoutDirection;
        }
        return super.getItemViewType(position);
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        View itemView;
        TextView tvName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;
            tvName = itemView.findViewById(R.id.tv_fruit_name);
        }
    }
}
