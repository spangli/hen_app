package hu.marton.schpangli.main

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import hu.marton.schpangli.R
import hu.marton.schpangli.eggs.EggsActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tyukmenu.setOnClickListener { startActivity(Intent(this,EggsActivity::class.java)) }
    }
}
