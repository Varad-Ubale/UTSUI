package com.vktech.utsapp_ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editTextDepart, editTextArrival;
    RadioGroup radioGroupBookingType;
    Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize components
        editTextDepart = findViewById(R.id.editTextDepart);
        editTextArrival = findViewById(R.id.editTextArrival);
        radioGroupBookingType = findViewById(R.id.radioGroupBookingType);
        btnNext = findViewById(R.id.btnNext);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String from = editTextDepart.getText().toString().trim();
                String to = editTextArrival.getText().toString().trim();
                int selectedId = radioGroupBookingType.getCheckedRadioButtonId();

                if (from.isEmpty() || to.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter both station names", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (selectedId == -1) {
                    Toast.makeText(MainActivity.this, "Please select booking type", Toast.LENGTH_SHORT).show();
                    return;
                }

                RadioButton selectedRadio = findViewById(selectedId);
                String bookingType = selectedRadio.getText().toString();

                String message = "Booking from " + from + " to " + to + " via " + bookingType;
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
            }
        });
    }
}