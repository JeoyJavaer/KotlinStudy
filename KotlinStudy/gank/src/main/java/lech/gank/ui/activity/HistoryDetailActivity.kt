package lech.gank.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_history_detail.*
import lech.gank.R
import lech.gank.ui.fragment.RecommendFragment

class HistoryDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history_detail)
        val date = intent.getStringExtra("date")
        initToolbar(date)
        addContainer(date)
    }

    private fun addContainer(date: String?) {
        supportFragmentManager.beginTransaction()
                .add(R.id.container, RecommendFragment.newInstance(date!!))
                .commit()
    }

    private fun initToolbar(date: String?) {
        setSupportActionBar(toolbar)
        supportActionBar!!.title = date
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        when (item!!.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }
}
