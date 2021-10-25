package br.edu.ifsp.scl.sdm.charandroid

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import br.edu.ifsp.scl.sdm.charandroid.chart.*

class MainActivity : AppCompatActivity() {

    private lateinit var btnBarChart: Button
    private lateinit var btnPieChart: Button
    private lateinit var btnBarSimpleChart: Button
    private lateinit var btnLineChart: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnBarChart = findViewById(R.id.btnBarChart)
        btnPieChart = findViewById(R.id.btnPieChart)
        btnBarSimpleChart = findViewById(R.id.btnBarSimpleChart)
        btnLineChart = findViewById(R.id.btnLineChart)

        btnBarChart.setOnClickListener(View.OnClickListener {
            val I = Intent(this@MainActivity, BarChartActivity::class.java)
            startActivity(I)
        })

        btnPieChart.setOnClickListener(View.OnClickListener {
            val I = Intent(this@MainActivity, PieChartActivity::class.java)
            startActivity(I)
        })

        btnBarSimpleChart.setOnClickListener(View.OnClickListener {
            val I = Intent(this@MainActivity, BarChartSimpleActivity::class.java)
            startActivity(I)
        })

        btnLineChart.setOnClickListener(View.OnClickListener {
            val I = Intent(this@MainActivity, LineChartActivity::class.java)
            startActivity(I)
        })

    }
}