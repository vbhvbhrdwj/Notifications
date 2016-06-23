package com.example.windowslive.notifications;


import android.app.Notification;
import android.app.NotificationManager;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnToast)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        customToast();
                    }
                });
    }

    private void showToast(){

        //Toast.makeText(this, "Toast", Toast.LENGTH_SHORT).show();

        Toast toast = Toast
                .makeText(this, "Toast", Toast.LENGTH_SHORT);
        toast.show();
    }

    private void customToast(){

        // teach once and learn twice
        Toast toast = Toast
                .makeText(this, "Toast", Toast.LENGTH_SHORT);

        EditText edt = new EditText(this);
        edt.setHint("Toast");

        toast.setView(edt);
        toast.show();
    }

    public void clickMe(View view){
        if(view.getId() == R.id.btnStatus){

            createNotificationComapct();
        }
    }

    private void createSimpleStatusBarNotification(){

        Notification.Builder builder =
                new Notification.Builder(this)
                        .setContentTitle("Content Title")
                        .setContentText("Content Text")
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentInfo("Content Info");

        NotificationManager manager = (NotificationManager)
                getSystemService(NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            manager.notify(3112,builder.build());
        }
    }

    private void createNotificationComapct(){

        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this);
        builder.setContentInfo("Content Info");
        builder.setContentText("Content Text");
        builder.setContentTitle("Content title");
        builder.setSmallIcon(R.mipmap.ic_launcher);

        Notification notification = builder.build();

        NotificationManager manager = (NotificationManager)
                getSystemService(NOTIFICATION_SERVICE);

        manager.notify(1321,notification);
    }
}
