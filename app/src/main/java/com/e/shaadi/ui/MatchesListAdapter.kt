package com.e.shaadi.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.e.shaadi.databinding.MatchListItemBinding
import com.e.shaadi.models.Result


class MatchesListAdapter : RecyclerView.Adapter<MatchesListAdapter.ProfileViewHolder>() {

    var profileList = ArrayList<Result>()
    var clickListener : onClickHandler? = null

    fun setData(list: ArrayList<Result>) {
        this.profileList = list
        notifyDataSetChanged()
    }

    fun setListener(listener: onClickHandler) {
        clickListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val listItemBinding: MatchListItemBinding =
            MatchListItemBinding.inflate(layoutInflater, parent, false)
        return ProfileViewHolder(listItemBinding,clickListener)
    }

    override fun onBindViewHolder(holder: ProfileViewHolder, position: Int) {
        val data = profileList[position]
        holder.bind(data)
    }

    override fun getItemCount(): Int = profileList.size

    class ProfileViewHolder(var binding: MatchListItemBinding,var listener: onClickHandler?) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Result) {
            binding.data = data
            binding.imgAccept.setOnClickListener {
                data.status = true
                listener?.onClickViewItem(data,adapterPosition)
            }
            binding.imgDecline.setOnClickListener {
                data.status = false
                listener?.onClickViewItem(data,adapterPosition)
            }
        }
    }
}