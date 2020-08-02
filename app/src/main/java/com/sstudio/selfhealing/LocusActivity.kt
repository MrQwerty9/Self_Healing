package com.sstudio.selfhealing

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.sstudio.selfhealing.GlobalVar.locusInput
import com.sstudio.selfhealing.adapter.LocusAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.dialog_locus.*

class LocusActivity : AppCompatActivity() {

    private lateinit var locusAdapter: LocusAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        locusAdapter = LocusAdapter(this)
//        listResultPresenterImpl = ListResultPresenterImpl(this, this)

//        listResultPresenterImpl.loadResult()
        rv_locus.layoutManager = LinearLayoutManager(this)
        rv_locus.adapter = locusAdapter
        locusAdapter.notifyDataSetChanged()

        btn_next.setOnClickListener {
            if (0 in locusInput){
                Toast.makeText(this, "Harap isi semua bidang", Toast.LENGTH_SHORT).show()
            }else {
                if (locusInput.sum() >= 26) {
                    startActivity(Intent(this, EmotionActivity::class.java))
                }else{
                    dialog()
                }
                repeat(locusInput.size) {
                    Log.d("mytag", "locus $it: ${locusInput[it]}")
                }
            }
        }
    }

    private fun dialog(){
        val dialogAdd = Dialog(this)
        dialogAdd.setContentView(R.layout.dialog_locus)

        dialogAdd.btn_locus_next.setOnClickListener {
            startActivity(Intent(this, HealingLocusActivity::class.java))
            dialogAdd.dismiss()
        }
        dialogAdd.btn_locus_Cancel.setOnClickListener {
            dialogAdd.dismiss()
        }
        dialogAdd.show()
    }
}
//pernyataan (-), dijawab YA diskor 1, dijawab TIDAK diskor 2.
//pernyataan (+) dijawab YA diskor 2, dijawab TIDAK diskor 1.

//Nilai batas untuk locus of Control = 26, Nilai batas untuk kematangan emosi = 22,
//Nilai batas untuk perilaku beresiko = 22, nilai batas keputusan rasional= 42