package com.kar.horoscope.repository

import com.google.firebase.firestore.FirebaseFirestore
import com.kar.horoscope.models.DayModel
import com.kar.horoscope.service.FirebaseService
import io.reactivex.Observable
import java.util.*

class FirebaseRepository : FirebaseService {

    private val ref = FirebaseFirestore.getInstance()

    override fun getData ( date: String, titleZodiac: String ): Observable<DayModel> {
        val collectionReference = ref.collection(titleZodiac)
        val query = collectionReference.whereEqualTo( "date", date )

        return Observable.create {
            query.get().addOnCompleteListener { task ->
                if( task.isSuccessful ) {
                    for ( snapshot in task.result!!) {
                        val txt = snapshot.toObject(DayModel::class.java)
                        it.onNext ( txt )
                    }
                }
            }
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

}