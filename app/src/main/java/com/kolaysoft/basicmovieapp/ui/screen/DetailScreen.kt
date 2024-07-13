import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.kolaysoft.basicmovieapp.data.model.MovieItem
import com.kolaysoft.basicmovieapp.ui.theme.Color2Beige

@Composable
fun DetailScreen(navController: NavController, movieId: String?) {
    val context = LocalContext.current
    val detailedMovie = getDummyMovie().first { it.movieImdbID == movieId }

    Scaffold(
        topBar = {
            Appbar(detailedMovie = detailedMovie, context = context, navController = navController)
        },
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
                .background(Color2Beige),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            MainContent(movieItem = detailedMovie)
        }
    }
}

@Composable
fun MainContent(movieItem: MovieItem, modifier: Modifier = Modifier) {
    MovieDetailData(movieItem = movieItem, modifier = Modifier)
    MovieDetailScrollableImage(movieItem = movieItem, modifier = Modifier)
}

@Composable
fun MovieDetailScrollableImage(modifier: Modifier, movieItem: MovieItem) {
    LazyRow {
        items(movieItem.movieImages) {image ->
            ElevatedCard(
                modifier = modifier
                    .wrapContentSize()
                    .width(LocalConfiguration.current.screenWidthDp.dp)
                    .padding(10.dp),
                elevation = CardDefaults.elevatedCardElevation(5.dp)
            ) {
                MovieRectangleImage(imageUrl = image)
            }
        }
    }
}

@Composable
fun MovieDetailData(movieItem: MovieItem, modifier: Modifier) {
    Text(text = movieItem.movieTitle, style = MaterialTheme.typography.headlineLarge)
    Text(text = movieItem.movieYear, style = MaterialTheme.typography.titleLarge)
    Text(text = movieItem.movieDirector, style = MaterialTheme.typography.titleLarge)
    Text(text = movieItem.movieGenre, style = MaterialTheme.typography.titleMedium)
    Text(text = movieItem.movieImdbRating, style = MaterialTheme.typography.titleMedium)
    Text(text = movieItem.moviePlot, style = MaterialTheme.typography.titleMedium, modifier = modifier.padding(10.dp))


}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Appbar(detailedMovie: MovieItem, context: Context, navController: NavController) {
    TopAppBar(
        title = { Text(text = detailedMovie.movieTitle) },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = Color2Beige, titleContentColor = Color.Black),
        navigationIcon = {
            IconButton(
                onClick = { navController.popBackStack() }) {
                Icon(imageVector = Icons.AutoMirrored.Default.ArrowBack, contentDescription = "", tint = Color.Black)
            }
        }, actions = {
            IconButton(onClick = {
                Toast.makeText(
                    context,
                    "${detailedMovie.movieTitle} added to favorites",
                    Toast.LENGTH_SHORT
                ).show()
            }) {
                Icon(imageVector = Icons.Filled.Favorite, contentDescription = "", tint = Color.Red)
            }
        }
    )
}