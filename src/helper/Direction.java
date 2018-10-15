package helper;

public enum Direction
{
	UP(-1,0,"^"), RIGHT(0,1,">"), DOWN(1,0,"v"), LEFT(0,-1,"<");
    public int y,x;
    public String pointer;

    Direction(int y, int x, String pointer) {
            this.y = y;
            this.x = x;
            this.pointer = pointer;
    }
    
    public int getX()
    {
    	return this.x;
    }
    public int getY()
    {
    	return this.y;
    }
    public String getPointer()
    {
    	return this.pointer;
    }
}
