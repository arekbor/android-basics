package pl.ar97.androidstudiobasics

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import pl.ar97.androidstudiobasics.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {
    private val mainVm by activityViewModels<MainViewModel>()
    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindUserData(mainVm.getUser())
    }

    private fun bindUserData(user: User?) {
        user?: return

        binding.imageView.setImageResource(user.image)
        binding.nameTv.text = "${user.name} ${user.surname}"
        binding.technologyTv.text = user.technology
        binding.birthTv.text = user.birthDate
        binding.cityTv.text = user.city
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}