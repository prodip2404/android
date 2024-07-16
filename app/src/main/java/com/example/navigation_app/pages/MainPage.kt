package com.example.navigation_app.pages

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.navigation_app.R
import com.example.navigation_app.ui.theme.PurpleGrey80

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainPage(){
    var nameField= remember {
        mutableStateOf("")
    }
    var ageField= remember {
        mutableStateOf("")
    }

    val contextMe= LocalContext.current
    Scaffold(
        topBar = {
        TopAppBar(
            title = { Text(text = "Main Page", fontSize = 20.sp) },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = colorResource(id = R.color.purple_500),
                titleContentColor = Color.White
            ),
        )
    },
        content = { contentpadding->
            Column(
                Modifier
                    .padding(contentpadding)
                    .fillMaxSize(),
                horizontalAlignment = Alignment. CenterHorizontally,
                verticalArrangement = Arrangement.Center) {
                OutlinedTextField(
                    label ={ Text(text = "Name")},
                    value = nameField.value,
                    onValueChange ={nameField.value=it},
                    colors = TextFieldDefaults.colors(
                        focusedLabelColor = Color.Green,
                        unfocusedIndicatorColor = Color.White,
                    )
                )
                Spacer(modifier = Modifier.height(20.dp))
                OutlinedTextField(label ={ Text(text = "Age")},
                    value = ageField.value  , onValueChange = {ageField.value=it},
                    colors = TextFieldDefaults.colors(
                        focusedLabelColor = Color.Green,
                        unfocusedIndicatorColor = Color.White,
                    )


                )
                OutlinedButton(onClick = { Toast.makeText(contextMe, "OK", Toast.LENGTH_SHORT).show() }) {
                    Text(text = "Submit")
                }
            }
        }
    )

}