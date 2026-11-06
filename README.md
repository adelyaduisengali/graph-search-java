# Graph Search Algorithms in Java

Implementation of classic graph search algorithms on a map of cities
in Kazakhstan (e.g. finding a path from Almaty to Kyzylorda).

## Algorithms
- **Dijkstra's algorithm** – shortest path in a weighted graph
- **Breadth-First Search (BFS)** – path with the fewest edges in an unweighted graph
- **Depth-First Search (DFS)** – graph traversal

## Project structure
- `Vertex` – a graph node (city)
- `WeightedGraph` / `UnweightedGraph` – graph representations
- `Search` – common interface for all search algorithms
- `DijkstraSearch`, `BreadthFirstSearch`, `DepthFirstSearch` – algorithm implementations
- `Main` – builds the graphs and prints the found paths

## Tech stack
Java · Generics · IntelliJ IDEA
## Example graph
Six cities of Kazakhstan connected by edges:

| From     | To        | Weight |
|----------|-----------|--------|
| Almaty   | Astana    | 2.1    |
| Almaty   | Shymkent  | 7.2    |
| Shymkent | Astana    | 3.9    |
| Shymkent | Atyrau    | 7.8    |
| Shymkent | Kyzylorda | 5.4    |
| Atyrau   | Astana    | 7.1    |
| Astana   | Kostanay  | 3.5    |

The program finds a path from **Almaty** to **Kyzylorda**:
- **Dijkstra** finds the shortest weighted path:
  Almaty → Astana → Shymkent → Kyzylorda (total 11.4),
  which is shorter than the direct route through Shymkent (7.2 + 5.4 = 12.6)
- **BFS** finds the path with the fewest edges:
  Almaty → Shymkent → Kyzylorda
- **DFS** finds a path by exploring as deep as possible first

## How to run
Open the project in IntelliJ IDEA and run `Main.java`.

## Author
Duisengaliyeva Adel, Astana IT University (ST-2502)
