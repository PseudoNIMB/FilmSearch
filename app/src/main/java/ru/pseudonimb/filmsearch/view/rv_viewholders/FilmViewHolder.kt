package ru.pseudonimb.filmsearch.view.rv_viewholders


import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ru.pseudonimb.filmsearch.data.ApiConstants
import ru.pseudonimb.filmsearch.databinding.FilmItemBinding
import ru.pseudonimb.filmsearch.domain.Film

//В конструктор класс передается layout, который мы создали(film_item.xml)
class FilmViewHolder(private val binding: FilmItemBinding)
    : RecyclerView.ViewHolder(binding.root) {

    //Привязываем view из layout к переменным
    //private val title = binding.title
    //private val poster = binding.poster
    //private val description = binding.description

    //В этом методе кладем данные из film в наши view
    fun bind(film: Film) {
        //Устанавливаем заголовок
        binding.title.text = film.title
        //Устанавливаем постер

        //Указываем контейнер, в котором будет "жить" наша картинка
        Glide.with(itemView)
            //Загружаем сам ресурс
            .load(ApiConstants.IMAGES_URL + "w342" + film.poster)
            //Центруем изображение
            .centerCrop()
            //Указываем ImageView, куда будем загружать изображение
            .into(binding.poster)
        //Устанавливаем описание
        binding.description.text = film.description
        //Рейтинг
        binding.ratingDonut.setProgress((film.rating * 10).toInt())
    }
}