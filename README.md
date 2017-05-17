# kotlinplate
Kotlin Android MVP boilerplate starter project.

Project contains a detailed sample app that implements MVP architecture using Kotlin, Dagger2, RxJava2 and Retrofit. Application also provides full testing implementation. Project is created using latest [AndroidStudio Canary build](http://tools.android.com/download/studio/canary/latest/) so some updates will be needed.

For `code` check [develop branch](https://github.com/marsicdev/kotlinplate/tree/develop).

**Notice:**
Created for personal use and still work in progress

## Project

### Packaging

#### The app has following packages
1. **data**: It contains all the data accessing and manipulating components
2. **di**: Dependency providing classes using Dagger2
3. **ui**: View classes along with their corresponding Presenters and Contracts
4. **utils**: Extension functions

#### Build flavors

* **debug**
* **release** 

## Resources

### Libraries

1. [Kotlin - Statically typed programming language for the JVM, Android and the browser](https://kotlinlang.org)
1. [Dagger2 - A fast dependency injector for Android and Java](https://github.com/googlesamples/android-architecture)
2. [RxJava2 - Reactive Extensions for the JVM](https://github.com/amitshekhariitbhu/RxJava2-Android-Samples)
3. [RxAndroid - Reactive Extensions for Android](https://github.com/ReactiveX/RxAndroid)
4. [Retrofit - Type-safe HTTP client for Android and Java](https://github.com/amitshekhariitbhu/Fast-Android-Networking)
4. [OkHttp - An HTTP+HTTP/2 client for Android and Java](https://github.com/janishar/PlaceHolderView)

### References 

1. [Google - Android Architecture Blueprints](https://github.com/googlesamples/android-architecture)
2. [MindorksOpenSource - Android MVP Architecture](https://github.com/MindorksOpenSource/android-mvp-architecture)

## License


    The MIT License (MIT)

    Copyright (c) 2017 Marko Arsić

    Permission is hereby granted, free of charge, to any person obtaining a copy
    of this software and associated documentation files (the "Software"), to deal
    in the Software without restriction, including without limitation the rights
    to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
    copies of the Software, and to permit persons to whom the Software is
    furnished to do so, subject to the following conditions:

    The above copyright notice and this permission notice shall be included in all
    copies or substantial portions of the Software.

    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
    IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
    FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
    AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
    LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
    OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
    SOFTWARE.
