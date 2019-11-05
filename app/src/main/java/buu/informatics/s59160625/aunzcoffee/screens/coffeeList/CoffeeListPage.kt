package buu.informatics.s59160625.aunzcoffee.screens.coffeeList


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import buu.informatics.s59160625.aunzcoffee.R
import buu.informatics.s59160625.aunzcoffee.databinding.FragmentCoffeeListPageBinding
/**
 * A simple [Fragment] subclass.
 */
class CoffeeListPage : Fragment() {
    private lateinit var viewModel: CoffeeListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentCoffeeListPageBinding>(inflater,
            R.layout.fragment_coffee_list_page,container, false)
        viewModel = ViewModelProviders.of(this).get(CoffeeListViewModel::class.java)

        val args = CoffeeListPageArgs.fromBundle(arguments!!)

        if(args.numBtn == 1){
            val adapter = CoffeeListAdapter()
            adapter.replaceItems(viewModel.coffeeList)
            binding.coffeeListRecycleView.adapter = adapter
        }else{
            val adapter = TeaListAdapter()
            adapter.replaceTeaItems(viewModel.teaList)
            binding.coffeeListRecycleView.adapter = adapter
        }
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        Log.i("CoffeeList", "CoffeeList Start")
    }

}