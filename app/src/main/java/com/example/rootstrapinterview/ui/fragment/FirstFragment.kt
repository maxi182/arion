package com.test.arion.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rootstrapinterview.R
import com.example.rootstrapinterview.data.model.characters.Character
import com.example.rootstrapinterview.ui.adapter.CharactersAdapter
import com.example.rootstrapinterview.ui.viewmodel.CharactersListViewModel
import kotlinx.android.synthetic.main.fragment_characters.*
import org.koin.androidx.viewmodel.ext.android.viewModel


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment(), CharactersAdapter.OnItemClickListener {

    private val charactersListViewModel by viewModel<CharactersListViewModel>()
    private var characterList = ArrayList<Any>()
    lateinit var characterAdapter: CharactersAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_characters, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        setupObservers()
        charactersListViewModel.fetchCharacters()

//        view.findViewById<Button>(R.id.button_first).setOnClickListener {
//            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
//        }
    }

    private fun setupObservers() {

        charactersListViewModel.charactersDataFetched.observe(
            viewLifecycleOwner,
            Observer { characters ->
                clearList()
                characterList?.addAll(characters.charactersList)
                characterAdapter?.notifyDataSetChanged()

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
            layoutManager = LinearLayoutManager(this.context)
            adapter = characterAdapter
        }
        characterAdapter?.notifyDataSetChanged()

    }

    override fun onItemSelected(transaction: Character) {
        //this go to nest fragment
    }
}