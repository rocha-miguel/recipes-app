package br.com.miguel.recipes.screens

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Mail
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PhotoCamera
import androidx.compose.material.icons.filled.RemoveRedEye
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.miguel.recipes.R
import br.com.miguel.recipes.ui.theme.RecipesTheme

@Composable
fun SignupScreen(modifier: Modifier = Modifier) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                MaterialTheme.colorScheme.background
            )
    ) {
        TopEndCard(modifier = Modifier.align(Alignment.TopEnd))

        Column(
            modifier = Modifier
                .fillMaxSize()
                .align(alignment = Alignment.Center),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TittleComponent()
            Spacer(modifier = Modifier.height(48.dp))
            UserImage()
            SignupUserForm()
        }

        BottomStartCard(modifier = Modifier.align(Alignment.BottomStart))
    }
}

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    showSystemUi = true
)
@Composable
private fun SignupScreenPreview() {
    RecipesTheme {
        SignupScreen()
    }
}


@Composable
fun TittleComponent(modifier: Modifier = Modifier) {

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = stringResource(R.string.sign_up),
            color = MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.titleLarge

        )
        Text(
            text = stringResource(R.string.create_account),
            color = MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.titleSmall
        )

    }


}

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Composable
private fun TittleComponentPreview() {
    RecipesTheme {
        TittleComponent()
    }

}


@Composable
fun UserImage(modifier: Modifier = Modifier) {

    Box(
        modifier = modifier
            .size(120.dp)
    ) {
        Image(
            modifier = Modifier
                .size(130.dp)
                .align(Alignment.Center),
            painter = painterResource(R.drawable.woman),
            contentDescription = stringResource(R.string.imagem_de_uma_mulher)
        )
        Icon(
            imageVector = Icons.Default.PhotoCamera,
            contentDescription = stringResource(R.string.camera_icone),
            modifier = Modifier
                .align(Alignment.BottomEnd),
            tint = MaterialTheme.colorScheme.primary
        )
    }

}

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Composable
private fun UserImagePreview() {
    RecipesTheme {
        UserImage()

    }
}


@Composable
fun SignupUserForm(modifier: Modifier = Modifier) {

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(32.dp)
    ) {

        OutlinedTextField(
            value = "",
            onValueChange = {},
            modifier = Modifier
                .fillMaxWidth(),
            label = {
                Text(
                    text = stringResource(R.string.your_name),
                    style = MaterialTheme.typography.labelSmall,
                    )
            },
            shape = RoundedCornerShape(16.dp),
            colors = OutlinedTextFieldDefaults
                .colors(
                    focusedBorderColor = MaterialTheme.colorScheme.primary,
                    unfocusedBorderColor = MaterialTheme.colorScheme.primary,

                ),
            leadingIcon = {
                Icon (
                    imageVector = Icons.Default.Person,
                    contentDescription = stringResource(R.string.person_icon),
                    tint = MaterialTheme.colorScheme.tertiary
                )
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            )
        )

        OutlinedTextField(
            value = "",
            onValueChange = {},
            modifier = Modifier
                .fillMaxWidth(),
            label = {
                Text(
                    text = stringResource(R.string.your_e_mail),
                    style = MaterialTheme.typography.labelSmall,
                )
            },
            shape = RoundedCornerShape(16.dp),
            colors = OutlinedTextFieldDefaults
                .colors(
                    focusedBorderColor = MaterialTheme.colorScheme.primary,
                    unfocusedBorderColor = MaterialTheme.colorScheme.primary,

                    ),
            leadingIcon = {
                Icon (
                    imageVector = Icons.Default.Mail,
                    contentDescription = stringResource(R.string.icon_email),
                    tint = MaterialTheme.colorScheme.tertiary
                )
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            )
        )

        OutlinedTextField(
            value = "",
            onValueChange = {},
            modifier = Modifier
                .fillMaxWidth(),
            label = {
                Text(
                    text = stringResource(R.string.your_password),
                    style = MaterialTheme.typography.labelSmall,
                )
            },
            shape = RoundedCornerShape(16.dp),
            colors = OutlinedTextFieldDefaults
                .colors(
                    focusedBorderColor = MaterialTheme.colorScheme.primary,
                    unfocusedBorderColor = MaterialTheme.colorScheme.primary,

                    ),
            leadingIcon = {
                Icon (
                    imageVector = Icons.Default.Lock,
                    contentDescription = stringResource(R.string.icon_password),
                    tint = MaterialTheme.colorScheme.tertiary
                )
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.NumberPassword,
                imeAction = ImeAction.Done
            ),

            trailingIcon = {
                Icon (
                    imageVector = Icons.Default.RemoveRedEye,
                    contentDescription = stringResource(R.string.eye_icon),
                    tint = MaterialTheme.colorScheme.tertiary
                )
            }
        )

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            shape = RoundedCornerShape(8.dp)
        )
        {
            Text(
                text = stringResource(R.string.create_account),
                color = MaterialTheme.colorScheme.onPrimary,
                style = MaterialTheme.typography.labelMedium
            )
        }
    }


}

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Composable
private fun SignupUserFormPreview() {
    RecipesTheme {
        SignupUserForm()

    }

}