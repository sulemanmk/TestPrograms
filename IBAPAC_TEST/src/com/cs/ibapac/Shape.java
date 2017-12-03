/**
 * This is the Canvas class which stores the width w and height h.
 */
package com.cs.ibapac;

/**
 * @author SuLEmaN
 * 
 */
public class Shape {
	int w;
	int h;
	final static char HORIZONTAL_PIXEL = '-';
	final static char VERTICAL_PIXEL = '|';
	final static char EMPTY_PIXEL = ' ';
	final static char H_V_LINE = 'X';

	char shape[][];

	public Shape() {
	}

	public Shape(int w, int h) {
		super();
		this.w = w + 2;
		this.h = h + 2;
	}

	public int getW() {
		return this.w;
	}

	public void setW(int w) {
		this.w = w + 2;
	}

	public int getH() {
		return this.h;
	}

	public void setH(int h) {
		this.h = h + 2;
	}

	public char[][] getShape() {
		return this.shape;
	}

	public void setShape(char[][] shape) {
		this.shape = shape;
	}

	/*
	 * Scan throw all the screen pixels of the screen between w,h and print only
	 * those pixels which are marked for display
	 */
	public void prepareCanvas() {
		shape = new char[this.h][this.w];
		for (int i = 0; i < this.h; i++) {
			for (int j = 0; j < this.w; j++) {
				if (i == 0 || (i == (this.h - 1))) {
					this.shape[i][j] = HORIZONTAL_PIXEL;
				} else if ((j == 0) || (j == (this.w - 1))) {
					this.shape[i][j] = VERTICAL_PIXEL;
				} else {
					this.shape[i][j] = EMPTY_PIXEL;
				}
			}
		}
	}

	public void prepareLine(int x1, int y1, int x2, int y2) {
		// Horizontal line
		if (y1 == y2) {
			for (int i = 0; i < this.h; i++) {
				for (int j = 0; j < this.w; j++) {
					if ((j >= x1 && j <= x2) && (i == y1)) {
						this.shape[i][j] = H_V_LINE;
					}
				}
			}
		}
		// Vertical line
		if (x1 == x2) {
			for (int i = 0; i < this.h; i++) {
				for (int j = 0; j < this.w; j++) {
					if ((j == x1) && (i >= y1 && i <= y2)) {
						this.shape[i][j] = H_V_LINE;
					}
				}
			}
		}
	}

	public void prepareRectangle(int x1, int y1, int x2, int y2) {
		prepareLine(x1, y1, x2, y1);
		prepareLine(x1, y1, x1, y2);
		prepareLine(x2, y1, x2, y2);
		prepareLine(x1, y2, x2, y2);

	}

	public void prepareBucketFill(int x, int y, char colour) {
		if(x > 0 || x < this.h || y > 0 || y  < this.w) {
			
		}
		for (int i = 0; i < this.h; i++) {
			for (int j = 0; j < this.w; j++) {
				if (this.shape[i][j] == ' ') {
					this.shape[i][j] = colour;
				}
			}
		}
	}

	public void drawShape() {
		for (int i = 0; i < this.h; i++) {
			for (int j = 0; j < this.w; j++) {
				System.out.print(this.shape[i][j]);
			}
			System.out.println("");
		}

	}

	public static void main(String[] args) {
		Shape s = new Shape(20, 4);
		s.prepareCanvas();
		// s.drawShape();
		s.prepareLine(1, 2, 6, 2);
		// s.drawShape();
		s.prepareLine(6, 3, 6, 4);
		// s.drawShape();
		s.prepareRectangle(14, 1, 18, 3);
		//s.drawShape();
		s.prepareBucketFill(10, 3, 'O');
		s.drawShape();
	}
}
