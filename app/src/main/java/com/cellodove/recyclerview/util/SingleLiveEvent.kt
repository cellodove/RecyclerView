package com.cellodove.recyclerview.util

import androidx.annotation.MainThread
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class SingleLiveEvent<T> : MutableLiveData<T>() {
    @MainThread
    override fun observe(owner: LifecycleOwner, observer: Observer<in T?>) {
        super.observe(owner, Observer { data ->
            if (data == null) return@Observer
            observer.onChanged(data)
            value = null
        })
    }

    @MainThread
    fun sendEvent(data: T) {
        value = data
    }

    fun postEvent(viewModelScope: CoroutineScope, data: T) {
        viewModelScope.launch {
            value = data
        }
    }
}