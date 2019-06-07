#!/bin/bash

if [ "$1" = "release" ];
then
    ./gradlew clean build bintrayUpload -Plibrarycoreonly
    ./gradlew build bintrayUpload -x test -x lint -Plibraryviewsonly

    #./gradlew build bintrayUpload -x test -x lint -Pcommunitymaterialonly
    #./gradlew build bintrayUpload -x test -x lint -PDevIcononly
    #./gradlew build bintrayUpload -x test -x lint -PEntypoonly
    #./gradlew build bintrayUpload -x test -x lint -Pfontawesomeonly
    #./gradlew build bintrayUpload -x test -x lint -PFoundationIconsonly
    #./gradlew build bintrayUpload -x test -x lint -Pgooglematerialonly
    #./gradlew build bintrayUpload -x test -x lint -PIoniconsonly
    #./gradlew build bintrayUpload -x test -x lint -Pmaterialdesigniconiconly
    #./gradlew build bintrayUpload -x test -x lint -Pmeteoconsonly
    #./gradlew build bintrayUpload -x test -x lint -Pocticons
    #./gradlew build bintrayUpload -x test -x lint -PPixeden7Strokeonly
    #./gradlew build bintrayUpload -x test -x lint -PTypeiconsonly
    #./gradlew build bintrayUpload -x test -x lint -Pweathericonsonly
else
    echo todo
fi