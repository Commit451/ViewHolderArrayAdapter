package com.commit451.viewholderarrayadapter.sample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.AutoCompleteTextView
import android.widget.Spinner
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
        val adapter = ViewHolderArrayAdapter(this, cheeses, { parent ->
            CheeseViewHolder.inflate(parent)
        }, { parent ->
            CheeseDropDownViewHolder.inflate(parent)
        }, { viewHolder, position, item ->
            viewHolder.bind(item)
        }, { viewHolder, position, item ->
            viewHolder.bind(item)
        })
        spinner.adapter = adapter

        val singleSpinner = findViewById<Spinner>(R.id.single_spinner)
        singleSpinner.adapter = CheeseSingleAdapter(this, cheeses)

        val textSpinner = findViewById<View>(R.id.text_spinner) as Spinner
        textSpinner.adapter = TextViewHolderArrayAdapter(this, R.layout.item_spinner_cheese, R.layout.item_spinner_dropdown_cheese, cheeses)

        val textSingleSpinner = findViewById<View>(R.id.text_single_spinner) as Spinner
        textSingleSpinner.adapter = SingleTextViewHolderArrayAdapter(this, R.layout.item_spinner_cheese, cheeses)

        val autoCompleteTextView = findViewById<View>(R.id.text_autocomplete) as AutoCompleteTextView
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
