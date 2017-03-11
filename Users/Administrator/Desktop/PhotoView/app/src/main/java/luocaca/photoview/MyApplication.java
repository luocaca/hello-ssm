package luocaca.photoview;

import android.app.Application;

import com.activeandroid.ActiveAndroid;

/**
 * Created by Administrator on 2017/1/16 0016.
 */

public class MyApplication extends Application {


    private static MyApplication context  ;

    public void onCreate() {
        super.onCreate();
        ActiveAndroid.initialize(this);
        context = this ;

    }

    public void onTerminate() {
        super.onTerminate();
        ActiveAndroid.dispose();
    }



    public static Application getContext()
    {
        return  context ;
    }

}
