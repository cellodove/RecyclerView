package com.cellodove.recyclerview.extension

import android.app.AlertDialog
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import androidx.fragment.app.FragmentActivity
import com.cellodove.recyclerview.R
import java.util.concurrent.atomic.AtomicBoolean

fun FragmentActivity.showAlertDialog(
    title: String? = null,
    msg: String,
    positive: String = getString(R.string.confirm),
    negative: String = getString(R.string.cancel),
    positiveCallback: () -> Unit,
    negativeCallback: (() -> Unit)? = null
) {
    AlertDialog.Builder(this).apply {
        title?.also { setTitle(it) }
        setMessage(msg)
        setCancelable(negativeCallback == null)
        setPositiveButton(positive) { _, _ -> positiveCallback() }
        setNegativeButton(negative) { _, _ -> negativeCallback?.invoke() }
        setOnCancelListener { negativeCallback?.invoke() }
    }.show()
}

fun FragmentActivity.showAlertDialogOK(
    title: String? = null,
    msg: String,
    positive: String = getString(R.string.confirm),
    positiveCallback: () -> Unit,
    negativeCallback: (() -> Unit)? = null
) {
    AlertDialog.Builder(this).apply {
        title?.also { setTitle(it) }
        setMessage(msg)
        setCancelable(negativeCallback == null)
        setPositiveButton(positive) { _, _ -> positiveCallback() }
        setOnCancelListener { negativeCallback?.invoke() }
    }.show()
}


fun EditText.afterTextChanged(afterTextChanged: (String) -> Unit) {
    this.addTextChangedListener(object : TextWatcher {
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            // EMPTY
        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            // EMPTY
        }

        override fun afterTextChanged(editable: Editable?) {
            afterTextChanged.invoke(editable.toString())
        }
    })
}

inline fun <reified T : View> T.setOnSingleClickListener(crossinline block: (T) -> Unit) {
    val intervalMs = 300L
    val canClick = AtomicBoolean(true)

    setOnClickListener { view ->
        if (canClick.getAndSet(false)) {
            view.run {
                postDelayed({
                    canClick.set(true)
                }, intervalMs)
                block(view as T)
            }
        }
    }
}

inline fun <reified T : View> T.setOnSingleLongClickListener(crossinline block: (T) -> Unit) {
    setOnLongClickListener {
        block(it as T)
        true
    }
}