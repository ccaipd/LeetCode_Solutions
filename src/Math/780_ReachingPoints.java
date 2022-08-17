package Math;

class Solution {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        // O(log(max(tx, ty))) why..?
        return backtrack(sx, sy, tx, ty);
    }

    public boolean backtrack(int sx, int sy, int tx, int ty) {
        if(tx < 1 || ty < 1) return false;
        if(tx < sx || ty < sy) return false;
        if(tx == sx && ty == sy) return true;

        if(tx == ty)
            return tx == sx && ty == sy;
        else if(tx > ty)
            if(ty > sy) return backtrack(sx, sy, tx % ty, ty);
            else return (tx - sx) % ty == 0;
        else {
            if(tx > sx) return backtrack(sx, sy, tx, ty % tx);
            else return (ty - sy) % tx == 0;
        }
    }

    /* work backwards TLE
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        return backtrack(sx, sy, tx, ty);
    }

    public boolean backtrack(int sx, int sy, int tx, int ty) {
        if(tx < 1 || ty < 1) return false;
        if(tx < sx || ty < sy) return false;
        if(tx == sx && ty == sy) return true;
        // System.out.println(tx + " " + ty + " ");
        if(tx == ty)
            return tx == sx && ty == sy;
        else if(tx > ty)
            return backtrack(sx, sy, tx - ty, ty);
        else
            return backtrack(sx, sy, tx, ty - tx);
    }
    */
}