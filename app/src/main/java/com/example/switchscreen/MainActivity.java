package com.example.switchscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void OnClickGetName(View view) {
        Intent getNameScreenIntent = new Intent(this,
                secondScreen.class);

        final int result = 1;
        getNameScreenIntent.putExtra("callingActivity", "MainActivity");

        //start the second screen without expect a result
        //startActivity(getNameScreenIntent);

        ///start the second screen expect a result
        startActivityForResult(getNameScreenIntent, result);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        TextView usernameMessage = (TextView)
                findViewById(R.id.user_name_message);

        String nameSentBack = data.getStringExtra("userName");

        //usernameMessage.append(" " + nameSentBack);
        String s = getString(R.string.the_user_name_is);
        usernameMessage.setText(s+ ": "+ nameSentBack);

    }
}