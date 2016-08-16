package co.box.app.ru.www.manipulate;


import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.view.LayoutInflater;
public class G extends Application {

    public static Context context;
    public static Activity activity;
    public static LayoutInflater inflater;


    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }
}
