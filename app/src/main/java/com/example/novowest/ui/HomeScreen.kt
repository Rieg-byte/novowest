package com.example.novowest.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.novowest.R
import com.example.novowest.data.listOfBeverages
import com.example.novowest.data.listOfDish
import com.example.novowest.data.listOfSauces
import com.example.novowest.data.listOfSnacks
import com.example.novowest.model.Dish
import com.example.novowest.ui.theme.*
import com.example.novowest.ui.view.CartView


//@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreen(
) {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
            .verticalScroll(state = scrollState)
            .fillMaxSize()
    ) {
        Category(name = R.string.dishes)
        ListOfDish(listOfDish)
        Category(name = R.string.snacks)
        ListOfDish(listOfSnacks)
        Category(name = R.string.sauces)
        ListOfDish(listOfSauces)
        Category(name = R.string.beverages)
        ListOfDish(listOfBeverages)
    }
}


@Composable
fun ListOfDish(
    n: List<Dish>
){
    LazyRow(modifier = Modifier
        .fillMaxWidth()){
        items(n){
            item ->  DishCard(item)

        }


    }
}

@Composable
fun DishCard(item: Dish,cartViewModel: CartView = viewModel()) {
    Card(
        modifier = Modifier
            .height(260.dp)
            .width(140.dp)
            .padding(5.dp),
        elevation = 6.dp,
        shape = RoundedCornerShape(10.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(6.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column() {
                Image(
                    modifier = Modifier
                        .height(110.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .fillMaxWidth()
                        .wrapContentWidth(CenterHorizontally)
                        ,
                    painter = painterResource(id = item.image),
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = "${item.price} руб.",
                    fontSize = 14.sp,
                    fontFamily = Montserrat,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(40.dp),
                    text = item.nameDish,
                    fontFamily = Montserrat,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis,
                    fontSize = 12.sp,
                )
            }
            Button(
                modifier = Modifier
                    .height(30.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(10.dp),
                onClick = {
                    cartViewModel.addInCart(item)
                    }) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                ) {
                    Text(text="Добавить", fontSize = 12.sp, fontFamily = Montserrat)
                }
            }
        }
    }
}


@Composable
fun Category(
    @StringRes name: Int
){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(28.dp)
            .padding(start=5.dp, end = 5.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Text(
            text = stringResource(name),
            fontSize = 16.sp,
            fontFamily = Montserrat,
            fontWeight = FontWeight.Bold
        )
        Text(
            modifier = Modifier.clickable {  },
            text = stringResource(R.string.more),
            fontSize = 16.sp,
            fontFamily = Montserrat,
            color = Indigo600
        )

    }
}




/*
@Composable
fun CategoryButton(
    onClick: ()->Unit,
    text: String,
    imageVector: ImageVector
){
    Button(
        modifier = Modifier.background(MaterialTheme.colors.background),
        onClick =  onClick,
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                imageVector = imageVector,
                contentDescription = null,
                tint = Color.Black)
            Text(
                text = text
            )
        }
    }
}



@Composable
fun ListOfDish(){
    LazyColumn(){
        item {
            DishCard()
        }
        item {
            DishCard()
        }

    }
}

@Composable
fun ListOfDish1(){
    LazyColumn(){
        item {
            DishCard()
        }
        item {
            DishCard()
        }
        item {
            DishCard()
        }
        item {
            DishCard()
        }
        item {
            DishCard()
        }

    }
}

@Composable
fun Categories(){
    var category by remember{ mutableStateOf(0) }
    Row(
        modifier = Modifier.fillMaxWidth().padding(6.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        CategoryButton(
            onClick = { category = 0},
            text = "Блюда",
            imageVector = Icons.Filled.RamenDining)
        CategoryButton(
            onClick = { category = 1},
            text = "Снэки",
            imageVector = Icons.Filled.LocalPizza)
        CategoryButton(
            onClick = { category = 2},
            text = "Соусы",
            imageVector = Icons.Filled.SoupKitchen)
        CategoryButton(
            onClick = { category = 3},
            text = "Напитки",
            imageVector = Icons.Filled.EmojiFoodBeverage)
    }
    when(category){
        0 -> ListOfDish()
        1 -> ListOfDish1()
        2 -> ListOfDish()
        else -> ListOfDish()
    }
}

@Composable
fun DishCard(){
    Card(modifier = Modifier
        .fillMaxWidth()
        .height(90.dp)
        .padding(5.dp)) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(6.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row() {
                Image(
                    modifier = Modifier
                        .size(80.dp)
                        .clip(CircleShape),
                    painter = painterResource(id = R.drawable.test),
                    contentDescription = null,
                    contentScale = ContentScale.Crop)
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    text="Неопределенный текст",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            IconButton(onClick = { /*TODO*/ },
                Modifier
                    .clip(RoundedCornerShape(12.dp))
                    .background(Amber800)
            ) {
                Icon(imageVector = Icons.Default.AddShoppingCart, contentDescription = null)

            }

        }

    }
}*/