package com.example.novowest.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.novowest.R
import com.example.novowest.ui.theme.Montserrat
import com.example.novowest.ui.theme.Roboto


@Composable
fun ProfileScreen(){
    Column(
        modifier = Modifier.fillMaxSize().padding(5.dp)
    ) {
        Text(
            text = stringResource(id = R.string.name) + ":",
            fontFamily = Montserrat,
            fontSize = 18.sp)
        Text(
            text = stringResource(id = R.string.email) + ":",
            fontFamily = Montserrat,
            fontSize = 18.sp)
    }
}
