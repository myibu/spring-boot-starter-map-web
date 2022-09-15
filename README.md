# spring-boot-starter-map-web
web service api of map, with spring-boot-starter

## Implements
use `RestTemplate` to invoke api of map server provider

## Installation
```bash
<dependency>
  <groupId>com.github.myibu</groupId>
  <artifactId>spring-boot-starter-map-web</artifactId>
  <version>1.0.0</version>
</dependency>
```

## Examples
```java
@Autowired
private AmapWebClient amapWebClient;

GpsLocation location = amapWebClient.address2Gps("北京市朝阳区阜通东大街6号");
System.out.println(location);
```

## Change Notes
### 1.0.0
- support amap api, like address2Gps and so on.
