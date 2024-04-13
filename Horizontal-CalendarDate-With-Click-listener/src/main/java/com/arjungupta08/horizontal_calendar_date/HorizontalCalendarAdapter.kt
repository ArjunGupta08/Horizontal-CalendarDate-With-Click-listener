package com.arjungupta08.horizontal_calendar_date

import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import kotlin.collections.ArrayList

class HorizontalCalendarAdapter(private val listener: (calendarDateModel: CalendarDateModel, position: Int) -> Unit):
    RecyclerView.Adapter<HorizontalCalendarAdapter.CalendarViewHolder>(){

    private var list = ArrayList<CalendarDateModel>()
    private var adapterPosition = -1


    interface OnItemClickListener{
        fun onItemClick(ddMmYy: String, dd: String, day: String)
    }

    private var mListener: OnItemClickListener? = null

    fun setOnItemClickListener(listener: OnItemClickListener){
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

            val text = itemList.calendarYear
            val date = itemList.calendarDate
            val day = itemList.calendarDay
            mListener?.onItemClick(text,date,day)
            listener.invoke(itemList, position)
        }

        if (itemList.isSelected){
            holder.calendarDay.setTextColor(ContextCompat.getColor(holder.itemView.context, R.color.white))
            holder.calendarDate.setTextColor(ContextCompat.getColor(holder.itemView.context, R.color.white))
            holder.linear.setBackgroundResource(R.drawable.rectangle_fill)
        }else {
            holder.calendarDay.setTextColor(ContextCompat.getColor(holder.itemView.context, R.color.black))
            holder.calendarDate.setTextColor(ContextCompat.getColor(holder.itemView.context, R.color.black))
            holder.linear.setBackgroundResource(R.drawable.rectangle_outline)
        }
    }
    override fun getItemCount(): Int {
        return list.size
    }

    class CalendarViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val calendarDay : TextView= itemView.findViewById(R.id.tv_calendar_day)
            val calendarDate : TextView= itemView.findViewById(R.id.tv_calendar_date)
            val linear : LinearLayout= itemView.findViewById(R.id.linear_calendar)
    }

    fun setData(calendarList: ArrayList<CalendarDateModel>) {
        list.clear()
        list.addAll(calendarList)
        notifyDataSetChanged()
    }
}


