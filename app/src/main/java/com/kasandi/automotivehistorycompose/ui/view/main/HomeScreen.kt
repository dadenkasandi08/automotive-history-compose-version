package com.kasandi.automotivehistorycompose.ui.view.main

import android.content.Intent
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.kasandi.automotivehistorycompose.data.model.Brand
import com.kasandi.automotivehistorycompose.data.repository.BrandRepository
import com.kasandi.automotivehistorycompose.helper.ViewModelFactory
import com.kasandi.automotivehistorycompose.ui.components.Search
import com.kasandi.automotivehistorycompose.ui.theme.cadet_grey
import com.kasandi.automotivehistorycompose.ui.theme.engineering_orange
import com.kasandi.automotivehistorycompose.ui.theme.prussian_blue
import com.kasandi.automotivehistorycompose.ui.view.detail.DetailActivity

@Composable
private fun BrandListItem(
    brand: Brand,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    Card(
        modifier = Modifier
            .fillMaxWidth(1f)
            .padding(10.dp, 8.dp)
            .clickable {
                val intent = Intent(context, DetailActivity::class.java)
                intent.putExtra("extra_brand", brand)
                startActivity(context, intent, null)
            },
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(1f)
                .background(prussian_blue)
        ) {
            Text(
                text = brand.name,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                maxLines = 1,
                color = engineering_orange,
                modifier = Modifier
                    .padding(8.dp, 8.dp, 0.dp, 0.dp)
            )

            Text(
                text = brand.year,
                fontSize = 12.sp,
                color = cadet_grey,
                maxLines = 1,
                modifier = Modifier
                    .padding(8.dp, 4.dp, 0.dp, 0.dp)

            )

            AsyncImage(
                model = brand.photo,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(125.dp)
                    .padding(0.dp, 4.dp, 0.dp, 8.dp)

            )
        }
    }
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: MainViewModel = viewModel(factory = ViewModelFactory(BrandRepository()))
) {
    val brands by viewModel.brands.collectAsState()
    val query by viewModel.query

    Box(modifier = modifier) {
        LazyColumn(
            contentPadding = PaddingValues(bottom = 80.dp)
        ) {
            item {
                Search(
                    query = query,
                    onQueryChange = viewModel::search
                )
            }
            items(brands) { brand ->
                BrandListItem(
                    brand = brand,
                    modifier = Modifier
                        .fillMaxWidth()
                        .animateItemPlacement(tween(durationMillis = 100))
                )
            }
        }
    }
}