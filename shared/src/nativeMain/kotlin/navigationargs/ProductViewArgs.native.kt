package navigationargs

actual class ProductViewArgs(
    private val _id: String,
    private val _title: String,
    private val _description: String,
    private val _image: String
) {
    actual val id: String get() = _id
    actual val title: String get() = _title
    actual val description: String get() = _description
    actual val image: String get() = _image
}