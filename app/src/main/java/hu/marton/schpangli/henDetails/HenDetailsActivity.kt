package hu.marton.schpangli.henDetails

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import hu.marton.schpangli.R
import hu.marton.schpangli.henDetails.adapter.EggDateAdapter
import hu.marton.schpangli.network.model.Egg
import kotlinx.android.synthetic.main.activity_hen_details.*

class HenDetailsActivity: AppCompatActivity(), HenDetailsScreen {

    private var presenter: HenDetailsPresenter? = null
    private var adapter: EggDateAdapter? = null
    private var chickenId: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hen_details)

        presenter = HenDetailsPresenter(this, this)
        adapter = EggDateAdapter()
        date_list.adapter = adapter

        chickenId = intent.getStringExtra("chickenId")
        chickenId?.let { presenter?.getHenDetails(it) }
    }

    override fun loadHenDetails(eggsList: ArrayList<Egg>?, sumEgg: Int?) {
        eggsList?.let { adapter?.setList(it) }
        tv_number_eggs.text = chickenId + " számú csirke " + sumEgg?.toString() + "db tojást tojt."
    }

    override fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

}