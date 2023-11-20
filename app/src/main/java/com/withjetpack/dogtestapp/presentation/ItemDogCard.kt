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

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.withjetpack.dogtestapp.domain.Dog

@Composable
fun ItemDogCard(dog: Dog, onItemClicked: (dog: Dog) -> Unit) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp, 5.dp, 16.dp, 16.dp)
            .clickable {
            },
        shape = RoundedCornerShape(8.dp),
        elevation = 8.dp,
    ) {

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFBB86FC))
                .padding(5.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {


                Spacer(modifier = Modifier.width(16.dp))

                Column(modifier = Modifier.align(Alignment.CenterVertically)) {
                    Text(
                        text = dog.name,
                        modifier = Modifier.padding(0.dp, 0.dp, 12.dp, 0.dp),
                        color = MaterialTheme.colors.surface,
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.subtitle1
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = buildString {
                            append(dog.age)
                            append("yrs | ")
                            append(dog.id)
                        },
                        modifier = Modifier.padding(0.dp, 0.dp, 12.dp, 0.dp),
                        color = MaterialTheme.colors.surface,
                        style = MaterialTheme.typography.caption
                    )

                }

            }
        }
    }
}
