package br.edu.ifsp.scl.sdm.charandroid.chart

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.edu.ifsp.scl.sdm.charandroid.R
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.AxisBase
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter

class LineChartActivity : AppCompatActivity() {


    private lateinit var lineChart: LineChart
    private var scoreList = ArrayList<Score>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_line_chart)

        lineChart = findViewById(R.id.lineChart)

        initLineChart()
        setDataToLineChart()
    }

    private fun initLineChart() {

        //Hide grid lines
        lineChart.axisLeft.setDrawGridLines(false)
        val xAxis: XAxis = lineChart.xAxis
        xAxis.setDrawGridLines(false)
        xAxis.setDrawAxisLine(false)

        //Remove right y-axis
        lineChart.axisRight.isEnabled = false

        //Remove legend
        lineChart.legend.isEnabled = false

        //Remove description label
        lineChart.description.isEnabled = false

        //Add animation
        lineChart.animateX(1000, Easing.EaseInSine)

        //To draw label on xAxis
        xAxis.position = XAxis.XAxisPosition.BOTTOM_INSIDE
        xAxis.valueFormatter = MyAxisFormatter()
        xAxis.setDrawLabels(true)
        xAxis.granularity = 1f
        xAxis.labelRotationAngle = +90f

    }

    inner class MyAxisFormatter : IndexAxisValueFormatter() {

        override fun getAxisLabel(value: Float, axis: AxisBase?): String {
            val index = value.toInt()
            return if (index < scoreList.size) {
                scoreList[index].name
            } else {
                ""
            }
        }
    }

    private fun setDataToLineChart() {
        //Now draw bar chart with dynamic data
        val entries: ArrayList<Entry> = ArrayList()

        scoreList = getScoreList()

        //You can replace this data object with  your custom object
        for (i in scoreList.indices) {
            val score = scoreList[i]
            entries.add(Entry(i.toFloat(), score.score.toFloat()))
        }

        val lineDataSet = LineDataSet(entries, "")
        lineDataSet.color = Color.RED

        //Remove circle chart
        lineDataSet.circleHoleColor = Color.TRANSPARENT
        lineDataSet.setCircleColor(Color.TRANSPARENT)

        val data = LineData(lineDataSet)
        lineChart.data = data
        lineChart.invalidate()
    }

    private fun getScoreList(): ArrayList<Score> {
        scoreList.add(Score("John", 59))
        scoreList.add(Score("Rey", 75))
        scoreList.add(Score("Steve", 85))
        scoreList.add(Score("Kevin", 55))
        scoreList.add(Score("Jeff", 63))

        return scoreList
    }

}