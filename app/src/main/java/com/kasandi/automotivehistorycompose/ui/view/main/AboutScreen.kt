package com.kasandi.automotivehistorycompose.ui.view.main

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kasandi.automotivehistorycompose.R
import com.kasandi.automotivehistorycompose.ui.theme.prussian_blue

@Composable
fun AboutScreen(
    modifier: Modifier = Modifier
) {
    LazyColumn {
        item {
            Image(
                painter = painterResource(R.drawable.developer),
                contentDescription = "Banner Image",
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .height(250.dp)
            )

            Text(
                text = stringResource(R.string.my_name),
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                fontSize = 24.sp,
                color = prussian_blue,
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .padding(16.dp, 0.dp, 16.dp, 0.dp)
            )

            Text(
                text = stringResource(R.string.my_email),
                maxLines = 1,
                textAlign = TextAlign.Center,
                fontSize = 12.sp,
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .padding(16.dp, 0.dp, 16.dp, 0.dp)

            )

            Text(
                text = stringResource(R.string.my_profile),
                fontSize = 14.sp,
                textAlign = TextAlign.Justify,
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .padding(16.dp, 16.dp, 16.dp, 16.dp)
            )
        }
    }
}