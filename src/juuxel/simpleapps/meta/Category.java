package juuxel.simpleapps.meta;

import juuxel.simpleapps.localization.Localizable;

import java.util.Set;

/**
 * The category interface for Vee-like environments.
 */
public interface Category extends Localizable
{
    /**
     * Get the parent categories for this category.
     * @return The parents.
     */
    Set<Category> getParents();
}
