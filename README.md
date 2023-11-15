### 这是一个常用且好用的自定义View库。



### Step 1. Add the JitPack repository to your build file

** Add it in your root build.gradle at the end of repositories: **
```kotlin
    dependencyResolutionManagement {
        repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
        repositories {
            google()
            mavenCentral()
            maven { url = uri(path = "https://www.jitpack.io") }
        
        }
    }
    
```
### Step 2. Add the dependency

```kotlin

    dependencies {
	   implementation ('com.github.ethann-tech:Zincum:0.0.3')
	}

```