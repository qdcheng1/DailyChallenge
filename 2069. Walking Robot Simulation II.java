class Robot {
    
    int width;
    int height;
    String[] dirs;
    int x;
    int y;
    int dir;
    public Robot(int width, int height) {
        this.width = width;
        this.height = height;
        
        dirs = new String[]{"East", "North", "West", "South"};
        x = height - 1;
        y = 0;
        dir = 0;
    }
    
    public void move(int num) {
        int count = num / (2 * width + 2 * height - 4);
        num = num % (2 * width + 2 * height - 4);
        
        /**
        
        下面这句话非常重要。如果num == 0会回到当前的位置但是方向可能变或者可能不变，走一遍就知道了。
        I got stuck in the contest because of this.
        
        **/
        if (num == 0) {
            num = 2 * width + 2 * height - 4;
        }
        
        while (num > 0) {
            int step = 0;
            if (dir == 0) {
                step = goEast(num);
            } else if (dir == 1) {
                step = goNorth(num);
            } else if (dir == 2) {
                step = goWest(num);
            } else {
                step = goSouth(num);
            }
            num -= step;
            //System.out.println("x: " + x + " y: " + y + " dir: " + dirs[dir]);
            if (num > 0) {
                dir = (dir + 1) % 4;
            }
        }
    }
    
    private int goEast(int num) {
        int step = Math.min(width - 1 - y, num);
        y += step;
        return step;
    }
    
    private int goNorth(int num) {
        int step = Math.min(x, num);
        x -= step;
        return step;
    }
    
    private int goWest(int num) {
        int step = Math.min(num, y);
        y -= step;
        
        return step;
    }
    
    private int goSouth(int num) {
        int step = Math.min(num, height - 1 - x);
        x += step;
        return step;
    }
    
    public int[] getPos() {
        int tx = y;
        int ty = height - x - 1;
        return new int[]{tx, ty};
    }
    
    public String getDir() {
        return dirs[dir];
    }
}

/**
 * Your Robot object will be instantiated and called as such:
 * Robot obj = new Robot(width, height);
 * obj.move(num);
 * int[] param_2 = obj.getPos();
 * String param_3 = obj.getDir();
 */
