package com.example.assignment3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.GET;

public class MainActivity extends AppCompatActivity {
    private TextView totalCases;
    private TextView totalRecovered;
    private TextView totalDeaths;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        totalCases = findViewById(R.id.totalCases);
        totalRecovered = findViewById(R.id.totalRecovered);
        totalDeaths = findViewById(R.id.totalDeaths);

        getCovid();
    }

    private void getCovid() {
        Call<Covid> callCovid = RetrofitClient.getInstance().apiService().getCovid();
        callCovid.enqueue(new Callback<Covid>() {
            @Override
            public void onResponse(Call<Covid> call, Response<Covid> response) {
                Covid covidData = response.body();
                printCovid(covidData);
            }

            @Override
            public void onFailure(Call<Covid> call, Throwable t) {

            }
        });
    }

    private void printCovid(Covid covidData) {
        StringBuilder builderCases = new StringBuilder();
        StringBuilder builderRecovered = new StringBuilder();
        StringBuilder builderDeaths = new StringBuilder();

        builderCases.append(covidData.getTotalCases());
        totalCases.setText(builderCases.toString());
        builderRecovered.append(covidData.getTotalRecovered());
        totalRecovered.setText(builderRecovered.toString());
        builderDeaths.append(covidData.getTotalDeaths());
        totalDeaths.setText(builderDeaths.toString());
    }
}