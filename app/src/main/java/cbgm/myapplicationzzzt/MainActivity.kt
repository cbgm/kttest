package cbgm.myapplicationzzzt

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.view.Menu
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.toolbar.*
import cbgm.myapplicationzzzt.main.MainFrag
import cbgm.myapplicationzzzt.settings.SettingsFrag


class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        switchState(MainFrag(), "Main")

    }

    fun locationActivate(view: View) {
        view.visibility = View.GONE
    }


    fun toogleTitle(show: Boolean) {
        toolbar.setTitleTextColor(Color.BLACK)
        supportActionBar!!.setTitle("test")
        supportActionBar!!.setDisplayShowTitleEnabled(show)
        maintitlecontainer.visibility = if (!show) View.VISIBLE else View.GONE

    }

    fun toggleBackButton(show: Boolean) {
        supportActionBar!!.setHomeAsUpIndicator(android.R.drawable.ic_media_play)
        supportActionBar!!.setDisplayHomeAsUpEnabled(show)

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        when(item?.itemId) {
            R.id.action_settings -> switchState(SettingsFrag(), "Settings")
            android.R.id.home -> onBackPressed()
        }

        return super.onOptionsItemSelected(item)
    }

     fun switchState(fragment: Fragment, tag: String) {
        replaceFragment(fragment, R.id.frag_holder, tag)
    }

    private inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> FragmentTransaction) {
        val fragmentTransaction = beginTransaction()
        fragmentTransaction.func()
        fragmentTransaction.commit()
    }

    private fun FragmentManager.inBackStack() {
        if (backStackEntryCount > 1) {
            popBackStackImmediate()
            beginTransaction().commit()
        } else {
            finish()
        }
    }

    override fun onBackPressed() {
        backStack()
    }

    private fun AppCompatActivity.replaceFragment(fragment: Fragment, frameId: Int, backStackTag: String) {
        supportFragmentManager.inTransaction {
            addToBackStack(backStackTag)
            replace(frameId, fragment, backStackTag)

        }
    }
    private fun AppCompatActivity.backStack() {
        supportFragmentManager.inBackStack()
    }
}


