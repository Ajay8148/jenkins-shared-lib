def call(String imageName, String containerName) {
    echo "Building Docker image: ${imageName}"
    sh "docker build -t ${imageName} ."

    echo "Stopping old container if exists"
    sh "docker rm -f ${containerName} || true"

    echo "Running new container"
    sh "docker run -d -p 8080:80 --name ${containerName} ${imageName}"
}

