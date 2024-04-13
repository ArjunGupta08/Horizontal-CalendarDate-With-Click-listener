# Horizontal CalendarDate With Click listener

[![](https://jitpack.io/v/ArjunGupta08/Horizontal-CalendarDate-With-Click-listener.svg)](https://jitpack.io/#ArjunGupta08/Horizontal-CalendarDate-With-Click-listener)

## [See Demo](https://youtube.com/shorts/YQ8cCuMc9JY?feature=share)
- it shows an horizontal row of dates and days of an perticular month.
- You can switch betweeen months easily.
<img align="right" src="https://github.com/ArjunGupta08/Horizontal-CalendarDate-With-Click-listener/assets/85922120/38ad50e2-0297-4d44-977a-e65c7a12dc2f" width="250" />

# How To

To get a Git project into your build:

> **Step 1.** Add the JitPack repository to your build file

Add it in your root build.gradle at the end of repositories:

     dependencyResolutionManagement {
    		repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    		repositories {
                         google()
                         mavenCentral()
                         maven { url uri("https://jitpack.io") }    			     
    		}
    	}

> **Step 2.** Add the dependency

     dependencies {
    	  implementation ("com.github.ArjunGupta08:Horizontal-CalendarDate-With-Click-listener:1.1.0")
    	}

> **Step-3** SetUp your Click Listeners

    // implement interface in your activity
    class MainActivity : AppCompatActivity(), HorizontalCalendarAdapter.OnItemClickListener {

    override fun onItemClick(ddMmYy: String, dd: String, day: String) {
        findViewById<TextView>(R.id.selectedDate).text = "Selected date: $ddMmYy"
        findViewById<TextView>(R.id.selectedDD).text = "Selected DD: $dd"
        findViewById<TextView>(R.id.selectedDay).text = "Selected day: $day"
    }

> **Step 4** recycler View SetUp

        tvDateMonth = findViewById(R.id.text_date_month)
        ivCalendarNext = findViewById(R.id.iv_calendar_next)
        ivCalendarPrevious = findViewById(R.id.iv_calendar_previous)

        recyclerView = findViewById(R.id.recyclerView)     
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        val calendarSetUp = HorizontalCalendarSetUp()
        
        val tvMonth = calendarSetUp.setUpCalendarAdapter(recyclerView, this@MainActivity) // Make sure to implement the interface as guided in step-3
        tvDateMonth.text = tvMonth

        // SetUp your previous and next month keys
        calendarSetUp.setUpCalendarPrevNextClickListener(ivCalendarNext, ivCalendarPrevious, this@MainActivity) {
            tvDateMonth.text = it
        }


[![](https://jitpack.io/v/ArjunGupta08/Horizontal-CalendarDate-With-Click-listener.svg)](https://jitpack.io/#ArjunGupta08/Horizontal-CalendarDate-With-Click-listener)
