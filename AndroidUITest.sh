#!/bin/bash
#Takes an argument of the name of your emulator
#Start the emulator
/Applications/Genymotion.app/Contents/MacOS/gmtool admin start "Google Nexus 5"

# Wait for Android to finish booting
adb wait-for-device shell 'while [[ -z $(getprop sys.boot_completed) ]]; do sleep 1; done;'

# Run the tests
./gradlew connectedAndroidTest -i

# Stop the background processes
ps x | grep "Genymotion\.app/Contents/MacOS/.*player" | awk '{print $1}' | xargs kill