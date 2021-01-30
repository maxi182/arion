package com.example.rootstrapinterview.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.rootstrapinterview.R
import com.example.rootstrapinterview.data.model.characters.Character
import com.example.rootstrapinterview.extensions.loadImageBitmap
import kotlinx.android.synthetic.main.item_character.view.*


/**
 * Created by Maxi
 * since 21/12/2020
 */
class CharactersAdapter(
    private val context: Context, private val itemList: MutableList<Any>,
    private val itemClickLister: OnItemClickListener?
) :
    RecyclerView.Adapter<BaseViewHolder<*>>() {


    interface OnItemClickListener {
        fun onItemSelected(transaction: Character)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        return TransactionViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_character, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return itemList?.size
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when (holder) {
            is TransactionViewHolder -> holder.bind(
                itemList[position] as Character,
                position
            )
        }
    }

    inner class TransactionViewHolder(itemView: View) :
        BaseViewHolder<Character>(itemView) {
        override fun bind(item: Character, position: Int) {
            itemView?.img_character.loadImageBitmap(item.image!!)
            itemView.setOnClickListener { itemClickLister?.onItemSelected(item) }
        }
    }
}