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

> **Step 3** recycler View SetUp

        recyclerView = findViewById(R.id.recyclerView)
        
        tvDateMonth = findViewById(R.id.text_date_month)
        ivCalendarNext = findViewById(R.id.iv_calendar_next)
        ivCalendarPrevious = findViewById(R.id.iv_calendar_previous)

        val calendarSetUp = HorizontalCalendarSetUp()
        
        val tvMonth = calendarSetUp.setUpCalendarAdapter(recyclerView, this@MainActivity)
        tvDateMonth.text = tvMonth

        // SetUp your previous and next month keys
        calendarSetUp.setUpCalendarPrevNextClickListener(ivCalendarNext, ivCalendarPrevious, this@MainActivity) {
            tvDateMonth.text = it
        }
> **Step-4** Handle your previous and next month keys

    // implement interface in your activity
    class MainActivity : AppCompatActivity(), HorizontalCalendarAdapter.OnItemClickListener {

    override fun onItemClick(ddMmYy: String, dd: String, day: String) {
        findViewById<TextView>(R.id.selectedDate).text = "Selected date: $ddMmYy"
        findViewById<TextView>(R.id.selectedDD).text = "Selected DD: $dd"
        findViewById<TextView>(R.id.selectedDay).text = "Selected day: $day"
    }

[![](https://jitpack.io/v/ArjunGupta08/Horizontal-CalendarDate-With-Click-listener.svg)](https://jitpack.io/#ArjunGupta08/Horizontal-CalendarDate-With-Click-listener)
