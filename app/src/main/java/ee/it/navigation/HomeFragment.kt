package ee.it.navigation

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ee.it.navigation.databinding.FragmentHomeBinding

class HomeFragment : Fragment(R.layout.fragment_home) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(FragmentHomeBinding.bind(view)) {
            goButton.setOnClickListener {
                go(nameInput.text.toString())
            }

            goButton.isEnabled = false
            nameInput.doAfterTextChanged {
                goButton.isEnabled = it?.isNotBlank() ?: false
            }
        }
    }

    private fun go(name: String) {
        val data = MyData(name, 123)
        val args = bundleOf("data" to data)
        findNavController().navigate(R.id.action_homeFragment_to_dataGraph, args)
    }
}