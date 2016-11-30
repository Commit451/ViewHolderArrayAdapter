package com.commit451.viewholderarrayadapter.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Spinner;

import com.commit451.viewholderarrayadapter.TextViewHolderArrayAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = (Spinner) findViewById(R.id.spinner);

        ArrayList<Cheese> cheeses = load();
        CheeseSpinnerAdapter adapter = new CheeseSpinnerAdapter(this, cheeses);
        spinner.setAdapter(adapter);

        Spinner textSpinner = (Spinner) findViewById(R.id.text_spinner);
        textSpinner.setAdapter(new TextViewHolderArrayAdapter<>(this, R.layout.item_spinner_cheese, load()));
    }

    private ArrayList<Cheese> load() {
        ArrayList<Cheese> cheeses = new ArrayList<>();
        for (int i=0; i<100; i++) {
            cheeses.add(Cheeses.getRandomCheese());
        }
        return cheeses;
    }
}
