# ViewHolderArrayAdapter
`ArrayAdapter` for use with a `Spinner` which makes use of `ViewHolder`s from the RecyclerView API

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
    compile 'com.github.Commit451:ViewHolderArrayAdapter:0.0.1'
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

    @Override
    protected CheeseViewHolder onCreateViewHolder(ViewGroup parent) {
        return CheeseViewHolder.inflate(parent);
    }

    @Override
    protected void onBindViewHolder(CheeseViewHolder holder, Cheese item, int position) {
        holder.bind(item);
    }
}
```
and setting the adapter on the spinner looks very typical:
```java
CheeseSpinnerAdapter adapter = new CheeseSpinnerAdapter(this, cheeses);
spinner.setAdapter(adapter);
```

# Why ViewHolder?
Many times, you might have `ViewHolder`s defined that can be shared between Spinners and RecyclerViews. This simple library bridges the gap.

# Limitations
Usage of ViewHolderArrayAdapter assumes that you want your Spinner dropdown items and the view you see when a selection is made to be the same.

License
--------

    Copyright 2016 Commit 451

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
