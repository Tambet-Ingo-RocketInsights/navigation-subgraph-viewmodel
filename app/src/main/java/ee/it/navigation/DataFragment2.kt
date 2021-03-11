package ee.it.navigation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import ee.it.navigation.databinding.FragmentData2Binding

class DataFragment2 : Fragment(R.layout.fragment_data2) {
    private val viewModel: MyDataViewModel by navGraphViewModels(R.id.data_graph)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(FragmentData2Binding.bind(view)) {
            textView.text = viewModel.data.name

            doneButton.setOnClickListener {
                findNavController().popBackStack(R.id.homeFragment, false)
            }
        }
    }
}