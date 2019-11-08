package buu.informatics.s59160625.aunzcoffee.testRecycleView


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import buu.informatics.s59160625.aunzcoffee.R
import buu.informatics.s59160625.aunzcoffee.databinding.FragmentTestRecycleViewBinding

/**
 * A simple [Fragment] subclass.
 */
class TestRecycleView : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentTestRecycleViewBinding>(inflater,
            R.layout.fragment_test_recycle_view,container, false)
        val viewModel = ViewModelProviders.of(this).get(MyViewModel::class.java)

        val adapter = MyAdapter()
        adapter.replaceItems(viewModel.items)
        binding.recycleView.adapter = adapter

//      myViewModel.itemss.observe(viewLifecycleOwner, Observer {
//      it?.let {
//          adapter._data =
//        }
//      })
        return binding.root
    }


}
