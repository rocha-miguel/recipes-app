package br.com.miguel.recipes.screens

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.miguel.recipes.R
import br.com.miguel.recipes.navigation.Destination
import br.com.miguel.recipes.ui.theme.RecipesTheme


@Composable
fun InitialScreen(navController: NavController) {
    // Box EMPILHA os componentes
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = MaterialTheme.colorScheme.background
            )
    ) {

        TopEndCard(modifier = Modifier.align(Alignment.TopEnd))


        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(R.drawable.cooking),
                contentDescription = stringResource(R.string.imagem_de_um_homem_cozinhando),
                modifier = Modifier
                    .size(190.dp)

            )

            Spacer(modifier = Modifier.height(100.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = stringResource(R.string.unlimited_recipes),
                    color = MaterialTheme.colorScheme.secondary,
                    style = MaterialTheme.typography.titleSmall

                )
                Text(
                    text = stringResource(R.string.app_title),
                    style = MaterialTheme.typography.displayLarge,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier
                        .padding(top = 8.dp, bottom = 16.dp)

                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Button(
                        onClick = {
                            navController.navigate(Destination.LoginScreen.route)
                        },
                        colors = ButtonDefaults
                            .buttonColors(
                                containerColor = MaterialTheme.colorScheme.primary
                            ),
                        border = BorderStroke(
                            width = 1.dp,
                            color = MaterialTheme.colorScheme.tertiary
                        ),
                        modifier = Modifier
                            .size(width = 128.dp, height = 48.dp)

                    ) {
                        Text(
                            text = stringResource(R.string.button_login),
                            color = MaterialTheme.colorScheme.onPrimary,
                            style = MaterialTheme.typography.labelMedium
                        )
                    }

                    Spacer(modifier = Modifier.width(8.dp))
                    Button(
                        onClick = {
                            navController.navigate(Destination.SignupScreen.route)
                        },
                        colors = ButtonDefaults
                            .buttonColors(
                                containerColor = MaterialTheme.colorScheme.tertiary
                            ),
                        border = BorderStroke(
                            width = 1.dp,
                            color = MaterialTheme.colorScheme.primary
                        ),
                        modifier = Modifier
                            .size(width = 128.dp, height = 48.dp)
                    )
                    {
                        Text(
                            text = stringResource(R.string.button_signup),
                            color = MaterialTheme.colorScheme.onTertiary,
                            style = MaterialTheme.typography.labelMedium
                        )
                    }
                }
            }
        }

        BottomStartCard(modifier = Modifier.align(Alignment.BottomStart))


    }
}

@Composable
@Preview(
    showBackground = true,
    showSystemUi = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
fun InitialScreenPreview() {
    RecipesTheme {
        InitialScreen(rememberNavController())
    }
}
