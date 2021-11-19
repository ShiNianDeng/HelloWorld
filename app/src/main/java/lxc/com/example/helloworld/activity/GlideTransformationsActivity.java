package lxc.com.example.helloworld.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.PointF;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import jp.wasabeef.glide.transformations.BlurTransformation;
import jp.wasabeef.glide.transformations.ColorFilterTransformation;
import jp.wasabeef.glide.transformations.CropCircleTransformation;
import jp.wasabeef.glide.transformations.CropCircleWithBorderTransformation;
import jp.wasabeef.glide.transformations.CropSquareTransformation;
import jp.wasabeef.glide.transformations.CropTransformation;
import jp.wasabeef.glide.transformations.GrayscaleTransformation;
import jp.wasabeef.glide.transformations.MaskTransformation;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;
import jp.wasabeef.glide.transformations.gpu.BrightnessFilterTransformation;
import jp.wasabeef.glide.transformations.gpu.ContrastFilterTransformation;
import jp.wasabeef.glide.transformations.gpu.InvertFilterTransformation;
import jp.wasabeef.glide.transformations.gpu.KuwaharaFilterTransformation;
import jp.wasabeef.glide.transformations.gpu.PixelationFilterTransformation;
import jp.wasabeef.glide.transformations.gpu.SepiaFilterTransformation;
import jp.wasabeef.glide.transformations.gpu.SketchFilterTransformation;
import jp.wasabeef.glide.transformations.gpu.SwirlFilterTransformation;
import jp.wasabeef.glide.transformations.gpu.ToonFilterTransformation;
import jp.wasabeef.glide.transformations.gpu.VignetteFilterTransformation;
import lxc.com.example.helloworld.R;

public class GlideTransformationsActivity extends BaseActivity implements View.OnClickListener {

    private ImageView ivTransformation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide_transformations);
        initView();
    }

    private void initView() {
        ivTransformation = fd(R.id.iv_transformation);
        fd(R.id.btn_cropCircle).setOnClickListener(this);
        fd(R.id.btn_cropCircle_with_border).setOnClickListener(this);
        fd(R.id.btn_crop_square).setOnClickListener(this);
        fd(R.id.btn_rounded_corners).setOnClickListener(this);
        fd(R.id.btn_color_filter).setOnClickListener(this);
        fd(R.id.btn_gray_scale).setOnClickListener(this);
        fd(R.id.btn_blur).setOnClickListener(this);
        fd(R.id.btn_mask).setOnClickListener(this);
        fd(R.id.btn_toon_filter).setOnClickListener(this);
        fd(R.id.btn_sepia_filter).setOnClickListener(this);
        fd(R.id.btn_contrast_ffilter).setOnClickListener(this);
        fd(R.id.btn_invert_filter).setOnClickListener(this);
        fd(R.id.btn_pixelation_filter).setOnClickListener(this);
        fd(R.id.btn_sketch_filter).setOnClickListener(this);
        fd(R.id.btn_swirl_filter).setOnClickListener(this);
        fd(R.id.btn_brightness_filter).setOnClickListener(this);
        fd(R.id.btn_kuwahara_filter).setOnClickListener(this);
        fd(R.id.btn_vignette_filter).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_cropCircle:
                Glide.with(this)
                        .load(R.drawable.demo)
                        .transform(new CropTransformation(300, 300, CropTransformation.CropType.CENTER))
                        .into(ivTransformation);
                break;
            case R.id.btn_cropCircle_with_border:
                Glide.with(this)
                        .load(R.drawable.demo)
                        .transform(new CropCircleWithBorderTransformation())
                        .into(ivTransformation);
                break;
            case R.id.btn_crop_square:
                Glide.with(this)
                        .load(R.drawable.demo)
                        .transform(new CropSquareTransformation())
                        .into(ivTransformation);
                break;
            case R.id.btn_rounded_corners:
                Glide.with(this)
                        .load(R.drawable.demo)
                        .transform(new RoundedCornersTransformation(200, 100, RoundedCornersTransformation.CornerType.ALL))
                        .into(ivTransformation);
                break;
            case R.id.btn_color_filter:
                Glide.with(this)
                        .load(R.drawable.demo)
                        .transform(new ColorFilterTransformation(0x7900CCCC))
                        .into(ivTransformation);
                break;
            case R.id.btn_gray_scale:
                Glide.with(this)
                        .load(R.drawable.demo)
                        .transform(new GrayscaleTransformation())
                        .into(ivTransformation);
                break;
            case R.id.btn_blur:
                Glide.with(this)
                        .load(R.drawable.demo)
                        .transform(new BlurTransformation(25, 8))
                        .into(ivTransformation);
                break;
            case R.id.btn_mask:
                Glide.with(this)
                        .load(R.drawable.demo)
                        .transform(new MaskTransformation(R.drawable.banana))
                        .into(ivTransformation);
                break;
            case R.id.btn_toon_filter:
                Glide.with(this)
                        .load(R.drawable.demo)
                        .transform(new ToonFilterTransformation(0.5F, 5F))
                        .into(ivTransformation);
                break;
            case R.id.btn_sepia_filter:
                Glide.with(this)
                        .load(R.drawable.demo)
                        .transform(new SepiaFilterTransformation(20F))
                        .into(ivTransformation);
            case R.id.btn_contrast_ffilter:
                Glide.with(this)
                        .load(R.drawable.demo)
                        .transform(new ContrastFilterTransformation(6F))
                        .into(ivTransformation);
                break;
            case R.id.btn_invert_filter:
                Glide.with(this)
                        .load(R.drawable.demo)
                        .transform(new InvertFilterTransformation())
                        .into(ivTransformation);
                break;

            case R.id.btn_pixelation_filter:
                Glide.with(this)
                        .load(R.drawable.demo)
                        .transform(new PixelationFilterTransformation(20))
                        .into(ivTransformation);
                break;
            case R.id.btn_sketch_filter:
                Glide.with(this)
                        .load(R.drawable.demo)
                        .transform(new SketchFilterTransformation())
                        .into(ivTransformation);
                break;
            case R.id.btn_swirl_filter:
                Glide.with(this)
                        .load(R.drawable.demo)
                        .transform(new SwirlFilterTransformation(1.0F, 0.5F, new PointF(0.5F, 0.5F)))
                        .into(ivTransformation);
                break;
            case R.id.btn_brightness_filter:
                Glide.with(this)
                        .load(R.drawable.demo)
                        .transform(new BrightnessFilterTransformation(0.5F))
                        .into(ivTransformation);
                break;
            case R.id.btn_kuwahara_filter:
                Glide.with(this)
                        .load(R.drawable.demo)
                        .transform(new KuwaharaFilterTransformation(10))
                        .into(ivTransformation);
                break;
            case R.id.btn_vignette_filter:
                Glide.with(this)
                        .load(R.drawable.demo)
                        .transform(new VignetteFilterTransformation(new PointF(0.5F, 0.5F), new float[]{0.0F, 0.0F, 0.0F}, 0.0F, 0.5F))
                        .into(ivTransformation);
                break;
            default:
                break;
        }
    }
}