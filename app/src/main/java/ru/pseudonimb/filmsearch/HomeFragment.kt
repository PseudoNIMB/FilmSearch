package ru.pseudonimb.filmsearch

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {
    private lateinit var filmsAdapter: FilmListRecyclerAdapter
    private val filmsDataBase = listOf(
        Film("Flash", R.drawable.flash, "Description"),
        Film("Ghost Busters!", R.drawable.ghostbusters, "Description"),
        Film("Back to the Future", R.drawable.backtothefuture, "Description"),
        Film("Jaws", R.drawable.jaws, "Description"),
        Film("Jurassic Park", R.drawable.jurassic, "Description"),
        Film("Raiders", R.drawable.raiders, "Description"),
        Film("Top Gun", R.drawable.topgun, "Description"),
        Film("WandaVision", R.drawable.wandavision, "Description"),

        )


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //находим наш RV
        main_recycler.apply {
            //Инициализируем наш адаптер в конструктор передаем анонимно инициализированный интерфейс
            filmsAdapter = FilmListRecyclerAdapter(object : FilmListRecyclerAdapter.OnItemClickListener {
                override fun click(film: Film) {
                    (requireActivity() as MainActivity).launchDetailsFragment(film)
                }
            })
            //Присваиваем адаптер
            adapter = filmsAdapter
            //Присвои layoutmanager
            layoutManager = LinearLayoutManager(requireContext())
            //Применяем декоратор для отступов
            val decorator = TopSpacingItemDecoration(8)
            addItemDecoration(decorator)
        }
        //Кладем нашу БД в RV
        filmsAdapter.addItems(filmsDataBase)
    }



}