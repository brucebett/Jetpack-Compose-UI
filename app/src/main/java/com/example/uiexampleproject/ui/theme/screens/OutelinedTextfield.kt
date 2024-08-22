package com.example.uiexampleproject.ui.theme.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text2.input.TextFieldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextField(modifier: Modifier = Modifier) {

    var text by remember { mutableStateOf("") }

    OutlinedTextField(
        value = text,
        onValueChange = { text = it },
        label = { Text("Enter text") },
        placeholder = { Text("Placeholder") },
        textStyle = LocalTextStyle.current.copy(
            color = Color.Black,
            fontSize = 18.sp,
            textAlign = TextAlign.Left
        ),
        singleLine = true,
        modifier = Modifier.padding(16.dp),
        shape = MaterialTheme.shapes.medium, // Custom shape
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Blue, // Border color when focused
            unfocusedBorderColor = Color.Gray, // Border color when not focused
            cursorColor = Color.Red, // Cursor color
            focusedLabelColor = Color.Blue, // Label color when focused
            unfocusedLabelColor = Color.Gray, // Label color when not focused
//            placeholderColor = Color.LightGray // Placeholder color
        ),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text // Specify keyboard type
        )
    )

}

@Preview (showBackground = true, showSystemUi = true)
@Composable
fun TextFieldPreview() {
TextField()
}