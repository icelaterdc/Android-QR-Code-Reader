package com.example.qrcodeapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.qrcodeapp.util.QRCodeUtil

@Composable
fun GenerateScreen(navController: NavController) {
    var text by remember { mutableStateOf("") }
    var bitmap by remember { mutableStateOf<Bitmap?>(null) }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        TextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Kodlanacak metni girin") },
            modifier = Modifier.fillMaxWidth()
        )
        Button(
            onClick = {
                bitmap = QRCodeUtil.generateQR(text)
            },
            modifier = Modifier.align(Alignment.CenterHorizontally).padding(top = 16.dp)
        ) {
            Text("QR Kod Oluştur")
        }
        bitmap?.let {
            Image(
                bitmap = it.asImageBitmap(),
                contentDescription = "Oluşturulan QR Kod",
                modifier = Modifier.size(256.dp).align(Alignment.CenterHorizontally).padding(top = 16.dp)
            )
        }
    }
}
