package ru.pseudonimb.filmsearch.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import ru.pseudonimb.filmsearch.view.rv_adapters.FilmListRecyclerAdapter
import ru.pseudonimb.filmsearch.R
import ru.pseudonimb.filmsearch.view.rv_adapters.TopSpacingItemDecoration
import ru.pseudonimb.filmsearch.databinding.FragmentHomeBinding
import ru.pseudonimb.filmsearch.domain.Film
import ru.pseudonimb.filmsearch.utils.AnimationHelper
import ru.pseudonimb.filmsearch.view.MainActivity

import java.util.*

class HomeFragment : Fragment() {
    private lateinit var filmsAdapter: FilmListRecyclerAdapter
    private val filmsDataBase = listOf(
        Film("Flash", R.drawable.flash, "Description", 7.7f),
        Film("Ghost Busters!", R.drawable.ghostbusters, "Description", 6.3f),
        Film("Back to the Future", R.drawable.backtothefuture, "Description", 5.2f),
        Film("Jaws", R.drawable.jaws, "Description", 9.2f),
        Film("Jurassic Park", R.drawable.jurassic, "Description", 8.3f),
        Film("Raiders", R.drawable.raiders, "Description", 7.2f),
        Film("Top Gun", R.drawable.topgun, "Description", 5.8f),
        Film("WandaVision", R.drawable.wandavision, "Description", 8.8f),
        )

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        AnimationHelper.performFragmentCircularRevealAnimation(binding.homeFragmentRoot, requireActivity(), 1)

        initSearchView()

        //находим наш RV
        initRecycler()
        //Кладем нашу БД в RV
        filmsAdapter.addItems(filmsDataBase)
    }

    private fun initSearchView() {
        binding.searchView.setOnClickListener {
            binding.searchView.isIconified = false
        }

        //Подключаем слушателя изменений введенного текста в поиска
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            //Этот метод отрабатывает при нажатии кнопки "поиск" на софт клавиатуре
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }

            //Этот метод отрабатывает на каждое изменения текста
            override fun onQueryTextChange(newText: String): Boolean {
                //Если ввод пуст то вставляем в адаптер всю БД
                if (newText.isEmpty()) {
                    filmsAdapter.addItems(filmsDataBase)
                    return true
                }
                //Фильтруем список на поискк подходящих сочетаний
                val result = filmsDataBase.filter {
                    //Чтобы все работало правильно, нужно и запроси и имя фильма приводить к нижнему регистру
                    it.title.lowercase(Locale.getDefault())
                        .contains(newText.toLowerCase(Locale.getDefault()))
                }
                //Добавляем в адаптер
                filmsAdapter.addItems(result)
                return true
            }
        })
    }

    private fun initRecycler() {
        binding.mainRecycler.apply {
            filmsAdapter =
                FilmListRecyclerAdapter(object : FilmListRecyclerAdapter.OnItemClickListener {
                    override fun click(film: Film) {
                        (requireActivity() as MainActivity).launchDetailsFragment(film)
                    }
                })
            //Присваиваем адаптер
            adapter = filmsAdapter
            //Присваиваем layout manager
            layoutManager = LinearLayoutManager(requireContext())
            //Применяем декоратор для отступов
            val decorator = TopSpacingItemDecoration(8)
            addItemDecoration(decorator)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}