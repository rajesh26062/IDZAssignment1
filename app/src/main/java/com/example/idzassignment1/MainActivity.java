package com.example.idzassignment1;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
public class MainActivity extends AppCompatActivity {
    private EditText editTextName, editTextDOB, editTextEmail;
    private Button buttonSubmit;
    private ArrayList<User> userList = new ArrayList<>();
    public boolean isDateValid(String dateString) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        sdf.setLenient(false);
        try {
            Date date = sdf.parse(dateString);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
    public boolean isValidEmail(String email) {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextName = findViewById(R.id.editTextName);
        editTextDOB = findViewById(R.id.editTextDOB);
        editTextEmail = findViewById(R.id.editTextEmail);
        buttonSubmit = findViewById(R.id.buttonSubmit);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString();
                String dob = editTextDOB.getText().toString();
                String email = editTextEmail.getText().toString();


                if (name.isEmpty() || dob.isEmpty() || email.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!isValidEmail(email)) {
                    Toast.makeText(MainActivity.this, "Invalid email format", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!isDateValid(dob)){
                    Toast.makeText(MainActivity.this, "Invalid DOB format", Toast.LENGTH_SHORT).show();
                    return;
                }
                User user = new User(name,dob,email);
                userList.add(user);
                Intent intent = new Intent(MainActivity.this, DisplayActivity.class);
                intent.putExtra("user", user);
                startActivity(intent);
            }
        });
    }
}
