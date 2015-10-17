package juuxel.maple.localization;


/**
 * The helper interface for localizable objects like {@link juuxel.maple.meta.Category}.
 */
public interface Localizable
{
    /**
     * Get the unlocalized name for this object.
     * @return The unlocalized name.
     */
    String getUnlocalizedName();
}
