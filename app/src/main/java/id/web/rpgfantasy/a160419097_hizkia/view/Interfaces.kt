package id.web.rpgfantasy.a160419097_hizkia.view

import android.view.View
import android.widget.CompoundButton
import id.web.rpgfantasy.a160419097_hizkia.model.Category
import id.web.rpgfantasy.a160419097_hizkia.model.EBook
import id.web.rpgfantasy.a160419097_hizkia.model.Profile

interface CategorySaveListener{
    fun onSaveCategoryClicked(view:View, obj: Category)
}
interface EbookSaveListener{
    fun OnSaveEbookClicked(view:View, obj:EBook)
}
interface ProfileSaveListener{
    fun OnSaveProfileClicked(view:View, obj:Profile)
}

interface  EbookDeleteListener{
    fun onDeleteEboookClicked(view:View, obj: EBook)
}

interface EbookEditListener{
    fun OnEditEbookClicked(view:View, obj:EBook)
}
interface ProfileEditListener{
    fun OnEditProfileClicked(view:View, obj:Profile)
}

interface NavigateToListEbookListener{
    fun onNavigateToListEbookListener(view: View)
}
interface NavigateToDetailEbookListener{
    fun onNavigateToDetailEbookListener(view: View)
}
interface NavigateToDetailProfileListener{
    fun onNavigateToDetailProfileListener(view: View)
}
interface NavigateToNewEbookListener{
    fun onNavigateToNewEbookListener(view: View)
}
interface NavigateToNewCategoryListener{
    fun onNavigateToNewCategoryListener(view: View)
}
interface NavigateToNewProfileListener{
    fun onNavigateToNewProfileListener(view: View)
}
interface NavigateToEditEbookListener{
    fun onNavigateToEditEbookListener(view: View, id: Int)
}
interface NavigateToAboutListener{
    fun onNavigateToAboutListener(view: View)
}
interface NavigateToAuthorListener{
    fun onNavigateToAuthorListener(view: View)
}
interface NavigateToReviewsListener{
    fun onNavigateToReviewsListener(view: View)
}