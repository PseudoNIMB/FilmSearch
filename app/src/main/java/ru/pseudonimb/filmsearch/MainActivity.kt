package ru.pseudonimb.filmsearch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClickButton1(view: View) {
        Toast.makeText(this, "Меню", Toast.LENGTH_SHORT).show()
    }

    fun onClickButton2(view: View) {
        Toast.makeText(this, "Избранное", Toast.LENGTH_SHORT).show()
    }

    fun onClickButton3(view: View) {
        Toast.makeText(this, "Посмотреть позже", Toast.LENGTH_SHORT).show()
    }

    fun onClickButton4(view: View) {
        Toast.makeText(this, "Подборки", Toast.LENGTH_SHORT).show()
    }

    fun onClickButton5(view: View) {
        Toast.makeText(this, "Настройки", Toast.LENGTH_SHORT).show()
    }
}