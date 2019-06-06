package com.kar.horoscope.repository

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.kar.horoscope.models.DayModel
import com.kar.horoscope.service.FirebaseService
import io.reactivex.Observable
import java.util.*

class FirebaseRepository : FirebaseService {

    private val ref = FirebaseDatabase.getInstance().reference


    override fun getData ( date: String, titleZodiac: String ): Observable<DayModel> {

        println ( "The date is -> $date" )
        ref.keepSynced(true)
        val query = ref.child(titleZodiac).orderByChild("date" ).equalTo( date )


        return Observable.create {

            query.addValueEventListener(object : ValueEventListener {

                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    if ( dataSnapshot.exists() ) {
                        for ( snapshot in dataSnapshot.children ) {
                            val cur = snapshot.getValue(DayModel::class.java)
                            if ( cur != null )
                                it.onNext( cur )
                        }
                    }
                }

                override fun onCancelled(datasnapshot: DatabaseError) {
                    it.onError(error("Error occurred") )
                    query.removeEventListener(this)
                }

            })
        }

    }

    override fun pushDailyData(model: DayModel) {
    }

    override fun getDate() : String {
        val calendar = Calendar.getInstance()

        val day = calendar.get ( Calendar.DAY_OF_MONTH )
        val month = calendar.get ( Calendar.MONTH ) + 1
        val year = calendar.get( Calendar.YEAR ).toString()

        var today = day.toString()
        var todayMonth = month.toString()

        if( day < 10 )      today = "0$day"
        if ( month < 10 )   todayMonth = "0$month"

        return "$today/$todayMonth/$year"
    }

    override fun getTitle(): String = "Aries"

}