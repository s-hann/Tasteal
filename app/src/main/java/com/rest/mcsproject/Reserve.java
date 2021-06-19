package com.rest.mcsproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Reserve extends AppCompatActivity {

    EditText input_nama;
    EditText input_telp;
    Spinner total_orang;
    Spinner posisi_duduk;
    String nama, telp, posisi, tanggal;
    int orang;
    SmsManager smsManager;

    Button btn_reserve;
    DatePicker dp_reservation;


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        this.finish();
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserve);

        //  back
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        input_nama = findViewById(R.id.input_nama);
        input_telp = findViewById(R.id.input_telp);
        total_orang = findViewById(R.id.total_orang);
        posisi_duduk = findViewById(R.id.posisi_duduk);
        btn_reserve = findViewById(R.id.btn_reserve);
        dp_reservation = findViewById(R.id.dp_reservation);

        dp_reservation.setMinDate(System.currentTimeMillis() - 1000);

        smsManager = SmsManager.getDefault();
        permission();

        total_orang.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                orang = Integer.parseInt(total_orang.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        posisi_duduk.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                posisi = posisi_duduk.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btn_reserve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                nama = input_nama.getText().toString();
                telp = input_telp.getText().toString();
                int month = (dp_reservation.getMonth() + 1);
                String putMonth;
                if(month / 10 < 1) {
                    putMonth = "0" + month;
                }
                else {
                    putMonth = "" + month;
                }
                tanggal = dp_reservation.getDayOfMonth() + "-" + putMonth + "-" + dp_reservation.getYear();


                if(nama.isEmpty() || telp.isEmpty()) {
                    if(nama.isEmpty()){
                        input_nama.setError("Name cannot be empty.");
                    }
                    if(telp.isEmpty()){
                        input_telp.setError("Phone number cannot be empty.");
                    }
                }
                else{
                    String confirmation = "Reservation Success!\n" +
                            "Name: " + nama + "\n"+
                            "Date: " + tanggal + "\n"+
                            "Total of people: " + orang + "\n" +
                            "Location: " + posisi + "\n" +
                            "See you there!";

                    smsManager.sendTextMessage(telp, null, confirmation, null, null);

                    String reserve = "Reservation\n" +
                            "Name: " + nama + "\n" +
                            "Date: " + tanggal + "\n"+
                            "Total of people: " + orang + "\n" +
                            "Location: " + posisi + "\n" +
                            "Phone number: " + telp;

                    smsManager.sendTextMessage("5554", null, reserve, null, null);


                    try {
                        Toast.makeText(Reserve.this, "Reservation success!", Toast.LENGTH_SHORT).show();
                        Thread.sleep(1000);
                    }
                    catch (Exception e) {

                    }

                    finish();
                }
            }
        });
    }

    void permission(){
        int sendPermission = ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS);
        if( sendPermission != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.SEND_SMS},1);
        }
        int recPermission = ContextCompat.checkSelfPermission(this, Manifest.permission.RECEIVE_SMS);
        if( recPermission != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.RECEIVE_SMS},1);
        }
        int readPermission = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_SMS);
        if( readPermission != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.READ_SMS},1);
        }
    }
}