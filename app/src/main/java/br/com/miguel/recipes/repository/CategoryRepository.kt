package br.com.miguel.recipes.repository

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import br.com.miguel.recipes.R
import br.com.miguel.recipes.factory.RetrofitClient
import br.com.miguel.recipes.model.Category
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/* fun getAllCategories() = listOf<Category>(
    Category(
        id = 1000, name = "Chicken",
        image = R.drawable.chickenl, background = Color(0xFFABF2E9)
    ),
    Category(
        id = 2000, name = "Beef",
        image = R.drawable.beef, background = Color(0xFFF4D6C0)
    ),
    Category(
        id = 3000, name = "Fish",
        image = R.drawable.fishl, background = Color(0xFFC6DAFA)
    ),
    Category(
        id = 4000, name = "Bakery",
        image = R.drawable.bakery, background = Color(0xFFF8D9D9)
    ),
    Category(
        id = 5000, name = "Vegetable",
        image = R.drawable.vegetable, background = Color(0xFFABF2E9)
    ),
    Category(
        id = 6000, name = "Desserts",
        image = R.drawable.dessert, background = Color(0xFF72412B)
    ),
    Category(
        id = 7000, name = "Drinks",
        image = R.drawable.drink, background = Color(0xFF80DEEA)
    )
) */


@Composable
fun getAllCategories(): List<Category> {

    var categories by remember {
        mutableStateOf(listOf<Category>())
    }

    val callCategories = RetrofitClient.getCategoryService().getAllCategories()

    callCategories.enqueue(object : Callback<List<Category>> {
        override fun onResponse(
            call: Call<List<Category>?>,
            response: Response<List<Category>?>
        ) {
            categories = response.body()!!
        }

        override fun onFailure(
            p0: Call<List<Category>?>,
            p1: Throwable
        ) {
            println(p1.printStackTrace())

        }
    })

    return categories
}


@Composable
fun getCategoryById(id: Int) = getAllCategories()
   .find { category ->
     category.id == id
}