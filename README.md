# flutter_osm_plugin
![pub](https://img.shields.io/badge/pub-v0.4.5%2B1-orange)

osm plugin for flutter apps (only Android for now, iOS will be supported in future)

* current position
* change position 
* tracking user location
* customize Icon Marker
* draw Road,recuperate information (duration/distance) of the current road
* ClickListener on Marker
* calculate distance between 2 points

## Getting Started


## Installing

Add the following to your `pubspec.yaml` file:

    dependencies:
      flutter_osm_plugin: ^0.4.5+1
## Simple Usage
#### Creating a basic `OSMFlutter`:
  
  
    OSMFlutter( 
        key: osmKey,
        currentLocation: false,
        road: Road(
                startIcon: MarkerIcon(
                  icon: Icon(
                    Icons.person,
                    size: 64,
                    color: Colors.brown,
                  ),
                ),
                roadColor: Colors.yellowAccent,
        ),
        markerIcon: MarkerIcon(
        icon: Icon(
          Icons.person_pin_circle,
          color: Colors.blue,
          size: 56,
          ),
        ),
        initPosition: GeoPoint(latitude: 47.35387, longitude: 8.43609),
    );

### Declare GlobalKey

`  GlobalKey<OSMFlutterState> osmKey = GlobalKey<OSMFlutterState>();`

### set map on user current position

` osmKey.currentState.currentPosition() `

### zoomIN

* ` osmKey.currentState.zoom(2.) `

* ` osmKey.currentState.zoomIn() `


### zoomOut

* ` osmKey.currentState.zoom(-2.) `

* ` osmKey.currentState.zoomOut() `

###  track user current position

` osmKey.currentState.enableTracking() `

### disable tracking user position

` osmKey.currentState.disabledTracking() `

### initialise position

` osmKey.currentState.changeLocation(GeoPoint(latitude: 47.35387, longitude: 8.43609)) `

### recuperation current position

`GeoPoint geoPoint = osmKey.currentState.myLocation() `

### select/create new position

`GeoPoint geoPoint = osmKey.currentState.selectPosition() `

### draw road,recuperate distance in km and duration in sec
` RoadInfo roadInfo = await osmKey.currentState.drawRoad( GeoPoint(latitude: 47.35387, longitude: 8.43609),GeoPoint(latitude: 47.4371, longitude: 8.6136)); `
` print("${roadInfo.distance}km")`
` print("${roadInfo.duration}sec")`

### change static geopoint position
> you can use it if you don't have at first static position and you need to add  staticPoints with empty list of geoPoints
> you can use it to change their position over time
` osmKey.currentState.setStaticPosition(List<GeoPoint> geoPoints,String id ) `

####  `OSMFlutter`
| Properties           | Description                         |
| -------------------- | ----------------------------------- |
| `currentLocation`    | enable the current position.        |
| `trackMyPosition`    | enbaled tracking user position.     |
| `showZoomController` | show default zoom controller.       |
| `initPosition`       | set default position showing in map |
| `markerIcon`         | set icon Marker                     |
| `defaultZoom`        | set default zoom to use in zoomIn()/zoomOut() (default 1)       |
| `road`               | set color and start/end/middle markers in road |
| `useSecureURL`       | enabled secure urls                  |
| `staticPoints`       | List of Markers you want to show always ,should every marker have unique id |
| `onGeoPointClicked`  | listener on static geoPoint          |

## STATIC METHODS:
### calculate distance between 2 geopoint position
` double distanceEnMetres = await distance2point(GeoPoint(longitude: 36.84612143139903,latitude: 11.099388684927824,),
        GeoPoint( longitude: 36.8388023164018, latitude: 11.096959785428027, ),); `


## NOTICE:
> `for now the map working only for android,iOS will be available soon `

> ` if you get ssl certfiction exception,use can use http by following instruction below `

> ` if you want to use http in Android PIE or above : `
  * enable useSecureURL and add ` android:usesCleartextTraffic="true" `  in your manifest like example below :

    * ` <application
        ...
        android:usesCleartextTraffic="true"> 
        `

#### MIT LICENCE
