package com.staqu.aidldemo;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainView, View.OnClickListener {

    private MainPresenter mPresenter;
    private EditText editText1;
    private EditText editText2;
    private TextView textViewResult;
    private Button resultButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpView();
        setUpPresenter();

    }


    private void setUpView() {
        editText1 = (EditText) findViewById(R.id.ed_FirstNumber);
        editText2 = findViewById(R.id.ed_SecondNumber);
        textViewResult = (TextView) findViewById(R.id.ed_Result);
        resultButton = findViewById(R.id.btn_Result);
        resultButton.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        mPresenter.onItemClicked();
    }

    private void setUpPresenter() {
        mPresenter = new MainPresenter(this);
    }


    @Override
    public String getNumber1() {
       return editText1.getText().toString().trim();

    }

    @Override
    public String getNumber2() {
       return editText2.getText().toString().trim();
    }

    @Override
    public void setResultNumber(int number) {
        textViewResult.setText(String.valueOf(number));

    }

}
