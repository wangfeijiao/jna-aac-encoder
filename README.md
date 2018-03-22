# jna-aac-encoder

[![Build Status](https://travis-ci.org/sheinbergon/jna-aac-encoder.svg?branch=master)](https://travis-ci.org/sheinbergon/jna-aac-encoder) [![Coverage Status](https://coveralls.io/repos/github/sheinbergon/jna-aac-encoder/badge.svg)](https://coveralls.io/github/sheinbergon/jna-aac-encoder) [![License: LGPL v3](https://img.shields.io/badge/License-LGPL%20v3-blue.svg)](https://www.gnu.org/licenses/lgpl-3.0) [![Maven Central](https://maven-badges.herokuapp.com/maven-central/org.sheinbergon/jna-aac-encoder/badge.svg)](https://maven-badges.herokuapp.com/maven-central/org.sheinbergon/jna-aac-encoder)
                                                                                                                                                                                                                                                                                                 
This library provides AAC encoding capabilities for the JVM. 
It utilizes the [FDK AAC](https://github.com/mstorsjo/fdk-aac) library via JNA in order to do so.


## License
**Important!** While this library uses LGPL-3, please see
the [FDK AAC license](NOTICE) for additional information
regarding re/distribution and licensing limitations.

## Usage

#### Dependencies

Artifacts are available on maven central:

**_Gradle_**
```groovy
compile 'org.sheinbergon:jna-aac-encoder:0.1.1'
```
**_Maven_**
```xml
<dependency>
    <groupId>org.sheinbergon</groupId>
    <artifactId>jna-aac-encoder</artifactId>
    <version>0.1.1</version>
</dependency>
```

#### Notice!!!

The **_libfdk-aac_** shared library so/dll/dylib file is required to be accessible
for dynamic loading upon execution. If using the above depdencey, you
need to make sure the shared library is installed as part of the runtime OS enviroment
and accessible to JNA. See [this](https://github.com/java-native-access/jna/blob/master/www/FrequentlyAskedQuestions.md#calling-nativeloadlibrary-causes-an-unsatisfiedlinkerror) link for additional information

To make things easier, cross compilations artifacts (containing the shared library)
for both Windows (64bit) and Linux(64bit) are provided through maven _classifiers_ :

##### Windows 64
**_Gradle_**
```groovy
compile 'org.sheinbergon:jna-aac-encoder:0.1.1:win32-x86-64'
```
**_Maven_**
```xml
<dependency>
    <groupId>org.sheinbergon</groupId>
    <artifactId>jna-aac-encoder</artifactId>
    <version>0.1.1</version>
    <classifier>win32-x86-64</classifier>
</dependency>
```
##### Linux 64
**_Gradle_**
```groovy
compile 'org.sheinbergon:jna-aac-encoder:0.1.1:linux-x86-64'
```
**_Maven_**
```xml
<dependency>
    <groupId>org.sheinbergon</groupId>
    <artifactId>jna-aac-encoder</artifactId>
    <version>0.1.1</version>
    <classifier>linux-x86-64</classifier>
</dependency>
```

32bit platform won't be supported for now.
OSX/Macos toolchain is a bit trickier, so you'll just have to pre-install the dylib in advance.


#### Java AudioSystem
```java
AudioInputStream input = AudioSystem.getAudioInputStream(...);
File output = new File(...);
AudioSystem.write(input, AACFileTypes.AAC_LC, output);
```

#### Limitations
Currently, only pcm_s16le WAV input is supported, meaning:
* Sample size - 16 bit(signed)
* WAV format - PCM
* Byte order - Little Endian

While this seems to the common raw-audio formatting, it's important
to note that providing input audio with different formatting will cause
the encoding process to fail. 

Additional restrictions:
* A maximum of 6 audio input/output channels
* Only the AAC-LC(**L**ow **C**omplaxity) encoding profile is suuported  


## Roadmap
* Improved lower-level interface (with examples).
* Performance tests/comparison (JMH).
* Support for AAC HE & HEv2.
* Meta-data insertion.
* MacOS cross-compiling?
* AAC Decoding???