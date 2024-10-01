package com.example.form;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editTextName;
    private EditText editTextSurname;
    private EditText editTextEmail;
    private EditText editTextPhone;
    private EditText editTextPassword;
    private EditText editTextConfirmPassword;
    private Button SubmitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.editTextName);
        editTextSurname = findViewById(R.id.editTextSurname);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPhone = findViewById(R.id.editTextPhone);
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextConfirmPassword = findViewById(R.id.editTextConfirmPassword);
        SubmitButton = findViewById(R.id.SubmitButton);

        SubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString().trim();
                String suranme = editTextSurname.getText().toString().trim();
                String email = editTextEmail.getText().toString().trim();
                String phone = editTextPhone.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();
                String confirmpasword = editTextConfirmPassword.getText().toString().trim();

                if (name.isEmpty()) {
                    Toast.makeText(MainActivity.this,"prosze wporawdzić imie", Toast.LENGTH_SHORT).show();
                } else if (suranme.isEmpty()) {
                    Toast.makeText(MainActivity.this, "prosze wporawdzić nazwisko", Toast.LENGTH_SHORT).show();
                } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    Toast.makeText(MainActivity.this, "Niepoprawny adres e-mail", Toast.LENGTH_SHORT).show();
                } else if (phone.length()< 9){
                    Toast.makeText(MainActivity.this, "Niepoprawny numer telefonu", Toast.LENGTH_SHORT).show();
                } else if (password.length()<6){
                    Toast.makeText(MainActivity.this, "hasło jest za krótkie", Toast.LENGTH_SHORT).show();
                } else if (!confirmpasword.equals(password)) {
                    Toast.makeText(MainActivity.this, "hasła nie są identyczne", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "formularz przesłany poprawnie", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
