package br.com.mateusfiereck.androidroomwithcoroutines.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.mateusfiereck.androidroomwithcoroutines.R
import br.com.mateusfiereck.androidroomwithcoroutines.data.model.News
import timber.log.Timber

class NewsAdapter : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    private var news = emptyList<News>()

    override fun getItemCount() = news.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = NewsViewHolder(
        LayoutInflater.from(parent.context).inflate(
            R.layout.item_news,
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) = holder.bind(news[position])

    fun loadNews(items: List<News>) {
        Timber.d("loadNews")
        news = items
        notifyDataSetChanged()
    }

    inner class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val titleNews by lazy { itemView.findViewById<TextView>(R.id.title_news) }
        private val textNews by lazy { itemView.findViewById<TextView>(R.id.text_news) }

        fun bind(news: News) {
            titleNews.text = news.title
            textNews.text = news.text
        }
    }
}