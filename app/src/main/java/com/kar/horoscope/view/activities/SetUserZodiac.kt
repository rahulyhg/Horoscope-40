package com.kar.horoscope.view.activities

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.NumberPicker
import com.kar.horoscope.R
import com.kar.horoscope.models.Preference
import com.kar.horoscope.repository.SharedPrefPreferenceService
import com.kar.horoscope.util.ChangeDividerColor
import kotlinx.android.synthetic.main.activity_set_user_zodiac.*

class SetUserZodiac : AppCompatActivity() {

    var selectedItem : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_set_user_zodiac)


        val names = resources.getStringArray(R.array.Zodiacs)
        numberPicker.minValue = 0
        numberPicker.maxValue = names.size-1
        numberPicker.displayedValues = names
        numberPicker.descendantFocusability = NumberPicker.FOCUS_BLOCK_DESCENDANTS
        numberPicker.wrapSelectorWheel = false
        ChangeDividerColor().changeDividerColor( numberPicker, Color.TRANSPARENT )

        numberPicker.setOnValueChangedListener { numberPicker, _, _ ->
            selectedItem = numberPicker.value
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()

        startActivity(Intent ( this, MainActivity::class.java ) )
        finish()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.set, menu)
        return true
    }

    @SuppressLint("CheckResult")
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if( item.itemId == R.id.set ) {

            val sharedPreferences = getSharedPreferences( "Preference", Context.MODE_PRIVATE )
            val sharedPrefPreferenceService = SharedPrefPreferenceService ( sharedPreferences )
            val preference = Preference ( "Name", selectedItem )
            sharedPrefPreferenceService.savePreference( preference )

            val intent = Intent ( this, Forecast::class.java )
            intent.putExtra("Title", sharedPrefPreferenceService.getPreference("Name", -1 ) )
            startActivity(intent )
            finish()

            return true
        }

        return super.onOptionsItemSelected(item)
    }
}
