package domain.model.products

data class ProductResponseDomain(
    val desc: String,
    val endDate: String,
    val id: Int,
    val image: String,
    val instructions: String,
    val platforms: String,
    val publishedDate: String,
    val status: String,
    val thumbnail: String,
    val title: String,
    val type: String,
    val users: Int,
    val worth: String
)