package hu.marton.schpangli.eggs

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import hu.marton.schpangli.R
import hu.marton.schpangli.eggs.adapter.ChickenAdapter
import hu.marton.schpangli.model.Chicken
import kotlinx.android.synthetic.main.activity_eggs.*

class EggsActivity : AppCompatActivity(), ChickenAdapter.OnChickenClick {

    private var adapter: ChickenAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_eggs)

        adapter = ChickenAdapter(this)
        val list = arrayListOf<Chicken>(
            Chicken(1),
            Chicken(2),
            Chicken(3),
            Chicken(4),
            Chicken(5),
            Chicken(6),
            Chicken(7),
            Chicken(88)
        )
        adapter?.setList(list)
        chicken_list.adapter = adapter
    }

    override fun onChickenClick(item: Chicken) {
        Toast.makeText(this, item.numberOfEggs?.toString(), Toast.LENGTH_LONG).show()
    }
}
