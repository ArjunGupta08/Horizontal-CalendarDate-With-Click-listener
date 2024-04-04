package com.arjun.horizontalcalendardate

import android.content.Context
import android.widget.AdapterView.OnItemClickListener
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

class CalendarSetUp() {

    private val sdf = SimpleDateFormat("MMMM yyyy", Locale.ENGLISH)
    private val cal = Calendar.getInstance(Locale.ENGLISH)
    private val currentDate = Calendar.getInstance(Locale.ENGLISH)
    private val dates = ArrayList<Date>()
    private lateinit var adapter: CalendarAdapter
    private val calendarList2 = ArrayList<CalendarDateModel>()

    /*
     * Set up click listener
     */
    fun setUpCalendarClickListener(ivCalendarNext: ImageView, ivCalendarPrevious: ImageView, listener: CalendarAdapter.onItemClickListener) {
        ivCalendarNext.setOnClickListener {
            cal.add(Calendar.MONTH, 1)
            setUpCalendar(listener)
        }
        ivCalendarPrevious.setOnClickListener {
            cal.add(Calendar.MONTH, -1)
            if (cal == currentDate)
                setUpCalendar(listener)
            else
                setUpCalendar(listener)
        }
    }


    /*
     * Setting up adapter for recyclerview
     */
    fun setUpCalendarAdapter(recyclerView: RecyclerView, listener : CalendarAdapter.onItemClickListener) {
        val snapHelper: SnapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(recyclerView)
        adapter = CalendarAdapter { calendarDateModel: CalendarDateModel, position: Int ->
            calendarList2.forEachIndexed { index, calendarModel ->
                calendarModel.isSelected = index == position
            }
            adapter.setData(calendarList2)
            adapter.setOnItemClickListener(listener)
        }
        recyclerView.adapter = adapter

        setUpCalendar(listener)
    }

    /*
     * Function to setup calendar for every month
     */
    private fun setUpCalendar(listener: CalendarAdapter.onItemClickListener) {
        val calendarList = ArrayList<CalendarDateModel>()
//        tvDateMonth.text = sdf.format(cal.time)
        val monthCalendar = cal.clone() as Calendar
        val maxDaysInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH)
        dates.clear()
        monthCalendar.set(Calendar.DAY_OF_MONTH, 1)
        while (dates.size < maxDaysInMonth) {
            dates.add(monthCalendar.time)
            calendarList.add(CalendarDateModel(monthCalendar.time))
            monthCalendar.add(Calendar.DAY_OF_MONTH, 1)
        }
        calendarList2.clear()
        calendarList2.addAll(calendarList)
        adapter.setOnItemClickListener(listener)
        adapter.setData(calendarList)
    }

}