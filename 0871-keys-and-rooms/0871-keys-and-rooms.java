class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        Queue<Integer> q = new LinkedList<>();
        
        boolean[] unlocked = new boolean[rooms.size()];
        int numUnlocked = 1;
        unlocked[0] = true;
        
        q.add(0);
        while(!q.isEmpty()) {
            int currRoom = q.poll();

            for (int key: rooms.get(currRoom)) {
                if (unlocked[key])  {
                    continue;
                }
                 
                unlocked[key] = true;
                numUnlocked++;
                q.add(key);
            }   
        }
        return numUnlocked == n;
    }
}