#!/bin/bash
projectName="synchronous-example"
echo "building services of $projectName..."
for d in */; do
    echo "entering $d folder..."
    cd "$d" || exit
    echo "building '$d' service..."
    ./mvnw clean install -Dmaven.test.skip=true
    cd ..
done
echo "building done."