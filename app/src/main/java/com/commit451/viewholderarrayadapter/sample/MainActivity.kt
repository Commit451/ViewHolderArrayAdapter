package com.commit451.viewholderarrayadapter.sample

import android.os.Bundle
import android.widget.AutoCompleteTextView
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.commit451.viewholderarrayadapter.SingleTextViewHolderArrayAdapter
import com.commit451.viewholderarrayadapter.TextViewHolderArrayAdapter
import com.commit451.viewholderarrayadapter.ViewHolderArrayAdapter
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cheeses = load()

        val spinner = findViewById<Spinner>(R.id.spinner)
        val adapter = ViewHolderArrayAdapter(
            context = this,
            objects = cheeses,
            onCreateViewHolder = { parent ->
                CheeseViewHolder.inflate(parent)
            },
            onCreateDropDownViewHolder = { parent ->
                CheeseDropDownViewHolder.inflate(parent)
            },
            onBindViewHolder = { viewHolder, _, item ->
                viewHolder.bind(item)
            },
            onBindDropDownViewHolder = { viewHolder, _, item ->
                viewHolder.bind(item)
            }
        )
        spinner.adapter = adapter

        val singleSpinner = findViewById<Spinner>(R.id.single_spinner)
        singleSpinner.adapter = CheeseSingleAdapter(this, cheeses)

        val textSpinner = findViewById<Spinner>(R.id.text_spinner)
        textSpinner.adapter = TextViewHolderArrayAdapter(this, R.layout.item_spinner_cheese, R.layout.item_spinner_dropdown_cheese, cheeses)

        val textSingleSpinner = findViewById<Spinner>(R.id.text_single_spinner)
        textSingleSpinner.adapter = SingleTextViewHolderArrayAdapter(this, R.layout.item_spinner_cheese, cheeses)

        val autoCompleteTextView = findViewById<AutoCompleteTextView>(R.id.text_autocomplete)
        autoCompleteTextView.setAdapter(CheeseSingleAdapter(this, cheeses))
    }

    private fun load(): ArrayList<Cheese> {
        val cheeses = ArrayList<Cheese>()
        for (i in 0..99) {
            cheeses.add(Cheeses.randomCheese)
        }
        return cheeses
    }
}
