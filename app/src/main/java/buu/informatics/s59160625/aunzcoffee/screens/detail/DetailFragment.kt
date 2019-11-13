package buu.informatics.s59160625.aunzcoffee.screens.detail


import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import buu.informatics.s59160625.aunzcoffee.R
import buu.informatics.s59160625.aunzcoffee.database.CoffeeDatabase
import buu.informatics.s59160625.aunzcoffee.databinding.FragmentDetailBinding

/**
 * A simple [Fragment] subclass.
 */
class DetailFragment : Fragment() {
    lateinit var share_word: String
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentDetailBinding>(inflater,
            R.layout.fragment_detail,container, false)
        val application = requireNotNull(this.activity).application
        val dataSource = CoffeeDatabase.getInstance(application).coffeeDatabaseDao
        val viewModelFactory = DetailViewModelFactory(dataSource, application)
        val viewModel = ViewModelProviders.of(this, viewModelFactory).get(DetailViewModel::class.java)

        //***Call Argument***///
        val args = DetailFragmentArgs.fromBundle(arguments!!)
        share_word = args.coffeeName
        binding.ingrediantText.text = args.coffeeName ///***Use Argument***///

        viewModel.checkCoffeeToGetIngredient(args.coffeeName)

        val adapter = IngrediantAdapter()
        binding.ingrediantRecycleView.adapter = adapter
        viewModel.ingredientName.observe(this, Observer {
            it?.let {
                adapter.data = it
            }
        })

        val adapter2 = BrewAdapter()
        binding.brewRecycleView.adapter = adapter2
        viewModel.brewing.observe(this, Observer {
            it?.let {
                adapter2.data = it
            }
        })

        viewModel.allCoffee.observe(this, Observer {
            Log.i("data",it.toString())
            for (element in it) {
                if (element.coffeeName == args.coffeeName) {
                    binding.addBtn.text = "คุณได้เพิ่มเป็นรายการโปรดแล้ว"
                    binding.addBtn.setBackgroundColor(Color.RED)
                    binding.addBtn.isEnabled = false
                }
            }
        })

        binding.addBtn.setOnClickListener {
            viewModel.insert(args.coffeeName)
            Toast.makeText(context,"เพิ่มเป็นรายการโปรดเรียบร้อย",Toast.LENGTH_LONG).show()
        }

        setHasOptionsMenu(true)
        return binding.root
    }

    // Creating our Share Intent
    private fun getShareIntent() : Intent {
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.setType("text/plain")
            .putExtra(Intent.EXTRA_TEXT, getString(R.string.share_coffee_text, share_word))
        return shareIntent
    }

    // Starting an Activity with our new Intent
    private fun shareSuccess() {
        startActivity(getShareIntent())
    }

    // Showing the Share Menu Item Dynamically
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.ingrediant_menu, menu)
        // check if the activity resolves
        if (null == getShareIntent().resolveActivity(activity!!.packageManager)) {
            // hide the menu item if it doesn't resolve
            menu.findItem(R.id.share)?.isVisible = false
        }
    }

    // Sharing from the Menu
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.share -> shareSuccess()
        }
        return super.onOptionsItemSelected(item)
    }
}

