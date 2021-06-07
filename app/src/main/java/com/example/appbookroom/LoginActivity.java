package com.example.appbookroom;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingUtil;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.appbookroom.databinding.ActivityLoginBinding;
import com.example.appbookroom.databinding.DialogLoginBinding;

public class LoginActivity extends AppCompatActivity {
    ActivityLoginBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_login);

        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                LayoutInflater layoutInflater = LayoutInflater.from(LoginActivity.this);
                DialogLoginBinding dialogLoginBinding = DialogLoginBinding.inflate(layoutInflater);
                builder.setView(dialogLoginBinding.getRoot());
                AlertDialog alertDialog = builder.create();
                dialogLoginBinding.btnCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertDialog.dismiss();
                    }
                });
                dialogLoginBinding.imgCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertDialog.dismiss();
                    }
                });

                int width = (int) (getResources().getDisplayMetrics().widthPixels * 0.92);
                int height = (int) (getResources().getDisplayMetrics().heightPixels * 0.35);
                alertDialog.getWindow().setBackgroundDrawableResource(R.drawable.shape_dialog);
                alertDialog.getWindow().setLayout(width, height);
                alertDialog.show();

            }
        });
    }

}