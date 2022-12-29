package ru.pseudonimb.filmsearch.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.pseudonimb.filmsearch.databinding.FragmentSelectionsBinding
import ru.pseudonimb.filmsearch.utils.AnimationHelper

class SelectionsFragment : Fragment() {

    private var _binding: FragmentSelectionsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSelectionsBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        AnimationHelper.performFragmentCircularRevealAnimation(binding.selectionsFragmentRoot, requireActivity(), 4)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}