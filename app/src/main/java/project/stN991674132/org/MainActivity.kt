package project.stN991674132.org

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Click roll
        findViewById<Button>(R.id.button).setOnClickListener {
            //Showing notification which disappears
            showNotification("Dice Rolled!!")
            //store the value of the the random int
            var result = rollDie()
            //Displaying the result of the random int we got on the screen
            findViewById<TextView>(R.id.txtViewDie1).text = result.toString()
            //setting the dice image to the number we got
            rolldiceImage(result.toString())

        }
        //Click count up
        findViewById<Button>(R.id.button2).setOnClickListener {
            //Displaying the text
            showNotification("Dice Counted Up!")
            // storing the response gotten from the function after adding 1 to it or pushing it back to 1
            val output = clickcountup()
            //setting the dice image to the number we got
            rolldiceImage(output)
            findViewById<TextView>(R.id.txtViewDie1).text=output
           }
    }
    //creating a function to increase the count of dice or returning it back to 1 if its 6
    private fun clickcountup(): String{
        var rollresponse=(findViewById<TextView>(R.id.txtViewDie1).text?:0).toString();
        var newvalue = ((rollresponse.toInt() + 1).toString())
        if (newvalue=="7"){
            newvalue="1"
        }
        return newvalue;
    }
    //this functions just rolls the dice
    private fun rollDie():Int{
        val result = Random.nextInt(6)+1
        return result
    }
    //this function shows the message according to the button clicked
    private fun showNotification(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

        //I used text view because toast was glitchy, coz when i click it multiple time it doesnt show up
//        findViewById<TextView>(R.id.textView).text= message
//        //.visibility makes the the notification disappear
//        findViewById<TextView>(R.id.textView).visibility=TextView.VISIBLE

//        // Hide the notification after a delay
//        Handler(Looper.getMainLooper()).postDelayed({
//            findViewById<TextView>(R.id.textView).visibility=TextView.INVISIBLE
//        }, 400)

    }
    // this function changes the image to respective roll number
    fun rolldiceImage(output: String){
        when (output) {
            "1" -> findViewById<ImageView>(R.id.imageView2).setImageResource(R.drawable.die_1)
            "2" -> findViewById<ImageView>(R.id.imageView2).setImageResource(R.drawable.die_2)
            "3" -> findViewById<ImageView>(R.id.imageView2).setImageResource(R.drawable.die_3)
            "4" -> findViewById<ImageView>(R.id.imageView2).setImageResource(R.drawable.die_4)
            "5" -> findViewById<ImageView>(R.id.imageView2).setImageResource(R.drawable.die_5)
            "6" -> findViewById<ImageView>(R.id.imageView2).setImageResource(R.drawable.die_6)
            else -> println("changed to else")
        }
    }

}
