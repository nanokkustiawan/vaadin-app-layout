package com.github.appreciated.applayout.webcomponents.appmenu;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.IronIcon;


@Tag("app-submenu")
@HtmlImport("bower_components/app-menu/app-submenu.html")
public class AppSubmenu extends Component implements HasComponents {

    private final AppMenu menu;
    private final AppMenuIconItem item;
    private final IronIcon ironIcon;
    private final Div toggleWrapper;
    private AppMenu parent;

    /**
     * <div class="app-menu-item" slot="submenu-trigger">
     * <app-menu-icon-item icon="icons:account-balance">Accounts</app-menu-icon-item>
     * <iron-icon icon="expand-more" class="expand-icon"></iron-icon>
     * </div>
     *
     * @param sectionName
     * @param icon
     */
    public AppSubmenu(String sectionName, Icon icon) {
        toggleWrapper = new Div();
        toggleWrapper.getElement().getClassList().add("app-menu-item");
        toggleWrapper.getElement().setAttribute("slot", "submenu-trigger");

        item = new AppMenuIconItem(sectionName, icon.getElement().getAttribute("icon"));
        ironIcon = new IronIcon("icons", "expand-more");

        toggleWrapper.add(item, ironIcon);
        menu = new AppMenu();
        menu.getElement().setAttribute("slot", "submenu-content");
        addToSubmenu(toggleWrapper);
        addToSubmenu(menu);
    }

    public Div getToggleWrapper() {
        return toggleWrapper;
    }

    private void addToSubmenu(Component component) {
        getElement().appendChild(component.getElement());
    }

    @Override
    public void add(Component... components) {
        menu.add(components);
    }

    @Override
    public void remove(Component... components) {
        menu.remove(components);
    }

    @Override
    public void removeAll() {
        menu.removeAll();
    }

    public AppMenu getMenu() {
        return menu;
    }

    public void setParent(AppMenu parent) {
        this.parent = parent;
        menu.setParent(this);
    }

    public AppMenuIconItem getItem() {
        return item;
    }

    public IronIcon getIronIcon() {
        return ironIcon;
    }

    public void setSelected(AppMenu appMenu) {
        this.parent.setSelected(this);
    }
}

