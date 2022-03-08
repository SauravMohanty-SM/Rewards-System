package com.baracudda.rewards

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.baracudda.rewards.Adepter.ServiceAdepter
import com.baracudda.rewards.Adepter.UserAdepter
import com.baracudda.rewards.DB.UserDatabase
import com.baracudda.rewards.models.Services
import com.baracudda.rewards.models.UserDetails
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class RewardDetails : AppCompatActivity() {

    lateinit var database: UserDatabase
    lateinit var arrayList: ArrayList<Services>
    private lateinit var userRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reward_details)

        database = UserDatabase.getDatabase(this)

        userRecyclerView = findViewById(R.id.RecyclerViewInRewardActivity)
        userRecyclerView.layoutManager = LinearLayoutManager(this)
        userRecyclerView.setHasFixedSize(true)


        //TODO: Implemented to Add dummy values
//        GlobalScope.launch {
//            database.serviceDao().insertService(Services(
//                0, "Walking", "You waking more you will rewarded more",
//                5, "5.5 * 5"
//            ))
//
//            database.serviceDao().insertService(Services(
//                0, "Running", "You running more you will rewarded more",
//                8, "8.0 * 3"
//            ))
//
//            database.serviceDao().insertService(Services(
//                0, "Sleeping", "You sleeping more you will rewarded more",
//                2, "1.5 * 30"
//            ))
//        }
        showData()
    }

    private fun showData() {
        arrayList = ArrayList()

        database.serviceDao().readService().observe(this, Observer {
            for (m in it) {
                Log.d("TAG", "The data is $m")
                arrayList.add(m)
            }
            userRecyclerView.adapter = ServiceAdepter(arrayList)
        })
    }
}