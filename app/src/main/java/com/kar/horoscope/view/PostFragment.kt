package com.kar.horoscope.view

import android.annotation.SuppressLint
import android.arch.lifecycle.ViewModelProviders
import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kar.horoscope.R
import com.kar.horoscope.repository.FirebaseRepository
import com.kar.horoscope.view.activities.Forecast
import com.kar.horoscope.viewmodels.forecast.ForecastVMFactory
import com.kar.horoscope.viewmodels.forecast.ForecastViewModel
import kotlinx.android.synthetic.main.content.*

class PostFragment : Fragment() {

    val repository = FirebaseRepository()
    val viewModel: ForecastViewModel by lazy {
        ViewModelProviders.of(this,
            ForecastVMFactory(repository)
        ).get(ForecastViewModel::class.java)
    }


    private val ARG_PAGE : String = "arg_page"

    fun newInstance(pageNumber: Int): Fragment {
        val postsFragment = PostFragment()
        val arguments = Bundle()

        arguments.putInt(ARG_PAGE, pageNumber + 1)
        postsFragment.arguments = arguments

        return postsFragment
    }

    override fun onCreateView(inflater: LayoutInflater, parent: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate( R.layout.content, parent, false )
    }

    @SuppressLint("CheckResult")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val arguments = arguments
        val pageNumber = arguments?.getInt( ARG_PAGE )

        ///create the view querying to firestore
        viewModel
            .getFirebaseData(  Forecast().title.toString() )
            .subscribe {
                forecastText.text = it.text
                forecastText.setTextColor(Color.WHITE)
            }
    }

}