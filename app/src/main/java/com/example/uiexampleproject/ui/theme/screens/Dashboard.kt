package com.example.uiexampleproject.ui.theme.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Dashboard(modifier: Modifier = Modifier) {

    Column ( modifier = Modifier
        .clip(shape = RoundedCornerShape(10.dp))
        .fillMaxHeight()
        .fillMaxWidth(),
      horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom


    ){

    }

}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun DashboardPreview() {
    Dashboard()
}