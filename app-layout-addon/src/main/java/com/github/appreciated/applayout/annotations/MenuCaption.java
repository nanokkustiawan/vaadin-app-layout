package com.github.appreciated.applayout.annotations;

import com.github.appreciated.applayout.builder.AppLayoutBuilder;
import com.github.appreciated.applayout.builder.interfaces.ComponentFactory;
import com.github.appreciated.applayout.component.appmenu.left.LeftNavigationComponent;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * This annotation is meant to be used in combination with
 * {@link AppLayoutBuilder#withNavigationElementProvider(ComponentFactory)}
 *
 * The value of this annotation will be used for the {@link LeftNavigationComponent} as the caption of the button
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface MenuCaption {
    String value();
}
