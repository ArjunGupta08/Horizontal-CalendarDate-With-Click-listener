package com.arjungupta08.horizontal_calendar_date

import android.widget.ImageView
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

class HorizontalCalendarSetUp() {

    private val sdf = SimpleDateFormat("MMMM yyyy", Locale.ENGLISH)
    private val cal = Calendar.getInstance(Locale.ENGLISH)
    private val currentDate = Calendar.getInstance(Locale.ENGLISH)
    private val dates = ArrayList<Date>()
    private lateinit var adapter: HorizontalCalendarAdapter
    private val calendarList2 = ArrayList<CalendarDateModel>()

    /*
     * Set up click listener
     */
    fun setUpCalendarPrevNextClickListener(ivCalendarNext: ImageView, ivCalendarPrevious: ImageView, listener: HorizontalCalendarAdapter.OnItemClickListener, month : (String) -> Unit ) {
        ivCalendarNext.setOnClickListener {
            cal.add(Calendar.MONTH, 1)
            val monthDate = setUpCalendar(listener)
            month.invoke(monthDate)
        }
        ivCalendarPrevious.setOnClickListener {
            cal.add(Calendar.MONTH, -1)
            if (cal == currentDate) {
                val monthDate = setUpCalendar(listener)
                month.invoke(monthDate)
            } else {
                val monthDate = setUpCalendar(listener)
                month.invoke(monthDate)
            }
        }
    }


    /*
     * Setting up adapter for recyclerview
     */
    fun setUpCalendarAdapter(recyclerView: RecyclerView, listener : HorizontalCalendarAdapter.OnItemClickListener) : String {
        val snapHelper: SnapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(recyclerView)

        adapter = HorizontalCalendarAdapter() { calendarDateModel: CalendarDateModel, position: Int ->
            calendarList2.forEachIndexed { index, calendarModel ->
                calendarModel.isSelected = index == position
            }
        }
        adapter.setData(calendarList2)
        adapter.setOnItemClickListener(listener)
        recyclerView.adapter = adapter

        return setUpCalendar(listener)
    }

    /*
     * Function to setup calendar for every month
     */
    private fun setUpCalendar(listener: HorizontalCalendarAdapter.OnItemClickListener) : String {
        val calendarList = ArrayList<CalendarDateModel>()
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
        return sdf.format(cal.time)
    }

}