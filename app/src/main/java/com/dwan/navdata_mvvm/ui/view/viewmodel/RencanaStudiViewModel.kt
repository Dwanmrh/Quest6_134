package com.dwan.navdata_mvvm.ui.view.viewmodel

import androidx.lifecycle.ViewModel
import com.dwan.navdata_mvvm.model.RencanaStudi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class RencanaStudiViewModel : ViewModel() {

    private val _krsState = MutableStateFlow(RencanaStudi())
    val krsStateUi: StateFlow<RencanaStudi> = _krsState.asStateFlow()

    fun setMataKuliah(mkPilihan: String) {
        _krsState.update { state -> state.copy(namaMK = mkPilihan) }
    }
    fun setKelas(kelasPilihan: String) {
        _krsState.update { state -> state.copy(kelas = kelasPilihan) }
    }
    fun saveDataKRS(data: MutableList<String>) {
        _krsState.update { status -> status.copy(
            namaMK = data[0],
            kelas  = data[1]
        )
        }
    }
}