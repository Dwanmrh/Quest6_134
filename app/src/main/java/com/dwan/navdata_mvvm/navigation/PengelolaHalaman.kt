package com.dwan.navdata_mvvm.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dwan.navdata_mvvm.ui.view.screen.DetailView
import com.dwan.navdata_mvvm.ui.view.screen.MahasiswaFormView
import com.dwan.navdata_mvvm.ui.view.screen.RencanaStudiView
import com.dwan.navdata_mvvm.ui.view.screen.SplashView
import com.dwan.navdata_mvvm.ui.view.viewmodel.MahasiswaViewModel
import com.dwan.navdata_mvvm.ui.view.viewmodel.RencanaStudiViewModel

enum class Halaman {
    Splash,
    Mahasiswa,
    Matakuliah,
    Tampil
}

@Composable
fun MahasiswaApp(
    modifier: Modifier = Modifier,
    mahasiswaViewModel: MahasiswaViewModel = viewModel(),
    krsViewModel: RencanaStudiViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {
    val mahasiswaUiState = mahasiswaViewModel.statusUI.collectAsState().value
    val rencanaStudiUiState = krsViewModel.krsStateUi.collectAsState().value

    NavHost(
        navController = navController,
        startDestination = Halaman.Splash.name,
        modifier = modifier.padding()
    ) {
        // Halaman Splash
        composable(route = Halaman.Splash.name) {
            SplashView(onMulaiButton = {
                navController.navigate(Halaman.Mahasiswa.name)
            })
        }
        // Halaman Form Mahasiswa
        composable(route = Halaman.Mahasiswa.name) {
            MahasiswaFormView(
                onSubmitButtonClicked = {
                    mahasiswaViewModel.saveDataMahaSiswa(it)
                    navController.navigate(Halaman.Matakuliah.name)
                },
                onBackButtonClicked = { navController.popBackStack() }
            )
        }
        // Halaman Rencana Studi
        composable(route = Halaman.Matakuliah.name) {
            RencanaStudiView(
                mahasiswa = mahasiswaUiState,
                onSubmitButtonClicked = { krs -> krsViewModel.saveDataKRS(krs)
                    navController.navigate(Halaman.Tampil.name)
                },
                onBackButtonClicked = { navController.popBackStack() }
            )
        }
        // Halaman Detail/Tampil
        composable(route = Halaman.Tampil.name) {
            DetailView(
                mahasiswa = mahasiswaUiState,
                rencanaStudi = rencanaStudiUiState,
                onBackButtonClicked = { navController.popBackStack() },
                onResetButtonClicked = {
                    navController.navigate(Halaman.Splash.name) {
                        popUpTo(Halaman.Splash.name) { inclusive = true }
                    }
                }
            )
        }
    }
}