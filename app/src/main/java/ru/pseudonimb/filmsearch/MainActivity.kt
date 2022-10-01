package ru.pseudonimb.filmsearch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initNavigation()
    }

    val filmsDataBase = listOf(
        Film("Back to the Future", R.drawable.backtothefuture, "Back to the Future"),
        Film("Flash", R.drawable.flash, "Flash"),
        Film("Ghostbusters", R.drawable.ghostbusters, "GhostBusters!"),
        Film("Jaws", R.drawable.jaws, "Jaws"),
        Film("Jurassic Park", R.drawable.jurassic, "Jurassic park"),
        Film("Raiders", R.drawable.raiders, "Raiders"),
        Film("Top Gun", R.drawable.topgun, "Top Gun"),
        Film("WandaVision", R.drawable.wandavision, "WandaVision")
    )

    private fun initNavigation() {
        topAppBar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.settings -> {
                    Toast.makeText(this, "Настройки", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }

        bottom_navigation.setOnNavigationItemSelectedListener {

            when (it.itemId) {
                R.id.favorites -> {
                    Toast.makeText(this, "Избранное", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.watch_later -> {
                    Toast.makeText(this, "Посмотреть похже", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.selections -> {
                    Toast.makeText(this, "Подборки", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }
    }
}