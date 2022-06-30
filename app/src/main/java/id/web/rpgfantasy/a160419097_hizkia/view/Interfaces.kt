package id.web.rpgfantasy.a160419097_hizkia.view

import android.view.View
import android.widget.CompoundButton
import id.web.rpgfantasy.a160419097_hizkia.model.Category
import id.web.rpgfantasy.a160419097_hizkia.model.EBook

interface CategorySaveListener{
    fun onSaveCategoryClicked(view:View, obj: Category)
}

interface EbookSaveListener{
    fun OnSaveEbookClicked(view:View, obj:EBook)
}
interface  EbookDeleteListener{
    fun onDeleteEboookClicked(view:View, obj: EBook)
}
interface NavigateToDetailEbookListener{
    fun onNavigateToDetailEbookListener(view: View)
}