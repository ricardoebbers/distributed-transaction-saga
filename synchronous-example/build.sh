#!/bin/bash
projectName="synchronous-example"
echo "building services of $projectName..."
for d in */; do
    echo "building '$d' service..."
    cd "$d" || exit
    imageName="$projectName/${d%/}"
    echo "creating '$imageName' image..."
    ./mvnw spring-boot:build-image -Dspring-boot.build-image.imageName="$imageName"
    cd ..
done
echo "building done."