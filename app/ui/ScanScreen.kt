package com.example.qrcodeapp.ui

import android.Manifest
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import com.google.mlkit.vision.barcode.BarcodeScanning
import com.google.mlkit.vision.common.InputImage
import java.util.concurrent.Executors

@Composable
fun ScanScreen(navController: NavController) {
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current
    val cameraProviderFuture = remember { ProcessCameraProvider.getInstance(context) }
    var code by remember { mutableStateOf("") }
    var scanning by remember { mutableStateOf(true) }

    Column(modifier = Modifier.fillMaxSize()) {
        AndroidView(factory = { ctx ->
            val previewView = PreviewView(ctx)
            val preview = Preview.Builder().build()
            val selector = CameraSelector.Builder()
                .requireLensFacing(CameraSelector.LENS_FACING_BACK)
                .build()
            preview.setSurfaceProvider(previewView.surfaceProvider)
            val imageAnalysis = ImageAnalysis.Builder()
                .setBackpressureStrategy(ImageAnalysis.STRATEGY_KEEP_ONLY_LATEST)
                .build()
            imageAnalysis.setAnalyzer(Executors.newSingleThreadExecutor()) { image ->
                val mediaImage = image.image ?: return@setAnalyzer
                val inputImage = InputImage.fromMediaImage(mediaImage, image.imageInfo.rotationDegrees)
                BarcodeScanning.getClient().process(inputImage)
                    .addOnSuccessListener { barcodes ->
                        barcodes.forEach {
                            if (scanning) {
                                code = it.rawValue ?: ""
                                scanning = false
                            }
                        }
                    }
                    .addOnCompleteListener { image.close() }
            }
            cameraProviderFuture.get().bindToLifecycle(lifecycleOwner, selector, preview, imageAnalysis)
            previewView
        }, modifier = Modifier.weight(1f))

        if (code.isNotEmpty()) {
            Text(
                text = code,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.surface)
                    .padding(16.dp),
                textAlign = TextAlign.Center
            )
            Button(onClick = { scanning = true; code = "" }, modifier = Modifier.padding(16.dp)) {
                Text("Tekrar Tara")
            }
        }
    }
}
