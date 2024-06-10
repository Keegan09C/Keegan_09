package layout

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.firstapp.weatherapp.R
import pracpractice.og.DetailViewActivity

class MainActivity2 : AppCompatActivity() {
    private lateinit var txtDate: EditText
    private lateinit var days: EditText
    private lateinit var weather: EditText
    private lateinit var txtNotes: EditText
    private lateinit var buttonSave: Button
    private lateinit var buttonClear: Button
    private lateinit var buttonNext: Button
    private lateinit var tvMessage: TextView
    private val dateArray = mutableListOf<Float>()
    private val timeArrayMorning = mutableListOf<Float>()
    private val timeArrayAfternoon = mutableListOf<Float>()
    private val notesArray = mutableListOf<String>()



    @SuppressLint("MissingInflatedId", "SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtDate = findViewById(R.id.txtDate)
        weather = findViewById(R.id.txtAfternoonTime)
        txtNotes = findViewById(R.id.txtNotes)
        buttonClear = findViewById(R.id.buttonClear)




        buttonClear.setOnClickListener {
            txtDate.setText("")
            txtNotes.setText("")

        }
        buttonSave.setOnClickListener {
            val screenTimeDate = txtDate.text.toString()
            val screenTimeMorning = screenTimeDate.length.toString()
            val txtAfternoonTime = null
            val screenTimeAfternoon = txtAfternoonTime.toString()
            val screenTimeNote = txtNotes.text.toString()

            if (screenTimeDate.isNotEmpty() && screenTimeMorning.isNotEmpty() && screenTimeAfternoon.isNotEmpty()) {
                try {
                    dateArray.add(screenTimeDate.toFloat())
                    timeArrayMorning.add(screenTimeMorning.toFloat())
                    timeArrayAfternoon.add(screenTimeAfternoon.toFloat())
                    notesArray.add(screenTimeNote)
                    txtDate.text.clear()
                    txtNotes.text.clear()
                } catch (e: NumberFormatException) {
                    tvMessage.text = "Search for Temp"
                }
            } else {
                tvMessage.text = "Search for Temp"
            }
        }

        buttonNext.setOnClickListener {

            val intent = Intent(this, DetailViewActivity::class.java)
            intent.putExtra("dateArray", dateArray.toFloatArray())
            intent.putExtra("timeArrayMorning", timeArrayMorning.toFloatArray())
            intent.putExtra("timeArrayAfternoon", timeArrayAfternoon.toFloatArray())
            intent.putExtra("notesArray", notesArray.toTypedArray())
            startActivity(intent)

        }
    }



