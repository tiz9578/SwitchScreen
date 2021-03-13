package com.example.switchscreen;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class secondScreen extends Activity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.second_layout);

        Intent activityThatCalled = getIntent();

        String previousActivity = activityThatCalled.getExtras().getString("callingActivity");

        TextView callingActivityMessage = (TextView)
                findViewById(R.id.calling_activity_textView);

        callingActivityMessage.append(" " + previousActivity);
    }

    public void onSendUserName(View view) {
        EditText userNameET = (EditText)
                findViewById(R.id.user_name_edit_text);
        String username = String.valueOf(userNameET.getText());

        Intent goingBack = new Intent();
        goingBack.putExtra("userName", username);

        setResult(RESULT_OK, goingBack);

        finish();

    }


}
