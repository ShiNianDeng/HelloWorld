package lxc.com.example.helloworld.activity;


import android.app.Activity;
import android.view.View;

import androidx.annotation.IdRes;

public class BaseActivity extends Activity {

    /**
     *  findViewById
     *
     * @param id
     * @param <T>
     * @return
     */
    protected <T extends View> T fd(@IdRes int id) {
        return findViewById(id);
    }
}