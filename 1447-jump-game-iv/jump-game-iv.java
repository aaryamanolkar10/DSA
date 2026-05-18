import java.util.*;

class Solution {
    public int minJumps(int[] arr) {

        int n = arr.length;

        if (n == 1) {
            return 0;
        }

        // Map value -> list of indices
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];

        queue.offer(0);
        visited[0] = true;

        int steps = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int s = 0; s < size; s++) {

                int current = queue.poll();

                // Reached last index
                if (current == n - 1) {
                    return steps;
                }

                // Same value jumps
                List<Integer> neighbors = map.get(arr[current]);

                if (neighbors != null) {

                    for (int next : neighbors) {

                        if (!visited[next]) {
                            visited[next] = true;
                            queue.offer(next);
                        }
                    }

                    // Important optimization
                    neighbors.clear();
                }

                // current + 1
                if (current + 1 < n && !visited[current + 1]) {
                    visited[current + 1] = true;
                    queue.offer(current + 1);
                }

                // current - 1
                if (current - 1 >= 0 && !visited[current - 1]) {
                    visited[current - 1] = true;
                    queue.offer(current - 1);
                }
            }

            steps++;
        }

        return -1;
    }
}