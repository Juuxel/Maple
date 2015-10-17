package juuxel.maple.meta;

/**
 * The metadata types for {@link Metadata}
 */
public enum MetaTypes
{
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
    ALL,

    /**
     * Description type. Should be an instance of {@link String}.
     */
    DESCRIPTION
}
