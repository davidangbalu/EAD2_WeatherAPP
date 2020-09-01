package com.x00122898.weatherapiclient;

import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText searchCity;
    Button btn;
    TextView condition;
    TextView conditionOutput;
    TextView minTemp;
    TextView minTempOutput;
    TextView maxTemp;
    TextView maxTempOutput;
    TextView windSpeed;
    TextView windSpeedOutput;
    TextView windDirection;
    TextView windDirectionOutput;
    TextView outlook;
    TextView outlookOutput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchCity = findViewById(R.id.InputCity);

        condition = findViewById(R.id.condition);
        conditionOutput = findViewById(R.id.conditionOutput);
        minTemp = findViewById(R.id.minTemp);
        minTempOutput = findViewById(R.id.minTempOutput);
        maxTemp = findViewById(R.id.maxTemp);
        maxTempOutput = findViewById(R.id.maxTempOutput);
        windDirection = findViewById(R.id.windDirection);
        windDirectionOutput = findViewById(R.id.windDirectionOutput);
        windSpeed = findViewById(R.id.windSpeed);
        windSpeedOutput = findViewById(R.id.windSpeedOutput);
        outlook = findViewById(R.id.outlook);
        outlookOutput = findViewById(R.id.outlookOutput);



        btn = findViewById(R.id.btn_city);


        final DataService dataService = new DataService(MainActivity.this);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dataService.getWeatherByCity(searchCity.getText().toString(), new DataService.WeatherByCityResponse() {
                    @Override
                    public void onError(String message) {
                        Toast.makeText(MainActivity.this, "Not Found", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onResponse(WeatherInformation weatherInformation) {

                        conditionOutput.setText(weatherInformation.getConditions());

                        minTempOutput.setText(String.valueOf(weatherInformation.getMinTemp()));

                        maxTempOutput.setText(String.valueOf(weatherInformation.getMaxTemp()));

                        windDirectionOutput.setText(weatherInformation.getWindDirect());

                        windSpeedOutput.setText(String.valueOf(weatherInformation.getWindSpeed()));

                        outlookOutput.setText(weatherInformation.getOutlook());

                    }
                });

            }
        });

    }

}