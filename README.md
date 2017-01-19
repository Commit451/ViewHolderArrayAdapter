# ViewHolderArrayAdapter
`ArrayAdapter` for use in replacement of `ArrayAdapter` which makes use of `ViewHolder`s from the RecyclerView API

[![Build Status](https://travis-ci.org/Commit451/ViewHolderArrayAdapter.svg?branch=master)](https://travis-ci.org/Commit451/ViewHolderArrayAdapter) [![](https://jitpack.io/v/Commit451/ViewHolderArrayAdapter.svg)](https://jitpack.io/#Commit451/ViewHolderArrayAdapter)

# Dependency
```gradle
allprojects {
    repositories {
        maven { url "https://jitpack.io" }
    }
}
```
and within your module's `build.gradle`

```gradle
dependencies {
    compile 'com.github.Commit451:ViewHolderArrayAdapter:insert.latest.version'
}
```

# Usage
See the sample project for full usage.
Typically, you will subclass `ViewHolderArrayAdapter` similar to how you would subclass `RecyclerView.Adapter`
```java
public class CheeseSpinnerAdapter extends ViewHolderArrayAdapter<Cheese, CheeseViewHolder> {

    //Required constructor, annoying
    public CheeseSpinnerAdapter(Context context, List<Cheese> objects) {
        super(context, objects);
    }

    @NonNull
    @Override
    protected CheeseViewHolder onCreateViewHolder(@NonNull ViewGroup parent) {
        return CheeseViewHolder.inflate(parent);
    }

    @NonNull
    @Override
    protected CheeseDropDownViewHolder onCreateDropDownViewHolder(@NonNull ViewGroup parent) {
        return CheeseDropDownViewHolder.inflate(parent);
    }

    @Override
    protected void onBindViewHolder(@NonNull CheeseViewHolder holder, Cheese item, int position) {
        holder.bind(item);
    }

    @Override
    protected void onBindDropDownViewHolder(@NonNull CheeseDropDownViewHolder holder, Cheese item, int position) {
        holder.bind(item);
    }
}
```
and setting the adapter on the spinner looks very typical:
```java
CheeseSpinnerAdapter adapter = new CheeseSpinnerAdapter(this, cheeses);
spinner.setAdapter(adapter);
```

If you want to use the same `ViewHolder` for both the dropdown and the selected item:
```java
public class CheeseSingleAdapter extends SingleViewHolderArrayAdapter<Cheese, CheeseViewHolder> {

    public CheeseSingleAdapter(Context context, List<Cheese> objects) {
        super(context, objects);
    }

    @NonNull
    @Override
    protected CheeseViewHolder onCreateSingleViewHolder(@NonNull ViewGroup parent) {
        return CheeseViewHolder.inflate(parent);
    }

    @Override
    protected void onBindSingleViewHolder(@NonNull CheeseViewHolder holder, Cheese item, int position) {
        holder.bind(item);
    }
}
```

And if you have a simple view where only the text changes, you can use `TextViewHolderArrayAdapter`:
```java
Spinner textSpinner = (Spinner) findViewById(R.id.text_spinner);
textSpinner.setAdapter(new TextViewHolderArrayAdapter<>(this, R.layout.item_spinner_cheese, R.layout.item_spinner_dropdown_cheese, cheeses));
```
And similarly, if they share the same `ViewHolder`:
```java
Spinner textSingleSpinner = (Spinner) findViewById(R.id.text_single_spinner);
textSingleSpinner.setAdapter(new TextSingleViewHolderArrayAdapter<>(this, R.layout.item_spinner_cheese, cheeses));
```

ViewHolderArrayAdapter is not just limited to Spinners, though that is what it was originally designed for. All in all, you could use it with:
- Spinner
- AutoCompleteTextView
- ListView (please don't use ListView)

# Why ViewHolder?
Many times, you might have `ViewHolder`s defined that can be shared between Spinners and RecyclerViews. This simple library bridges the gap. Also using `ViewHolder` is more efficient, as it forces recycling for spinners which can otherwise be overlooked.

License
--------

    Copyright 2017 Commit 451

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
