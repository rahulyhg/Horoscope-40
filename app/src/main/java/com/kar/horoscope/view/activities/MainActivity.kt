package com.kar.horoscope.view.activities

import android.annotation.SuppressLint
import android.arch.lifecycle.ViewModelProviders
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.view.MenuItem
import com.kar.horoscope.R
import com.kar.horoscope.repository.MainRepository
import com.kar.horoscope.repository.adapter.MainAdapter
import com.kar.horoscope.viewmodels.main.MainViewModel
import com.kar.horoscope.viewmodels.main.ViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var toggle: ActionBarDrawerToggle

    @SuppressLint("CheckResult")
    @RequiresApi(Build.VERSION_CODES.KITKAT)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val drawer = findViewById<DrawerLayout>(R.id.drawer)
        toggle = ActionBarDrawerToggle(this, drawer, R.string.open, R.string.close )
        drawer.addDrawerListener(toggle)
        toggle.syncState()

        Objects.requireNonNull(supportActionBar)?.setDisplayHomeAsUpEnabled(true)

        val repository = MainRepository( this )
        val viewModel: MainViewModel by lazy {
            ViewModelProviders.of(this,
                ViewModelFactory(repository)
            ).get(MainViewModel::class.java)
        }

        viewModel.getObservableListModel.subscribe{
            val adapter = MainAdapter( it, this )
            recyclerView.layoutManager = GridLayoutManager( this, 3 )
            recyclerView.adapter = adapter
        }

        navigationView.setNavigationItemSelectedListener {
            val id = it.itemId
            viewModel.navigationLogic( id )
            true
        }
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if ( toggle.onOptionsItemSelected(item) )
            return true
        return super.onOptionsItemSelected(item)
    }
}
