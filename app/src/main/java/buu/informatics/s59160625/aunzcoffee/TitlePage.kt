package buu.informatics.s59160625.aunzcoffee


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_title_page.*
import buu.informatics.s59160625.aunzcoffee.databinding.FragmentTitlePageBinding
/**
 * A simple [Fragment] subclass.
 */
class TitlePage : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentTitlePageBinding>(inflater,
            R.layout.fragment_title_page,container, false)
        binding.titleBtnCoffee.setOnClickListener {view ->
            view.findNavController().navigate(R.id.action_title_page_to_coffeeList_page)
        }
        binding.titleBtnTea.setOnClickListener {view ->
            view.findNavController().navigate(R.id.action_title_page_to_tea_list)
        }
        setHasOptionsMenu(true)
        return binding.root
    }
}
