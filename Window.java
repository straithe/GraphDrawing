/**
 * B. Postnikoff
 * Window
 * Holds the main.
 * Creates the display window
 * 2016-04-08
 */

import java.awt.*;
import javax.swing.*;
import java.util.*;

public class Window extends JFrame
{
    private DrawPolygon graph;
    private GraphPanel graphPanel;
    private LinePanel linePanel;
    private AestheticsPanel aestheticsPanel;
    private DetailsPanel detailsPanel;
    private JPanel optionPanel;
    private JPanel graphingPanel;

    public static void main(String[] args)
    {
        Window window = new Window();
    }

    // Constructor for the window
    public Window()
    {
        // Sets window defaults
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(800,800);
        this.setResizable(false);
        this.setTitle("Graph Drawing");

        // Creates the various graph display panels
        this.detailsPanel = new DetailsPanel(this);
        detailsPanel.setMaximumSize(new Dimension(625,50));

        this.graph = new DrawPolygon();
        graph.setPreferredSize(new Dimension(625, 750));

        // Creates the various option display panels
        this.graphPanel = new GraphPanel(this);
        graphPanel.setPreferredSize(new Dimension(175, 75));

        this.linePanel = new LinePanel(this);
        linePanel.setPreferredSize(new Dimension(175, 100));

        this.aestheticsPanel = new AestheticsPanel(this);
        aestheticsPanel.setPreferredSize(new Dimension(175, 625));

        // Creates the graphing panel
        graphingPanel = new JPanel(new BorderLayout());
        graphingPanel.add(detailsPanel, BorderLayout.PAGE_START);
        graphingPanel.add(graph, BorderLayout.PAGE_END);

        // Creates the option panel container panel
        optionPanel = new JPanel(new BorderLayout());
        optionPanel.add(graphPanel, BorderLayout.PAGE_START);
        optionPanel.add(linePanel, BorderLayout.CENTER);
        optionPanel.add(aestheticsPanel, BorderLayout.PAGE_END);

        // Adds the panels to the content pane
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(graphingPanel, BorderLayout.WEST);
        this.getContentPane().add(optionPanel, BorderLayout.EAST);
        this.setVisible(true);
    }
    
    // Updates the edges in the graph
    public void updateGraphEdges(ArrayList<Edge> edges) {
        graph.updateEdges(edges);
    }

    // Updates the graph in the window
    public void updateGraphVertices(Vertex[] vertexList) {
        graph.updateVertices(vertexList);
    }    

    // Updates the line type in the graph
    public void updateLineType(int lineType) {
        graph.updateLineType(lineType);
    }

    // Updates the graph details in the details panel.
    public void updateDetails(String graphName, int numVertices, int numEdges)  {
        detailsPanel.updateDetails(graphName, numVertices, numEdges);
    }

    // Updates the graph to show the current aesthetic choice
    public void updateAesthetic(int aesthetic) {
        graph.updateAesthetic(aesthetic);
    }
    
    // Uptes the vertex color
    public void updateVertexColor(Color color) {
        graph.updateVertexColor(color);
    }
}
