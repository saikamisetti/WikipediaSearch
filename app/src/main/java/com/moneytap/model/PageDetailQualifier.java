package com.moneytap.model;

import com.squareup.moshi.JsonQualifier;
import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by Sai on 23/07/18.
 */
@Retention(RUNTIME)
@JsonQualifier
public @interface PageDetailQualifier {
}
