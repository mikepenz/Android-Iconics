#!/bin/bash

if [ "$1" = "release" ];
then
    ./gradlew clean build uploadArchives generatePomFileForReleasePublication bintrayUpload -Plibrarycoreonly
    ./gradlew build uploadArchives generatePomFileForReleasePublication bintrayUpload -x test -Plibraryviewsonly
else
    ./gradlew clean build uploadArchives -Plibrarycoreonly
    ./gradlew build uploadArchives -x test -Plibraryviewsonly
fi