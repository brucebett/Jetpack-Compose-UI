package com.example.uiexampleproject.ui.theme.screens

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AnnotatedText() {

    Column(
        modifier = Modifier
            .clip(shape = RoundedCornerShape(10.dp))
            .fillMaxHeight()
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        val annotatedText = buildAnnotatedString {
            // Initial text
            withStyle(
                style = SpanStyle(
                    color = Color.Black,
                    fontFamily = FontFamily.Monospace,
                    fontWeight = FontWeight.SemiBold,
                    letterSpacing = 1.5.sp,
                    fontSize = 25.sp,
                )
            ) {
                append("Don't have an accountYet...? ")
            }

            // Sign Up text
            pushStringAnnotation(
                tag = "REGISTER",
                annotation = "REGISTER"
            )
            withStyle(
                style = SpanStyle(
                    color = Color.Green,
                    textDecoration = TextDecoration.Underline,
                    fontFamily = FontFamily.Monospace,
                    fontWeight = FontWeight.SemiBold,
                    letterSpacing = 1.5.sp,
                    fontSize = 25.sp,
                )
            ) {
                append("REGISTER")
            }
            pop()

            // Add space or any separator if needed

            append(" ")

            Spacer(modifier = Modifier.height(10.dp))


            // Forgot Password text
            withStyle(
                style = SpanStyle(
                    color = Color.Black,
                    letterSpacing = 1.5.sp,
                    fontFamily = FontFamily.Monospace,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.SemiBold
                )
            ) {
                append("Forgot Password...?")
            }

            pushStringAnnotation(
                tag = "CLICK HERE",
                annotation = "CLICK HERE"
            )
            withStyle(
                style = SpanStyle(
                    color = Color.Green,
                    textDecoration = TextDecoration.Underline,
                    fontFamily = FontFamily.Monospace,
                    fontWeight = FontWeight.SemiBold,
                    letterSpacing = 1.5.sp,
                    fontSize = 25.sp,
                )
            ) {
                append("CLICK HERE")
            }
            pop()
        }

        ClickableText(
            text = annotatedText,
            onClick = { offset ->
                annotatedText.getStringAnnotations(
                    tag = "SignUp",
                    start = offset,
                    end = offset
                ).firstOrNull()?.let { annotation ->
                    // Handle Sign Up click
                    Log.d("Clicked", "Sign Up clicked")
                }

                annotatedText.getStringAnnotations(
                    tag = "CLICK HERE",
                    start = offset,
                    end = offset
                ).firstOrNull()?.let { annotation ->
                    // Handle Forgot Password click
                    Log.d("Clicked", "Forgot Password clicked")
                }
            }
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AnnotatedTextPreview() {
    AnnotatedText()
}
