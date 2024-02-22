package mx.unam.fi.listacomida

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import mx.unam.fi.listacomida.data.DataSource
import mx.unam.fi.listacomida.model.Platillo
import mx.unam.fi.listacomida.ui.theme.ListaComidaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ListaComidaTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val platillos = DataSource().loadPlatillos()
                    MenuList(platillos = platillos)
                }
            }
        }
    }
}

@Composable
fun MenuList(platillos: List<Platillo>) {
    LazyColumn {
        items(platillos) { platillo ->
            MenuCard(platillo = platillo)
        }
    }
}

@Composable
fun MenuCard(platillo: Platillo) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column {
            Image(
                painter = painterResource(id = platillo.drawableResourceId),
                contentDescription = stringResource(id = platillo.nombreResourceId),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(190.dp)
                    .padding(bottom = 8.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = stringResource(id = platillo.nombreResourceId),
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.headlineMedium
            )
            Text(
                text = stringResource(id = platillo.precioResourceId),
                modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 8.dp),
                style = MaterialTheme.typography.bodySmall
            )
            Text(
                text = stringResource(id = platillo.esloganResourceId),
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ShowMenuCard() {
    val platillos = DataSource().loadPlatillos()
    MenuList(platillos = platillos)
}
