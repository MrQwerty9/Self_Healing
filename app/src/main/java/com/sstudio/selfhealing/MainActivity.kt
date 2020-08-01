package com.sstudio.selfhealing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.sstudio.selfhealing.adapter.LocusAdapter
import com.sstudio.selfhealing.model.Locus
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var locusAdapter: LocusAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        locusAdapter = LocusAdapter(this)
//        listResultPresenterImpl = ListResultPresenterImpl(this, this)

//        listResultPresenterImpl.loadResult()
        rv_locus.layoutManager = LinearLayoutManager(this)
        rv_locus.adapter = locusAdapter
    }
}