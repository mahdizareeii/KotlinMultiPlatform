package navigationargs

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
actual class ProductViewArgs(
    private val _id: String,
    private val _title: String,
    private val _desc: String,
    private val _image: String
) : Parcelable {
    actual val id: String get() = _id
    actual val title: String get() = _title
    actual val desc: String get() = _desc
    actual val image: String get() = _image
}