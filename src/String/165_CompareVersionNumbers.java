package String;

class Solution {
    public int compareVersion(String version1, String version2) {
        // O(Max(M, N))
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        int x = 0, y = 0;
        for(int i = 0; i < Math.max(v1.length, v2.length); i++) {
            x = i < v1.length ? Integer.parseInt(v1[i]) : 0;
            y = i < v2.length ? Integer.parseInt(v2[i]) : 0;

            if(x != y)
                return x > y ? 1 : -1;
        }

        return 0;
    }
}