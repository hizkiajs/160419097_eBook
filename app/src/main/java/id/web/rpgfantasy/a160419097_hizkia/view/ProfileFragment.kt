package id.web.rpgfantasy.a160419097_hizkia.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import id.web.rpgfantasy.a160419097_hizkia.R
import id.web.rpgfantasy.a160419097_hizkia.databinding.FragmentProfileBinding
import id.web.rpgfantasy.a160419097_hizkia.util.loadImage
import id.web.rpgfantasy.a160419097_hizkia.viewmodel.ProfileViewModel
import kotlinx.android.synthetic.main.fragment_profile.*

/**
 * A simple [Fragment] subclass.
 * Use the [ProfileFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProfileFragment : Fragment(), NavigateToDetailProfileListener {
    private lateinit var viewModel : ProfileViewModel
    private lateinit var dataBinding:FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        dataBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_profile, container, false )
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)
        viewModel.fetch(1)
        dataBinding.navigateToDetailProfileListener = this
        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.profileLiveData.observe(viewLifecycleOwner){
            dataBinding.profile = it
        }
    }

    override fun onNavigateToDetailProfileListener(view: View) {
        var id = view.tag
        var action: NavDirections = ProfileFragmentDirections.actionProfileFragmentToProfileDetailFragment(id.toString())
        Navigation.findNavController(view).navigate(action)
    }
}