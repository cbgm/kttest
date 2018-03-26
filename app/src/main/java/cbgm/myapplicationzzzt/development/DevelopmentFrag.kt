package cbgm.myapplicationzzzt.development

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import cbgm.myapplicationzzzt.MainActivity
import cbgm.myapplicationzzzt.R
import com.jjoe64.graphview.GraphView
import com.jjoe64.graphview.series.DataPoint
import com.jjoe64.graphview.series.LineGraphSeries



/**
 * Created by SA_Admin on 19.03.2018.
 */
class DevelopmentFrag : Fragment() {

    override fun onResume() {
        (this.activity as MainActivity).apply {
            toggleBackButton(true)
            toogleTitle(true)
        }
        super.onResume()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.development_frag, container, false)
        val graph = view.findViewById<GraphView>(R.id.graph)
        val data = arrayOf<DataPoint>(DataPoint(0.0, 1.0), DataPoint(1.0, 5.0), DataPoint(2.0, 3.0))
        val series = LineGraphSeries<DataPoint>(data)
        graph.addSeries(series)

        return view
    }
}
