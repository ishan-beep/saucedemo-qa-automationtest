plugins {
    id("java")
}

group = "com.ishan"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {

    implementation("org.seleniumhq.selenium:selenium-java:4.18.1")
    implementation("io.github.bonigarcia:webdrivermanager:6.1.0")
    testImplementation("org.testng:testng:7.9.0")
}


tasks.test {
    // Tests are written with TestNG, configure the test task to run TestNG
    useTestNG()
}