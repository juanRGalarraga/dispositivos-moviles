package com.example.myapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapp.DisplayActivity.Companion.EXTRA_TEXT
import com.example.myapp.ui.theme.MyAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainActivityContent()
        }
    }

    //El activity comienza a ser visible
    override fun onStart() {
        super.onStart()
        Log.i("onStart", "Estoy es el onStart")
    }

    //El activity es completamente visible
    override fun onResume() {
        super.onResume()
        Log.i("onResume", "Estoy es el onResume")
    }
}



@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
            text = "Hello $name!",
            modifier = modifier
    )
}

@Composable
fun MainActivityContent(){
    var text by remember { mutableStateOf("") }
    val context = LocalContext.current;

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text(text = "Mensaje") },
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldColors
        )
        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                if(text.isNotEmpty()){
                    val intent = Intent(context, DisplayActivity::class.java).apply {
                        putExtra(EXTRA_TEXT, text)
                    }
                    context.startActivity(intent)
                }
            }) {
            Text("Button")
        }

    }

}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyAppTheme {
        Greeting("Android")
    }
}