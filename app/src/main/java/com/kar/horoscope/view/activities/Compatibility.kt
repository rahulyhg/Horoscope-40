package com.kar.horoscope.view.activities

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.widget.Toast
import com.kar.horoscope.R
import com.kar.horoscope.repository.CompatibilityRepository
import com.kar.horoscope.repository.adapter.CompatibilityAdapter
import com.kar.horoscope.service.ItemClickedCallback
import com.kar.horoscope.util.SpacesItemDecoration
import com.kar.horoscope.viewmodels.compatibility.CompatibilityVMFactory
import com.kar.horoscope.viewmodels.compatibility.CompatibilityViewModel
import kotlinx.android.synthetic.main.activity_compatibility.*

class Compatibility : AppCompatActivity(), ItemClickedCallback {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView( R.layout.activity_compatibility )


        val repository = CompatibilityRepository(this )
        val viewModel: CompatibilityViewModel by lazy {
            ViewModelProviders.of(this,
                CompatibilityVMFactory(repository)
            ).get(CompatibilityViewModel::class.java)
        }

        recyclerView.addItemDecoration( SpacesItemDecoration( 100 ))
        recyclerView.layoutManager = GridLayoutManager( this, 2 )
        recyclerView.adapter = CompatibilityAdapter (
            viewModel.getImageData,
            viewModel.getNameData,
            this)
    }

    override fun itemClicked(name: String, image: Int) {
        Toast.makeText(this, "Item Clicked", Toast.LENGTH_LONG ).show()
    }
}
