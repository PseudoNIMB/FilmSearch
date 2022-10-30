package ru.pseudonimb.filmsearch

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.pseudonimb.filmsearch.databinding.FragmentDetailsBinding

class DetailsFragment : Fragment() {
    private lateinit var film: Film

    private lateinit var binding: FragmentDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setFilmsDetails()

        binding.detailsFavorites.setOnClickListener {
            if (!film.isInFavorites) {
                binding.detailsFavorites.setImageResource(R.drawable.ic_baseline_favorite_24)
                film.isInFavorites = true
            } else {
                binding.detailsFavorites.setImageResource(R.drawable.ic_baseline_favorite_border_24)
                film.isInFavorites = false
            }
        }

        binding.detailsShare.setOnClickListener {
            //Создаем интент
            val intent = Intent()
            //Укзываем action с которым он запускается
            intent.action = Intent.ACTION_SEND
            //Кладем данные о нашем фильме
            intent.putExtra(
                Intent.EXTRA_TEXT,
                "Check out this film: ${film.title} \n\n ${film.description}"
            )
            //УКазываем MIME тип, чтобы система знала, какое приложения предложить
            intent.type = "text/plain"
            //Запускаем наше активити
            startActivity(Intent.createChooser(intent, "Share To:"))
        }
    }


    private fun setFilmsDetails() {
        //Получаем наш фильм из переданного бандла
        val film = arguments?.get("film") as Film

        //Устанавливаем заголовок
        binding.detailsToolbar.title = film.title
        //Устанавливаем картинку
        binding.detailsPoster.setImageResource(film.poster)
        //Устанавливаем описание
        binding.detailsDescription.text = film.description

        binding.detailsFavorites.setImageResource(
            if (film.isInFavorites) {
                R.drawable.ic_baseline_favorite_24
            }
            else {
                R.drawable.ic_baseline_favorite_border_24
            }
        )
    }
}