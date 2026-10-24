class DetectSquares {
    private Map<Integer, Map<Integer, Integer>> points;

    public DetectSquares() {
        points = new HashMap<>();
    }

    public void add(int[] point) {
        int x = point[0];
        int y = point[1];

        points.putIfAbsent(y, new HashMap<>());
        Map<Integer, Integer> row = points.get(y);

        row.put(x, row.getOrDefault(x, 0) + 1);
    }

    public int count(int[] point) {
        int x = point[0];
        int y = point[1];

        int count = 0;

        if (!points.containsKey(y)) {
            return 0;
        }

        for (int col : points.get(y).keySet()) {
            if (col == x) {
                continue;
            }

            int side = col - x;

            int x3 = x;
            int x4 = col;

            int y3 = y + side;
            int y4 = y + side;

            count += points.get(y).get(col)
                    * getCount(x3, y3)
                    * getCount(x4, y4);

            y3 = y - side;
            y4 = y - side;

            count += points.get(y).get(col)
                    * getCount(x3, y3)
                    * getCount(x4, y4);
        }

        return count;
    }

    private int getCount(int x, int y) {
        if (!points.containsKey(y)) {
            return 0;
        }

        return points.get(y).getOrDefault(x, 0);
    }
}