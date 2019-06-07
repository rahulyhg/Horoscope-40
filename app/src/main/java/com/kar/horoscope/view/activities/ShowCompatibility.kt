package com.kar.horoscope.view.activities

import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.kar.horoscope.R
import com.kar.horoscope.repository.ShowRepository
import com.kar.horoscope.viewmodels.showcompatibility.ShowCompatibilityVMFactory
import com.kar.horoscope.viewmodels.showcompatibility.ShowCompatibilityViewModel
import kotlinx.android.synthetic.main.activity_show_compatibility.*

class ShowCompatibility : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_compatibility)

        title = "Compatibility"
        val intent = intent

        val male = intent.getStringExtra("MaleName" )
        val female = intent.getStringExtra("FemaleName" )

        val bitmapMale = intent.getParcelableExtra<Bitmap>("MaleBitmap")
        val bitmapFemale = intent.getParcelableExtra<Bitmap>("FemaleBitmap")

        maleZodiac.text = male
        femaleZodiac.text = female

        designText(maleZodiac)
        designText(femaleZodiac)

        maleImage.setImageBitmap(bitmapMale)
        femaleImage.setImageBitmap(bitmapFemale)

        val finder = "${male.toLowerCase()}-${female.toLowerCase()}"
        val repository = ShowRepository()

        val viewModel: ShowCompatibilityViewModel by lazy {
            ViewModelProviders.of(this,
                ShowCompatibilityVMFactory(repository)
            ).get(ShowCompatibilityViewModel::class.java)
        }


        compText.text = viewModel.getText( finder )
    }

    private fun designText( txt: TextView) {
        txt.setTextColor(Color.WHITE)
        txt.setTypeface(txt.typeface, Typeface.BOLD_ITALIC )
        txt.textSize = 18.toFloat()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        startActivity( Intent ( this, MainActivity::class.java) )
        finish()
    }

}
