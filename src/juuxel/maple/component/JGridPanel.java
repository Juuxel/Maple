package juuxel.maple.component;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

/**
 * A panel with a custom wrapper around GridBagLayout.
 */
public class JGridPanel extends JPanel
{
    private GridProperties properties;
    private final GridBagConstraints constraints = new GridBagConstraints();
    private int nextComponent = 0;
    private final HashMap<Component, Integer> indexMap = new HashMap<>();

    /**
     * Class constructor.
     */
    public JGridPanel()
    {
        properties = new GridProperties();
    }

    /**
     * Constructs a new JGridPanel object.
     * @param properties the grid properties for this object
     */
    public JGridPanel(GridProperties properties)
    {
        setProperties(properties);
    }

    {
        setLayout(new GridBagLayout());
    }

    /**
     * Get the GridProperties object for this panel.
     * @return the grid properties
     */
    public GridProperties getProperties()
    {
        return properties;
    }

    /**
     * Set the GridProperties object for this panel.
     * @param properties the grid properties
     */
    public void setProperties(GridProperties properties)
    {
        this.properties = properties;
    }

    /**
     * Set the index of the next component.
     * @param nextComponent the index
     */
    public void setNextComponent(int nextComponent)
    {
        this.nextComponent = nextComponent;
    }

    /**
     * Get the index of the next component.
     * @return the index
     */
    public int getNextComponent()
    {
        return nextComponent;
    }

    /**
     * Calls {@link #addToGrid(Component, int)} with component parameter and the value of nextComponent.
     * @param component the component to add
     * @return the component argument
     */
    public Component addToGrid(Component component)
    {
        return addToGrid(component, indexMap.containsKey(component) ? indexMap.get(component) : nextComponent++);
    }

    /**
     * Adds a component to the grid.
     * @param component the component to be added
     * @param index the index for the component
     * @return the component argument
     */
    public Component addToGrid(Component component, int index)
    {
        return properties.addComponent(this, component, index);
    }
    
    /**
     * Maps the component specified by the comp argument to the index specified by the index argument.
     * @param comp the component to be mapped
     * @param index the index for the component
     */
    public void mapComponent(Component comp, int index)
    {
        indexMap.put(comp, index);
    }
     
    /**
     * Properties for JGridPanel.
     */
    public static class GridProperties
    {
        private final HashMap<Integer, GridCellProperties> gridProperties = new HashMap<>();

        /**
         * Put a property in this object.
         * @param i the key for the value
         * @param cellProperties the {@link GridCellProperties} value
         */
        public void put(int i, GridCellProperties cellProperties)
        {
            gridProperties.put(i, cellProperties);
        }

        /**
         * Gets a property from this object.
         * @param i the key for the value
         * @return the {@link GridCellProperties} value
         */
        public GridCellProperties get(int i)
        {
            boolean hasExistingEntry = gridProperties.containsKey(new Integer(i));
            
            if (!hasExistingEntry) gridProperties.put(i, new GridCellProperties());

            return gridProperties.get(new Integer(i));
        }

        /**
         * Add a component to the Container specified by the parent argument.
         * @param parent the Container to add component to
         * @param component the component to be added
         * @param index the index for the component
         * @return the component argument
         */
        public Component addComponent(JGridPanel parent, Component component, int index)
        {
            GridBagConstraints constraints = parent.constraints;
            GridCellProperties properties = get(index);

            constraints.gridheight = properties.gridHeight;
            constraints.gridwidth = properties.gridWidth;
            constraints.gridx = properties.gridX;
            constraints.gridy = properties.gridY;

            parent.add(component, constraints);

            return component;
        }
    }

    /**
     * Properties for a cell in a JGridPanel instance.
     */
    public static class GridCellProperties
    {
        /**
         * The width of this cell.
         */
        public int gridWidth = 1;

        /**
         * The height of this cell.
         */
        public int gridHeight = 1;

        /**
         * The location of this cell in the X axis.
         */
        public int gridX = 0;

        /**
         * The location of this cell in the Y axis.
         */
        public int gridY = 0;

        /**
         * Class constructor.
         */
        public GridCellProperties()
        {}

        /**
         * Constructs a new GridCellProperties instance.
         * @param gridX location of this cell in X axis
         * @param gridY location of this cell in Y axis
         */
        public GridCellProperties(int gridX, int gridY)
        {
            this.gridX = gridX;
            this.gridY = gridY;
        }

        /**
         * Constructs a new GridCellProperties instance.
         * @param gridX location of this cell in X axis
         * @param gridY location of this cell in Y axis
         * @param gridHeight height of this grid cell
         * @param gridWidth width of this grid cell
         */
        public GridCellProperties(int gridX, int gridY, int gridHeight, int gridWidth)
        {
            this(gridX, gridY);
            this.gridWidth = gridWidth;
            this.gridHeight = gridHeight;
        }
    }
}
