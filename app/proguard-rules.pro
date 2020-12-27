-keepattributes SourceFile, LineNumberTable, Signature, *Annotation*
-keep public class * extends java.lang.Exception

-keepclassmembers class * extends java.lang.Enum {
    <fields>;
    **[] values();
}

-keepclassmembers,allowobfuscation class * {
  @com.google.gson.annotations.SerializedName <fields>;
}