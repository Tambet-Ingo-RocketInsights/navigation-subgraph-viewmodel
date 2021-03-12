package ee.it.navigation.data

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import ee.it.navigation.data.databinding.FragmentData1Binding

class DataFragment1 : Fragment(R.layout.fragment_data1) {
    private val viewModel: MyDataViewModel by navGraphViewModels(R.id.data_graph)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(FragmentData1Binding.bind(view)) {
            textView.text = viewModel.data.name

            nextButton.setOnClickListener {
                findNavController().navigate(R.id.action_dataFragment1_to_dataFragment2)
            }
        }
    }
}