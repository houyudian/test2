package com.fh.utils;

import java.lang.annotation.*;

/**
 * @author shangfeng
 * @Title: ExcelAnno
 * @Package com.fh.excelutil.excelanno
 * @Description: ${todo}
 * @date 2019/7/17  15:02
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.TYPE})
@Documented
public @interface ExcelAnno {
    String value() default "";
    String title() default "";
    String sheetName() default "";
    String mkdir() default "";
}
