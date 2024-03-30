package com.example.idzassignment1;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.idzassignment1.User;

public class DisplayActivity extends AppCompatActivity {

    private TextView textViewName, textViewDOB, textViewEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        // Find TextViews by their IDs
        textViewName = findViewById(R.id.textViewName);
        textViewDOB = findViewById(R.id.textViewDOB);
        textViewEmail = findViewById(R.id.textViewEmail);

        // Retrieve user information passed from MainActivity
        User user = (User) getIntent().getSerializableExtra("user");

        // Display user information in TextViews
        textViewName.setText(user.getName());
        textViewDOB.setText(user.getDob());
        textViewEmail.setText(user.getEmail());
    }
}
