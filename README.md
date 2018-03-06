# 自定义圆形百分比view [![](https://www.jitpack.io/v/xiedong11/CirclePercentView.svg)](https://www.jitpack.io/#xiedong11/CirclePercentView) #

 ![Sample Screenshot](https://github.com/xiedong11/CirclePercentView/blob/master/picture/percentView.gif)

## 依赖配置 ##

### 在你project的build.gradle 文件中添加如下配置项 ###
```
allprojects {
    repositories {
		...
       maven { url 'https://www.jitpack.io' }
	}
	}
```
### 在你module中的build.gradle中添加如下配置 ###
```
dependencies {
	        compile 'com.github.xiedong11:CirclePercentView:v1.0.1'
	}
```

* 如果你的项目中引入后，项目目依赖包发生Manifest Merge冲突，请在Module把依赖改成如下：
```
   compile ('com.github.xiedong11:RippleView:1.2'){
    exclude group: 'com.android.support'
}
```


** 使用样例 **

```

    <com.zhuandian.circlepercent.PercentCircle
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:background_color="#bcb6b6"
        app:text_str_color="#332233"
        app:percent_target="25"
        app:percent_text_color="#333333"
        app:ring_color="#7c0d25"
        app:radius="200" />
```
**属性说明**

* radius：圆环半径大小

* background_color：圆环内部背景颜色

* percent_text_color：百分比数字字体颜色

* text_str_color：百分比数字上部文字描述字体颜色

* ring_color：圆环的颜色

* percent_text_desc：百分比数字上部的文字描述字符串

* percent_target：百分比具体的数值

