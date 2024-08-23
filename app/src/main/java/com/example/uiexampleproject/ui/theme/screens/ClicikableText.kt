package com.example.uiexampleproject.ui.theme.screens

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
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

@Composable
fun Clickabletext(modifier: Modifier = Modifier) {

 Column ( modifier = Modifier
     .clip(shape = RoundedCornerShape(10.dp))
     .fillMaxHeight()
     .fillMaxWidth(),
     horizontalAlignment = Alignment.CenterHorizontally,
     verticalArrangement = Arrangement.Center


 ){

     val annotatedText = buildAnnotatedString {
         //append your initial text
         withStyle(
             style = SpanStyle(
                 color = Color.Black,
             )
         ) {
             append("Don't have an account? ")

         }

         //Start of the pushing annotation which you want to color and make them clickable later
         pushStringAnnotation(
             tag = "SignUp",// provide tag which will then be provided when you click the text
             annotation = "SignUp"
         )
         //add text with your different color/style
         withStyle(
             style = SpanStyle(
                 color = Color.Red,
                 textDecoration = TextDecoration.Underline,
                 fontFamily = FontFamily.Monospace,
                 fontWeight = FontWeight(600),
             )
         ) {
             append("Sign Up")
         }
         // when pop is called it means the end of annotation with current tag
         pop()
     }

     ClickableText(
         text = annotatedText,
         onClick = { offset ->
             annotatedText.getStringAnnotations(
                 tag = "SignUp",// tag which you used in the buildAnnotatedString
                 start = offset,
                 end = offset
             )[0].let { annotation ->
                 //do your stuff when it gets clicked
                 Log.d("Clicked", annotation.item)
             }
         }
     )

 }

}

@Preview (showBackground = true, showSystemUi = true)
@Composable
fun ClickabletextPreview() {
    Clickabletext()
}