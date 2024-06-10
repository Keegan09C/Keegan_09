package pracpractice.og

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.firstapp.weatherapp.R

class DetailViewActivity : AppCompatActivity() {

    private lateinit var btn_back : Button
    private lateinit var monday: TextView
    private lateinit var tuesday : TextView
    private lateinit var wensday: TextView
    private lateinit var thursday : TextView
    private lateinit var friday : TextView




    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.actitvtydetailview)

        btn_back = findViewById(R.id.btn_back)
        monday = findViewById(R.id.tvHoursPM)
        tuesday = findViewById(R.id.tvHoursAM)
        wensday = findViewById(R.id.tvHoursNotes)
        thursday = findViewById(R.id.tvHoursPM)

        val dateArray = intent.getFloatArrayExtra("dateArray") ?.toList()?:emptyList()
        val NotesArray = intent.getStringArrayExtra("noteArray") ?.toList() ?:emptyList()
        val timeArrayMorning = intent.getFloatArrayExtra("timeArrayMorning") ?.toList() ?:emptyList()
        val  timeArrayAternoon=intent.getFloatArrayExtra("timeArrayAfternoon") ?.toList() ?:emptyList()

        val dated = StringBuilder()
        for ((index, date) in  dateArray.withIndex()){
            dated.append("Day ${index + 1}: $date \n")
        }
        val hoursAM = StringBuilder()
        for ((index, hours) in  timeArrayMorning.withIndex()){
            hoursAM.append("Day ${index + 1}: $hours \n")
        }
        val hoursPM = StringBuilder()
        for ((index, hours) in  timeArrayAternoon.withIndex()){
            hoursPM.append("Day ${index + 1}: $hours \n")
        }
        val noted = StringBuilder()
        for ((index, note) in  NotesArray.withIndex()){
            noted.append("Day ${index + 1}: $note \n")
        }

        monday.text = dated.toString()
        tuesday.text = hoursAM.toString()
        wensday.text = hoursPM.toString()
        thursday.text = intent.getStringExtra("noteArray")

        btn_back.setOnClickListener {
            finish()


