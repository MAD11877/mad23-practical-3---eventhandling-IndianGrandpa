package sg.edu.np.mad.ex2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.Random;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ImageView img = findViewById(R.id.centerImage);

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertBox();
            }
        });
    }

    private int randomOTP(){
        Random rand = new Random();
        int value = rand.nextInt(999999);
        return value;
    }

    private void alertBox(){
        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        builder.setMessage("MADness").setCancelable(false);
        builder.setPositiveButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        builder.setNegativeButton("View", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String number = Integer.toString(randomOTP());
                Intent myNewIntent = new Intent(ListActivity.this, MainActivity.class);
                myNewIntent.putExtra("OTP", number);
                startActivity(myNewIntent);
            }
        });

        AlertDialog alert = builder.create();
        alert.setTitle("Profile");
        alert.show();
    }
}