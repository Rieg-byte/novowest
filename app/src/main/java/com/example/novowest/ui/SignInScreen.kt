package com.example.novowest.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.novowest.R
import com.example.novowest.ui.theme.Amber800
import com.example.novowest.ui.theme.Montserrat
import com.example.novowest.ui.theme.Roboto
import com.example.novowest.ui.view.SignInViewModel
import java.time.format.TextStyle

@Composable
fun SignInScreen(
    signInViewModel: SignInViewModel = viewModel(),
    navController: NavController
) {
    val signUiState by signInViewModel.signInUiState.collectAsState()
    val email: String by signInViewModel.email.collectAsState()
    val password: String by signInViewModel.password.collectAsState()
    var passwordVisibility by remember { mutableStateOf(false) }
    val focusManager = LocalFocusManager.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(38.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = stringResource(id = R.string.app_name),
            fontSize = 36.sp,
            fontStyle = FontStyle.Italic,
            fontFamily = Montserrat,
            fontWeight = FontWeight.Bold,
            color = Amber800
        )
        Text(
            text = stringResource(id = R.string.login_title),
            fontWeight = FontWeight.Bold,
            fontFamily = Montserrat,
            fontSize = 26.sp
        )
        EditTextField(
            modifier = Modifier.fillMaxWidth(),
            label = R.string.email,
            value = email,
            isWrong = signUiState.isWrong,
            onValueChange = { signInViewModel.email.value = it },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next),
            keyboardActions = KeyboardActions(
                onNext = {focusManager.moveFocus(FocusDirection.Down)}
            )
        )
        EditPasswordField(
            modifier = Modifier.fillMaxWidth(),
            label = R.string.password,
            value = password,
            isWrong = signUiState.isWrong,
            passwordVisibility = passwordVisibility,
            onValueChange = { signInViewModel.password.value = it },
            onClick = { passwordVisibility = !passwordVisibility } ,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(
                onDone = { focusManager.clearFocus() }
            )
        )
        Spacer(Modifier.height(5.dp))
        if (signUiState.isWrong){
            Text(
                text = stringResource(id = R.string.is_wrong),
                fontFamily = Montserrat,
                color = MaterialTheme.colors.error,
                fontSize = 14.sp
                )
        }
        Text(
            text = stringResource(R.string.forget_password),
            fontFamily = Montserrat,
            fontSize = 12.sp,
            modifier = Modifier
                .clickable { }
                .align(Alignment.Start)
        )
        Spacer(Modifier.height(5.dp))
        ActionButton(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                if (signInViewModel.checkUserEmailOrPassword()) {
                    navController.navigate(AuthScreen.Main.name)
                }
            },
            text = R.string.login,
        )
        OutlinedActionButton(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                navController.navigate(AuthScreen.SignUp.name)
                      },
            text = R.string.signup,
        )
    }
}


@Composable
fun ActionButton(
    modifier: Modifier = Modifier,
    onClick: ()->Unit,
    @StringRes text: Int
) {
    Button(
        modifier = modifier,
        onClick = onClick,
        shape = RoundedCornerShape(10.dp)
    ) {
        Text(text = stringResource(text), fontFamily = Montserrat)
    }
}

@Composable
fun OutlinedActionButton(
    modifier: Modifier = Modifier,
    onClick: ()->Unit,
    @StringRes text: Int,
) {
    OutlinedButton(
        modifier = modifier,
        onClick = onClick,
        shape = RoundedCornerShape(10.dp)
    ) {
        Text(text = stringResource(text), fontFamily = Montserrat)
    }
}


@Composable
fun EditTextField(
    modifier: Modifier = Modifier,
    @StringRes label: Int,
    value: String,
    isWrong: Boolean,
    onValueChange: (String)-> Unit,
    keyboardOptions: KeyboardOptions,
    keyboardActions: KeyboardActions,){
    OutlinedTextField(
        modifier = modifier,
        label = { Text(stringResource(label), fontFamily = Montserrat) },
        value = value,
        onValueChange = onValueChange,
        singleLine = true,
        isError = isWrong,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        shape = RoundedCornerShape(10.dp)
    )
}


@Composable
fun EditPasswordField(
    modifier: Modifier = Modifier,
    @StringRes label: Int,
    value: String,
    isWrong: Boolean,
    passwordVisibility: Boolean,
    onClick: () -> Unit,
    onValueChange: (String)-> Unit,
    keyboardOptions: KeyboardOptions,
    keyboardActions: KeyboardActions){
    OutlinedTextField(
        modifier = modifier,
        label = { Text(stringResource(label), fontFamily = Montserrat) },
        value = value,
        onValueChange = onValueChange,
        singleLine = true,
        isError = isWrong,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        shape = RoundedCornerShape(10.dp),
        trailingIcon = {
            IconButton(
                onClick = onClick
            ) {
                Icon(
                    imageVector = if(passwordVisibility) {
                        Icons.Default.VisibilityOff
                    } else {
                        Icons.Default.Visibility
                    },
                    contentDescription = null
                )
            }
        },
        visualTransformation =
        if (passwordVisibility) VisualTransformation.None
        else PasswordVisualTransformation()
    )
}


