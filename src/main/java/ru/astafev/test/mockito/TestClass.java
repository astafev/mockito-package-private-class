package ru.astafev.test.mockito;

import org.mockito.Mockito;

public class TestClass {

    public static void main(String[] args) {
        //works fine
        System.out.println("basic package private class: " + mockedProperty("hi", PrivateClass.class).getName());

        System.out.println("\n\n\nfirst variant with\n     when(result.getName()).thenReturn(name)");
        try {
            System.out.println("1st time " + mockedProperty("hi", PublicClass.class).getName());
            System.out.println("2nd time " + mockedProperty("hi", PublicClass.class).getName());
        } catch (Exception e) {
            System.out.println("got error " + e.getClass().getName());
        }

        System.out.println("\n\n\nsecond variant with\n     doReturn(name).when(result).getName()");
        try {
            System.out.println("1st time " + mockedProperty2("hi", PublicClass.class).getName());
            System.out.println("2nd time " + mockedProperty2("hi", PublicClass.class).getName());
        } catch (Exception e) {
            System.out.println("got error " + e.getClass().getName());
        }
    }

    public static <T extends PrivateClass> T mockedProperty(String name, Class<T> clazz) {
        T result = Mockito.mock(clazz);
        Mockito.when(result.getName()).thenReturn(name);
//        doReturn(name).when(result).getName();
        return result;
    }

    public static <T extends PrivateClass> T mockedProperty2(String name, Class<T> clazz) {
        T result = Mockito.mock(clazz);
//        when(result.getName()).thenReturn(name);
        Mockito.doReturn(name).when(result).getName();
        return result;
    }
}
