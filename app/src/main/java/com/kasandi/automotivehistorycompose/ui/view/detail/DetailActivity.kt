package com.kasandi.automotivehistorycompose.ui.view.detail

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.kasandi.automotivehistorycompose.data.model.Brand
import com.kasandi.automotivehistorycompose.ui.theme.AutomotiveHistoryComposeTheme
import com.kasandi.automotivehistorycompose.ui.theme.engineering_orange

class DetailActivity : ComponentActivity() {
    private var selectedBrand: Brand? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        selectedBrand = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Brand>(EXTRA_BRAND, Brand::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Brand>(EXTRA_BRAND)
        }

        setContent {
            AutomotiveHistoryComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    detailView(brand = selectedBrand)
                }
            }
        }
    }

    companion object {
        const val EXTRA_BRAND = "extra_brand"
    }
}

@Composable
fun detailView(
    brand: Brand?,
    modifier: Modifier = Modifier
) {
    LazyColumn {
        item {
            AsyncImage(
                model = brand?.photo.toString(),
                contentDescription = "Brand photo",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxWidth(1f)
            )

            Text(
                text = brand?.name.toString(),
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                textAlign = TextAlign.Center,
                fontSize = 30.sp,
                color = engineering_orange,
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .padding(16.dp, 16.dp, 16.dp, 0.dp)
            )

            Text(
                text = brand?.year.toString(),
                maxLines = 1,
                textAlign = TextAlign.Center,
                fontSize = 12.sp,
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .padding(16.dp, 0.dp, 16.dp, 0.dp)

            )

            Text(
                text = "Founder: ${brand?.founder.toString()}",
                fontSize = 12.sp,
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .padding(16.dp, 8.dp, 16.dp, 0.dp)
            )

            Text(
                text = "Owner/CEO: ${brand?.owner.toString()}",
                fontSize = 12.sp,
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .padding(16.dp, 0.dp, 16.dp, 0.dp)
            )

            Text(
                text = brand?.history.toString(),
                fontSize = 14.sp,
                textAlign = TextAlign.Justify,
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .padding(16.dp, 16.dp, 16.dp, 16.dp)
            )
        }
    }
}