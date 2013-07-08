package com.mostka.cl3d.server.werecars;

import java.util.ArrayList;

import org.javatuples.Pair;

import com.mostka.cl3d.shared.werecars.message.Boxes;

public class BoxGrid {

	class Start {
		public int x, y, z, angle;

		public Start(int x, int y, int z, int angle) {
			this.x = x;
			this.y = y;
			this.z = z;
			this.angle = angle;
		}
	}

	private int[] dataArr;
	private int x, y, z;
	private Trans toBox;
	private Trans fromBox;
	private ArrayList<Start> startList = new ArrayList<Start>();

	public BoxGrid(int x, int y, int z, Trans trans, Trans itrans) {
		dataArr = new int[(x * y * z)];
		this.x = x;
		this.y = y;
		this.z = z;
		this.toBox = trans;
		this.fromBox = itrans;
	}

	public void addStart(int x, int y, int z, int angle) {
		startList.add(new Start(x, y, z, angle));
	}

	public Start nextStart() {
		if (startList.size() == 0) {
			Position pos = fromBox.fromBox(0, 0, 0);
			return new Start(pos.x, pos.y, pos.z, 0);
		}
		Start ret = startList.remove(0);
		startList.add(ret);
		Position pos = fromBox.fromBox(ret.x, ret.y, ret.z);
		return new Start(pos.x, pos.y, pos.z, ret.angle);
	}

	public int getBox(int x, int y, int z) {
		if (x < 0 && y < 0 && z < 0 && x >= this.x && y >= this.y && z >= this.z) {
			return 0;
		}
		return dataArr[x + this.x * (y + this.y * z)];
	}

	private void setBox(int x, int y, int z, int type) {
		dataArr[x + this.x * (y + this.y * z)] = type;
	}

	public Box[] getVicinity(int x, int y, int z) {
		Position pos = toBox.toBox(x, y, z);
		x = pos.x;
		y = pos.y;
		z = pos.z;
		ArrayList<Box> ret = new ArrayList<>();
		for (int i : new int[] { x - 1, x, x + 1 }) {
			for (int j : new int[] { y - 1, y, y + 1 }) {
				for (int k : new int[] { z + 1, z, z - 1 }) {
					int b = getBox(i, j, k);
					if (b != 0) {
						Box box = new Box(b);
						if (getBox(i, j, k + 1) == 0) {
							box.topmost = 1;
						}
						box.pos = fromBox.fromBox(i, j, k);
						ret.add(box);
					}
				}
			}
		}

		return (Box[]) ret.toArray();
	}

	public Position getDim() {
		return new Position(x, y, z);
	}

	// type,x,y,z
	public static int[] boxList= new int[]{7,20,20,5,7,20,21,5,7,20,22,5,7,20,23,5,7,20,24,5,7,20,25,5,7,20,26,5,7,20,27,5,7,20,28,5,7,20,29,5,7,20,30,5,7,21,20,5,1,21,21,5,1,21,22,5,1,21,23,5,1,21,24,5,7,21,25,5,1,21,26,5,1,21,27,5,1,21,28,5,1,21,29,5,7,21,30,5,7,22,20,5,1,22,21,5,1,22,22,5,1,22,23,5,1,22,24,5,7,22,25,5,1,22,26,5,1,22,27,5,1,22,28,5,1,22,29,5,7,22,30,5,7,23,20,5,1,23,21,5,1,23,22,5,1,23,23,5,1,23,24,5,7,23,25,5,1,23,26,5,1,23,27,5,1,23,28,5,1,23,29,5,7,23,30,5,7,24,20,5,1,24,21,5,1,24,22,5,1,24,23,5,1,24,24,5,7,24,25,5,1,24,26,5,1,24,27,5,1,24,28,5,1,24,29,5,7,24,30,5,7,25,20,5,7,25,21,5,7,25,22,5,7,25,23,5,7,25,24,5,7,25,25,5,7,25,26,5,7,25,27,5,7,25,28,5,7,25,29,5,7,25,30,5,7,26,20,5,1,26,21,5,1,26,22,5,1,26,23,5,1,26,24,5,7,26,25,5,1,26,26,5,1,26,27,5,1,26,28,5,1,26,29,5,7,26,30,5,7,27,20,5,1,27,21,5,1,27,22,5,1,27,23,5,1,27,24,5,7,27,25,5,1,27,26,5,1,27,27,5,1,27,28,5,1,27,29,5,7,27,30,5,7,28,20,5,1,28,21,5,1,28,22,5,1,28,23,5,1,28,24,5,7,28,25,5,1,28,26,5,1,28,27,5,1,28,28,5,1,28,29,5,7,28,30,5,7,29,20,5,1,29,21,5,1,29,22,5,1,29,23,5,1,29,24,5,7,29,25,5,1,29,26,5,1,29,27,5,1,29,28,5,1,29,29,5,7,29,30,5,7,30,20,5,7,30,21,5,7,30,22,5,7,30,23,5,7,30,24,5,7,30,25,5,7,30,26,5,7,30,27,5,7,30,28,5,7,30,29,5,7,30,30,5,2,20,20,6,2,20,25,6,2,20,30,6,2,25,20,6,2,25,25,6,2,25,30,6,2,30,20,6,2,30,25,6,2,30,30,6,20,22,22,7,20,22,28,7,20,28,22,7,20,28,28,7};

	public static Pair<BoxGrid, Boxes> readBoxFile(int[] boxString, int boxSize, Trans toBox, Trans fromBox) throws Exception {
		int type=0,x=1,y=2,z=3;
		int[] mx = new int[]{0,0,0,0};
		for(int i=0;i<boxList.length;i+=4){
			for(int what : new int[]{x,y,z}){
				if (boxList[i+what]<0){
					throw new Exception("negative index");
				}
				if (boxList[i+what]>mx[what]){
					mx[what]=boxList[i+what];
				}
			}
		}
		BoxGrid grid = new BoxGrid(mx[x]+1, mx[y]+1, mx[z]+1, toBox, fromBox);
		com.mostka.cl3d.shared.werecars.message.Box[] forClient = new com.mostka.cl3d.shared.werecars.message.Box[boxList.length/4];
		for(int i=0;i<boxList.length;i+=4){
			if (boxList[i]>=20 && boxList[i]<24){
				// Coordinates type 20,21,22,23 represent the initial positions of players and will not be displayed on the screen.
				grid.setBox(boxList[i+x], boxList[i+y], boxList[i+z], boxList[i+type]-20);
			}else{
				// Coordinates blocks making up the platform for the game. Coordinates to the user to plot of level.
				grid.setBox(boxList[i+x], boxList[i+y], boxList[i+z], boxList[i+type]);
				Position pos = fromBox.fromBox(boxList[i+x], boxList[i+y], boxList[i+z]);
				com.mostka.cl3d.shared.werecars.message.Box box = Messages.createBox(pos.x, pos.y, pos.z, boxSize, boxList[i+type]);
				forClient[i/4]=box;
			}
		}
		Boxes boxes = Messages.createBoxes(forClient);
		return new Pair<BoxGrid, Boxes>(grid, boxes);
	}
}
