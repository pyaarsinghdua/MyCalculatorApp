package com.example.mysecondcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.Expression
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Numbers
        tvOne.setOnClickListener{appenOnExpression( string = "1", canClear = true)}
        tvTwo.setOnClickListener{ appenOnExpression( string = "2", canClear = true) }
        tvThree.setOnClickListener{ appenOnExpression( string = "3", canClear = true) }
        tvFour.setOnClickListener{ appenOnExpression( string = "4", canClear = true) }
        tvFive.setOnClickListener{ appenOnExpression( string = "5", canClear = true) }
        tvSix.setOnClickListener{ appenOnExpression( string = "6", canClear = true) }
        tvSeven.setOnClickListener{ appenOnExpression( string = "7", canClear = true) }
        tvEight.setOnClickListener{ appenOnExpression( string = "8", canClear = true) }
        tvNine.setOnClickListener{ appenOnExpression( string = "9", canClear = true) }
        tvZero.setOnClickListener{ appenOnExpression( string = "0", canClear = true) }
        tvDot.setOnClickListener{ appenOnExpression( string = ".", canClear = true) }

        //Operators
        tvPlus.setOnClickListener{ appenOnExpression( string = "+", canClear = false)}
        tvMul.setOnClickListener{ appenOnExpression( string = "*", canClear = false)}
        tvMinus.setOnClickListener{ appenOnExpression( string = "-", canClear = false)}
        tvDivide.setOnClickListener{ appenOnExpression( string = "/", canClear = false)}
        tvOpen.setOnClickListener{ appenOnExpression( string = "(", canClear = false)}
        tvClose.setOnClickListener{ appenOnExpression( string = ")", canClear = false)}

        tvCleaar.setOnClickListener{ tvExpression.text = ""
        tvResult.text= ""
        }

        tvBack.setOnClickListener(){
            val string = tvExpression.text.toString()
            if(string.isNotEmpty()){
                tvExpression.text = string.substring(0, string.length-1)
            }

            tvResult.text = ""
        }

        tvEquals.setOnClickListener(){
            try{
                val expression=ExpressionBuilder(tvExpression.text.toString()).build()
                val result = expression.evaluate()
                val longResult = result.toString()
                if(result == longResult.toDouble())
                    tvResult.text = longResult.toString()
                else
                    tvResult.text = result.toString()


            }catch (e:Exception){
                Log.d("Exception","message : "+ e.message)
            }
        }


    }

    fun appenOnExpression( string: String, canClear : Boolean){

        if(tvResult.text.isNotEmpty()){
            tvExpression.text = ""
        }

        if(canClear){
            tvResult.text = ""
            tvExpression.append(string)
        }else{
            tvExpression.append(tvResult.text)
            tvResult.text = ""
            tvExpression.append(string)
        }

    }
}
