# gradle-zip-unzip

# reference:
1.任务-Gradle DSL版本6.5
https://docs.gradle.org/current/dsl/org.gradle.api.Task.html
2.Android自动化构建之使用Gradle下载与处理文件
https://www.jianshu.com/p/dc075afd3a84
3.Gradle脚本常用功能总结
https://yuweiguocn.github.io/gradle-summary/
4.gradle下载脚本
https://github.com/zhengbobin/gradle-download-task


# 下载
def soFiles = new File(buildDir, 'temp.zip')
def out = new BufferedOutputStream(new FileOutputStream(soFiles))
out << new URL(downloadUrl).openStream()
out.close()

# 拷贝
copy {
  println "soFiles.getAbsolutePath() = " + soFiles.getAbsolutePath()
  from zipTree(soFiles.toString())
  into buildDir
}
copy {
  // arm64-v8a
  from new File(buildDir, 'arm64-v8a')
  into 'src/main/jniLibs/arm64-v8a'
}

# 删除
delete {
  // delete buildDir
  delete soFiles
  delete new File(buildDir, 'arm64-v8a')
  println "so files and JARS update finish."
}
