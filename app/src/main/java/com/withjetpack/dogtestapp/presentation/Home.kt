/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.withjetpack.dogtestapp.presentation

import android.util.Log
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.withjetpack.dogtestapp.common.ToolBar

@Composable
fun Home() {
    val viewModel: DogViewModel = hiltViewModel()
    LaunchedEffect(true) {
        viewModel.getDogs()
    }

    val dogList by viewModel.dogsState.collectAsState()
    Log.d("DogListSize", "Size of dog list: ${dogList.size}")

    LazyColumn {
        item {
            ToolBar()
            Spacer(modifier = Modifier.height(8.dp))
        }
        items(dogList) {
                ItemDogCard(
                    it,
                    onItemClicked = { dog ->
                    }
                )
        }
    }
}
