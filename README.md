# ViewHolderArrayAdapter
A replacement of `ArrayAdapter` which makes use of `ViewHolder`s from the RecyclerView API.

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
Typically, you will create a `ViewHolderArrayAdapter`:
```kotlin
val spinner = findViewById<Spinner>(R.id.spinner)
val adapter = ViewHolderArrayAdapter(this, cheeses, { parent ->
    //create the overall view holder
    CheeseViewHolder.inflate(parent)
}, { parent ->
    //create the dropdown view holder
    CheeseDropDownViewHolder.inflate(parent)
}, { viewHolder, position, item ->
    //bind the overall view holder
    viewHolder.bind(item)
}, { viewHolder, position, item ->
    //bind the dropdown view holder
    viewHolder.bind(item)
})
spinner.adapter = adapter
```

If you want to use the same `ViewHolder` for both the dropdown and the selected item, you can use `SingleViewHolderArrayAdapter`. And if you have a simple view where only the text changes, you can use `TextViewHolderArrayAdapter`, or `SingleTextViewHolderArrayAdapter`

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
