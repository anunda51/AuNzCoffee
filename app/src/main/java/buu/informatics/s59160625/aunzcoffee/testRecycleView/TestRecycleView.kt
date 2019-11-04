package buu.informatics.s59160625.aunzcoffee.testRecycleView


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import buu.informatics.s59160625.aunzcoffee.R
import buu.informatics.s59160625.aunzcoffee.databinding.FragmentCoffeeListPageBinding
import buu.informatics.s59160625.aunzcoffee.databinding.FragmentTestRecycleViewBinding
import kotlinx.android.synthetic.main.fragment_test_recycle_view.*

/**
 * A simple [Fragment] subclass.
 */
class TestRecycleView : Fragment() {
//    private lateinit var adapter: MyAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentTestRecycleViewBinding>(inflater,
            R.layout.fragment_test_recycle_view,container, false)
        val items = listOf(
            MyData("AAA","BBB"),
            MyData("AAA","BBB"),
            MyData("AAA","BBB")
        )
        val adapter = MyAdapter()
        adapter.replaceItems(items)
        binding.recycleView.adapter = adapter
        return binding.root
//        return inflater.inflate(R.layout.fragment_test_recycle_view, container, false)
    }


}
