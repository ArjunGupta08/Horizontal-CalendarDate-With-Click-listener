# Horizontal CalendarDate With Click listener

[![](https://jitpack.io/v/ArjunGupta08/Horizontal-CalendarDate-With-Click-listener.svg)](https://jitpack.io/#ArjunGupta08/Horizontal-CalendarDate-With-Click-listener)

## [See Demo](https://youtube.com/shorts/YQ8cCuMc9JY?feature=share)

- it shows an horizontal row of dates and days of an perticular month

# How To

To get a Git project into your build:

> **Step 1.** Add the JitPack repository to your build file

Add it in your root build.gradle at the end of repositories:

     dependencyResolutionManagement {
    		repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    		repositories {
    			mavenCentral()
    			maven { url uri("https://jitpack.io") }
    		}
    	}

> **Step 2.** Add the dependency

     dependencies {
    	        implementation ("com.github.ArjunGupta08:Horizontal-CalendarDate-With-Click-listener:Tag")
    	}

[![](https://jitpack.io/v/ArjunGupta08/Horizontal-CalendarDate-With-Click-listener.svg)](https://jitpack.io/#ArjunGupta08/Horizontal-CalendarDate-With-Click-listener)

> **Step 3** recycler View SetUp

        recyclerView = findViewById(R.id.recyclerView)
        
        ivCalendarNext = findViewById(R.id.iv_calendar_next)
        ivCalendarPrevious = findViewById(R.id.iv_calendar_previous)

        val calendarSetUp = HorizontalCalendarSetUp()
        calendarSetUp.setUpCalendarAdapter(recyclerView, this@MainActivity)
        calendarSetUp.setUpCalendarPrevNextClickListener(ivCalendarNext, ivCalendarPrevious, this@MainActivity)


