import BaseFragment
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.rootstrapinterview.R
import com.example.rootstrapinterview.data.model.characters.Character
import com.example.rootstrapinterview.ui.adapter.CharactersAdapter
import com.example.rootstrapinterview.ui.viewmodel.CharactersListViewModel
import kotlinx.android.synthetic.main.fragment_characters.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class FirstFragment : BaseFragment(), CharactersAdapter.OnItemClickListener {

    private val charactersListViewModel by viewModel<CharactersListViewModel>()
    private var characterList = ArrayList<Any>()
    lateinit var characterAdapter: CharactersAdapter

    override val layoutResource: Int
        get() = R.layout.fragment_characters

    override fun setupFragment(savedInstanceState: Bundle?) {
        setupRecyclerView()
        setupObservers()
        charactersListViewModel.fetchCharacters()
    }

    private fun setupObservers() {
        charactersListViewModel.charactersDataFetched.observe(
            viewLifecycleOwner,
            Observer { characters ->
                clearList()
                characterList?.addAll(characters.charactersList)
                characterAdapter?.notifyDataSetChanged()

            })

        charactersListViewModel.errorMessage.observe(
            viewLifecycleOwner,
            Observer { error ->
                showSnackBar(root_view, getString(error))

            })
    }

    private fun clearList() {
        characterList.clear()
        characterAdapter?.notifyDataSetChanged()
    }

    private fun setupRecyclerView() {

        characterAdapter =
            CharactersAdapter(requireContext(), characterList, this)
        recycler_chracters?.apply {
            layoutManager = GridLayoutManager(this.context, 3)
            adapter = characterAdapter
        }
        characterAdapter?.notifyDataSetChanged()

    }

    override fun onItemSelected(character: Character) {

        val actions = FirstFragmentDirections.actionFirstFragmentToSecondFragment(character)
        findNavController().navigate(actions)
    }
}