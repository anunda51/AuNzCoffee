package buu.informatics.s59160625.aunzcoffee.screens.list


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import buu.informatics.s59160625.aunzcoffee.R
import buu.informatics.s59160625.aunzcoffee.databinding.FragmentListBinding

/**
 * A simple [Fragment] subclass.
 */
class ListFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentListBinding>(inflater,
            R.layout.fragment_list,container, false)
        val viewModel = ViewModelProviders.of(this).get(ListViewModel::class.java)

        val args = ListFragmentArgs.fromBundle(arguments!!)

        viewModel.setData(args.numBtn)

        val adapter = ListAdapter()
        binding.coffeeListRecycleView.adapter = adapter
        viewModel.coffee.observe(this, Observer {
            it?.let {
                adapter.data = it
            }
        })

        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        Log.i("CoffeeList", "CoffeeList Start")
    }

}