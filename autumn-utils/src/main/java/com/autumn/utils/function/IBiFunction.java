package com.autumn.utils.function;

import java.io.Serializable;
import java.util.function.BiFunction;

/**
 * @author shenke
 * @since 2022/11/5 11:20
 */
public interface IBiFunction<T, U, R> extends BiFunction<T, U, R>, Serializable {

}
