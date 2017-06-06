package com.yj.mvpdaggerretrofitrxjava.dagger;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by YJ on 2017/6/5.
 */

@Scope
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface UIScope {
}
