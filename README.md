# object-csv-java
<b>
A simple Library to convert CSV format to Java model.
</b>

## INSTALL Gradle
#### Resoving gradle dependency 
##### Paste following in lines in root gradle build.config
```grovy
repositories {
    maven {
        url  "https://dl.bintray.com/sahurjt/ObjectCsv" 
    }
}
```
##### Paste following line in app build.config
```grovy
implementation 'com.sahurjt:objectpref:1.0.0'
```
## INSTALL Maven
#### Resoving maven dependency 
##### Paste following in lines in project pom.xml file
```xml
<?xml version="1.0" encoding="UTF-8" ?>
<settings xsi:schemaLocation='http://maven.apache.org/SETTINGS/1.0.0 http://maven.apache.org/xsd/settings-1.0.0.xsd'
          xmlns='http://maven.apache.org/SETTINGS/1.0.0' xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance'>
    
    <profiles>
        <profile>
            <repositories>
                <repository>
                    <snapshots>
                        <enabled>false</enabled>
                    </snapshots>
                    <id>bintray-sahurjt-ObjectCsv</id>
                    <name>bintray</name>
                    <url>https://dl.bintray.com/sahurjt/ObjectCsv</url>
                </repository>
            </repositories>
            <pluginRepositories>
                <pluginRepository>
                    <snapshots>
                        <enabled>false</enabled>
                    </snapshots>
                    <id>bintray-sahurjt-ObjectCsv</id>
                    <name>bintray-plugins</name>
                    <url>https://dl.bintray.com/sahurjt/ObjectCsv</url>
                </pluginRepository>
            </pluginRepositories>
            <id>bintray</id>
        </profile>
    </profiles>
    <activeProfiles>
        <activeProfile>bintray</activeProfile>
    </activeProfiles>
</settings>
```
##### Add maven dependency
```xml
	<dependency>
		<groupId>com.sahurjt</groupId>
		<artifactId>objectcsv</artifactId>
		<version>1.0.0</version>
	</dependency>
```

#### Complete Example <a href="https://github.com/Rjtsahu/object-csv-java-example/blob/master/src/Main.java">source code</a>

#### Usage :
```java
CsvHolder<SampleModel> holder = ObjectCsv.getInstance().from(FILE_PATH).with(CsvDelimiter.COMMA)
				.getCsvHolderforClass(SampleModel.class);
```

##### Detailed documentation will be updated soon.
##### Future version will have support to handle file read on android system.
