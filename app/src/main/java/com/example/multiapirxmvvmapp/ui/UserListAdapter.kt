package com.example.multiapirxmvvmapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.multiapirxmvvmapp.R
import com.example.multiapirxmvvmapp.data.network.model.User
import com.example.multiapirxmvvmapp.databinding.RvCardItemBinding

class UserListAdapter: RecyclerView.Adapter<UserListViewHolder>() {
    var allUserList = mutableListOf<User>()

    fun setData(users: List<User>){
        this.allUserList = users.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RvCardItemBinding.inflate(inflater, parent, false)
        return UserListViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return allUserList.size
    }

    override fun onBindViewHolder(holder: UserListViewHolder, position: Int) {
        val user = allUserList[position]
        holder.binding.textViewUserName.text = user.firstName +" "+ user.lastName
        holder.binding.textViewUserEmail.text = user.email

        Glide.with(holder.itemView.context).load(user.avatarImage)
            .placeholder(R.drawable.placeholder)
            .into(holder.binding.imageViewAvatar)
    }

}

class UserListViewHolder constructor(val binding: RvCardItemBinding): RecyclerView.ViewHolder(binding.root){

}
