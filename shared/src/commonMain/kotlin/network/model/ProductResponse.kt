package network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProductResponse(
    @SerialName("description")
    val description: String?,
    @SerialName("end_date")
    val endDate: String?,
    @SerialName("gamerpower_url")
    val gamerpowerUrl: String?,
    @SerialName("id")
    val id: Int?,
    @SerialName("image")
    val image: String?,
    @SerialName("instructions")
    val instructions: String?,
    @SerialName("open_giveaway")
    val openGiveaway: String?,
    @SerialName("open_giveaway_url")
    val openGiveawayUrl: String?,
    @SerialName("platforms")
    val platforms: String?,
    @SerialName("published_date")
    val publishedDate: String?,
    @SerialName("status")
    val status: String?,
    @SerialName("thumbnail")
    val thumbnail: String?,
    @SerialName("title")
    val title: String?,
    @SerialName("type")
    val type: String?,
    @SerialName("users")
    val users: Int?,
    @SerialName("worth")
    val worth: String?
)