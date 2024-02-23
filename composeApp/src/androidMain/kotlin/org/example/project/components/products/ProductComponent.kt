package org.example.project.components.products

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import componentdata.products.ProductComponentData

@Composable
fun ProductComponent(
    modifier: Modifier = Modifier,
    data: ProductComponentData
) {
    Column(modifier = modifier){
        //TODO image
        Text(data.title)
        Spacer(modifier.size(10.dp))
        Text(data.description)
    }
}