package com.michaelmccormick.myfirstkmmapp.android.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.michaelmccormick.myfirstkmmapp.models.Repository

@Composable
fun RepositoryComposable(
    repository: Repository,
) {
    Column(
        modifier = Modifier.padding(
            vertical = 8.dp,
            horizontal = 12.dp,
        ),
    ) {
        Text(
            repository.name,
            style = MaterialTheme.typography.h6,
        )
        Text(
            repository.fullName,
            style = MaterialTheme.typography.subtitle1,
        )
    }
}
