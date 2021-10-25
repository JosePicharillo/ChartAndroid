package br.edu.ifsp.scl.sdm.charandroid.chart

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.edu.ifsp.scl.sdm.charandroid.R
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.utils.ColorTemplate
import java.util.ArrayList

class BarChartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bar_chart)

        title = "Bar Chart"

        val chart: BarChart = findViewById(R.id.barChart)
        val infoChart = ArrayList<BarEntry>()

        infoChart.add(BarEntry(945f, 0f))
        infoChart.add(BarEntry(1040f, 1f))
        infoChart.add(BarEntry(1133f, 2f))
        infoChart.add(BarEntry(1240f, 3f))
        infoChart.add(BarEntry(1369f, 4f))
        infoChart.add(BarEntry(1487f, 5f))
        infoChart.add(BarEntry(1501f, 6f))
        infoChart.add(BarEntry(1645f, 7f))
        infoChart.add(BarEntry(1578f, 8f))
        infoChart.add(BarEntry(1695f, 9f))

//        val year = ArrayList<String>()
//        year.add("2008")
//        year.add("2009")
//        year.add("2010")
//        year.add("2011")
//        year.add("2012")
//        year.add("2013")
//        year.add("2014")
//        year.add("2015")
//        year.add("2016")
//        year.add("2017")

        val bardataset = BarDataSet(infoChart, "No Of Employee")
        chart.animateY(5000)

        //val data = BarData(year, bardataset)
        val data = BarData(bardataset)
        bardataset.setColors(*ColorTemplate.COLORFUL_COLORS)

        chart.data = data
    }
}