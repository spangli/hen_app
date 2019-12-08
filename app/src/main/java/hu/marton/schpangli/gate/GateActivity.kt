package hu.marton.schpangli.gate

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import hu.marton.schpangli.R
import kotlinx.android.synthetic.main.activity_gate.*

class GateActivity: AppCompatActivity() {

	private var isOpened = false
	private var error = false

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_gate)

		setUpGate()

		btn_gate.setOnClickListener {
			isOpened = !isOpened
			setUpGate()
		}
	}

	private fun setUpGate() {
		if (!error) {
			if (isOpened) {
				tv_status.text = "A kapu nyitva"
				btn_gate.text = "Zár"
			} else {
				tv_status.text = "A kapu zárva"
				btn_gate.text = "Nyit"
			}
		} else {
			tv_status.text = "Hiba lépett fel"
			btn_gate.visibility = View.INVISIBLE
		}
	}
}