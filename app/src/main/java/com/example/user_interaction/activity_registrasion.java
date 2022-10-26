package com.example.user_interaction;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

public class activity_registrasion extends AppCompatActivity {
    EditText editNama;
    EditText editUsername;
    EditText editPassword;
    RadioButton radiolk;
    RadioButton radiopr;
    Spinner spinner;
    CheckBox checkBox;
    String negara;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrasion);
        editNama = findViewById(R.id.nama_et);
        editPassword = findViewById(R.id.pass_et);
        editUsername = findViewById(R.id.username_et);
        radiolk = findViewById(R.id.radio_lk);
        radiopr = findViewById(R.id.radio_pr);
        spinner = findViewById(R.id.spinner_negara);
        checkBox = findViewById(R.id.checkbox);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter
                .createFromResource(this, R.array.negara, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                negara = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public Void daftar(View view) {
        if (checkBox.isChecked()) {
            Intent intent = new Intent(this,activity_reghasil.class);
            intent.putExtra("NAMA", editNama.getText().toString());
            intent.putExtra("USERNAME", editUsername.getText().toString());
            intent.putExtra("NEGARA", negara);
            if (radiolk.isChecked()) {
                intent.putExtra("JK", "Laki-Laki");
            } else if (radiopr.isChecked()) {
                intent.putExtra("JK", "Perempuan");
            }
            startActivity(intent);
        } else {
            showAlert("Anda Harus Menyetujui Kententuan!!");
        }
        return null;
    }


    public void showAlert(String text) {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Peringatan");
        alert.setMessage(text);
        alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        alert.show();
    }
}

