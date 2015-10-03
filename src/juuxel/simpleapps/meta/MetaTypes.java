package juuxel.simpleapps.meta;

/**
 * The metadata types for {@link Metadata}
 */
public enum MetaTypes
{
    /**
     * Category metadata type. Should be an instance of {@link Category}.
     */
    CATEGORY,

    /**
     * Icon metadata type. Should be an instance of {@link javax.swing.Icon}.
     */
    ICON,

    /**
     * Name metadata type. Should be an instance of {@link String}.
     */
    NAME,

    /**
     * Multi-metadata type. Should be an instance of {@link ApplicationMeta}.
     */
    ALL
}
