[![](https://jitpack.io/v/ethann-tech/Zincum.svg)](https://jitpack.io/#ethann-tech/Zincum)

### 项目名称

【Zincum】是化学元素周期表中第三十位元素，中文名为《锌》,以此作为项目名称的目的就是懒得起名子
本项目意在为自己打造一个基于Kotlin语言的快速开发库。里面包含但不限于 BaseX 举例：BaseFragment
、BaseActivity等,自定义View,

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
    implementation('com.github.ethann-tech:Zincum:latest')
}

```