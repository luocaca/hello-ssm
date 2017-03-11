package luocaca.photoview;

import android.content.Intent;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

/**
 * Created by Administrator on 2017/3/10 0010.
 */

public class MyHandlers {

    LoginActivity loginActivity;
    int num = 0;

    public MyHandlers(LoginActivity loginActivity) {
        this.loginActivity = loginActivity;
    }


    public final void onClickName(View view) {

        Log.i("loginActivity==", "" + loginActivity.getClass());

        upLoadImg();

//        say_good_bye();


//        Toast.makeText(view.getContext(), "onClickName()"+loginActivity.getClass(), Toast.LENGTH_SHORT).show();


    }

    private void upLoadImg() {

//        Intent intent = new Intent();
//                /* 开启Pictures画面Type设定为image */
//        intent.setType("image/*");
//                /* 使用Intent.ACTION_GET_CONTENT这个Action */
//
//        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
//
//        intent.setAction(Intent.ACTION_PICK);
//                /* 取得相片后返回本画面 */


        Intent intent = new Intent(Intent.ACTION_PICK, null);
        intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
        loginActivity.startActivityForResult(intent, 1);


        /**
         * Uri imageUri = FileProvider.getUriForFile(MainActivity.this, "com.camera_photos.fileprovider", new File(SDPathUtils.getCachePath(), "temp.jpg"));
         openCameraIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
         openCameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
         startActivityForResult(openCameraIntent, 2);
         */

    }

    public final void onClickAge(View view) {
        Toast.makeText(view.getContext(), "onClickAge()", Toast.LENGTH_SHORT).show();
    }


    public void say_good_bye() {
        Log.e("nfff", "fff");
        num = 1;
        Log.e("nfff", "fff");
        Log.e("nfff", "fff");
        Log.e("nfff", "fff");
        Log.e("nfff", "fff");
        Log.e("nfff", "fff");
        num = 2;


    }


    /**
     * Thread is suspended.	这里写图片描述
     Thread is waiting on a monitor lock.	这里写图片描述
     Thread is running.	这里写图片描述
     Thread is executing network operation, and is waiting for data to be passed.	这里写图片描述
     Thread is idle.	这里写图片描述
     Event Dispatch Thread that is busy.	这里写图片描述
     Thread is executing disk operation.
     */

}
