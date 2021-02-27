package com.wugeDomain;

import com.wugeDomain.SysLog;
import org.springframework.core.NamedThreadLocal;

public class SysLogContextUtils {
    private static final ThreadLocal<SysLog> requestAttributesHolder = new NamedThreadLocal("Request attributes");

    public static void setSysLog(SysLog sysLog){
        requestAttributesHolder.set(sysLog);
    }

    public static SysLog getSysLog(){
        return requestAttributesHolder.get();
    }

}
