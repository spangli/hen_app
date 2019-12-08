package hu.marton.schpangli.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import hu.marton.schpangli.R
import hu.marton.schpangli.eggs.EggsActivity
import hu.marton.schpangli.gate.GateActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tyukmenu.setOnClickListener { startActivity(Intent(this,EggsActivity::class.java)) }
        kapumenu.setOnClickListener { startActivity(Intent(this,GateActivity::class.java)) }
    }
}
