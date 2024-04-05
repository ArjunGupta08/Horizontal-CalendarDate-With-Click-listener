package com.arjun.horizontalcalendardate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.arjungupta08.horizontal_calendar_date.HorizontalCalendarAdapter
import com.arjungupta08.horizontal_calendar_date.HorizontalCalendarSetUp

class MainActivity : AppCompatActivity(), HorizontalCalendarAdapter.OnItemClickListener {

    private lateinit var recyclerView: RecyclerView
    private lateinit var tvDateMonth: TextView
    private lateinit var ivCalendarNext: ImageView
    private lateinit var ivCalendarPrevious: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvDateMonth = findViewById(R.id.text_date_month)
        recyclerView = findViewById(R.id.recyclerView)
        ivCalendarNext = findViewById(R.id.iv_calendar_next)
        ivCalendarPrevious = findViewById(R.id.iv_calendar_previous)

        val calendarSetUp = HorizontalCalendarSetUp()
        calendarSetUp.setUpCalendarAdapter(recyclerView, this@MainActivity)
        calendarSetUp.setUpCalendarPrevNextClickListener(ivCalendarNext, ivCalendarPrevious, this@MainActivity)
    }

    override fun onItemClick(text: String, date: String, day: String) {
        findViewById<TextView>(R.id.selectedDate).text = "Selected date: $text"
        findViewById<TextView>(R.id.selectedDD).text = "Selected DD: $date"
        findViewById<TextView>(R.id.selectedDay).text = "Selected day: $day"
    }
}