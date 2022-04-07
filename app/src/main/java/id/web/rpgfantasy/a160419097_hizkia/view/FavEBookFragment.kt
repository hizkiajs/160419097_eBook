package id.web.rpgfantasy.a160419097_hizkia.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import id.web.rpgfantasy.a160419097_hizkia.R
import id.web.rpgfantasy.a160419097_hizkia.model.EBook
import id.web.rpgfantasy.a160419097_hizkia.viewmodel.EBookViewModel
import kotlinx.android.synthetic.main.fragment_e_book_list.*
import kotlinx.android.synthetic.main.fragment_e_book_list.recView
import kotlinx.android.synthetic.main.fragment_e_book_list.txtError
import kotlinx.android.synthetic.main.fragment_fav_e_book.*

/**
 * A simple [Fragment] subclass.
 * Use the [FavEBookFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FavEBookFragment : Fragment() {
    private lateinit var viewModel : EBookViewModel
    private val eBookListAdapter = EBookListAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fav_e_book, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProvider(this).get(EBookViewModel::class.java)
        viewModel.refresh()

        recVieww.layoutManager = LinearLayoutManager(context)
        recVieww.adapter = eBookListAdapter

        observeViewModel()

        refreshLayout.setOnRefreshListener {
            recVieww.visibility = View.GONE
            txtErrorr.visibility = View.GONE
            progressLoadd.visibility = View.VISIBLE
            viewModel.refresh()
            refreshLayoutt.isRefreshing = false
        }
    }

    private fun observeViewModel() {
        viewModel.eBooksLiveData.observe(viewLifecycleOwner){
            var arr: ArrayList<EBook> = arrayListOf()
            arr.add(it[0])
            arr.add(it[1])
            eBookListAdapter.updateeBookList(arr)
        }
        viewModel.eBooksLoadErrorLiveData.observe(viewLifecycleOwner){
            if(it == true){
                txtErrorr.visibility = View.VISIBLE
            }else{
                txtErrorr.visibility = View.GONE
            }
        }
        viewModel.loadingLiveData.observe(viewLifecycleOwner){
            if(it){
                recVieww.visibility = View.GONE
                progressLoadd.visibility = View.VISIBLE
            } else{
                recVieww.visibility = View.VISIBLE
                progressLoadd.visibility = View.GONE
            }
        }
    }
}