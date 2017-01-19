package com.commit451.viewholderarrayadapter.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;

import com.commit451.viewholderarrayadapter.TextSingleViewHolderArrayAdapter;
import com.commit451.viewholderarrayadapter.TextViewHolderArrayAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Cheese> cheeses = load();

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        CheeseSpinnerAdapter adapter = new CheeseSpinnerAdapter(this, cheeses);
        spinner.setAdapter(adapter);

        Spinner singleSpinner = (Spinner) findViewById(R.id.single_spinner);
        singleSpinner.setAdapter(new CheeseSingleAdapter(this, cheeses));

        Spinner textSpinner = (Spinner) findViewById(R.id.text_spinner);
        textSpinner.setAdapter(new TextViewHolderArrayAdapter<>(this, R.layout.item_spinner_cheese, R.layout. item_spinner_dropdown_cheese, cheeses));

        Spinner textSingleSpinner = (Spinner) findViewById(R.id.text_single_spinner);
        textSingleSpinner.setAdapter(new TextSingleViewHolderArrayAdapter<>(this, R.layout.item_spinner_cheese, cheeses));

        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.text_autocomplete);
        autoCompleteTextView.setAdapter(new CheeseSingleAdapter(this, cheeses));
    }

    private ArrayList<Cheese> load() {
        ArrayList<Cheese> cheeses = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            cheeses.add(Cheeses.getRandomCheese());
        }
        return cheeses;
    }
}
