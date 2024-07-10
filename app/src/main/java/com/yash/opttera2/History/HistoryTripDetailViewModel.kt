package com.yash.opttera2.History

import androidx.lifecycle.ViewModel
import com.yash.opttera2.History.models.TabUiData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class HistoryTripDetailViewModel: ViewModel() {


    private val _tabData = MutableStateFlow(TabUiData())
    val tabData: StateFlow<TabUiData> = _tabData.asStateFlow()



    fun updateTab1Data() {
        // Update the data for Tab 1
    _tabData.update {
        it.copy(currentRoute = it.optimalRoute)
    }
    }

    fun updateTab2Data() {
        // Update the data for Tab 2
        _tabData.update {
            it.copy(currentRoute = it.fastestRoute)
        }
    }

    fun updateTab3Data() {
        // Update the data for Tab 3
        _tabData.update {
            it.copy(currentRoute = it.tenMinRoute)
        }
    }



}