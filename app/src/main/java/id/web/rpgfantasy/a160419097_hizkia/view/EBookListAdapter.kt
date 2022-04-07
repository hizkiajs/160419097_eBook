package id.web.rpgfantasy.a160419097_hizkia.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import id.web.rpgfantasy.a160419097_hizkia.R
import id.web.rpgfantasy.a160419097_hizkia.model.EBook
import id.web.rpgfantasy.a160419097_hizkia.util.loadImage
import kotlinx.android.synthetic.main.e_book_list_item.view.*

class EBookListAdapter(val eBookList:ArrayList<EBook>):
    RecyclerView.Adapter<EBookListAdapter.EBookViewHolder>(){
    class EBookViewHolder(var view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EBookViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.e_book_list_item, parent, false)
        return EBookViewHolder(view)
    }

    override fun onBindViewHolder(holder: EBookViewHolder, position: Int) {
        val eBook = eBookList[position]
        with(holder.view){
            txtIDEBookList.text = eBook.id.toString()
            txtNameEBookList.text = eBook.nama.toString()
            btnDetailEBookList.setOnClickListener {
                val action = EBookListFragmentDirections.actionEBookListFragmentToEBookDetailFragment(eBook.id.toString())
                Navigation.findNavController(it).navigate(action)
            }
            imgEBookListPhoto.loadImage(eBook.photo, progressLoadingeBookPhoto)
        }
    }

    override fun getItemCount() = eBookList.size


    fun updateeBookList(neweBookList : ArrayList<EBook>){
        eBookList.clear()
        eBookList.addAll(neweBookList)
        notifyDataSetChanged()
    }
}