package com.github.appreciated.applayout.behaviour.top;

import com.github.appreciated.applayout.behaviour.AppLayout;
import com.github.appreciated.applayout.builder.interfaces.NavigationElementContainer;
import com.github.appreciated.applayout.component.appmenu.left.LeftNavigationComponent;
import com.github.appreciated.applayout.design.AppLayoutDesign;
import com.github.appreciated.applayout.webcomponents.applayout.AppDrawer;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasElement;
import com.vaadin.flow.component.HasText;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.polymertemplate.Id;

import java.util.Arrays;
import java.util.List;

/**
 * Created by appreciated on 01.05.2017.
 * Edited By deyaeddin on 07.02.2018
 */

@Tag("app-layout-top-large")
@HtmlImport("frontend://com/github/appreciated/app-layout/top/top-large.html")
public class TopLarge extends AppLayout {
    protected final HorizontalLayout appBarElementWrapper = new HorizontalLayout();
    private final VerticalLayout contentPanel = new VerticalLayout();
    private final HorizontalLayout paperTabWrapper = new HorizontalLayout();
    private final VerticalLayout appBarWrapper = new VerticalLayout();
    private final HorizontalLayout appBar = new HorizontalLayout();
    private final HorizontalLayout appBarElementContainer = new HorizontalLayout();
    @Id("app-bar-elements")
    Div appBarElements;
    @Id("content")
    Div content;
    private Component title = new Span("");
    protected final HorizontalLayout titleWrapper = new HorizontalLayout(new HorizontalLayout(title));
    private List<LeftNavigationComponent> list;
    private NavigationElementContainer appMenuContainer;

    public TopLarge() {
        contentPanel.setSizeFull();

        paperTabWrapper.getElement().getStyle()
                .set("flex-grow", "1")
                .set("flex-shrink", "1")
                .set("align-self", "flex-end");
        paperTabWrapper.setWidth("100%");
        paperTabWrapper.setHeight("var(--app-bar-height)");
        paperTabWrapper.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);

        getElement().getClassList().addAll(Arrays.asList("app-layout-behaviour-" + getStyleName(), "app-layout"));
        appBar.add(titleWrapper, appBarElementWrapper);
        appBar.setFlexGrow(1.0, titleWrapper);
        appBar.setWidth("100%");
        appBar.setHeight("100%");
        appBarWrapper.add(appBar, paperTabWrapper);
        appBarWrapper.setMargin(false);
        appBarWrapper.setPadding(false);
        appBarWrapper.setSpacing(false);
        appBarElements.add(appBarWrapper);
        appBarElementWrapper.setSpacing(false);
        appBarElementWrapper.add(appBarElementContainer);
        appBarElementContainer.setHeight("100%");
        appBarElementWrapper.setAlignItems(FlexComponent.Alignment.START);
        titleWrapper.setHeight("100%");
        titleWrapper.setAlignItems(FlexComponent.Alignment.CENTER);
        ((Span) this.title).getStyle().set("white-space", "nowrap");
        titleWrapper.setAlignItems(FlexComponent.Alignment.CENTER);
        titleWrapper.setHeight("var(--app-bar-height)");

        appBarElementWrapper.setAlignItems(FlexComponent.Alignment.START);
        appBarElementWrapper.setHeight("var(--app-bar-height)");
    }

    @Override
    public String getStyleName() {
        return "top";
    }

    @Override
    public AppDrawer getDrawer() {
        return null;
    }

    @Override
    public void setAppLayoutContent(HasElement content) {
        if (content != null) {
            this.content.getElement().appendChild(content.getElement());
        }
    }

    public Div getAppBarElements() {
        return appBarElements;
    }

    public void setDesign(AppLayoutDesign design) {
        this.getElement().getClassList().add(design.getStyleName());
    }

    public HorizontalLayout getAppBar() {
        return appBar;
    }

    public HorizontalLayout getAppBarElementWrapper() {
        return appBarElementWrapper;
    }

    public Component getTitleLabel() {
        return title;
    }

    public void setTitle(String title) {
        if (this.title instanceof HasText) {
            ((HasText) this.title).setText(title);
        }
    }

    @Override
    public void setTitleElement(HasElement titleComponent) {

    }

    @Override
    public Component getTitleComponent() {
        return title;
    }

    public void setTitleComponent(Component component) {
        titleWrapper.replace(this.title, component);
        this.title = component;
    }

    public HorizontalLayout getTitleWrapper() {
        return titleWrapper;
    }

    public void addAppBarIcon(Component appBarIconComponent) {
        titleWrapper.add(appBarIconComponent);
    }

    @Override
    public void setBackNavigation(boolean visible) {
        //paperIconButton.setIcon(visible ? "arrow-back" : "menu");
    }

    @Override
    public void setActiveElement(HasElement content) {
        appMenuContainer.setActiveNavigationElementWithViewClass(content);
    }

    @Override
    public void setAppBar(Component component) {
        appBarElementContainer.removeAll();
        appBarElementContainer.add(component);
    }

    @Override
    public void setAppMenu(NavigationElementContainer container) {
        paperTabWrapper.removeAll();
        paperTabWrapper.add(container.getComponent());
        appMenuContainer = container;
    }
}

