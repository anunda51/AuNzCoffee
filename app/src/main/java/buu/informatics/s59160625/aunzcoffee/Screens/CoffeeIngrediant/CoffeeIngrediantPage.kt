package buu.informatics.s59160625.aunzcoffee.Screens.CoffeeIngrediant


import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import buu.informatics.s59160625.aunzcoffee.R
import buu.informatics.s59160625.aunzcoffee.databinding.FragmentCoffeeIngrediantPageBinding

/**
 * A simple [Fragment] subclass.
 */
class CoffeeIngrediantPage : Fragment() {
    private lateinit var viewModel: CoffeeIngrediantViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentCoffeeIngrediantPageBinding>(inflater,
            R.layout.fragment_coffee_ingrediant_page,container, false)
        viewModel = ViewModelProviders.of(this).get(CoffeeIngrediantViewModel::class.java)

        //***Call Argument***///
        val args = CoffeeIngrediantPageArgs.fromBundle(arguments!!)

        binding.ingrediantText.text = args.coffeeName ///***Use Argument***///
        setHasOptionsMenu(true)
        return binding.root
    }

    // Creating our Share Intent
    private fun getShareIntent() : Intent {

        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.setType("text/plain")
            .putExtra(Intent.EXTRA_TEXT, getString(R.string.share_coffee_text, "Hello"))
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
            menu.findItem(R.id.share)?.setVisible(false)
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

