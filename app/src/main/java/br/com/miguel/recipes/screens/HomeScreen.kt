package br.com.miguel.recipes.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import br.com.miguel.recipes.R
import br.com.miguel.recipes.components.CategoryItem
import br.com.miguel.recipes.components.RecipeItem
import br.com.miguel.recipes.navigation.Destination
import br.com.miguel.recipes.repository.SharedPreferencesUserRepository
import br.com.miguel.recipes.repository.UserRepository
import br.com.miguel.recipes.repository.getAllCategories
import br.com.miguel.recipes.repository.getAllRecipes
import br.com.miguel.recipes.ui.theme.RecipesTheme

@Composable
fun HomeScreen(navController: NavHostController, email: String?) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Scaffold(
            topBar = {
                MyTopAppBar(email!!)
            },
            bottomBar = {
                MyBottomAppBar()
            },
            floatingActionButton = {
                FloatingActionButton(
                    onClick = {},
                    shape = CircleShape,
                    containerColor = MaterialTheme.colorScheme.primary
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = stringResource(R.string.add_button)
                    )
                }
            }
        ) { paddingValues ->


            ContentScreen(
                modifier = Modifier.padding(paddingValues),
                navController
            )


        }

    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    RecipesTheme {
        HomeScreen(rememberNavController(), "")
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(email: String) {

    val userRepository: UserRepository = SharedPreferencesUserRepository(LocalContext.current)

    val user = userRepository.getUser()

    TopAppBar(
        modifier = Modifier
            .fillMaxWidth(),
        //.height(60.dp),

        title = {
            Row(
                modifier = Modifier
                    .padding(end = 4.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column() {
                    Text(
                        text = "Hello, ${user.name}",
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight.Bold

                    )
                    Text(
                        text = email,
                        style = MaterialTheme.typography.displaySmall
                    )
                }

                Card(
                    modifier = Modifier.size(48.dp),
                    shape = CircleShape,
                    colors = CardDefaults
                        .cardColors(
                            containerColor = Color.Transparent
                        ),
                    border = BorderStroke(
                        width = 1.dp,
                        color = MaterialTheme.colorScheme.primary
                    )
                ) {
                    Image(
                        painter = painterResource(R.drawable.woman),
                        contentDescription = stringResource(R.string.imagem_de_uma_mulher)
                    )
                }

            }
        }
    )


}

@Preview
@Composable
private fun MyTopAppBarPreview() {
    RecipesTheme() {
        MyTopAppBar("")
    }
}


data class BottomNavigationItem(
    val tittle: String,
    val icon: ImageVector
)

@Composable
fun MyBottomAppBar(modifier: Modifier = Modifier) {
    val items = listOf(
        BottomNavigationItem(stringResource(R.string.home), icon = Icons.Default.Home),
        BottomNavigationItem(stringResource(R.string.favorites), icon = Icons.Default.Favorite),
        BottomNavigationItem(stringResource(R.string.profile), icon = Icons.Default.Person),

        )

    NavigationBar(
        containerColor = MaterialTheme.colorScheme.tertiary
    ) {
        items.forEach { item ->
            NavigationBarItem(
                selected = false,
                onClick = {},
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.tittle,
                        tint = MaterialTheme.colorScheme.onTertiary,
                        modifier = Modifier
                            .size(24.dp)
                    )
                },
                label = {
                    Text(
                        text = item.tittle,
                        color = MaterialTheme.colorScheme.onTertiary,
                        style = MaterialTheme.typography.displaySmall
                    )
                }
            )
        }
    }
}

@Preview
@Composable
private fun MyBottomAppBarPreview() {
    RecipesTheme() {
        MyBottomAppBar()
    }
}

@Composable
fun ContentScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {

    val categories = getAllCategories()
    val recipes = getAllRecipes()

    Column(
        modifier = modifier
            .padding(horizontal = 0.dp)
            .fillMaxSize()

    ) {
        OutlinedTextField(
            value = "",
            onValueChange = {},
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .fillMaxWidth(),
            label = {
                Text(
                    text = stringResource(R.string.search_by_recipes),
                    style = MaterialTheme.typography.labelSmall
                )
            },
            shape = RoundedCornerShape(12.dp),
            colors = OutlinedTextFieldDefaults
                .colors(
                    unfocusedBorderColor = Color.Transparent,
                    unfocusedContainerColor = Color(0xfff5f5f5)
                ),
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = stringResource(R.string.search)
                )
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        Card(
            modifier = Modifier
                .padding(vertical = 4.dp, horizontal = 16.dp)
                .fillMaxWidth()
                .height(116.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.card_cooking),
                contentDescription = stringResource(R.string.cooking),
                modifier = Modifier
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop


            )
        }

        Text(
            modifier = Modifier.padding(vertical = 4.dp, horizontal = 16.dp),
            text = stringResource(R.string.categories),
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.primary
        )

        LazyRow(
            contentPadding = PaddingValues(horizontal = 1.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(categories) { category ->
                CategoryItem(category, onClick = {
                    navController.navigate(Destination.CategoryRecipeScreen.createRoute(category.id))
                })

            }
        }

        Text(
            modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp),
            text = stringResource(R.string.newly_added_recipes),
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.primary
        )

        LazyColumn(
            contentPadding = PaddingValues(vertical = 8.dp, horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(recipes) { recipe ->
                RecipeItem(recipe)

            }
        }


    }
}

@Preview(
    showBackground = true
)
@Composable
private fun ContentScreenPreview() {
    RecipesTheme() {
        ContentScreen(navController = rememberNavController())
    }

}















