package com.michaelmccormick.myfirstkmmapp.android.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.michaelmccormick.myfirstkmmapp.android.R
import com.michaelmccormick.myfirstkmmapp.android.viewmodel.SearchViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun SearchScreen(
    viewModel: SearchViewModel = getViewModel(),
) {
    Column {
        SearchField(
            searchQuery = viewModel.searchQuery,
            onQueryUpdated = viewModel::updateSearchQuery,
            onSearchClicked = viewModel::performSearch,
        )
        viewModel.error?.let {
            Text(text = it, color = Color.Red)
        }
        if (viewModel.isLoading) {
            LoadingSpinner()
        } else {
            LazyColumn(modifier = Modifier.fillMaxHeight()) {
                items(
                    count = viewModel.results.size,
                    itemContent = { index ->
                        RepositoryComposable(repository = viewModel.results[index])
                    },
                )
            }
        }
    }
}

@Composable
private fun SearchField(
    searchQuery: String,
    onQueryUpdated: (String) -> Unit,
    onSearchClicked: () -> Unit,
) {
    Row(modifier = Modifier.fillMaxWidth()) {
        TextField(
            value = searchQuery,
            onValueChange = { onQueryUpdated(it) },
            label = { Text(stringResource(id = R.string.search_field_label)) },
        )
        IconButton(onClick = onSearchClicked) {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = stringResource(id = R.string.search_icon_content_description),
            )
        }
    }
}
