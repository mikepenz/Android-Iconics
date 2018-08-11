#!/bin/bash

if [ "$1" = "release" ];
then
    ./gradlew clean build bintrayUpload -Plibrarycoreonly
    ./gradlew build bintrayUpload -x test -Plibraryviewsonly
else
    echo todo
fi