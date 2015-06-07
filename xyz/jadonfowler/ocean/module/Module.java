package xyz.jadonfowler.ocean.module;

public class Module {

    private String name;

    private int bind;

    private Category category;

    private boolean isEnabled;

    public Module(String name, int bind, Category c) {
        this.name = name;
        this.bind = bind;
        this.category = c;
    }

    public String getName() {
        return name;
    }

    public int getBind() {
        return bind;
    }

    public Category getCategory() {
        return category;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean e) {
        onToggle();
        if (e) onEnable();
        else onDisable();
        isEnabled = e;
    }

    public void toggle() {
        onToggle();
        setEnabled(!isEnabled);
    }

    public void onToggle() {}

    public void onEnable() {}

    public void onDisable() {}

    public void onUpdate() {}

    public void onRender() {}
}
