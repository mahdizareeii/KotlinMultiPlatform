package sharedscreen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import sharedui.ComposeAnalogClock
import util.DateAndTime

@Composable
fun ShareCockScreen() {
    MaterialTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            var time by remember { mutableStateOf(DateAndTime.getCurrentTimeMillis()) }

            LaunchedEffect("clock") {
                while (true) {
                    time = DateAndTime.getCurrentTimeMillis()
                    delay(100)
                }
            }

            ComposeAnalogClock(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp),
                timeInMillis = { time }
            )
        }
    }

}