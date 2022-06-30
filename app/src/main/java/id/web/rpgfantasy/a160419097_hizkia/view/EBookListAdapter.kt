package id.web.rpgfantasy.a160419097_hizkia.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import id.web.rpgfantasy.a160419097_hizkia.R
import id.web.rpgfantasy.a160419097_hizkia.databinding.EBookListItemBinding

import id.web.rpgfantasy.a160419097_hizkia.model.EBook
import id.web.rpgfantasy.a160419097_hizkia.model.EBookDao
import id.web.rpgfantasy.a160419097_hizkia.util.loadImage
import kotlinx.android.synthetic.main.e_book_list_item.view.*

class EBookListAdapter(val eBookList:ArrayList<EBook>, val current: String, val adapterOnClick:(EBook) -> Unit):
    RecyclerView.Adapter<EBookListAdapter.EBookViewHolder>(),EbookDeleteListener, NavigateToDetailEbookListener{
    class EBookViewHolder(var view: EBookListItemBinding) : RecyclerView.ViewHolder(view.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EBookViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        //val view = inflater.inflate(R.layout.e_book_list_item, parent, false)
        val view = EBookListItemBinding.inflate(inflater,parent,false)
        //val dataBinding = DataBindingUtil.inflate(inflater,R.layout.e_book_list_item, containe, false )
        return EBookViewHolder(view)
    }

    override fun onBindViewHolder(holder: EBookViewHolder, position: Int) {
        val eBook = eBookList[position]
        holder.view.eBook = eBook
        /*with(holder.view){
            txtIDEBookList.text = eBook.id.toString()
            txtNameEBookList.text = eBook.nama.toString()

            cardView.setOnClickListener{
                var action: NavDirections
                if (current == "eBooklist"){
                    action = EBookListFragmentDirections.actionEBookListFragmentToEBookDetailFragment(eBook.id.toString())
                }
                else {
                    action = FavEBookFragmentDirections.actionItemFavToEBookDetailFragment(eBook.id.toString())
                }
                Navigation.findNavController(it).navigate(action)
            }

            /*btnDetailEBookList.setOnClickListener {
                var action: NavDirections
                if (current == "eBooklist"){
                    action = EBookListFragmentDirections.actionEBookListFragmentToEBookDetailFragment(eBook.id.toString())
                }
                else {
                    action = FavEBookFragmentDirections.actionItemFavToEBookDetailFragment(eBook.id.toString())
                }
                Navigation.findNavController(it).navigate(action)
            }*/
            imgEBookListPhoto.loadImage(eBook.photo, progressLoadingeBookPhoto)
        }*/
    }

    override fun getItemCount() = eBookList.size


    fun updateeBookList(neweBookList : List<EBook>){
        eBookList.clear()
        eBookList.addAll(neweBookList)
        notifyDataSetChanged()
    }

    override fun onDeleteEboookClicked(view: View, obj: EBook) {
        adapterOnClick(obj)
    }

    override fun onNavigateToDetailEbookListener(view: View) {
        val id = view.tag.toString().toInt()
        var action: NavDirections
        if (current == "eBooklist"){
            action = EBookListFragmentDirections.actionEBookListFragmentToEBookDetailFragment(id.toString())
        }
        else {
            action = FavEBookFragmentDirections.actionItemFavToEBookDetailFragment(id.toString())
        }
        Navigation.findNavController(view).navigate(action)
    }
}