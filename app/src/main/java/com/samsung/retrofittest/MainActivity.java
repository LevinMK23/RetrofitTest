package com.samsung.retrofittest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private final YandexPredictorApi api = YandexPredictorService.getYandexPredictorApi();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView output = findViewById(R.id.textView);
        EditText input = findViewById(R.id.editTextTextPersonName);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(e -> {
            String text = input.getText().toString();
            input.setText("");
            api.getPredict(YandexPredictorService.API_KEY, "en", text, 5)
                    .enqueue(new Callback<Predict>() {
                        @Override
                        public void onResponse(@NonNull Call<Predict> call, @NonNull Response<Predict> response) {
                            if (response.isSuccessful()) {
                                Predict predict = response.body();
                                assert predict != null;
                                String result = String.join("\n", predict.getText());
                                output.setText(result);
                            }
                        }

                        @Override
                        public void onFailure(@NonNull Call<Predict> call, @NonNull Throwable t) {
                            Log.e("retrofit", t.toString());
                        }
                    });
        });

    }
}