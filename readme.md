# java-digitalbits-sdk


The Java DigitalBits Sdk library provides APIs to build transactions and connect to [Frontier](https://github.com/xdbfoundation/go/services/frontier).

## Installation

### Maven

Use [jitpack.io](https://jitpack.io)'s Maven repository:

```
repositories {
    maven { url "https://jitpack.io" }
}

dependencies {
    implementation 'com.github.digitalbits:java-digitalbits-sdk:{version}'
}
```

The list of versions to install can be found in the [Releases](./releases) section. More information can be found in [jitpack.io docs](https://jitpack.io/docs/).

### JAR

Download the latest jar from the GitHub repo's [releases tab](https://github.com/xdbfoundation/java-digitalbits-sdk/releases). Add the `jar` package to your project according to how your environment is set up.

## Basic Usage
For some examples on how to use this library, take a look at the [Get Started docs in the developers site](https://developers.digitalbits.io/guides/get-started/create-account.html).

## Documentation
Javadoc is available at https://xdbfoundation.github.io/java-digitalbits-sdk

## License
java-digitalbits-sdk is licensed under an Apache-2.0 license. See the [LICENSE](https://github.com/xdbfoundation/java-digitalbits-sdk/blob/master/LICENSE) file for details.

## xdr to jave code generation
All the java source files in io.digitalbits.sdk.xdr package are generated using the `xdrgen` command from the [digitalbits/xdrgen](https://github.com/xdbfoundation/xdrgen) 
```
xdrgen -o ./src/main/java/io/digitalbits/sdk/xdr -l java -n io.digitalbits.sdk.xdr ./xdr/DigitalBits-types.x ./xdr/DigitalBits-SCP.x ./xdr/DigitalBits-overlay.x ./xdr/DigitalBits-ledger-entries.x ./xdr/DigitalBits-ledger.x ./xdr/DigitalBits-transaction.x
```