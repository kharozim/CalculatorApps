package id.refactory.calculatorapps

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    var isNewOperation=true
    var dot=false
    fun btNumberEvent(view : View){
        if (isNewOperation){

        }
    }
}