package buu.informatics.s59160625.aunzcoffee.screens.title


import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import buu.informatics.s59160625.aunzcoffee.R
import buu.informatics.s59160625.aunzcoffee.databinding.FragmentTitleBinding

/**
 * A simple [Fragment] subclass.
 */
class TitleFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentTitleBinding>(inflater,
            R.layout.fragment_title,container, false)
        var checkBtn: Int

        binding.titleBtnCoffee.setOnClickListener {
            checkBtn = 1
            it.findNavController().navigate(TitleFragmentDirections.actionTitlePageToCoffeeListPage(numBtn = checkBtn))
        }
        binding.titleBtnTea.setOnClickListener {
            checkBtn = 2
            it.findNavController().navigate(TitleFragmentDirections.actionTitlePageToCoffeeListPage(numBtn = checkBtn))
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
