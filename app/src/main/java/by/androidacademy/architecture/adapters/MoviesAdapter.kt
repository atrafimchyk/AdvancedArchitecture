package by.androidacademy.architecture.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import by.androidacademy.architecture.R
import by.androidacademy.architecture.api.response.MovieJson

class MoviesAdapter(private val clickListener: (itemPosition: Int) -> Unit) :
    RecyclerView.Adapter<MovieViewHolder>() {

    private var movies: List<MovieJson> = emptyList()

    fun setMovies(movies: List<MovieJson>) {
        this.movies = movies
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movies[position]) {
            clickListener(position)
        }
    }

    override fun getItemCount(): Int {
        return movies.size
    }
}