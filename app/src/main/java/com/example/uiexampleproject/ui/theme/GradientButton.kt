package com.example.uiexampleproject.ui.theme

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun GradientButton(
    text: String,
    textColor: Color,
    gradient: Brush,
    onClick: () -> Unit
) {
    Column(modifier = Modifier
        .clip(shape = RoundedCornerShape(10.dp))
        .fillMaxHeight()
        .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    )
        
    {

        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent
            ),
            border = BorderStroke(2.dp, Color.Red),
            contentPadding = PaddingValues(5.dp),
            onClick = { onClick() },
        )
        {
            Box(
                modifier = Modifier
                    .background(gradient)
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(text = text, color = textColor)
            }
        }
        Spacer(modifier = Modifier.height(50.dp))
        Button(
            onClick = { /* Handle click */ },
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 8.dp,
                pressedElevation = 12.dp
            )
        ) {
            Text("Elevated Button")
        }

        Spacer(modifier = Modifier.height(50.dp))


        Button(
            onClick = { /* Handle click */ },
            border = BorderStroke(2.dp, Color.Red)
        ) {
            Text("Button with Border")
        }

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            onClick = { /* Handle click */ },
            modifier = Modifier
                .padding(16.dp)
                .width(150.dp)
                .height(50.dp)
        ) {
            Text("Sized Button")
        }
        Button(
            onClick = onClick,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF6200EE), // Purple
                contentColor = Color.White
            ),
            shape = RoundedCornerShape(16.dp),
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 8.dp,
                pressedElevation = 12.dp
            ),
            modifier = Modifier
                .padding(16.dp)
                .height(50.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = "buttonText",
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 1.5.sp
                )
            )
        }
    }



}

@Preview
@Composable
private fun GradientButtonPreview() {
    GradientButton(text = "Button",
        textColor = Color.White,
         gradient = Brush.horizontalGradient(
             colors = listOf(Green, Blue)
         )) {

    }
}