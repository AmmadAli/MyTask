## Project Overview:
* BaseFragments is being used to have common functionality.
* Application have one Activity and two fragments.
* NewsListFragment is used to display list of item fetched from server and NewsDetailFragment is used to display detail.



## Project Details
* Project is developed using Kotlin, Android Studio version 3.5 and Gradle version 5.4.1.
* Project is developed using MVVM clean architecture with live data and data binding  which are part of android Jetpack.
* Kotlin Coroutines are used in the project.
* Koin is used for dependency injection. There are few modules written like NetworkModule, RepositoryModule and NewsListingModule in AppModule file.
* Retrofit is used for network calls with Gson.
* DiffUtil is used with Recycler view adapter
* Navigation Component is used for navigation

## Steps to run:
* Clone the project or download it as zip file and extract in a directory.
* Import project in Android studio using existing studio project option.
* Create an emulator or run directly on device by clicking the run button from Android studio.

##Improvements:
* Currently Application has simple design that can be improved.
* More information fields can be added.
* Pagination can be applied using android PagedList which is part of android JetPack
* Testing can be done using JUnit, Mockito, espresso and some other libraries.