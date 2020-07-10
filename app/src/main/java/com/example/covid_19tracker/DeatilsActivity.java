package com.example.covid_19tracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DeatilsActivity extends AppCompatActivity {

    private int positionCountry;
    TextView tvCountry,tvCases,tvRecovered,tvCritical,tvActive,tvTodayCases,tvTotalDeaths,tvTodayDeaths;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deatils);
        Intent intent=getIntent();
        positionCountry=intent.getIntExtra("position",0);
        getSupportActionBar().setTitle("Deatils "+AffectedCountries.countryModleList.get(positionCountry).getCountry());

        tvCountry=findViewById(R.id.tvCountry1);
        tvCases=findViewById(R.id.tvCases1);
        tvRecovered=findViewById(R.id.tvRecovered1);
        tvCritical=findViewById(R.id.tvCritical1);
        tvActive=findViewById(R.id.tvActive1);
        tvTodayCases=findViewById(R.id.tvTodayCases1);
        tvTotalDeaths=findViewById(R.id.tvTodayDeaths1);
        tvTodayDeaths=findViewById(R.id.tvTodayDeaths1);



        tvCountry.setText(AffectedCountries.countryModleList.get(positionCountry).getCountry());
        tvCases.setText(AffectedCountries.countryModleList.get(positionCountry).getCases());
        tvRecovered.setText(AffectedCountries.countryModleList.get(positionCountry).getRecovered());
        tvCritical.setText(AffectedCountries.countryModleList.get(positionCountry).getCrirtical());
        tvActive.setText(AffectedCountries.countryModleList.get(positionCountry).getActive());
        tvTodayCases.setText(AffectedCountries.countryModleList.get(positionCountry).getTodayCases());
        tvTotalDeaths.setText(AffectedCountries.countryModleList.get(positionCountry).getDeaths());
        tvTodayDeaths.setText(AffectedCountries.countryModleList.get(positionCountry).getTodayDeaths());

    }
}
