package com.dwan.navdata_mvvm.ui.view.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dwan.navdata_mvvm.model.Mahasiswa
import com.dwan.navdata_mvvm.model.RencanaStudi

@Composable
fun DetailView(
    mahasiswa: Mahasiswa,
    rencanaStudi: RencanaStudi,
    onBackButtonClicked: () -> Unit,
    onResetButtonClicked: () -> Unit
) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text("Detail Mahasiswa", fontSize = 20.sp, fontWeight = FontWeight.Bold)

        // Menampilkan data Mahasiswa
        DetailRow(label = "Nama", value = mahasiswa.nama)
        DetailRow(label = "NIM", value = mahasiswa.nim)
        DetailRow(label = "Email", value = mahasiswa.email)

        Spacer(modifier = Modifier.padding(8.dp))

        // Menampilkan Rencana Studi
        Text("Rencana Studi", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        DetailRow(label = "Mata Kuliah", value = rencanaStudi.namaMK)
        DetailRow(label = "Kelas", value = rencanaStudi.kelas)

        Spacer(modifier = Modifier.padding(8.dp))

        // Tombol Navigasi
        Button(
            onClick = onBackButtonClicked,
            modifier = Modifier.fillMaxWidth()) {
            Text("Kembali")
        }
        Button(
            onClick = onResetButtonClicked,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Reset")
        }
    }
}

@Composable
fun DetailRow(label: String, value: String) {
    Column(modifier = Modifier.padding(bottom = 8.dp)) {
        Text(
            text = label,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )
        Text(
            text = value,
            fontSize = 14.sp
        )
    }
}