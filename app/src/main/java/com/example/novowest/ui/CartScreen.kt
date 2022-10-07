package com.example.novowest.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.novowest.data.cartList
import com.example.novowest.data.getPrice import com.example.novowest.model.Dish
import com.example.novowest.ui.theme.Montserrat
import com.example.novowest.ui.view.CartView


@Composable
fun CartScreen(){
    val price = remember{ mutableStateOf(getPrice(cartList))}
    ShoppingList(price)
}


@Composable
fun ShoppingList(price: MutableState<Int>){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp),
        horizontalAlignment = Alignment.CenterHorizontally

    ){
        LazyColumn(modifier = Modifier
            .fillMaxHeight(0.9f)
            .fillMaxWidth()){
            items(cartList){
                item -> CardCart(item, price = price)

            }

        }
        Order(price)
    }


}

@Composable
fun Order(price: MutableState<Int>) {
    Card(
        modifier = Modifier
            .fillMaxSize(),
        shape = RoundedCornerShape(10.dp),
        elevation = 10.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(5.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "${price.value} руб.", fontFamily = Montserrat, fontWeight = FontWeight.Bold)
            Button(
                shape = RoundedCornerShape(10.dp),
                onClick = {
                }) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                ) {
                    Text(text = "Заказать", fontSize = 12.sp
                        , fontFamily = Montserrat
                        , fontWeight = FontWeight.Bold)
                }
            }
        }

    }
}

@Composable
fun CardCart(item: Dish, cartView: CartView= viewModel(), price: MutableState<Int>){
    Card(modifier = Modifier
        .fillMaxWidth()
        .height(90.dp)
        .padding(5.dp),
        shape = RoundedCornerShape(10.dp)) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(6.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(modifier = Modifier.width(200.dp)) {
                Image(
                    modifier = Modifier
                        .size(80.dp)
                        .clip(RoundedCornerShape(10.dp)),
                    painter = painterResource(id = item.image),
                    contentDescription = null,
                    contentScale = ContentScale.Crop)
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    text=item.nameDish,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis
                )
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                var count by remember { mutableStateOf(1)}
                Text(
                    text = "${item.price} руб.",
                    fontSize = 18.sp,
                    fontFamily = Montserrat,
                    fontWeight = FontWeight.Bold
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    IconButton(onClick = {

                        if (count!=1) {
                            count-=1
                            price.value = price.value - item.price

                        } else{
                            cartList.remove(item)

                        }
                        }) {
                        Icon(imageVector = Icons.Default.Remove, contentDescription = null)

                    }
                    Text(text = "$count")
                    IconButton(onClick = {
                        if (count>=0){
                            count+=1
                            price.value = price.value + item.price                        }
                        }) {
                        Icon(imageVector = Icons.Default.Add, contentDescription = null)

                    }

                }

            }
        }

    }
}