package com.sstudio.selfhealing.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sstudio.selfhealing.GlobalVar.locusInput
import com.sstudio.selfhealing.R
import kotlinx.android.synthetic.main.item_quiz_v1.view.*


class LocusAdapter(private var context: Context) :
    RecyclerView.Adapter<LocusAdapter.ViewHolder>() {

    var quizLocus = arrayOf(
        context.getString(R.string.locus_1),
        context.getString(R.string.locus_4),
        context.getString(R.string.locus_5),
        context.getString(R.string.locus_2),
        context.getString(R.string.locus_6),
        context.getString(R.string.locus_3),
        context.getString(R.string.locus_7),
        context.getString(R.string.locus_8),
        context.getString(R.string.locus_9),
        context.getString(R.string.locus_10),
        context.getString(R.string.locus_11),
        context.getString(R.string.locus_12),
        context.getString(R.string.locus_13),
        context.getString(R.string.locus_14),
        context.getString(R.string.locus_15),
        context.getString(R.string.locus_16),
        context.getString(R.string.locus_17),
        context.getString(R.string.locus_18),
        context.getString(R.string.locus_19),
        context.getString(R.string.locus_20),
        context.getString(R.string.locus_21),
        context.getString(R.string.locus_22),
        context.getString(R.string.locus_23),
        context.getString(R.string.locus_24))

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_quiz_v1, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return quizLocus.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val locusPositive = intArrayOf(2,5,6,8,11,13,14,16,17,20,21,23)
        val number = position+1

        holder.textNo.text = number.toString()
        holder.textQuiz.text = quizLocus[position]

            holder.rbLocusY.setOnCheckedChangeListener { _, checked ->

                if (checked){
                    holder.rbLocusN.isChecked = false
                    if (number in locusPositive) { //quiz positive
                        locusInput[position] = 2
                        Log.d("myTag", "$position ${locusInput[position]}")
                    }else {
                        locusInput[position] = 1
                        Log.d("myTag", "$position ${locusInput[position]}")
                    }
                }

            }
            holder.rbLocusN.setOnCheckedChangeListener { _, checked ->
                if (checked) {
                    holder.rbLocusY.isChecked = false
                    if (number in locusPositive) { //quiz positive
                        locusInput[position] = 1
                        Log.d("myTag", "$position ${locusInput[position]}")
                    }else {
                        locusInput[position] = 2
                        Log.d("myTag", "$position ${locusInput[position]}")
                    }
                }
            }
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val textNo = view.tv_number_locus
        val cardView = view.cv_locus
        val rbLocusY = view.rb_locus_y
        val rbLocusN = view.rb_locus_n
        val textQuiz = view.tv_quiz_locus
    }
}