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
import id.web.rpgfantasy.a160419097_hizkia.databinding.FragmentCreateCategoryBinding
import id.web.rpgfantasy.a160419097_hizkia.databinding.FragmentCreateProfileBinding
import id.web.rpgfantasy.a160419097_hizkia.databinding.FragmentProfileDetailBinding
import id.web.rpgfantasy.a160419097_hizkia.model.Profile
import id.web.rpgfantasy.a160419097_hizkia.util.loadImage
import id.web.rpgfantasy.a160419097_hizkia.viewmodel.ProfileViewModel
import kotlinx.android.synthetic.main.fragment_profile.*
import kotlinx.android.synthetic.main.fragment_profile_detail.*

/**
 * A simple [Fragment] subclass.
 * Use the [ProfileDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProfileDetailFragment : Fragment(),ProfileEditListener {
    private lateinit var viewModel : ProfileViewModel
    private lateinit var dataBinding: FragmentProfileDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_profile_detail, container, false)
        dataBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_profile_detail, container, false )
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var id = ""
        arguments?.let {
            id = ProfileDetailFragmentArgs.fromBundle(requireArguments()).idprofile
        }
        viewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)
        viewModel.fetch(id.toInt())
        dataBinding.editProfileListener = this


        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.profileLiveData.observe(viewLifecycleOwner){
            dataBinding.pfp=it
//            editNama.setText(it.nama)
//            editTanggalLahir.setText(it.tanggalLahir)
//            editJenisKelamin.setText(it.jenisKelamin)
//            editEmail.setText(it.email)
//            editNoHP.setText(it.noHP)
//            txtIDProfileDetail.text = it.id.toString()
//            imgProfileDetailPhoto.loadImage(it.photo.toString())
        }
    }


    override fun onEditProfileClicked(view: View, obj: Profile) {

        obj?.let{
            viewModel.update(obj)
            Toast.makeText(view.context, "Profile Updated.", Toast.LENGTH_SHORT).show()
            Navigation.findNavController(view).popBackStack()
        }
    }

}