package ru.example.homework1

import android.content.AbstractThreadedSyncAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.ListView
import android.widget.ProgressBar
import android.widget.SimpleAdapter
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    val TAG: String = "MainActivity"

    lateinit var requestInput : TextInputEditText

    lateinit var podsAdapter: SimpleAdapter

    lateinit var progressBar: ProgressBar

    var pods = mutableListOf<HashMap<String, String>>(
        HashMap<String, String>().apply {
            put("Title", "Title 1")
            put("Content", "Content 1")
        },
        HashMap<String, String>().apply {
            put("Title", "Title 2")
            put("Content", "Content 2")
        },
        HashMap<String, String>().apply {
            put("Title", "Title 3")
            put("Content", "Content 3")
        },
        HashMap<String, String>().apply {
            put("Title", "Title 4")
            put("Content", "Content 4")
        }
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG, "start of onCreate function")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }
    fun initViews(){
        val toolbar: MaterialToolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        requestInput = findViewById(R.id.text_input_edit)

        val podsList: ListView = findViewById(R.id.pods_list)
        podsAdapter = SimpleAdapter(
            applicationContext,
            pods,
            R.layout.item_pod,
            arrayOf("Title", "Content"),
            intArrayOf(R.id.title, R.id.content)
        )
        podsList.adapter = podsAdapter
        val voiceInputButton: FloatingActionButton = findViewById(R.id.voice_input_button)
//        voiceInputButton.setOnClickListener(
//            Log.d(TAG, "FAB")
//        )

        progressBar = findViewById(R.id.progress_bar)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.action_stop ->{
                Log.d(TAG, "action_stop")
            }
        }
        when(item.itemId){
            R.id.action_clear ->{
                Log.d(TAG, "action_clear")
            }
        }
        return super.onOptionsItemSelected(item)
    }
}