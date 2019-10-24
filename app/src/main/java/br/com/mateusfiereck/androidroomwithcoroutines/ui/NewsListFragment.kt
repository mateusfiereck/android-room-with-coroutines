package br.com.mateusfiereck.androidroomwithcoroutines.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.onNavDestinationSelected
import androidx.recyclerview.widget.DividerItemDecoration
import br.com.mateusfiereck.androidroomwithcoroutines.R
import br.com.mateusfiereck.androidroomwithcoroutines.ext.hideKeyboard
import kotlinx.android.synthetic.main.fragment_news_list.*
import org.koin.android.viewmodel.ext.android.sharedViewModel

class NewsListFragment : Fragment(R.layout.fragment_news_list) {

    private val viewModel: NewsViewModel by sharedViewModel()
    private val newsAdapter = NewsAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupObservers()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        hideKeyboard()
        setHasOptionsMenu(true)

        list_news.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                DividerItemDecoration.VERTICAL
            )
        )
        list_news.adapter = newsAdapter

        viewModel.getNews()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.news_list_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return item.onNavDestinationSelected(findNavController()) || super.onOptionsItemSelected(
            item
        )
    }

    private fun setupObservers() {
        viewModel.news.observe(this, Observer {
            it?.let { listNews ->
                newsAdapter.loadNews(listNews)
            }
        })
    }
}
