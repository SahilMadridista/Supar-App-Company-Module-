package com.example.companyquizapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class SignupActivity extends AppCompatActivity {

   AutoCompleteTextView CompanyIndustryET,CompanyTypeET;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_signup);

      CompanyIndustryET = findViewById(R.id.company_industry_et);
      CompanyTypeET = findViewById(R.id.company_type_et);
      String[] industries = getResources().getStringArray(R.array.industries);
      String[] types = getResources().getStringArray(R.array.companyType);

      ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
              R.layout.actv_single_item, R.id.actv_text,industries);
      CompanyIndustryET.setAdapter(adapter);

      ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,
              R.layout.actv_single_item, R.id.actv_text,types);
      CompanyTypeET.setAdapter(adapter2);



   }

}