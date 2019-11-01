package buu.informatics.s59160625.aunzcoffee.Screens.CoffeeList


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.NavHostFragment
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
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentCoffeeListPageBinding>(inflater,
            R.layout.fragment_coffee_list_page,container, false)
        viewModel = ViewModelProviders.of(this).get(CoffeeListViewModel::class.java)
        binding.apply {
            button.text = viewModel.coffeeList[0]
            button.setOnClickListener{
                viewModel.num = 1
                goToIngrediantPage()
            }
            button2.text = viewModel.coffeeList[1]
            button2.setOnClickListener{
                viewModel.num = 2
                goToIngrediantPage()
            }
            button3.text = viewModel.coffeeList[2]
            button3.setOnClickListener{
                viewModel.num = 3
                goToIngrediantPage()
            }
            button4.text = viewModel.coffeeList[3]
            button4.setOnClickListener{
                viewModel.num = 4
                goToIngrediantPage()}
            button5.text = viewModel.coffeeList[4]
            button5.setOnClickListener{
                viewModel.num = 5
                goToIngrediantPage()
            }
        }
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        Log.i("CoffeeList", "CoffeeList Start")
    }

    private fun goToIngrediantPage() {
        viewModel.checkOnClick()
        val action = CoffeeListPageDirections.actionCoffeeListPageToCoffeeIngrediantPage(coffeeName = viewModel.name)
        NavHostFragment.findNavController(this).navigate(action)
    }
}