#!/bin/bash
projectName="synchronous-example"
echo "building services of '$projectName'..."
for d in */; do
    cd "$d" || exit
    echo "building '$d' service..."
    ./mvnw clean install -Dmaven.test.skip=true
    cd ..
done
echo "building done."