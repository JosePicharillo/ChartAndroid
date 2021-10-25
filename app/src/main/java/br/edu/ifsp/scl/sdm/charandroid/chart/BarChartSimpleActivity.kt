package br.edu.ifsp.scl.sdm.charandroid.chart

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.edu.ifsp.scl.sdm.charandroid.R
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.*
import java.util.*

class BarChartSimpleActivity : AppCompatActivity() {

    private lateinit var barChart: BarChart

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bar_simple_chart)
        title = "Bar Chart Simple"

        barChart = findViewById(R.id.barChartSimple)

        initBarChart()
        setDataLineChart()
//        lineLimitMinChart()
//        lineLimitMaxChart()
    }

    private fun initBarChart(){
        val xAxis: XAxis = barChart.xAxis!!
        barChart.description.isEnabled = false
        barChart.animateY(1000)
        barChart.legend.isEnabled = false
        barChart.notifyDataSetChanged()
        barChart.invalidate()
        barChart.axisRight.isEnabled = false
        xAxis.position = XAxis.XAxisPosition.BOTTOM
        xAxis.granularity = 1F
        xAxis.setCenterAxisLabels(true)
        xAxis.isGranularityEnabled = true
    }

    private fun setDataLineChart(){
        val infoChart = ArrayList<BarEntry>()
        infoChart.add(BarEntry(50f, 15f))

        val barDataSet = BarDataSet(infoChart, "")
        val barData = BarData(barDataSet)
        barDataSet.color = Color.GREEN
        barData.notifyDataChanged()
        barChart.data = barData
        barChart.data.setValueTextSize(20f)
    }

//    private fun lineLimitMinChart(){
//        val lineEntriesMin: MutableList<Entry> = arrayListOf()
//        lineEntriesMin.add(Entry(0f, 14f))
//        lineEntriesMin.add(Entry(0.2f, 14f))
//        val lineDataSetMin = LineDataSet(lineEntriesMin, "")
//        lineDataSetMin.color = Color.parseColor("#FAFF00")
//        lineDataSetMin.circleHoleColor = Color.TRANSPARENT
//        lineDataSetMin.setCircleColor(Color.TRANSPARENT)
//        lineDataSetMin.setDrawValues(false)
//    }
//
//    private fun lineLimitMaxChart() {
//        val lineEntriesMax: MutableList<Entry> = arrayListOf()
//        lineEntriesMax.add(Entry(0f, 16f))
//        lineEntriesMax.add(Entry(0.2f, 16f))
//        val lineDataSetMax = LineDataSet(lineEntriesMax, "")
//        lineDataSetMax.color = Color.parseColor("#C8191B")
//        lineDataSetMax.circleHoleColor = Color.TRANSPARENT
//        lineDataSetMax.setCircleColor(Color.TRANSPARENT)
//        lineDataSetMax.setDrawValues(false)
//    }

}