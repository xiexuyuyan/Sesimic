/* DO NOT EDIT THIS FILE - it is machine generated */
#include "com_yuyan_utils_KMP.h"
#include "../KMP.h"
/* Header for class com_yuyan_utils_KMP */

#include <stdlib.h>

/*----------------------------------------------------------------------*/
char* jstringToChar(JNIEnv* env, jstring jstr);
/*----------------------------------------------------------------------*/

/*
 * Class:     com_yuyan_utils_KMP
 * Method:    nativeFind
 * Signature: (Ljava/lang/String;Ljava/lang/String;)I
 */
JNIEXPORT jint JNICALL Java_com_yuyan_utils_KMP_nativeFind(JNIEnv *env, jclass c, jstring jpat, jstring jsrc) {
    char* pat = jstringToChar(env, jpat);
    char* src = jstringToChar(env, jsrc);

    return findStr(pat, src);
}

char* jstringToChar(JNIEnv* env, jstring jstr) {
    char* rtn = NULL;
    jclass clsstring = env->FindClass("java/lang/String");
    jstring strencode = env->NewStringUTF("utf-8");
    jmethodID mid = env->GetMethodID(clsstring, "getBytes", "(Ljava/lang/String;)[B");
    jbyteArray barr= (jbyteArray)env->CallObjectMethod(jstr, mid, strencode);
    jsize alen = env->GetArrayLength(barr);
    jbyte* ba = env->GetByteArrayElements(barr, JNI_FALSE);
    if (alen > 0) {
        rtn = (char*)malloc(alen + 1);
        memcpy(rtn, ba, alen);
        rtn[alen] = 0;
    }
    env->ReleaseByteArrayElements(barr, ba, 0);
    return rtn;
}

