package com.printoverit.todoroutineapp

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_question.*

class QuestionActivity : AppCompatActivity() , View.OnClickListener {

    private var mCurrentPosition:Int=1
    private var mQUestionList:ArrayList<Questions>?=null
    private var mOptionsSelected:Int =0
    private var mCorrectAnswers:Int =0
    private var mUserName:String? =null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)
        mUserName=intent.getStringExtra(Constants.USER_NAME)
         mQUestionList=Constants.getQuestions()
         setQuestions()
        tv_option_one.setOnClickListener(this)
        tv_option_two.setOnClickListener(this)
        tv_option_three.setOnClickListener(this)
        tv_option_four.setOnClickListener(this)
        btn_submit.setOnClickListener {

            if (mOptionsSelected==0){
                mCurrentPosition++
                when{
                    mCurrentPosition<=mQUestionList!!.size->{
                        setQuestions()
                    }
                    else->{
                        Toast.makeText(this,"You have Successfully Completed this Quiz!!",Toast.LENGTH_SHORT).show()
                        val intent=Intent(this,ScoreActivity::class.java)
                        intent.putExtra(Constants.USER_NAME,mUserName)
                        intent.putExtra(Constants.CORRECT_ANSWERS,mCorrectAnswers.toString())
                        startActivity(intent)
                        finish()
                    }
                }
            }else{
                val question=mQUestionList?.get(mCurrentPosition-1)
                if (question!!.correctAnswer!=mOptionsSelected){
                    answerView(mOptionsSelected,R.drawable.wrong_option_border_bg)
                }else{
                    mCorrectAnswers++
                }

                answerView(question.correctAnswer,R.drawable.correct_option_border_bg)
                if (mCurrentPosition==mQUestionList!!.size){
                    btn_submit.text="FINISH"
                }else{
                    btn_submit.text="GO TO NEXT QUESTION"
                }
                mOptionsSelected=0
            }
        }
    }
    private  fun setQuestions(){
        setDefaultViews()
        if (mCurrentPosition==mQUestionList!!.size){
            btn_submit.text="NEXT"
        }else{
            btn_submit.text="SUBMIT"
        }
        //mCurrentPosition=1
        val questions= mQUestionList?.get(mCurrentPosition-1)
        progressBar.progress=mCurrentPosition
        tv_progress.setText("$mCurrentPosition"+"/"+progressBar.max)
        tv_question.text=questions!!.question
        iv_image.setImageResource(questions.image)
        tv_option_one.text=questions.optionOne
        tv_option_two.text=questions.optionTwo
        tv_option_three.text=questions.optionThree
        tv_option_four.text=questions.optionFour
    }

    private fun setDefaultViews(){
        val options=ArrayList<TextView>()
        options.add(0,tv_option_one)
        options.add(1,tv_option_two)
        options.add(2,tv_option_three)
        options.add(3,tv_option_four)
        for (option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.background=ContextCompat.getDrawable(this,R.drawable.default_option_border_bg)
        }
    }
    private fun answerView(answer :Int , drawableView: Int){
        when(answer){
            1-> {
                tv_option_one.background=ContextCompat.getDrawable(this,drawableView)
            }
            2-> {
                tv_option_two.background=ContextCompat.getDrawable(this,drawableView)
            }
            3-> {
                tv_option_three.background=ContextCompat.getDrawable(this,drawableView)
            }
            4-> {
                tv_option_four.background=ContextCompat.getDrawable(this,drawableView)
            }
        }

    }
    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.tv_option_one ->{
                setSelectedOption(tv_option_one,1)
            }
            R.id.tv_option_two  ->{
                setSelectedOption(tv_option_two,2)
            }
            R.id.tv_option_three  ->{
                setSelectedOption(tv_option_three,3)
            }
            R.id.tv_option_four  ->{
                setSelectedOption(tv_option_four,4)
            }
        }
    }
    private fun setSelectedOption(tv:TextView , selectedOption:Int){
        setDefaultViews()
        mOptionsSelected=selectedOption
        tv.setTextColor(Color.parseColor("#FF000000"))
        tv.background=ContextCompat.getDrawable(this,R.drawable.selected_option_border_bg)

    }
}