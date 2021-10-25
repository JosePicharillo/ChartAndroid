package br.edu.ifsp.scl.sdm.charandroid.chart

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.edu.ifsp.scl.sdm.charandroid.R
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.utils.ColorTemplate
import java.util.ArrayList

class PieChartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pie_chart)

        title = "Pie Chart"

        val pieChart: PieChart = findViewById(R.id.piechart)
        val infoChart = ArrayList<PieEntry>()

        infoChart.add(PieEntry(945f, 0f))
        infoChart.add(PieEntry(1040f, 1f))
        infoChart.add(PieEntry(1133f, 2f))
        infoChart.add(PieEntry(1240f, 3f))
        infoChart.add(PieEntry(1369f, 4f))
        infoChart.add(PieEntry(1487f, 5f))
        infoChart.add(PieEntry(1501f, 6f))
        infoChart.add(PieEntry(1645f, 7f))
        infoChart.add(PieEntry(1578f, 8f))
        infoChart.add(PieEntry(1695f, 9f))

        val dataSet = PieDataSet(infoChart, "Number Of Employees")

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

        val data = PieData(dataSet)
        pieChart.data = data
        dataSet.setColors(*ColorTemplate.COLORFUL_COLORS)
        pieChart.animateXY(5000, 5000)
    }
}