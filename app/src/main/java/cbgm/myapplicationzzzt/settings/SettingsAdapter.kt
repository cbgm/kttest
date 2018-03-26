package cbgm.myapplicationzzzt.settings

import android.content.Context
import android.graphics.Color
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.view.LayoutInflater
import android.view.MotionEvent
import android.widget.TextView
import cbgm.myapplicationzzzt.R


/**
 * Created by SA_Admin on 20.03.2018.
 */
class SettingsAdapter(val context: Context, val data: ArrayList<String>) : BaseAdapter() {

    override fun getView(pos: Int, convertView: View?, container: ViewGroup?): View {

        val view: View
        val holder: ViewHolder

        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.settings_item, container, false)
            holder = ViewHolder()
            holder.text = view.findViewById(R.id.text) as TextView
            view.tag = holder
        } else {
            view = convertView
            holder = convertView.tag as ViewHolder
        }


        view.setOnTouchListener { view, motionEvent ->
            when(motionEvent.action) {
                MotionEvent.ACTION_DOWN -> {
                    view.setBackgroundColor(Color.RED)
                }
                MotionEvent.ACTION_UP -> {
                    view.setBackgroundColor(Color.WHITE)
                }
            }
             true
        }

        holder.text.setText(data[pos])

        return view
    }

    override fun getItem(p0: Int): Any {
        return data[p0]
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return this.data.size
    }

    private class ViewHolder {
        lateinit var text: TextView
        lateinit var base: TextView
    }
}