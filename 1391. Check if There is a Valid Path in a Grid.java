class Solution {
    enum Direction {
        Left(0),
        Up(1),
        None(2),
        Down(3),
        Right(4);

        private final int value;
        private Direction(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    class Node {
        Direction dir;
        int i;
        int j;
        Node(Direction dir, int i, int j) {
            this.dir = dir;
            this.i = i;
            this.j = j;
        }
    }
    
    public boolean hasValidPath(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(Direction.None, 0, 0));
        while (!q.isEmpty()) {
            Node curNode = q.poll();
            if (curNode.i == rows - 1 && curNode.j == cols - 1 && getNextDirection(grid[curNode.i][curNode.j], curNode.dir).size() > 0) return true;
            visited[curNode.i][curNode.j] = true;
            for (Node nextNode: getNextNode(curNode, grid, visited)) {
                q.offer(nextNode);
            }
        }
        return false;
    }

    private List<Direction> getNextDirection(int street, Direction dir) {
        List<Direction> list = new ArrayList<>();
        switch (street) {
            case 1:
            {
                switch (dir) {
                    case Left: 
                    {
                        list.add(Direction.Right);
                        return list;
                    }
                    case Right: 
                    {
                        list.add(Direction.Left);
                        return list;
                    }
                    case None: 
                    {
                        list.add(Direction.Right);
                        list.add(Direction.Left);
                        return list;
                    }
                    default: 
                    {
                        return list;
                    }
                }
            }
            case 2:
            {
                switch (dir) {
                    case Up:
                    {
                        list.add(Direction.Down);
                        return list;
                    }
                    case Down:
                    {
                        list.add(Direction.Up);
                        return list;
                    }
                    case None: 
                    {
                        list.add(Direction.Up);
                        list.add(Direction.Down);
                        return list;
                    }
                    default:
                    {
                        return list;
                    }
                }
            }
            case 3:
            {
                switch (dir) {
                    case Left:
                    {
                        list.add(Direction.Down);
                        return list;
                    }
                    case Down:
                    {
                        list.add(Direction.Left);
                        return list;
                    }
                    case None: 
                    {
                        list.add(Direction.Down);
                        list.add(Direction.Left);
                        return list;
                    }
                    default:
                    {
                        return list;
                    }
                }
            }
            case 4:
            {
                switch (dir) {
                    case Down: 
                    {
                        list.add(Direction.Right);
                        return list;
                    }
                    case Right: 
                    {
                        list.add(Direction.Down);
                        return list;
                    }
                    case None: 
                    {
                        list.add(Direction.Right);
                        list.add(Direction.Down);
                        return list;
                    }
                    default:
                    {
                        return list;
                    }
                } 
            }
            case 5:
            {
                switch (dir) {
                    case Left: 
                    {
                        list.add(Direction.Up);
                        return list;
                    }
                    case Up: 
                    {
                        list.add(Direction.Left);
                        return list;
                    }
                    case None: 
                    {
                        list.add(Direction.Up);
                        list.add(Direction.Left);
                        return list;
                    }
                    default:
                    {
                        return list;
                    }
                }
            }
            case 6:
            {
                switch (dir) {
                    case Right: 
                    {
                        list.add(Direction.Up);
                        return list;
                    }
                    case Up: 
                    {
                        list.add(Direction.Right);
                        return list;
                    }
                    case None: 
                    {
                        list.add(Direction.Up);
                        list.add(Direction.Right);
                        return list;
                    }
                    default:
                    {
                        return list;
                    }
                }              
            }
            default: return list;
        }
    }

    private List<Node> getNextNode(Node curNode, int[][] grid, boolean[][] visited) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] dirs = new int[][]{{0, -1}, {-1, 0}, {0, 0}, {1, 0}, {0, 1}};
        List<Node> res = new ArrayList<>();
        List<Direction> nextDirList = getNextDirection(grid[curNode.i][curNode.j], curNode.dir);
        for (Direction nextDir: nextDirList) {
            int nextI = curNode.i + dirs[nextDir.getValue()][0];
            int nextJ = curNode.j + dirs[nextDir.getValue()][1];
            if (nextI < rows && nextJ < cols && nextI >= 0 && nextJ >= 0 && !visited[nextI][nextJ]) {
                res.add(new Node(oppDirection(nextDir), nextI, nextJ));
            }
        }
        return res;
    }

    private Direction oppDirection(Direction dir) {
        switch (dir) {
            case Left: return Direction.Right;
            case Right: return Direction.Left;
            case Up: return Direction.Down;
            case Down: return Direction.Up;
            default: return Direction.None;
        }
    }
}

// Runtime: 42 ms, faster than 33.12% of Java online submissions for Check if There is a Valid Path in a Grid.
// Memory Usage: 56.7 MB, less than 100.00% of Java online submissions for Check if There is a Valid Path in a Grid.