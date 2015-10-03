package juuxel.simpleapps.localization;

/**
 * Unlocalized names for the environments that use localization.
 */
public final class Names
{
    /**
     * The localization keys for application categories.
     * Format: category.Category.Subcategory
     * The "Subcategory" part doesn't always exist.
     * The categories based on the ones the FreeDesktop menu specification.
     * SimpleApps doesn't include unnecessary and non-Java categories
     */
    public static final class Categories
    {
        // TODO Document everything

        public static final String ALL = "category.All";

        // Main categories

        /**
         * The localization key for audio and video applications.
         */
        public static final String AUDIO_VIDEO = "category.AudioVideo";
        public static final String AUDIO = "category.Audio";
        public static final String VIDEO = "category.Video";
        public static final String DEVELOPMENT = "category.Development";
        public static final String EDUCATION = "category.Education";
        public static final String GAME = "category.Game";
        public static final String GRAPHICS = "category.Graphics";
        public static final String NETWORK = "category.Network";
        public static final String OFFICE = "category.Office";
        public static final String SCIENCE = "category.Science";
        public static final String SETTINGS = "category.Settings";
        public static final String SYSTEM = "category.System";
        public static final String UTILITY = "category.Utility";

        // Meta-categories
        // Also includes Swing and JavaFX categories.
        // Everything here is a subcategory of Meta (a meta-category that exists only as a localization key).
        public static final String SWING = "category.Meta.Swing";
        public static final String JAVAFX = "category.Meta.JavaFX";
        public static final String CONSOLE_ONLY = "category.Meta.ConsoleOnly";
    }
}
