# android_demo
Personal Android demo (from some trick)

## Introduction

一个自己的Android demo库，用来实现一些黑魔法（大概

## Model

- **View-Scale MVP**

尝试实现一个view级别的mvp，方便热插拔

设计初衷是要

```kotlin
功能上希望做到
- 同级node之间解耦
- 可嵌套
- node只感知自己的child
- node间通信尽可能简单且便于控制

然后
- 可读性
- 扩展性
```
