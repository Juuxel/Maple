package juuxel.simpleapps.util;

import juuxel.simpleapps.AppEnvironment;

import java.io.PrintStream;

/**
 * The debugging utilities.
 */
public final class Debug
{
    /**
     * Print debug string to {@link System#out}
     * @param str The string to print
     */
    public static void printDebug(String str)
    {
        printDebug(str, System.out);
    }

    /**
     * Print debug string to {@code stream}
     * @param str The string to print
     * @param stream The {@link java.io.PrintStream} to print the string to
     */
    public static void printDebug(String str, PrintStream stream)
    {
        if (AppEnvironment.isDebugOutputEnabled())
            stream.println(str);
    }
}
