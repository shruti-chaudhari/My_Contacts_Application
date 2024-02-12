package com.example.myapplication.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.dataclasses.UserData

class UserAdapter(private val onItemClick: (UserData) -> Unit) :
    RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    private var userList = ArrayList<UserData>()

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        private val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
        private val emailTextView: TextView = itemView.findViewById(R.id.emailTextView)
        private val phoneTextView: TextView = itemView.findViewById(R.id.phoneTextView)

        fun bind(user: UserData) {
            nameTextView.text = "Name:: " + user.name
            emailTextView.text = "Email:: " + user.email
            phoneTextView.text = "Phone:: " + user.phone
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.layout_item_user, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = userList[position]
        holder.bind(user)
        holder.itemView.setOnClickListener { onItemClick(user) }
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun submitList(list: List<UserData>) {
        this.userList = list as ArrayList<UserData>
        notifyDataSetChanged()
    }
}