package com.example.myapplication.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.myapplication.R
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.adapters.UserAdapter
import com.example.myapplication.dataclasses.UserData
import com.example.myapplication.viewmodel.UserViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var userViewModel: UserViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var userAdapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userViewModel = ViewModelProvider(this)[UserViewModel::class.java]

        recyclerView = findViewById(R.id.recyclerView)
        userAdapter = UserAdapter { user ->
            showDialog(user)
//            Toast.makeText(this,"Clicked ${user.name}", Toast.LENGTH_LONG).show()
        }

        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = userAdapter
        }

        userViewModel.users.observe(this, Observer {
            userAdapter.submitList(it)
        })

        userViewModel.fetchUsers()

    }

    fun showDialog(user: UserData){
        //Inflate the dialog as custom view
        val messageBoxView = LayoutInflater.from(this).inflate(R.layout.layout_user_details_dialog, null)

        //AlertDialogBuilder
        val messageBoxBuilder = AlertDialog.Builder(this).setView(messageBoxView)

        val userName = messageBoxView.findViewById<TextView>(R.id.unameTextView)
        val userEmail = messageBoxView.findViewById<TextView>(R.id.uemailTextView)
        val userPhone = messageBoxView.findViewById<TextView>(R.id.uphoneTextView)
        val userWebsite = messageBoxView.findViewById<TextView>(R.id.uwebsiteTextView)
        val userId = messageBoxView.findViewById<TextView>(R.id.useridTextView)

        userName.text = user.name
        userEmail.text = user.email
        userPhone.text = user.phone
        userWebsite.text = user.website
        userId.text = user.id.toString()

        //show dialog
        val  messageBoxInstance = messageBoxBuilder.show()

        messageBoxView.setOnClickListener { v->
            messageBoxInstance.dismiss()
        }
    }
}