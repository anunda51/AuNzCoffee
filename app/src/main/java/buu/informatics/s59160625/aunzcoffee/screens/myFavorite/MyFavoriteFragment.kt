package buu.informatics.s59160625.aunzcoffee.screens.myFavorite


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
import buu.informatics.s59160625.aunzcoffee.database.CoffeeDatabase
import buu.informatics.s59160625.aunzcoffee.databinding.FragmentMyFavoriteBinding

/**
 * A simple [Fragment] subclass.
 */
class MyFavoriteFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentMyFavoriteBinding>(inflater,
            R.layout.fragment_my_favorite,container, false)
        val application = requireNotNull(this.activity).application
        val dataSource = CoffeeDatabase.getInstance(application).coffeeDatabaseDao
        val viewModelFactory = MyFavoriteViewModelFactory(dataSource, application)
        val viewModel = ViewModelProviders.of(this, viewModelFactory).get(MyFavoriteViewModel::class.java)
        binding.myFavoriteViewModel = viewModel

        viewModel.allCoffee.observe(this, Observer {
            val adapter = MyFavortieAdapter()
            binding.recycleView.adapter = adapter
            it?.let {
                adapter.data = it
            }
        })

        binding.deleteAllButton.setOnClickListener {
            viewModel.onClear()
            Log.i("database", "database is clear!")
        }

        return binding.root
    }


}
