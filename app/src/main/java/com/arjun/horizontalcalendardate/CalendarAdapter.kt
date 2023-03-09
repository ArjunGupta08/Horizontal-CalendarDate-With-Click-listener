package com.arjun.horizontalcalendardate

import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import kotlin.collections.ArrayList

class CalendarAdapter(private val listener: (calendarDateModel: CalendarDateModel, position: Int) -> Unit):
    RecyclerView.Adapter<CalendarAdapter.CalendarViewHolder>(){

    private var list = ArrayList<CalendarDateModel>()
    var adapterPosition = -1


    interface onItemClickListener{
        fun onItemClick(text: String, date: String, day: String)
    }

    private var mListener: onItemClickListener? = null

    fun setOnItemClickListener(listener: onItemClickListener){
        mListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CalendarViewHolder {
        val inflater : LayoutInflater = LayoutInflater.from(parent.context)
        val view: View = inflater.inflate(R.layout.date_layout,parent,false)
        return CalendarViewHolder(view)
    }


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: CalendarViewHolder, position: Int) {
        val itemList = list[position]
        holder.calendarDay.text = itemList.calendarDay
        holder.calendarDate.text = itemList.calendarDate

        holder.itemView.setOnClickListener {
            adapterPosition = position
            notifyItemRangeChanged(0, list.size)

            val text = itemList.calendarYear.toString()
            val date = itemList.calendarDate
            val day = itemList.calendarDay
            mListener?.onItemClick(text,date,day)
        }
        if (position == adapterPosition){
            holder.calendarDay.setTextColor(ContextCompat.getColor(holder.itemView.context, R.color.white))
            holder.calendarDate.setTextColor(ContextCompat.getColor(holder.itemView.context, R.color.white))
            holder.linear.background = holder.itemView.context.getDrawable(R.drawable.rectangle_fill)
        }else {
            holder.calendarDay.setTextColor(ContextCompat.getColor(holder.itemView.context, R.color.black))
            holder.calendarDate.setTextColor(ContextCompat.getColor(holder.itemView.context, R.color.black))
            holder.linear.background = holder.itemView.context.getDrawable(R.drawable.rectangle_outline)
        }

    }
    override fun getItemCount(): Int {
        return list.size
    }

    class CalendarViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val calendarDay = itemView.findViewById<TextView>(R.id.tv_calendar_day)
            val calendarDate = itemView.findViewById<TextView>(R.id.tv_calendar_date)
            val linear = itemView.findViewById<LinearLayout>(R.id.linear_calendar)
}

    fun setData(calendarList: ArrayList<CalendarDateModel>) {
        list.clear()
        list.addAll(calendarList)
        notifyDataSetChanged()
    }
}


