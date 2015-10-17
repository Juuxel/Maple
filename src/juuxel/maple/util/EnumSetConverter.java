package juuxel.maple.util;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

/**
 * Converts {@link java.util.EnumSet} instances to {@link java.util.Set} instances.
 * @param <E> The enum type
 * @param <T> The target type
 */
public class EnumSetConverter<E extends Enum<E>, T>
{
    /**
     * Convert {@link java.util.EnumSet} instances to {@link java.util.Set} instances.
     * @param enumSet The original set
     * @return Converted set
     * @throws ClassCastException when cast doesn't work.
     */
    @SuppressWarnings("unchecked")
    public Set<T> convert(EnumSet<E> enumSet) throws ClassCastException
    {
        Set<E> set = new HashSet<>();

        set.addAll(enumSet);

        return (Set<T>) set;
    }
}
