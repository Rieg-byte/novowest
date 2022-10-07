package com.example.novowest.data


import com.example.novowest.R
import com.example.novowest.model.Dish

val listOfDish:List<Dish> = listOf(
    Dish(
        dishId = 100,
        category = "Блюда",
        nameDish = "Борщ",
        price = 199,
        image = R.drawable.borsh,
    ),
    Dish(
        dishId = 101,
        category = "Блюда",
        nameDish = "Пельмени",
        price = 159,
        image = R.drawable.pelmeni,
    ),
    Dish(
        dishId = 102,
        category = "Блюда",
        nameDish = "Суп домашний",
        price = 179,
        image = R.drawable.soup,
    ),
    Dish(
        dishId = 103,
        category = "Блюда",
        nameDish = "Овсянка с ягодами",
        price = 109,
        image = R.drawable.oatmeal,
    ),
    Dish(
        dishId = 104,
        category = "Блюда",
        nameDish = "Рагу с говядиной",
        price = 219,
        image = R.drawable.stew,
    ),
)

val listOfSnacks:List<Dish> = listOf(
    Dish(
        dishId = 200,
        category = "Снэки",
        nameDish = "Чипсы",
        price = 89,
        image = R.drawable.crisps,
    ),
    Dish(
        dishId = 201,
        category = "Снэки",
        nameDish = "Крекеры с кунжутом и льняным маслом",
        price = 159,
        image = R.drawable.crackers,
    )
)

val listOfSauces:List<Dish> = listOf(
    Dish(
        dishId = 300,
        category = "Соусы",
        nameDish = "Соус Болоньезе",
        price = 149,
        image = R.drawable.bolognese,
    ),
    Dish(
        dishId = 301,
        category = "Соусы",
        nameDish = "Соус Песто",
        price = 179,
        image = R.drawable.pesto,
    ),
    Dish(
        dishId = 302,
        category = "Соусы",
        nameDish = "Соус Тартар",
        price = 159,
        image = R.drawable.tartar,
    ),
    Dish(
        dishId = 303,
        category = "Соусы",
        nameDish = "Соус Терияки",
        price = 199,
        image = R.drawable.terijak,
    )
)

val listOfBeverages:List<Dish> = listOf(
    Dish(
        dishId = 400,
        category = "Напитки",
        nameDish = "Чай черный",
        price = 49,
        image = R.drawable.teab,
    ),
    Dish(
        dishId = 401,
        category = "Напитки",
        nameDish = "Чай зелёный",
        price = 49,
        image = R.drawable.teaz,
    ),
    Dish(
        dishId = 402,
        category = "Напитки",
        nameDish = "Лимонад",
        price = 79,
        image = R.drawable.lemon,
    ),
    Dish(
        dishId = 403,
        category = "Напитки",
        nameDish = "Добрый Кола",
        price = 89,
        image = R.drawable.cola,
    ),
    Dish(
        dishId = 404,
        category = "Напитки",
        nameDish = "Персиковый сок",
        price = 65,
        image = R.drawable.juicep,
    ),
    Dish(
        dishId = 405,
        category = "Напитки",
        nameDish = "Яблочный сок",
        price = 65,
        image = R.drawable.juicea,
    )
)
