package id.web.rpgfantasy.a160419097_hizkia.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import id.web.rpgfantasy.a160419097_hizkia.R
import id.web.rpgfantasy.a160419097_hizkia.databinding.FragmentCreateEBookBinding
import id.web.rpgfantasy.a160419097_hizkia.databinding.FragmentCreateProfileBinding
import id.web.rpgfantasy.a160419097_hizkia.model.EBook
import id.web.rpgfantasy.a160419097_hizkia.model.Profile
import id.web.rpgfantasy.a160419097_hizkia.viewmodel.DetailViewModel
import id.web.rpgfantasy.a160419097_hizkia.viewmodel.ProfileViewModel


/**
 * A simple [Fragment] subclass.
 * Use the [CreateProfileFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CreateProfileFragment : Fragment(), ProfileSaveListener {
    private lateinit var viewModel: ProfileViewModel
    private lateinit var dataBinding: FragmentCreateProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        dataBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_create_profile, container, false )
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)
        dataBinding.profile = Profile("","","","","","")
        dataBinding.profileSaveListener = this

    }

    override fun onSaveProfileClicked(view: View, obj: Profile) {
        val list = listOf(obj)
        viewModel.addProfile(list)
        Toast.makeText(view.context, "Profile Created.", Toast.LENGTH_SHORT).show()
        Navigation.findNavController(view).popBackStack()
    }
}