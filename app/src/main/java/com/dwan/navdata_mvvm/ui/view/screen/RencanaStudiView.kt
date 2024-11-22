package com.dwan.navdata_mvvm.ui.view.screen

import androidx.compose.runtime.Composable
import com.dwan.navdata_mvvm.model.Mahasiswa

@Composable
fun RencanaStudiView(
    mahasiswa: Mahasiswa,
    onSubmitButtonClicked: (MutableList<String>) -> Unit,
    onBackButtonClicked: () -> Unit
) {}