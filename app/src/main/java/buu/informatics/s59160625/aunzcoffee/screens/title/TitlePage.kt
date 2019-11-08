package buu.informatics.s59160625.aunzcoffee.screens.title


import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import buu.informatics.s59160625.aunzcoffee.R
import buu.informatics.s59160625.aunzcoffee.database.CoffeeDatabase
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

        val application = requireNotNull(this.activity).application
        val dataSource = CoffeeDatabase.getInstance(application).coffeeDatabaseDao
        val viewModelFactory = TitleViewModelFactory(dataSource, application)
        val viewModel = ViewModelProviders.of(this, viewModelFactory).get(TitleViewModel::class.java)
        binding.titleViewModel = viewModel

        binding.titleBtnCoffee.setOnClickListener {view ->
            viewModel.checktBtn = 1
            view.findNavController().navigate(TitlePageDirections.actionTitlePageToCoffeeListPage(numBtn = viewModel.checktBtn))
        }
        binding.titleBtnTea.setOnClickListener {view ->
            viewModel.checktBtn = 2
            view.findNavController().navigate(TitlePageDirections.actionTitlePageToCoffeeListPage(numBtn = viewModel.checktBtn))
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
