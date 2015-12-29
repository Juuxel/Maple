package juuxel.maple.util;

import java.util.HashSet;
import java.util.Set;

public abstract class Manager<M extends Manageable>
{
    private final Set<M> set = new HashSet<>();

    /**
     * Add objects to this Manager.
     * @param object a object to be added
     */
    public void add(M object)
    {
        set.add(object);
    }

    public boolean has(M object)
    {
        return set.contains(object);
    }

    public boolean has(String name)
    {
        for (M object : set)
            if (object.getName().equals(name))
                return true;

        return false;
    }
}
