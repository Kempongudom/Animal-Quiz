package com.example.animalquiz

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat

class QuizQuestionActivity : AppCompatActivity(),View.OnClickListener {

    private var mSelectedPosition : Int = 0
    private var mCurrentPosition : Int = 1
    private var mQuestionList : ArrayList<Question>? = null
    private var mCorrectAnwer : Int = 0
    private var mUserName : String? = null


    private var tvOptionOne : TextView? = null
    private var tvOptionTwo : TextView? = null
    private var tvOptionThree : TextView? = null
    private var tvOptionFour : TextView? = null
    private var btnSubmit : Button? = null
    private var ivImage : ImageView? = null
    private var progresBarLine : ProgressBar? = null
    private var tvProgressBarNumber : TextView? = null
    private var tvQuestion : TextView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)

        tvOptionOne = findViewById(R.id.tv_optionOne)
        tvOptionTwo = findViewById(R.id.tv_optionTwo)
        tvOptionThree = findViewById(R.id.tv_optionThree)
        tvOptionFour = findViewById(R.id.tv_optionFour)
        btnSubmit = findViewById(R.id.btn_submit)
        ivImage = findViewById(R.id.iv_image)
        progresBarLine = findViewById(R.id.progressBar_line)
        tvProgressBarNumber = findViewById(R.id.progressBar_number)
        tvQuestion = findViewById(R.id.tv_question)

        mUserName = intent.getStringExtra(Constrains.USER_NAME)

        mQuestionList = Constrains.getQuestion()

        defaultOptionView()

        setQuestion()

        tvOptionOne?.setOnClickListener(this)
        tvOptionTwo?.setOnClickListener(this)
        tvOptionThree?.setOnClickListener(this)
        tvOptionFour?.setOnClickListener(this)
        btnSubmit?.setOnClickListener(this)
    }

    private fun defaultOptionView(){
        val options = ArrayList<TextView>()

        tvOptionOne?.let {
            options.add(0,it)
        }
        tvOptionTwo?.let {
            options.add(1,it)
        }
        tvOptionThree?.let{
            options.add(2,it)
        }
        tvOptionFour?.let {
            options.add(3, it)
        }

        for(option in options){
            option.setTextColor(Color.parseColor("#3a5a40"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,R.drawable.option_border
            )
        }
    }

    private fun answerView(answer : Int , drawableView : Int){
        when(answer){
            1 -> {
                tvOptionOne?.background = ContextCompat.getDrawable(this,drawableView)
            }
            2 -> {
                tvOptionTwo?.background = ContextCompat.getDrawable(this,drawableView)
            }
            3 -> {
                tvOptionThree?.background = ContextCompat.getDrawable(this,drawableView)
            }
            4 -> {
                tvOptionFour?.background = ContextCompat.getDrawable(this,drawableView)
            }
        }

    }

    private fun setQuestion(){

        val question : Question = mQuestionList!![mCurrentPosition-1]
        defaultOptionView()
        tvQuestion?.text = question.questions
        ivImage?.setImageResource(question.image)
        progresBarLine?.progress = mCurrentPosition
        tvProgressBarNumber?.text = "$mCurrentPosition/${progresBarLine?.max}"
        tvOptionOne?.text = question.optionOne
        tvOptionTwo?.text = question.optionTwo
        tvOptionThree?.text = question.optionThree
        tvOptionFour?.text = question.optionFour

        if(mCurrentPosition == mQuestionList!!.size){
            btnSubmit?.text = "Finish"
        }else{
            btnSubmit?.text = "Next"
        }

    }

    //set color and style to option that selected
    private fun selectedOptionView(tv : TextView, selectedOptionNum : Int){
        mSelectedPosition = selectedOptionNum
        defaultOptionView()
        tv.setTextColor(Color.parseColor("#FF03DAC5"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this,R.drawable.seleted_border
        )

    }


    override fun onClick(view: View?) {

        when(view?.id){

            R.id.tv_optionOne -> {
                tvOptionOne?.let {
                    selectedOptionView(it,1)
                }
            }

            R.id.tv_optionTwo -> {
                tvOptionTwo?.let {
                    selectedOptionView(it,2)
                }
            }

            R.id.tv_optionThree -> {
                tvOptionThree?.let {
                    selectedOptionView(it,3)
                }
            }

            R.id.tv_optionFour -> {
                tvOptionFour?.let {
                    selectedOptionView(it,4)
                }
            }

            R.id.btn_submit -> {

                if(mSelectedPosition == 0){
                    mCurrentPosition++

                    when{

                        mCurrentPosition <= mQuestionList!!.size ->{
                            setQuestion()
                        }
                        else ->{

                            val intent = Intent(this,ResultActivity::class.java)
                            intent.putExtra(Constrains.USER_NAME,mUserName)
                            intent.putExtra(Constrains.CORRECT_ANSWER,mCorrectAnwer)
                            intent.putExtra(Constrains.TOTAL_QUESTION,mQuestionList?.size)
                            startActivity(intent)
                            finish()
                        }
                    }
                }else{

                    val question = mQuestionList?.get(mCurrentPosition - 1)

                    if(question!!.correctAnswer != mSelectedPosition){
                        answerView(mSelectedPosition,R.drawable.wrong_border)
                    }

                    else{
                        mCorrectAnwer++
                    }
                    answerView(question.correctAnswer,R.drawable.correct_border)

                    if(mCurrentPosition == mQuestionList!!.size){
                        btnSubmit?.text = "Finish"
                    }else{
                        btnSubmit?.text = "Next"
                    }

                        mSelectedPosition = 0
                }

            }
        }

    }
}