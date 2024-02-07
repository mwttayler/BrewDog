package com.punk.design.system.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.punk.design.system.PunkTheme
import kotlinx.coroutines.TimeoutCancellationException
import java.lang.RuntimeException
import java.net.UnknownHostException
import java.util.concurrent.TimeoutException
import com.punk.shared.design.system.R as sharedR

@Composable
fun ErrorWithTryAgain(
    throwable: Throwable,
    onTryAgainClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier.fillMaxSize()
    ) {
        Text(
            text = formatMessage(throwable),
            style = MaterialTheme.typography.titleLarge,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick = onTryAgainClicked) {
            Text(text = stringResource(id = sharedR.string.error_try_again).uppercase())
        }
    }
}

@Composable
private fun formatMessage(throwable: Throwable): String {
    return when (throwable) {
        is UnknownHostException -> stringResource(id = sharedR.string.error_no_internet)
        is TimeoutException,
        is TimeoutCancellationException -> stringResource(id = sharedR.string.error_timeout)
        else -> stringResource(id = sharedR.string.error_generic)
    }
}

@Preview
@Composable
private fun ErrorWithTryAgainPreview() {
    PunkTheme {
        ErrorWithTryAgain(
            throwable = RuntimeException(),
            onTryAgainClicked = { /* no-op */ },
            modifier = Modifier.background(MaterialTheme.colorScheme.background)
        )
    }
}
