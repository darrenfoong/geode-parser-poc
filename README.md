# CacheXMLParser bug proof of concept

- Clone this repository and import it into Eclipse.
- Make sure that Oracle JDK 1.8 is being used (I used 8u141).
- Run `ServerTrimmed` and `ServerWhitespace`; both should work.
- Uncomment the `xerces` dependency in `build.gradle`.
- Refresh the Gradle project and run the two `Servers` again.
 - `ServerTrimmed` should work while `ServerWhitespace` will have a
   parsing error.
