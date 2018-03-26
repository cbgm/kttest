package cbgm.myapplicationzzzt.settings

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.SimpleAdapter
import cbgm.myapplicationzzzt.MainActivity
import cbgm.myapplicationzzzt.R
import kotlinx.android.synthetic.main.settings_frag.*
import kotlin.collections.ArrayList

/**
 * Created by SA_Admin on 19.03.2018.
 */
class SettingsFrag : Fragment() {

    override fun onResume() {
        (this.activity as MainActivity).apply {
            toggleBackButton(true)
            toogleTitle(true)
        }
        super.onResume()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view =  inflater!!.inflate(R.layout.settings_frag, container, false)

        val fruits = arrayListOf<String>("Chokeberry", "Chinese Quince", "Clementine")
        val listView = view.findViewById<ListView>(R.id.listView)
        listView.adapter = SettingsAdapter(context, fruits)

        return view
    }
}
