package id.web.rpgfantasy.a160419097_hizkia.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import id.web.rpgfantasy.a160419097_hizkia.R
import id.web.rpgfantasy.a160419097_hizkia.viewmodel.EBookViewModel
import kotlinx.android.synthetic.main.fragment_e_book_list.*

/**
 * A simple [Fragment] subclass.
 * Use the [EBookListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class EBookListFragment : Fragment() {
    private lateinit var viewModel : EBookViewModel
    private val eBookListAdapter = EBookListAdapter(arrayListOf(), "eBooklist")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_e_book_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProvider(this).get(EBookViewModel::class.java)
        viewModel.refresh()

        recView.layoutManager = LinearLayoutManager(context)
        recView.adapter = eBookListAdapter

        observeViewModel()

        refreshLayout.setOnRefreshListener {
            recView.visibility = View.GONE
            txtError.visibility = View.GONE
            progressLoad.visibility = View.VISIBLE
            viewModel.refresh()
            refreshLayout.isRefreshing = false
        }
    }

    private fun observeViewModel() {
        viewModel.eBooksLiveData.observe(viewLifecycleOwner){
            eBookListAdapter.updateeBookList(it)
        }
        viewModel.eBooksLoadErrorLiveData.observe(viewLifecycleOwner){
            if(it == true){
                txtError.visibility = View.VISIBLE
            }else{
                txtError.visibility = View.GONE
            }
        }
        viewModel.loadingLiveData.observe(viewLifecycleOwner){
            if(it){
                recView.visibility = View.GONE
                progressLoad.visibility = View.VISIBLE
            } else{
                recView.visibility = View.VISIBLE
                progressLoad.visibility = View.GONE
            }
        }
    }
}