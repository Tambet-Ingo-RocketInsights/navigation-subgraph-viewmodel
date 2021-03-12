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
            goSharedButton.setOnClickListener {
                goShared(nameInput.text.toString())
            }

            goSharedButton.isEnabled = false
            nameInput.doAfterTextChanged {
                goSharedButton.isEnabled = it?.isNotBlank() ?: false
            }

            goSingleButton.setOnClickListener {
                goSingle(nameInput.text.toString())
            }

            goSingleButton.isEnabled = false
            nameInput.doAfterTextChanged {
                goSingleButton.isEnabled = it?.isNotBlank() ?: false
            }
        }
    }

    private fun goShared(name: String) {
        val data = MyData(name, 123)
        val args = bundleOf("data" to data)
        findNavController().navigate(R.id.action_homeFragment_to_dataGraph, args)
    }

    private fun goSingle(name: String) {
        val data = MyData(name, 123)
        val args = bundleOf("data" to data)
        findNavController().navigate(R.id.action_homeFragment_to_singleFragment, args)
    }
}