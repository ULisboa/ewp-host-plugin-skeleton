<h1 align="center">
  <br>
  <a href="https://www.erasmuswithoutpaper.eu/"><img src="https://developers.erasmuswithoutpaper.eu/logo.png" alt="EWP" width="350"></a>
  <a href="https://www.ulisboa.pt/"><img src="https://rem.rc.iseg.ulisboa.pt/img/logo_ulisboa.png" alt="ULisboa" width="380"></a>
    <br>
  EWP Host Plugin Skeleton
  <br>
</h1>

<p align="center">
  <a href="https://maven-badges.herokuapp.com/maven-central/pt.ulisboa/ewp-host-plugin-skeleton">
    <img src="https://maven-badges.herokuapp.com/maven-central/pt.ulisboa/ewp-host-plugin-skeleton/badge.svg"
        alt="Maven Central">
  </a>
  <a href="https://github.com/ULisboa/ewp-host-plugin-skeleton/blob/master/LICENSE">
    <img alt="GitHub" src="https://img.shields.io/github/license/ulisboa/ewp-host-plugin-skeleton">
  </a>
  <img src="https://img.shields.io/badge/JDK-11+-green.svg" alt="JDK 11+">
</p>

<h4 align="center">This Java library contains the general skeleton of an EWP host plugin that may be implemented to allow EWP Node to obtain data from a host.</h4>


## Work in Progress warning

This project is still early in development. Therefore, until the first major version is released, 
non-backward changes may be introduced.

## Requirements

To clone and use this project, you'll need [Git](https://git-scm.com), if you intend to build it yourself, and [Maven](https://maven.apache.org/).

## Using the library

To use the library, click the Maven Central badge above and use the correct snippet for your dependency manager.

## Cloning the Project

To clone the project run:
```
git clone https://github.com/ULisboa/ewp-host-plugin-skeleton
```

## Building with Maven

Run the command line:
```
mvn clean package
```

The JAR will be located at ewp-host-plugin-skeleton/target.
The JAR may then be added as library to any Java project.

## Usage Example

The directory ewp-host-plugin-demo contains an example of a simple host plugin that 
returns hardcoded data.

From that example project, it is possible to extend with real API communication to external services 
to obtain the data required.

## License

This project is licensed under the terms of the [MIT license](LICENSE).