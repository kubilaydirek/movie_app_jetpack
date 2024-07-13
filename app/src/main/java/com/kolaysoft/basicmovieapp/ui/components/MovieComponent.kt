import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import coil.transform.CircleCropTransformation

@Composable
fun MovieCircleImage(modifier: Modifier = Modifier, imageUrl: String) {
    val painter = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current).data(imageUrl).size(Size.ORIGINAL)
            .transformations(CircleCropTransformation()).crossfade(true).build()
    )

    Image(painter = painter, contentDescription = "")

}


@Composable
fun MovieRectangleImage(imageUrl: String) {
    val painter = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current)
            .data(imageUrl)
            .size(Size.ORIGINAL)
            .crossfade(true)
            .build()
    )

    Image(painter = painter, contentDescription = "")
}

@Composable
fun MovieCamingSoonImage() {
    val painter = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current).data("https://cdn-icons-png.flaticon.com/128/8089/8089442.png")
            .size(Size.ORIGINAL)
            .transformations(CircleCropTransformation()).crossfade(true).build()
    )

    Image(painter = painter, contentDescription = "")

}