package juuxel.maple.util;

public interface Output
{
    void println(String s);

    default void println(Object o)
    {
        println(o.toString());
    }

    default void println(double d)
    {
        println(String.valueOf(d));
    }

    default void println(int i)
    {
        println(String.valueOf(i));
    }

    default void println(boolean b)
    {
        println(String.valueOf(b));
    }

    void print(String s);

    default void print(Object o)
    {
        print(o.toString());
    }

    default void print(double d)
    {
        print(String.valueOf(d));
    }

    default void print(int i)
    {
        print(String.valueOf(i));
    }

    default void print(boolean b)
    {
        print(String.valueOf(b));
    }
}
