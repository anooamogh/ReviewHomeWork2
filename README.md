# ReviewHomeWork2

Create a simple graph class.  This will be a private class included in Main.java  The graph class should have the following items:

    an adjacency list or matrix to hold the graph data
    variables to hold the current size and max size of the graph
    default constructor
        create empty adjacency list/matrix
        max size = 10
    overloaded constructor
        create empty adjacency list/matrix
        max size = int parameter
    isEmpty
        check if current size is zero
    createGraph
        read a formatted file and fill adjacency list/matrix (see included samples)
        The first line in the file contains a number that indicates the number of vertices (n).
            The vertices are labeled as 1, 2, 3, . . . , n.
            Each subsequent line describes the edges from each vertex
                the first number on the line is the starting vertex
                all subsequent numbers are the ending vertices
    isConnected
        Execute a depth first traversal and mark which nodes were visited.
        To be strongly connected, the traversal must visit all vertices starting from each node in the graph

Write a driver program to test the class.

    Prompt the user for the filename
    Create the graph
    Determine if the graph is strongly connected
        if strongly connected, print connected to the console
        else print not connected to the console
