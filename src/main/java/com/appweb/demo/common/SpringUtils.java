package com.appweb.demo.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.util.Iterator;
import java.util.Map;

@Slf4j
@Component
public class SpringUtils implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    public SpringUtils() {
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        log.info("init applicationContext");
        this.applicationContext = applicationContext;
    }

    public static ApplicationContext getContext() {
        checkApplicationContext();
        return applicationContext;
    }

    public static <T> T getBean(String name) {
        checkApplicationContext();
        return (T) applicationContext.getBean(name);
    }

    public static <T> T getBean(Class<T> clazz) {
        checkApplicationContext();
        Map<String, T> a = applicationContext.getBeansOfType(clazz);
        if (CollectionUtils.isEmpty(a)) {
            return null;
        } else {
            Iterator i$ = a.entrySet().iterator();
            if (i$.hasNext()) {
                Map.Entry<String, T> entry = (Map.Entry)i$.next();
                return a.get(entry.getKey());
            } else {
                return null;
            }
        }
    }

    private static void checkApplicationContext() {
        Assert.notNull(applicationContext, "applicaitonContext未注入,请在applicationContext.xml中定义SpringContextUtil");
    }
}
