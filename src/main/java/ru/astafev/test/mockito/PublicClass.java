package ru.astafev.test.mockito;

class PrivateClass {
    String name;
    public PrivateClass(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

public class PublicClass extends PrivateClass {

    public PublicClass(String name) {
        super(name);
    }
}