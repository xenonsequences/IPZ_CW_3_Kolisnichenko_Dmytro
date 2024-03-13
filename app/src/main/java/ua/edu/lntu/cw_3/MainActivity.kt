package ua.edu.lntu.cw_3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ThirtyDaysOfRecipes()
        }
    }
}

@Composable
fun ThirtyDaysOfRecipes() {
    LazyColumn {
        items(RecipeDataProvider.recipes) { recipe ->
            RecipeItem(recipe)
        }
    }
}

@Composable
fun RecipeItem(recipe: Recipe) {
    Column {
        // Зображення рецепту
        Image(
            painter = painterResource(id = recipe.imageResId),
            contentDescription = null, // Потрібно для доступності, може бути заповнено більш докладно
            modifier = Modifier
                .width(200.dp) // Задайте ширину відповідно до вашого дизайну
                .height(200.dp) // Задайте висоту відповідно до вашого дизайну
        )

        Spacer(modifier = Modifier.height(8.dp)) // Пропустити невеликий простір

        // Опис рецепту
        Text(text = recipe.description)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ThirtyDaysOfRecipes()
}
