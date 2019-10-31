package buu.informatics.s59160625.aunzcoffee.Screens.Title


import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import buu.informatics.s59160625.aunzcoffee.R
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
        Toast.makeText(context,"หน้าแรก",Toast.LENGTH_LONG).show()
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.options_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item!!,
            view!!.findNavController())
                || super.onOptionsItemSelected(item)
    }
}