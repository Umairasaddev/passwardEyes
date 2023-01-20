package com.example.passwardeyes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
EditText edittext;
boolean passwardVisible;
//    ImageView imageview_showhide_pass;
//EditText edittext_login_pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        edittext = findViewById(R.id.edittext);

        edittext.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                final int Right =2;
                if(event.getAction()==MotionEvent.ACTION_UP){
                    if(event.getRawX()>=edittext.getRight()-edittext.getCompoundDrawables()[Right].getBounds().width()) {

                        int selection = edittext.getSelectionEnd();
                        if(passwardVisible){

                            edittext.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.ic_baseline_visibility_off_24,0);
                            edittext.setTransformationMethod(PasswordTransformationMethod.getInstance());
                            passwardVisible = false;
                        }else
                        {
                            edittext.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.ic_baseline_visibility_24,0);
                            edittext.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                            passwardVisible = true;
                        }
                        edittext.setSelection(selection);
                        return true;
                    }
                }
                return false;
            }
        });


//        edittext_login_pass = findViewById(R.id.edittext_login_pass);
//        imageview_showhide_pass  = findViewById(R.id.imageview_showhide_pass);
//        imageview_showhide_pass.setImageResource(R.drawable.eyeclose);
//
//        imageview_showhide_pass.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (edittext_login_pass.getTransformationMethod().equals(HideReturnsTransformationMethod.getInstance())){
//                //if the passward is visible then hide it
//                edittext_login_pass.setTransformationMethod(PasswordTransformationMethod.getInstance());
//                imageview_showhide_pass.setImageResource(R.drawable.eyeopen);
//            }
//                else
//                {
//                    edittext_login_pass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
//                    imageview_showhide_pass.setImageResource(R.drawable.eyeclose);
//                }
//            }
//        });





    }
}