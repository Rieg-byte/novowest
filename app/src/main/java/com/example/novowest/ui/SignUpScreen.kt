package com.example.novowest.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronLeft
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.novowest.R
import com.example.novowest.ui.theme.Amber800
import com.example.novowest.ui.theme.Montserrat
import com.example.novowest.ui.theme.Roboto
import com.example.novowest.ui.view.SignInViewModel
import com.example.novowest.ui.view.SignUpViewModel

@Composable
fun SignUpScreen(
    signUpViewModel: SignUpViewModel = viewModel(),
    navController: NavController
){
    val signUpUiState by signUpViewModel.signUpUiState.collectAsState()
    val login by signUpViewModel.login.collectAsState()
    val email: String by signUpViewModel.email.collectAsState()
    val password: String by signUpViewModel.password.collectAsState()
    var passwordVisibility by remember { mutableStateOf(false) }
    val focusManager = LocalFocusManager.current
    Scaffold(
        topBar = {
            IconButton(onClick = { navController.navigate(AuthScreen.SignIn.name)}) {
                Icon(Icons.Filled.ChevronLeft, contentDescription = "Назад")
                
            }
        }) {
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
                text = stringResource(id = R.string.signup_title),
                fontFamily = Montserrat,
                fontWeight = FontWeight.Bold,
                fontSize = 26.sp
            )
            EditTextField(
                modifier = Modifier.fillMaxWidth(),
                label = R.string.name,
                value = login,
                isWrong = signUpUiState.isWrong,
                onValueChange = { signUpViewModel.login.value = it },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next),
                keyboardActions = KeyboardActions(
                    onNext = {focusManager.moveFocus(FocusDirection.Down)}
                )
            )
            EditTextField(
                modifier = Modifier.fillMaxWidth(),
                label = R.string.email,
                value = email,
                isWrong = signUpUiState.isWrong,
                onValueChange = { signUpViewModel.email.value = it },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next),
                keyboardActions = KeyboardActions(
                    onNext = {focusManager.moveFocus(FocusDirection.Down)}
                )
            )
            EditPasswordField(
                modifier = Modifier.fillMaxWidth(),
                label = R.string.password,
                value = password,
                isWrong = signUpUiState.isWrong,
                passwordVisibility = passwordVisibility,
                onValueChange = { signUpViewModel.password.value = it },
                onClick = { passwordVisibility = !passwordVisibility } ,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done),
                keyboardActions = KeyboardActions(
                    onDone = { focusManager.clearFocus() }
                )
            )
            Spacer(Modifier.height(5.dp))
            if (signUpUiState.isWrong){
                Text(
                    text = stringResource(id = R.string.is_empty),
                    color = MaterialTheme.colors.error,
                    fontFamily = Roboto,
                    fontSize = 14.sp
                )
            }
            Spacer(Modifier.height(5.dp))
            ActionButton(
                modifier = Modifier.fillMaxWidth(),
                onClick = { signUpViewModel.checkField() },
                text = R.string.signup,
            )
        }
    }
}

