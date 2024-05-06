package za.ac.iie.myassignmenttwo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class GameActivity : AppCompatActivity() {
    private lateinit var pet: Pet
    private lateinit var healthTextView: TextView
    private lateinit var hungerTextView: TextView
    private lateinit var cleanlinessTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        val imageView = findViewById<ImageView>(R.id.ivHappy)
        val feedButton = findViewById<Button>(R.id.feedButton)
        val cleanButton = findViewById<Button>(R.id.cleanButton)
        val playButton = findViewById<Button>(R.id.playButton)

        pet = Pet()

        healthTextView = findViewById(R.id.healthTextView)
        hungerTextView = findViewById(R.id.hungerTextView)
        cleanlinessTextView = findViewById(R.id.cleanlinessTextView)

        updateStatus()

        findViewById<Button>(R.id.feedButton).setOnClickListener { pet.feed(); updateStatus();
        imageView.setImageResource(R.drawable.peteating)}
        findViewById<Button>(R.id.cleanButton).setOnClickListener { pet.clean(); updateStatus();
        imageView.setImageResource(R.drawable.petbathing)}
        // findViewById<Button>(R.id.playButton).setOnClickListener { /* Implement play logic */ }
        startTimer()

    }

    private fun updateStatus(){
        with(pet){
            healthTextView.text = "Health: $health"
            hungerTextView.text = "Hunger: $hunger"
            cleanlinessTextView.text = "Cleanliness: $cleanliness"
        }

    }

    private fun startTimer() {
        GlobalScope.launch {
            while (true) {
                with(pet) {
                    decreaseHealth()
                    increaseHunger()
                    increaseCleanliness()
                    updateStatus()
                }
                delay(500000)
            }
        }

    }
}