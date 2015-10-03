package juuxel.simpleapps.meta;

import juuxel.simpleapps.localization.Names;

import java.util.HashSet;
import java.util.Set;

//TODO Document categories

/**
 * The default categories for SimpleApps.
 */
public enum Categories implements Category
{
    ALL(Names.Categories.ALL),
    AUDIO_VIDEO(Names.Categories.AUDIO_VIDEO, "AUDIO", "VIDEO"),
    AUDIO(Names.Categories.AUDIO),
    VIDEO(Names.Categories.VIDEO),
    DEVELOPMENT(Names.Categories.DEVELOPMENT),
    EDUCATION(Names.Categories.EDUCATION),
    GAME(Names.Categories.GAME),
    GRAPHICS(Names.Categories.GRAPHICS),
    NETWORK(Names.Categories.NETWORK),
    OFFICE(Names.Categories.OFFICE),
    SCIENCE(Names.Categories.SCIENCE),
    SETTINGS(Names.Categories.SETTINGS),
    SYSTEM(Names.Categories.SYSTEM),
    UTILITY(Names.Categories.UTILITY),
    CONSOLE_ONLY(Names.Categories.CONSOLE_ONLY),
    SWING(Names.Categories.SWING),
    JAVAFX(Names.Categories.JAVAFX);

    static
    {
        for (Categories c : values())
        {
            if (c != ALL)
                c.getParents().add(ALL);

            for (String s : c.parentStrings)
            {
                c.getParents().add(valueOf(s));
            }
        }
    }

    private final String name;
    private final Set<Category> parents;
    private String[] parentStrings = new String[0];

    Categories(String name, String... parents)
    {
        this(name);
        parentStrings = parents;
    }

    Categories(String name)
    {
        this.name = name;
        parents = new HashSet<>();
    }

    @Override
    public String getUnlocalizedName()
    {
        return name;
    }

    @Override
    public Set<Category> getParents()
    {
        return parents;
    }
}
