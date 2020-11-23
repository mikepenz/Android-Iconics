#!/bin/bash

./gradlew clean build

if [ "$1" = "release" ];
then
    ./gradlew bintrayUpload -x test -x lint -Plibrarytypefaceonly
    ./gradlew bintrayUpload -x test -x lint -Plibrarycoreonly
    ./gradlew bintrayUpload -x test -x lint -Plibraryviewsonly

    # ./gradlew bintrayUpload -x test -x lint -Pcommunitymaterialonly
    # ./gradlew bintrayUpload -x test -x lint -PDevIcononly
    # ./gradlew bintrayUpload -x test -x lint -PEntypoonly
    # ./gradlew bintrayUpload -x test -x lint -Pfontawesomeonly
    # ./gradlew bintrayUpload -x test -x lint -PFoundationIconsonly
    # ./gradlew bintrayUpload -x test -x lint -Pgooglematerialonly
    # ./gradlew bintrayUpload -x test -x lint -PIoniconsonly
    # ./gradlew bintrayUpload -x test -x lint -Pmaterialdesigniconiconly
    # ./gradlew bintrayUpload -x test -x lint -Pmeteoconsonly
    # ./gradlew bintrayUpload -x test -x lint -Pocticons
    # ./gradlew bintrayUpload -x test -x lint -PPixeden7Strokeonly
    # ./gradlew bintrayUpload -x test -x lint -PTypeiconsonly
    # ./gradlew bintrayUpload -x test -x lint -Pweathericonsonly
    # ./gradlew bintrayUpload -x test -x lint -Pmaterialdesigndxonly
else
    echo todo
fi