package org.example.project.screen.productslist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.example.project.composeutil.shimmerBrush

@Composable
fun ProductsSkeleton() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        repeat(10) {
            Box(
                modifier = Modifier
                    .padding(vertical = 4.dp, horizontal = 8.dp)
                    .background(
                        brush = shimmerBrush(targetValue = 1300f),
                        shape = RoundedCornerShape(4.dp)
                    )
                    .fillMaxWidth()
                    .height(100.dp)
            )
        }
    }
}