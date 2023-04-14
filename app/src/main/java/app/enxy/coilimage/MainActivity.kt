package app.enxy.coilimage

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import app.enxy.coilimage.ui.theme.CoilImageTheme
import coil.compose.AsyncImage
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.coil.CoilImage

val images = listOf(
    "https://sun9-71.userapi.com/impf/c845021/v845021812/105e6a/w1OjOQ5sDmg.jpg?size=1280x720&quality=96&sign=0f38cbb4feb224a83de26a61a61bfbe0&c_uniq_tag=2QRkIleKplOzUzH5mtqB7XFQmv3TBXsVqpC_6aZ0jZk&type=album",
    "https://pluspng.com/img-png/kotlin-logo-png-kotlin-collection-function-techshots-medium-1200x630.png",
    "https://miro.medium.com/max/1200/1*NF-UydLEpdf31t4arpCzhg.jpeg",
    "https://xakep.ru/wp-content/uploads/2017/10/140395/Kotlin.jpg",
    "https://miro.medium.com/max/1200/1*XLzOeOzcu_GJ6fo0SfNaVA.jpeg",
    "https://cdn2.duabhmoobtojsiab.com/img/kuvyoghmoobaHR0cDovL3J1YWEubWUvY29udGVudC9pbWFnZXMvMjAxOS8xMC9rb3RsaW4tY292ZXIuanBn.jpg",
    "https://miro.medium.com/max/3840/1*-884FNjzgYlq5GTO_c7aGw.png",
    "https://miro.medium.com/max/825/1*JsOUSnX3NMaY5Y3C3DsQNg.jpeg",
    "https://1.bp.blogspot.com/-SfC_Z4va004/Wfj1RHRGLGI/AAAAAAAAAvk/rQB-IjR3QREzFQaaSn9--XFy5Ens4mhfACPcBGAYYCw/s2520/Rectangle%25403x.png"
)
val urls = generateSequence { images }.take(20).flatten().toList()

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoilImageTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Row {
                            Button(
                                onClick = {
                                    startActivity(
                                        Intent(
                                            this@MainActivity,
                                            ActivityLandscapist::class.java
                                        )
                                    )
                                },
                                modifier = Modifier.weight(1f)
                            ) {
                                Text(
                                    text = "Landscapist (Coil)"
                                )
                            }
                            Button(
                                onClick = {
                                    startActivity(
                                        Intent(
                                            this@MainActivity,
                                            ActivityCoil::class.java
                                        )
                                    )
                                },
                                modifier = Modifier.weight(1f)
                            ) {
                                Text(
                                    text = "Coil"
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

class ActivityLandscapist : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoilImageTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CoilImageList(urls)
                }
            }
        }
    }
}

class ActivityCoil : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoilImageTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CoilList(urls)
                }
            }
        }
    }
}

@Composable
private fun CoilImageList(
    urls: List<String>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        modifier = modifier
    ) {
        items(
            items = urls,
        ) { url ->
            CoilImage(
                imageModel = { url },
                imageOptions = ImageOptions(contentScale = ContentScale.FillWidth),
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
private fun CoilList(
    urls: List<String>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        modifier = modifier
    ) {
        items(
            items = urls,
        ) { url ->
            AsyncImage(
                model = url,
                contentDescription = null,
                contentScale = ContentScale.FillWidth,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}
