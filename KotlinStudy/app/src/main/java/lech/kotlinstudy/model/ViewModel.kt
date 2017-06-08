package lech.weatherapp.model

import lech.weatherapp.db.MyDatabase
import kotlin.properties.Delegates

/**
 * Created by Android_61 on 2017/6/8.
 * Description
 * Others
 */
class ViewModel(val db: MyDatabase) {

    val myProperty by Delegates.observable(""){
        d,old,new ->db.saveChanges(this,new)
    }

    var positiveNumber=Delegates.vetoable(0){
        d,old,new ->new >=0
    }

}