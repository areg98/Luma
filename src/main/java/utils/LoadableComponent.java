package utils;

import java.time.Duration;

import static utils.CustomWebElement.printError;

public abstract class LoadableComponent<T extends LoadableComponent<T>> {
    public LoadableComponent() {
    }

    public T get() {
        try {
            this.isLoaded();
            return (T) this;
        } catch (Error var2) {
            printError("error");
            this.load();
            this.isLoaded();
            return (T) this;
        }
    }

    protected abstract void load();

    protected abstract void isLoaded() throws Error;

    public T open(){
        this.load();
        return this.get();

    }


}
