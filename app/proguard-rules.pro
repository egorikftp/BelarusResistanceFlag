-keep class * extends androidx.fragment.app.Fragment{}
-keepnames class * extends android.os.Parcelable
-keepnames class * extends java.io.Serializable

#Enum
-keepclassmembers class * extends java.lang.Enum {
    <fields>;
    **[] values();
}

-keep class com.egoriku.belarusresistanceflag.data.entity** {
    *;
}