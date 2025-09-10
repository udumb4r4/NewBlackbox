package top.niunaijun.blackbox.fake.service;

import android.util.Log;
import java.lang.reflect.Method;

public class GmsProxy implements java.lang.reflect.InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        try {
            // Existing logic here (original hook logic)
            // TODO: Insert your original method logic here
            return null; // Replace with actual logic if needed
        } catch (Exception e) {
            Log.e("BlackBox-GmsProxy", "Hook error in GmsProxy: " + method.getName(), e);
            return getDefaultReturnValue(method);
        }
    }
    private Object getDefaultReturnValue(Method method) {
        Class<?> returnType = method.getReturnType();
        if (returnType == Boolean.TYPE) return false;
        if (returnType == Integer.TYPE) return 0;
        if (returnType == Void.TYPE) return null;
        return null;
    }
}