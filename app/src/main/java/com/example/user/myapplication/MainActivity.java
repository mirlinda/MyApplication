package com.example.user.myapplication;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.util.HashMap;
import com.kosalgeek.asynctask.AsyncResponse;
import com.kosalgeek.asynctask.PostResponseAsyncTask;

import org.json.JSONObject;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements AsyncResponse,View.OnClickListener {

    EditText airFrom,airTo,DateFrom,TimeFrom;
    Button btnCheck;
    DatePickerDialog datePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         airFrom = (EditText) findViewById(R.id.editText);
         airTo = (EditText) findViewById(R.id.editText2);
         DateFrom=(EditText) findViewById(R.id.editText3);
        TimeFrom=(EditText) findViewById(R.id.editText4);
        btnCheck = (Button) findViewById(R.id.btnViewProducts);

        btnCheck.setOnClickListener(this);


    }

    @Override
    public void processFinish(String result) {

        Toast.makeText(this,result,Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, Result.class);
        intent.putExtra("Result", result);
        startActivity(intent);

    }


    @Override
    public void onClick(View v) {
        HashMap postData = new HashMap();
        postData.put("mobile","android");
        postData.put("txtfrom", airFrom.getText().toString());
        postData.put("txtTo", airTo.getText().toString() );
        postData.put("DateFrom", DateFrom.getText().toString() );
        postData.put("TimeFrom", TimeFrom.getText().toString() );

        PostResponseAsyncTask task1 = new PostResponseAsyncTask(this,postData);

        task1.execute("http://192.168.227.1:90/NasaApp/Interface.php");
    }
}
