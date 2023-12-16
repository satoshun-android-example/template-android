package io.github.satoshun.example.next

import android.net.Uri
import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavType
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Parcelize
@Serializable
data class NextUser(
  val id: Int,
  val name: String,
) : Parcelable

object NextUserType : NavType<NextUser>(isNullableAllowed = false) {
  override fun get(bundle: Bundle, key: String): NextUser? =
    bundle.getParcelable(key)

  override fun put(bundle: Bundle, key: String, value: NextUser) =
    bundle.putParcelable(key, value)

  override fun parseValue(value: String): NextUser {
    return Json.decodeFromString(value)
  }

  fun encodeToString(user: NextUser): String {
    return Uri.encode(Json.encodeToString(user))
  }
}
