package com.example.twodiceroll

import android.app.ProgressDialog.show
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var diceImage: ImageView = findViewById(R.id.imageView)
        var diceImage2: ImageView = findViewById(R.id.imageView2)


        diceImage.setImageResource(R.drawable.dice_3)
        diceImage2.setImageResource(R.drawable.dice_2)
        var resultButtonView: Button = findViewById(R.id.button)

        var mediaPlayer = MediaPlayer.create(this, R.raw.roll_the_dice)



        resultButtonView.setOnClickListener {
            rolldice()
            mediaPlayer.start()


        }
    }

    private fun rolldice() {
        var dice = Dice(6)
        var resultImage: ImageView = findViewById(R.id.imageView)
        var resultImage2: ImageView = findViewById(R.id.imageView2)
        var showBar: TextView = findViewById(R.id.textView2)


        var result1 = dice.roll()
        var result2 = dice.roll()

        when (result1) {
            1 -> resultImage.setImageResource(R.drawable.dice_1)
            2 -> resultImage.setImageResource(R.drawable.dice_2)
            3 -> resultImage.setImageResource(R.drawable.dice_3)
            4 -> resultImage.setImageResource(R.drawable.dice_4)
            5 -> resultImage.setImageResource(R.drawable.dice_5)
            6 -> resultImage.setImageResource(R.drawable.dice_6)
        }
        when (result2) {
            1 -> resultImage2.setImageResource(R.drawable.dice_1)
            2 -> resultImage2.setImageResource(R.drawable.dice_2)
            3 -> resultImage2.setImageResource(R.drawable.dice_3)
            4 -> resultImage2.setImageResource(R.drawable.dice_4)
            5 -> resultImage2.setImageResource(R.drawable.dice_5)
            6 -> resultImage2.setImageResource(R.drawable.dice_6)
        }
        when(result1) {

            result2 -> showBar.text = "       You won!"
            else    -> showBar.text = "       try again!"
        }

    }

}


class Dice(var sides: Int) {
    fun roll(): Int {
        return (1..sides).random()
    }

}