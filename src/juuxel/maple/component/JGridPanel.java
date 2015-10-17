package juuxel.maple.component;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class JGridPanel extends JPanel
{
    private GridProperties properties;
    private final GridBagConstraints constraints = new GridBagConstraints();

    private int nextComponent = 0;

    public JGridPanel()
    {
        properties = new GridProperties();
    }

    public JGridPanel(GridProperties properties)
    {
        this.properties = properties;
    }

    {
        GridBagLayout layout = new GridBagLayout();
        setLayout(layout);
    }

    public GridProperties getProperties()
    {
        return properties;
    }

    public void setProperties(GridProperties properties)
    {
        this.properties = properties;
    }

    public void setNextComponent(int nextComponent)
    {
        this.nextComponent = nextComponent;
    }

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
        return addToGrid(component, nextComponent++);
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

    public static class GridProperties
    {
        private final HashMap<Integer, GridCellProperties> gridProperties = new HashMap<>();
        private int rowWidth;

        public void put(int i, GridCellProperties cellProperties)
        {
            gridProperties.put(i, cellProperties);
        }

        public GridCellProperties get(int i)
        {
            GridCellProperties props = gridProperties.get(new Integer(i));

            return props != null ? props : gridProperties.put(i, new GridCellProperties());
        }

        public void setRowWidth(int rowWidth)
        {
            this.rowWidth = rowWidth;
        }

        public int getRowWidth()
        {
            return rowWidth;
        }

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

    public static class GridCellProperties
    {
        public int gridWidth = 1;
        public int gridHeight = 1;
        public int gridX = 0;
        public int gridY = 0;

        public GridCellProperties()
        {}

        public GridCellProperties(int gridX, int gridY)
        {
            this.gridX = gridX;
            this.gridY = gridY;
        }

        public GridCellProperties(int gridX, int gridY, int gridHeight, int gridWidth)
        {
            this(gridX, gridY);
            this.gridWidth = gridWidth;
            this.gridHeight = gridHeight;
        }
    }
}
