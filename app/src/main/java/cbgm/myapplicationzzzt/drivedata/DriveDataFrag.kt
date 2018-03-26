package cbgm.myapplicationzzzt.drivedata

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import cbgm.myapplicationzzzt.MainActivity
import cbgm.myapplicationzzzt.R
import cbgm.myapplicationzzzt.development.DevelopmentFrag

/**
 * Created by SA_Admin on 19.03.2018.
 */
class DriveDataFrag : Fragment() {

    override fun onResume() {
        (this.activity as MainActivity).apply {
            toggleBackButton(true)
            toogleTitle(true)
        }
        super.onResume()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.drivedata_frag, container, false)
        val btn = view.findViewById<LinearLayout>(R.id.bigbtn)
        btn.setOnClickListener{view ->
            (this.activity as MainActivity).apply{
                switchState(DevelopmentFrag(), "DevelopTag")
            }
        }

        return view
    }
}
