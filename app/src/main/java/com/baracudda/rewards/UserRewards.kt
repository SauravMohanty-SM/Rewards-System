package com.baracudda.rewards

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import com.baracudda.rewards.DB.UserDatabase
import com.baracudda.rewards.models.Rewards
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class UserRewards : AppCompatActivity() {

    lateinit var database: UserDatabase
    private lateinit var textView: TextView
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_rewards)

        var userId: Long = intent.getLongExtra("UserID", 0)
        var userName: String = intent.getStringExtra("UserName").toString()

        database = UserDatabase.getDatabase(this)
        textView = findViewById(R.id.rewardsOfUser)
        button = findViewById(R.id.buttonInReward)

        button.setOnClickListener {
            startActivity(Intent(this, RewardDetails::class.java))
        }

        //TODO: Implemented to Add dummy values
//        GlobalScope.launch {
//            database.rewardDao().insertReward(Rewards(0,3,4,0))
//            database.rewardDao().insertReward(Rewards(0,5,1,3))
//            database.rewardDao().insertReward(Rewards(0,1,4,3))
//            database.rewardDao().insertReward(Rewards(0,8,9,2))
//            database.rewardDao().insertReward(Rewards(0,0,4,0))
//            database.rewardDao().insertReward(Rewards(0,3,0,1))
//            database.rewardDao().insertReward(Rewards(0,0,0,10))
//        }

        database.rewardDao().readReward().observe(this, Observer {
            for (i in it) {
                if (i.UserID == userId) {
                    val ser1 = i.Service1
                    val ser2 = i.Service2
                    val ser3 = i.Service3
                    database.serviceDao().readService().observe(this, Observer {
                        for (i in it) {
                            if (i.ServiceId.toInt() == 1) {
                                textView.append("Hey!! \n$userName \nService 1 reward : $ser1 * ${i.ServiceReward} = ${ser1*i.ServiceReward}")
                            } else if (i.ServiceId.toInt() == 2) {
                                textView.append("\nService 2 reward : $ser2 * ${i.ServiceReward} = ${ser2*i.ServiceReward}")
                            } else if (i.ServiceId.toInt() == 3) {
                                textView.append("\nService 3 reward : $ser3 * ${i.ServiceReward} = ${ser3*i.ServiceReward}")
                            }
                        }
                    })
                }
            }
        })
    }
}