package ee.it.navigation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import ee.it.navigation.databinding.FragmentSingleBinding

class SingleFragment : Fragment(R.layout.fragment_single) {
    private val viewModel: MyDataViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(FragmentSingleBinding.bind(view)) {
            doneButton.setOnClickListener {
                findNavController().navigateUp()
            }

            textView.text = viewModel.data.name
        }
    }
}