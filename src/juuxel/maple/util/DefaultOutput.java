package juuxel.maple.util;

public class DefaultOutput implements Output
{
    @Override
    public void println(String s)
    {
        System.out.println(s);
    }

    @Override
    public void print(String s)
    {
        System.out.print(s);
    }
}
