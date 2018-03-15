# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile
-dontwarn javax.**
-keep interface *
-keep class javax.**{*;}

-dontwarn android.support.**
-dontwarn junit.**
-keep class * extends android.support.**{*;}
-keep class * extends android.app.*{*;}

-keep class android.** { *; }
-dontwarn android.**
-keep class com.** { *; }
-dontwarn com.**

-keep class org.**{*;}
-dontwarn org.**

-keep class android.support.**{*;}


-keep public class * extends android.app.Fragment
-keep public class * extends android.app.Application
-keep public class * extends android.app.Activity
-keep public class * extends android.app.Service
-keep public class * extends android.os.IInterface
-keep public class * extends android.content.BroadcastReceiver
-keep public class * extends android.content.ContentProvider
-keep public class * extends android.appwidget.AppWidgetProvider
-keep public class * extends android.webkit.*{*;}
-keep public class * extends android.widget.*{*;}
-keep public class * extends android.view.View{*;}
-keep public class * extends android.app.backup.BackupAgentHelper
-keep public class * extends android.preference.Preference
-keep class * implements android.os.Parcelable{*;}

-keepclassmembers class * extends android.app.Activity {
   public void *(android.view.View);
}

-keep class de.greenrobot.**{*;}
-dontwarn de.greenrobot.**

-keep class android.app.FragmentManager{*;}
-dontwarn android.app.FragmentManager**