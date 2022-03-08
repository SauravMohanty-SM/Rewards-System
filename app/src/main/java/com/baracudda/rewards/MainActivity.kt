package com.baracudda.rewards

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.baracudda.rewards.Adepter.UserAdepter
import com.baracudda.rewards.DB.UserDatabase
import com.baracudda.rewards.databinding.ActivityMainBinding
import com.baracudda.rewards.models.UserDetails
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity(), UserAdepter.NameClicked {

    private lateinit var binding: ActivityMainBinding
    lateinit var database: UserDatabase
    lateinit var arrayList: ArrayList<UserDetails>
    private lateinit var userRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.fab.setOnClickListener { view ->
            Toast.makeText(this, "Not Implemented Yet", Toast.LENGTH_SHORT).show()
        }

        database = UserDatabase.getDatabase(this)

        userRecyclerView = findViewById(R.id.RecyclerViewInMainActivity)
        userRecyclerView.layoutManager = LinearLayoutManager(this)
        userRecyclerView.setHasFixedSize(true)


        //TODO: Implemented to Add dummy values
//        GlobalScope.launch {
//            database.userDao().insertUser(
//                UserDetails(
//                    0, "Saurav", "11/20/2000", "11/20/2000", "Movie",
//                    0
//                )
//            )
//
//            database.userDao().insertUser(
//                UserDetails(
//                    0, "Monaj", "11/20/2000", "11/20/2000", "Movie",
//                    1
//                )
//            )
//
//            database.userDao().insertUser(
//                UserDetails(
//                    0, "Suraj", "11/20/2000", "11/20/2000", "Room",
//                    0
//                )
//            )
//
//            database.userDao().insertUser(
//                UserDetails(
//                    0, "Saurav", "11/20/2000", "11/20/2000", "Movie",
//                    0
//                )
//            )
//
//            database.userDao().insertUser(
//                UserDetails(
//                    0, "Monaj", "11/20/2000", "11/20/2000", "Movie",
//                    1
//                )
//            )
//
//            database.userDao().insertUser(
//                UserDetails(
//                    0, "Suraj", "11/20/2000", "11/20/2000", "Room",
//                    0
//                )
//            )
//
//            database.userDao().insertUser(
//                UserDetails(
//                    0, "Saurav", "11/20/2000", "11/20/2000", "Movie",
//                    0
//                )
//            )
//        }

        showData()
    }

    private fun showData() {

        arrayList = ArrayList()

        database.userDao().readUser().observe(this, Observer {
            for (i in it) {
                Log.d("TAG", "The data is $i")
                arrayList.add(i)
            }
            userRecyclerView.adapter = UserAdepter(arrayList, this)
        })

    }

    override fun onItemClicked(item: Long, name: String) {
        var intent = Intent(this, UserRewards::class.java)
        intent.putExtra("UserID", item)
        intent.putExtra("UserName", name)
        startActivity(intent)
    }

}