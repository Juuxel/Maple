package juuxel.maple.util;

import java.util.HashSet;
import java.util.Set;

public abstract class ModuleManager<M extends Module>
{
    private final Set<M> set = new HashSet<>();

    /**
     * Add modules to this ModuleManager.
     * @param module a module to be added
     */
    public void addModule(M module)
    {
        set.add(module);
    }

    public boolean hasModule(M module)
    {
        return set.contains(module);
    }

    public boolean hasModule(String name)
    {
        for (M module : set)
            if (module.getName().equals(name))
                return true;

        return false;
    }
}
