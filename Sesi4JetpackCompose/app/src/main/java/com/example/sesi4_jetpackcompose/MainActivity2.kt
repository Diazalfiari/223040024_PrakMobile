package com.example.sesi4_jetpackcompose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sesi4_jetpackcompose.ui.theme.Sesi4JetpackComposeTheme

class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Sesi4JetpackComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    FormRegistrasi(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun FormRegistrasi(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val nama = remember { mutableStateOf(TextFieldValue("")) }
    val username = remember { mutableStateOf(TextFieldValue("")) }
    val nomorTelepon = remember { mutableStateOf(TextFieldValue("")) }
    val email = remember { mutableStateOf(TextFieldValue("")) }
    val alamat = remember { mutableStateOf(TextFieldValue("")) }

    Column(modifier = modifier.fillMaxWidth().padding(16.dp)) {
        TextFieldWithLabel("Nama", nama)
        TextFieldWithLabel("Username", username)
        TextFieldWithLabel("Nomor Telepon", nomorTelepon, KeyboardOptions(keyboardType = KeyboardType.Phone))
        TextFieldWithLabel("Email", email, KeyboardOptions(keyboardType = KeyboardType.Email))
        TextFieldWithLabel("Alamat", alamat)

        Spacer(modifier = Modifier.height(16.dp))

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Button(modifier = Modifier.weight(1f), onClick = {
                if (nama.value.text.isNotEmpty() && username.value.text.isNotEmpty() &&
                    nomorTelepon.value.text.isNotEmpty() && email.value.text.isNotEmpty() && alamat.value.text.isNotEmpty()
                ) {
                    Toast.makeText(context, "Halo, ${nama.value.text}", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(context, "Semua inputan harus diisi!", Toast.LENGTH_LONG).show()
                }
            }) {
                Text("Simpan", color = Color.White, fontSize = 18.sp)
            }

            Button(modifier = Modifier.weight(1f), onClick = {
                nama.value = TextFieldValue("")
                username.value = TextFieldValue("")
                nomorTelepon.value = TextFieldValue("")
                email.value = TextFieldValue("")
                alamat.value = TextFieldValue("")
            }, colors = ButtonDefaults.buttonColors(containerColor = Color.Gray)) {
                Text("Reset", color = Color.White, fontSize = 18.sp)
            }
        }
    }
}

@Composable
fun TextFieldWithLabel(label: String, state: MutableState<TextFieldValue>, keyboardOptions: KeyboardOptions = KeyboardOptions.Default) {
    Column(modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)) {
        Text(text = label, modifier = Modifier.padding(bottom = 4.dp))
        TextField(
            value = state.value,
            onValueChange = { state.value = it },
            keyboardOptions = keyboardOptions,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    Sesi4JetpackComposeTheme {
        FormRegistrasi()
    }
}