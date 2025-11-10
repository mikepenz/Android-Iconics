#!/bin/bash

./gradlew clean build

if [ "$1" = "release" ];
then
    ./gradlew publishReleasePublicationToSonatypeRepository -x test -x lint -Plibrarytypefaceonly
    ./gradlew publishReleasePublicationToSonatypeRepository -x test -x lint -Plibrarycoreonly
    ./gradlew publishReleasePublicationToSonatypeRepository -x test -x lint -Plibraryviewsonly
    ./gradlew publishReleasePublicationToSonatypeRepository -x test -x lint -Plibrarycomposeonly

    # ./gradlew publishReleasePublicationToSonatypeRepository -x test -x lint -Pcommunitymaterialonly
    # ./gradlew publishReleasePublicationToSonatypeRepository -x test -x lint -PDevIcononly
    # ./gradlew publishReleasePublicationToSonatypeRepository -x test -x lint -PEntypoonly
    # ./gradlew publishReleasePublicationToSonatypeRepository -x test -x lint -Pfontawesomeonly
    # ./gradlew publishReleasePublicationToSonatypeRepository -x test -x lint -PFoundationIconsonly
    # ./gradlew publishReleasePublicationToSonatypeRepository -x test -x lint -Pgooglematerialonly
    # ./gradlew publishReleasePublicationToSonatypeRepository -x test -x lint -PIoniconsonly
    # ./gradlew publishReleasePublicationToSonatypeRepository -x test -x lint -Pmaterialdesigndxonly
    # ./gradlew publishReleasePublicationToSonatypeRepository -x test -x lint -Pmaterialdesigniconiconly
    # ./gradlew publishReleasePublicationToSonatypeRepository -x test -x lint -Pmaterialsymbolsonly
    # ./gradlew publishReleasePublicationToSonatypeRepository -x test -x lint -Pmeteoconsonly
    # ./gradlew publishReleasePublicationToSonatypeRepository -x test -x lint -Pocticons
    # ./gradlew publishReleasePublicationToSonatypeRepository -x test -x lint -Pphosphor
    # ./gradlew publishReleasePublicationToSonatypeRepository -x test -x lint -PPixeden7Strokeonly
    # ./gradlew publishReleasePublicationToSonatypeRepository -x test -x lint -PTypeiconsonly
    # ./gradlew publishReleasePublicationToSonatypeRepository -x test -x lint -Pweathericonsonly
else
    echo todo
fi