import android.os.Bundle
import android.view.MenuItem
import androidx.navigation.fragment.navArgs
import com.example.rootstrapinterview.R
import com.example.rootstrapinterview.extensions.loadImageBitmap
import kotlinx.android.synthetic.main.fragment_detail.*


class SecondFragment : BaseFragment() {

    private val args by navArgs<SecondFragmentArgs>()
    override val layoutResource: Int
        get() = R.layout.fragment_detail

    override fun setupFragment(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        showDatails()
            }

    private fun showDatails() {
        args?.let {
            img_character?.loadImageBitmap(args?.currentCharacter?.image)
            text_name?.setText(args?.currentCharacter?.name)
            text_species?.setText(args?.currentCharacter?.species)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item?.itemId) {
            android.R.id.home -> activity?.onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }
}