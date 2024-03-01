package org.example.project.screen.productview

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import navigationargs.ProductViewArgs

@Composable
fun ProductViewScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
) {
    val args = navController.previousBackStackEntry?.savedStateHandle?.get<ProductViewArgs>(
        "argument"
    )

    LazyColumn {
        item {
            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                model = args?.image.toString(),
                contentScale = ContentScale.Crop,
                contentDescription = "async_image_product"
            )
        }
        item { Spacer(modifier.size(3.dp)) }
        item {
            Text(
                modifier = Modifier.padding(horizontal = 8.dp),
                text = args?.title ?: "",
                fontWeight = FontWeight.ExtraBold,
                fontSize = 18.sp,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        }
        item { Spacer(modifier.size(1.dp)) }
        item {
            Text(
                modifier = Modifier.padding(horizontal = 8.dp),
                text = args?.description ?: "",
                fontWeight = FontWeight.Light,
                fontSize = 14.sp,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}