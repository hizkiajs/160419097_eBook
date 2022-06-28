package id.web.rpgfantasy.a160419097_hizkia.view

import android.view.View
import android.widget.CompoundButton
import id.web.rpgfantasy.a160419097_hizkia.model.Category

interface CategorySaveListener{
    fun onSaveCategoryClicked(view:View, obj: Category)
}