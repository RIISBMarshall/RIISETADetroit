$ANDROID_HOME/tools/emulator -avd $1 &
EMULATOR_PID=$!

# Wait for Android to finish booting
WAIT_CMD="$ANDROID_HOME/platform-tools/adb wait-for-device shell getprop init.svc.bootanim"
until $WAIT_CMD | grep -m 1 stopped; do
  echo "Waiting..."
  sleep 1
done

# Unlock the Lock Screen
$ANDROID_HOME/platform-tools/adb shell input keyevent 82

# Run the tests
./gradlew connectedAndroidTest -i

# Stop the background processes
kill $EMULATOR_PID