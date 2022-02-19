package com.printoverit.todoroutineapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_score.*

class ScoreActivity : AppCompatActivity() {
    private var mUserName:String?=null
    private var mCorrectAnswers:String?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)
        mUserName=intent.getStringExtra(Constants.USER_NAME)
        mCorrectAnswers=intent.getStringExtra(Constants.CORRECT_ANSWERS)
        player_name.text="Bas ab Game Khatam Apne Apne Ghar Jaro :) $mUserName with points $mCorrectAnswers"
    }
}