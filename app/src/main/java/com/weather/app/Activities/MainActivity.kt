package com.weather.app.Activities

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.weather.app.Adapters.HourlyAdapters
import com.weather.app.Domains.Hourly
import com.weather.app.R


class MainActivity : AppCompatActivity() {
    private var adapterHourly: RecyclerView.Adapter<*>? = null
    private lateinit var recyclerView:RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initRecyclerView()
    }

    private fun initRecyclerView() {
        val items = ArrayList<Hourly>()
        items.add(Hourly("9 pm",28,"cloudy"))
        items.add(Hourly("10 pm",29,"sunny"))
        items.add(Hourly("11 pm",30,"wind"))
        items.add(Hourly("12 pm",31,"rainy"))
        items.add(Hourly("1 am",32,"storm"))
        recyclerView = findViewById(R.id.view1)
        recyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        adapterHourly = HourlyAdapters(items)
        recyclerView.adapter = adapterHourly

    }
}