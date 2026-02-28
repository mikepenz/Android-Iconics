#!/bin/bash

./gradlew clean build

if [ "$1" = "release" ];
then
  ./gradlew :iconics-core:publishToMavenCentral -x test -x lint
  ./gradlew :iconics-typeface-api:publishToMavenCentral -x test -x lint
  ./gradlew :iconics-views:publishToMavenCentral -x test -x lint
  ./gradlew :iconics-compose:publishToMavenCentral -x test -x lint

  ./gradlew :community-material-typeface-library:publishToMavenCentral -x test -x lint
  ./gradlew :devicon-typeface-library:publishToMavenCentral -x test -x lint
  ./gradlew :entypo-typeface-library:publishToMavenCentral -x test -x lint
  ./gradlew :fontawesome-typeface-library:publishToMavenCentral -x test -x lint
  ./gradlew :foundation-icons-typeface-library:publishToMavenCentral -x test -x lint
  ./gradlew :google-material-typeface-library:publishToMavenCentral -x test -x lint
  ./gradlew :google-material-typeface-outlined-library:publishToMavenCentral -x test -x lint
  ./gradlew :google-material-typeface-rounded-library:publishToMavenCentral -x test -x lint
  ./gradlew :google-material-typeface-sharp-library:publishToMavenCentral -x test -x lint
  ./gradlew :material-symbols-typeface-outlined-library:publishToMavenCentral -x test -x lint
  ./gradlew :ionicons-typeface-library:publishToMavenCentral -x test -x lint
  ./gradlew :material-design-dx-typeface-library:publishToMavenCentral -x test -x lint
  ./gradlew :material-design-iconic-typeface-library:publishToMavenCentral -x test -x lint
  ./gradlew :meteocons-typeface-library:publishToMavenCentral -x test -x lint
  ./gradlew :octicons-typeface-library:publishToMavenCentral -x test -x lint
  ./gradlew :phosphor-typeface-library:publishToMavenCentral -x test -x lint
  ./gradlew :pixeden-7-stroke-typeface-library:publishToMavenCentral -x test -x lint
  ./gradlew :typeicons-typeface-library:publishToMavenCentral -x test -x lint
  ./gradlew :weather-icons-typeface-library:publishToMavenCentral -x test -x lint
  ./gradlew :simple-icons-typeface-library:publishToMavenCentral -x test -x lint
else
    echo todo
fi