package br.com.mateusfiereck.androidroomwithcoroutines.ui

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import br.com.mateusfiereck.androidroomwithcoroutines.R
import br.com.mateusfiereck.androidroomwithcoroutines.data.model.News
import org.koin.android.viewmodel.ext.android.sharedViewModel

class NewsAddFragment : Fragment(R.layout.fragment_news_add) {

    private val viewModel: NewsViewModel by sharedViewModel()

    private lateinit var inputTitle: EditText
    private lateinit var inputText: EditText
    private lateinit var buttonSave: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        inputTitle = view.findViewById(R.id.et_title)
        inputText = view.findViewById(R.id.et_text)
        buttonSave = view.findViewById(R.id.bt_save)

        buttonSave.setOnClickListener {
            val news = News(null, inputTitle.text.toString(), inputText.text.toString())

            if (news.title.isNotBlank() && news.text.isNotBlank()) {
                viewModel.addNews(news)
                requireActivity().onBackPressed()
            } else {
                Toast.makeText(
                    requireContext(),
                    getString(R.string.error_inputs),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}
