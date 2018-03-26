package cbgm.myapplicationzzzt.main

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import cbgm.myapplicationzzzt.MainActivity
import cbgm.myapplicationzzzt.R
import cbgm.myapplicationzzzt.drivedata.DriveDataFrag

/**
 * Created by SA_Admin on 19.03.2018.
 */
class MainFrag : Fragment() {

    override fun onResume() {
        (this.activity as MainActivity).apply {
            toggleBackButton(false)
            toogleTitle(false)
        }
        super.onResume()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.tt, container, false)
       /* val btn = view.findViewById<LinearLayout>(R.id.bigbtn)
        btn.setOnClickListener{view ->
            (this.activity as MainActivity).apply{
                switchState(DriveDataFrag(), "DriveTag")
            }
        }*/

        return view
    }
}
