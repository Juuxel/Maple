package juuxel.test;

import juuxel.simpleapps.meta.Categories;
import juuxel.simpleapps.meta.Category;

public class Main
{
    public static void main(String[] args)
    {
        for (Category category : Categories.values())
        {
            System.out.println(category.getUnlocalizedName() + ": " + category.getParents().size() + " parent" + (category.getParents().size() == 1 ? "" : "s"));
            for (Category category1 : category.getParents())
                System.out.println("  " + category1.getUnlocalizedName());
        }
    }
}
