package com.cellodove.recyclerview.extension

import android.os.Build
import android.text.Html
import android.view.View
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter

//View
@BindingAdapter(value = ["setVisible"])
fun View.setVisible(isShow: Boolean?) {
    this.isVisible = isShow ?: false
}

@BindingAdapter(value = ["onSingleClick"])
fun View.onSingleClick(block: View.OnClickListener) {
    setOnSingleClickListener(block::onClick)
}

@BindingAdapter(value = ["onLongClick"])
fun View.onLongClick(block: View.OnClickListener) {
    setOnSingleLongClickListener(block::onClick)
}

@BindingAdapter(value = ["textHtml"])
fun TextView.textHtml(value: String?) {
    value?.let {
        this.text = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            Html.fromHtml(value, Html.FROM_HTML_MODE_LEGACY)
        } else {
            @Suppress("DEPRECATION")
            Html.fromHtml(value)
        }
    }
}

@BindingAdapter(value = ["textHtml"])
fun TextView.textHtml(value: Int?) {
    value?.let {
        val text = resources.getString(it)
        this.text = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            Html.fromHtml(text, Html.FROM_HTML_MODE_LEGACY)
        } else {
            @Suppress("DEPRECATION")
            Html.fromHtml(text)
        }
    }
}

@BindingAdapter(value = ["isShow"])
fun View.setViewIsShow(isVisible: Boolean) {
    this.visibility = if (isVisible) View.VISIBLE else View.GONE
}

@BindingAdapter("visibility")
fun View.setVisibility(visible: Boolean){
    this.visibility =  if (visible) View.VISIBLE else View.GONE
}
