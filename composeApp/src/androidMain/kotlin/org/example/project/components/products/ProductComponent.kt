package org.example.project.components.products

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import componentdata.products.ProductComponentData

@Composable
fun ProductComponent(
    modifier: Modifier = Modifier,
    data: ProductComponentData
) {
    Row(modifier = modifier) {
        AsyncImage(
            modifier = Modifier.clip(RoundedCornerShape(5.dp)).size(100.dp),
            model = data.image,
            contentScale = ContentScale.Crop,
            contentDescription = "async_image_product"
        )
        Spacer(modifier.size(3.dp))
        Column {
            Text(
                text = data.title,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 14.sp,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier.size(1.dp))
            Text(
                text = data.description,
                fontWeight = FontWeight.Light,
                fontSize = 10.sp,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Preview
@Composable
fun PreviewProductComponent() {
    ProductComponent(
        data = ProductComponentData(
            "test", "test title", "test description"
        )
    )
}