package top.moxingwang.agent.api;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD,ElementType.TYPE_USE})
public @interface SPI {
    /**
     * default extension name
     */
    String value() default "";
}