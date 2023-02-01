package hamza.dali.flutter_osm_plugin.models

import org.osmdroid.util.GeoPoint

data class StopPoint(val id: Int, val name: String, val geoPoint: GeoPoint) {
}