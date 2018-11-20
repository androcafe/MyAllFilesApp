package visitindia.androcafe.myallfilesapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView iv_photo;
    Button btn_take_a_photo;

    public static int CAMERA_REQ=100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv_photo=findViewById(R.id.iv_photo);
        btn_take_a_photo=findViewById(R.id.btn_take_a_photo);

        btn_take_a_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intentTakePhoto=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intentTakePhoto,CAMERA_REQ);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode==CAMERA_REQ)
        {
            Bitmap photo= (Bitmap) data.getExtras().get("data");
            iv_photo.setImageBitmap(photo);
        }
    }
}
