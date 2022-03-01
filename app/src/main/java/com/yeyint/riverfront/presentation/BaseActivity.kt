package com.yeyint.riverfront.presentation

import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.yeyint.riverfront.R

abstract class BaseActivity : AppCompatActivity() {
    protected fun setUpToolbar(toolbar: Toolbar, isChild: Boolean) {
        toolbar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24)
        setSupportActionBar(toolbar)

        if (isChild) {
            if (supportActionBar != null) {
                supportActionBar!!.setDisplayHomeAsUpEnabled(true)
            }
        }
    }

    protected fun setUpToolbarText(toolbar_text: TextView, textValue: String) {
        toolbar_text.text = textValue
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}