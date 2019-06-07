package com.kar.horoscope.repository

import android.annotation.SuppressLint
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.kar.horoscope.models.DayModel
import com.kar.horoscope.service.FirebaseService
import io.reactivex.Observable
import java.text.SimpleDateFormat
import java.util.*

@Suppress("UNREACHABLE_CODE")
class FirebaseRepository : FirebaseService {

    private val ref = FirebaseDatabase.getInstance().reference

    override fun getData ( date: String, titleZodiac: String, path: String ): Observable<DayModel> {

        ref.keepSynced(true)
        val query = ref.child(titleZodiac).orderByChild(path ).equalTo( date )

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

    @SuppressLint("SimpleDateFormat")
    override fun getToday(): String {
        val calendar = Calendar.getInstance()
        val dateformat = SimpleDateFormat ( "dd/MM/yyyy" )

        return dateformat.format( calendar.time )
    }

    @SuppressLint("SimpleDateFormat")
    override fun getYesterday(): String {
        val calendar = Calendar.getInstance()
        calendar.add ( Calendar.DATE, -1 )

        val dateformat = SimpleDateFormat ( "dd/MM/yyyy" )

        return dateformat.format( calendar.time )

    }

    @SuppressLint("SimpleDateFormat")
    override fun getTomorrow(): String {

        val calendar = Calendar.getInstance()
        calendar.add ( Calendar.DATE, +1 )

        val dateformat = SimpleDateFormat ( "dd/MM/yyyy" )

        return dateformat.format( calendar.time )
    }

    override fun getMonth(): String {
        val calendar = Calendar.getInstance()
        return ( calendar.get( Calendar.MONTH ) + 1 ).toString()
    }

}