package buu.informatics.s59160625.aunzcoffee


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import buu.informatics.s59160625.aunzcoffee.databinding.FragmentCoffeeIngrediantPageBinding
import buu.informatics.s59160625.aunzcoffee.databinding.FragmentTitlePageBinding

/**
 * A simple [Fragment] subclass.
 */
class CoffeeIngrediantPage : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentCoffeeIngrediantPageBinding>(inflater,
            R.layout.fragment_coffee_ingrediant_page,container, false)
        setHasOptionsMenu(true)
        return binding.root
    }
}
