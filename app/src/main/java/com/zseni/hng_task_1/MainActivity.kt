package com.zseni.hng_task_1

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.zseni.hng_task_1.ui.theme.Hng_task_1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Hng_task_1Theme {
                // A surface container using the 'background' color from the theme
                AboutLayout { // No need to explicitly pass an empty parameter list
                    val mUrl = "https://github.com/idongesit98"
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(mUrl))
                    startActivity(intent)
                }
            }
        }
    }
}

@Composable
fun AboutLayout(openWebsite:() -> Unit) {
            ElevatedCard(
                modifier = Modifier
                    .absolutePadding(left = 1.dp, right = 10.dp)
                    .fillMaxWidth(),
                colors = CardDefaults.elevatedCardColors()
            ) {
                Image(
                    painter = painterResource(id =R.drawable.img),
                    contentScale = ContentScale.Crop,
                    contentDescription = stringResource(id = R.string.img_desc),
                    modifier = Modifier
                        .wrapContentSize()
                        .wrapContentHeight()
                        .padding(10.dp)
                )
                Text(
                    text = stringResource(id = R.string.my_name)
                )
            }
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(),
                    verticalArrangement = Arrangement.Bottom,
                    horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                    Button(
                        onClick = {openWebsite()},
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Text(text = "Open Github")

                    }
                }
            }


@Composable
fun myLink(openWebsite: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = { openWebsite() }, // Call the lambda function when the button is clicked
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Open Website")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AboutMePreview() {
    Hng_task_1Theme {
        AboutLayout {
        }
    }
}