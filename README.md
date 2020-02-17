# base64util-spring-boot-starter
在[jitpack](https://www.jitpack.io)上面复制"yehongzhi/base64util-spring-boot-starter"然后"Look up"
在需要引用的项目的pom文件中添加
```java
<repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://www.jitpack.io</url>
		</repository>
</repositories>
<dependency>
	    <groupId>com.github.yehongzhi</groupId>
	    <artifactId>base64util-spring-boot-starter</artifactId>
	    <version>Tag</version>
</dependency>
```
就可以引入base64util-spring-boot-starter
示例代码：
```java
  @Resource
  private Base64Service base64Service;
```
```java
String base64 = base64Service.image2Base64(imgUrl);
```
