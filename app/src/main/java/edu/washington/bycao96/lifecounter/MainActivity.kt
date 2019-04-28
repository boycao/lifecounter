package edu.washington.bycao96.lifecounter

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.playerlayout.view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Create the variable with findViewByID from xml
        var playerOne: ConstraintLayout = findViewById(R.id.playerOne)
        var playerTwo: ConstraintLayout = findViewById(R.id.playerTwo)
        var playerThree: ConstraintLayout = findViewById(R.id.playerThree)
        var playerFour: ConstraintLayout = findViewById(R.id.playerFour)
        var loser: TextView = findViewById(R.id.loser)
        var playerArray = arrayOf(playerOne, playerTwo, playerThree, playerFour)

        // Assign variable names and attributes
        var playernum = 1
        for(player in playerArray){
            player.playerText.playerName.text = "Player" + playernum++
            player.playerText.playerHealth.text = "30"
        }

        // If the playerhealth reaches the bound, pop up player i loses
        fun weHaveALoser(healthNum : Int, layout: ConstraintLayout) {
            if (healthNum <= 0) {
                val name = layout.playerText.playerName.text.toString()
                loser.text = name + " Loses!"
                loser.visibility = View.VISIBLE
            }
        }


        // Clicklistener for event changes
        for (layout in playerArray) {
            for (layout in playerArray) {
                layout.buttons.plusOne.setOnClickListener {
                    var health = layout.playerText.playerHealth.text.toString().toInt()
                    health ++
                    layout.playerText.playerHealth.text = health.toString()
                }
                layout.buttons.plusFive.setOnClickListener {
                    var health = layout.playerText.playerHealth.text.toString().toInt()
                    health += 5
                    layout.playerText.playerHealth.text = health.toString()
                }
                layout.buttons.minusOne.setOnClickListener {
                    var health = layout.playerText.playerHealth.text.toString().toInt()
                    health --
                    layout.playerText.playerHealth.text = health.toString()
                    weHaveALoser(health, layout)
                }
                layout.buttons.minusFive.setOnClickListener {
                    var health = layout.playerText.playerHealth.text.toString().toInt()
                    health -= 5
                    layout.playerText.playerHealth.text = health.toString()
                    weHaveALoser(health, layout)
                }
            }
        }

    }
}
