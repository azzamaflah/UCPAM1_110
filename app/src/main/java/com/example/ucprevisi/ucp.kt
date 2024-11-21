package com.example.ucprevisi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview

@Preview(showBackground = true)
@Composable
fun ucp(modifier: Modifier = Modifier) {

    var dariKota by remember { mutableStateOf("") }
    var keKota by remember { mutableStateOf("") }
    var tanggalPergi by remember { mutableStateOf("") }
    var tanggalPulang by remember { mutableStateOf("") }
    var kelasTerpilih by remember { mutableStateOf("Ekonomi") }
    val pilihanKelas = listOf("Ekonomi", "Bisnis")


    var tampilDariKota by remember { mutableStateOf("") }
    var tampilKeKota by remember { mutableStateOf("") }
    var tampilTanggalPergi by remember { mutableStateOf("") }
    var tampilTanggalPulang by remember { mutableStateOf("") }
    var tampilKelas by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Selamat Sore,\nazzam",
            style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold)
        )
        Spacer(modifier = Modifier.height(16.dp))


        Text(
            text = "Pemesanan",
            style = TextStyle(fontSize = 22.sp, fontWeight = FontWeight.SemiBold)
        )


        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = dariKota,
            onValueChange = { dariKota = it },
            label = { Text("Dari") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
        )
        TextField(
            value = keKota,
            onValueChange = { keKota = it },
            label = { Text("Ke") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
        )
        TextField(
            value = tanggalPergi,
            onValueChange = { tanggalPergi = it },
            label = { Text("Tanggal Pergi") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
        )
        TextField(
            value = tanggalPulang,
            onValueChange = { tanggalPulang = it },
            label = { Text("Tanggal Pulang") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
        )


        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Kelas",
            style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Medium)
        )
        pilihanKelas.forEach { pilihan ->
            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = kelasTerpilih == pilihan,
                    onClick = { kelasTerpilih = pilihan }
                )
                Text(pilihan)
            }
        }


        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                tampilDariKota = dariKota
                tampilKeKota = keKota
                tampilTanggalPergi = tanggalPergi
                tampilTanggalPulang = tanggalPulang
                tampilKelas = kelasTerpilih
            },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(text = "Simpan")
        }
    }
    Spacer(modifier = Modifier.height(24.dp))
    Text(
        text = "Detail Data",
        style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.SemiBold)
    )
    TampilkanData("Keberangkatan", tampilTanggalPergi, tampilDariKota)
    TampilkanData("Kedatangan", tampilTanggalPulang, tampilKeKota)

}



@Composable
fun TampilkanData(label: String, tanggal: String, lokasi: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black, shape = RoundedCornerShape(8.dp))
            .padding(16.dp)
            .padding(vertical = 8.dp)
    ) {
        Text(
            text = "$label: $tanggal - $lokasi",
            color = Color.White,
            style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Normal)
        )
    }
}
