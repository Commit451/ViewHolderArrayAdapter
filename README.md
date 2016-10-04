# ViewHolderArrayAdapter
ArrayAdapter for use with a Spinner which makes use of `ViewHolder`s from the RecyclerView API

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

# But... Why?
Many times, you might have ViewHolders defined that can be shared between Spinners and RecyclerViews. This bridges the gap

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
