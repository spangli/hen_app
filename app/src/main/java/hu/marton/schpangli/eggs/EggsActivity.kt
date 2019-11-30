package hu.marton.schpangli.eggs

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import hu.marton.schpangli.R
import hu.marton.schpangli.eggs.adapter.ChickenAdapter
import hu.marton.schpangli.model.Hen
import kotlinx.android.synthetic.main.activity_eggs.*

class EggsActivity : AppCompatActivity(), ChickenAdapter.OnChickenClick, EggsScreen {

    private var adapter: ChickenAdapter? = null
    private var presenter: EggsPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_eggs)

        adapter = ChickenAdapter(this)
        presenter = EggsPresenter(this, this)
        presenter?.getHens()

        chicken_list.adapter = adapter
    }

    override fun loadHens(list: ArrayList<Hen>) {
        adapter?.setList(list)
    }

    override fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onChickenClick(item: hu.marton.schpangli.model.Hen) {
        Toast.makeText(this, "", Toast.LENGTH_LONG).show()
    }
}
