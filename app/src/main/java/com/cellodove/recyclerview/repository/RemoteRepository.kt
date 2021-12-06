package com.cellodove.recyclerview.repository

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

class RemoteRepository {
    private val baseJob = SupervisorJob()
    private val uiScope = CoroutineScope(Dispatchers.Main + baseJob)


}