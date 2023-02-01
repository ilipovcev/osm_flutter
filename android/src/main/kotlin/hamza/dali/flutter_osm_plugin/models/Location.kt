package hamza.dali.flutter_osm_plugin.models

import org.osmdroid.util.GeoPoint

data class Location(
    val id: Int,
    val name: String,
    val slug: String,
    val geoPoint: GeoPoint,
    val typeId: Int,
    val typeSlug: String?,
    val typeColorHex: String?,
    val typeIconName: String?,
) {

}