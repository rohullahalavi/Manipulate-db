package co.box.app.ru.www.manipulate;

import android.app.Activity;
import android.widget.ArrayAdapter;

import java.util.ArrayList;


public class AllExtends extends Activity {


    public static Activity activity;
    @Override
    protected void onResume() {
        super.onResume();

    activity=this;
    }
}
