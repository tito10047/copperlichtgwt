package com.mostka.cl3d.server.werecars;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.tools.ant.taskdefs.Length;
import org.javatuples.Pair;

import no.eirikb.gwtchannelapi.server.ChannelServer;

import com.google.appengine.api.channel.ChannelMessage;
import com.google.appengine.api.channel.ChannelServiceFactory;
import com.google.web.bindery.autobean.shared.AutoBeanCodex;
import com.google.web.bindery.autobean.vm.AutoBeanFactorySource;
import com.mostka.cl3d.server.werecars.BoxGrid.Start;
import com.mostka.cl3d.shared.werecars.MessagesFactory;
import com.mostka.cl3d.shared.werecars.message.Boxes;
import com.mostka.cl3d.shared.werecars.message.Type;
/**
 * Werecars server: listens for events sent by the players.
 * Events processed and returned to the state of the world.
 */
@SuppressWarnings("serial")
public class Server implements Trans {
	private WsServer wsServer;
	private class Event{
		public static final int clientNew=0;
		public static final int clientDead=1;
		
		
		public int type;
		public String message;
		public Event(int type, String message) {
			super();
			this.type = type;
			this.message = message;
		}
	}
	private static final int floorDistance = 1;
	private static final int rotationFactor = 20;
	private static final int carHeight = 1;
	private static final double carRadius = 3.9;
	private static final double carSize = Server.carRadius * 2;
	private static final int boxRadius = 5;
	private static final int boxSize = Server.boxRadius * 2;
	
	/**
	 * series of events
	 */
	private HashMap<Integer, String> eventsList = new HashMap<>();
	/**
	 * list of players
	 */
	private HashMap<String, Car> clientsList = new HashMap<>();
	/**
	 * list WebSocket connections each player
	 */
	private ArrayList<String> clientsWsList = new ArrayList<String>();
	/**
	 * a list of keystrokes each player
	 */
	private HashMap<String,String[]> clientStates = new HashMap<>();
	/**
	 * a list of statuses of internal parameters of each player
	 */
	private HashMap<String, Internal> clientInternalList = new HashMap<>();
	/**
	 * list of items each player
	 */
	private HashMap<String, HashMap<String, ?>> clientDataList = new HashMap<>();
	private int now = 0; 
	private BoxGrid grid;
	private Boxes gridForClient;
	
	public Server(WsServer wsServer) {
		try {
			Pair<BoxGrid, Boxes> res = BoxGrid.readBoxFile(BoxGrid.boxList, Server.boxSize, this, this);
			this.grid = res.getValue0();
			this.gridForClient = res.getValue1();
			this.wsServer=wsServer;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static boolean debug=true;

	/**
	 * Adds a new event in the event list.
	 */
	public void addEvent(int type, String message) {
		eventsList.put(type, message);
		if (!debug){
			return;
		}
		for (int i=0;i<eventsList.size();i++){
			System.out.println("e-"+i+": "+eventsList.get(i));
		}
	}
	/**
	 * WebSocket is added to the list of active WebSocket connections and
	 * Add a new client-new event in the event list.
	 */
	public void addClient(String id){
		clientsWsList.add(id);
		eventsList.put(Type.newClient,id);
	}
	/**
	 * Remove from the list of active WebSocket WebSocket connections
	 */
	public void removeClient(String id){
		clientsWsList.remove(id);
		eventsList.put(Type.deadClient,id);
	}
	
	/**
	 * Returns the initial state information about the car for a new player
	 */
	private Car newClient(){
		Car car = new Car();
		Start start = grid.nextStart();
		car.pos.x = start.x + boxRadius;
		car.pos.y = start.y + boxRadius;
		car.pos.z = start.z + boxRadius;
		car.angle *= Math.PI;
		
		if (debug){
			System.out.println("newClient angle"+car.angle);
		}
		return car;
	}
	
	private void logs(String message){
		if (debug){
			System.out.println(message);
		}
	}
	
	public Position toBox(int x, int y, int z){
		return new Position(x / boxSize, y / boxSize, z / boxSize);
	}
	
	public Position fromBox(int x, int y, int z){
		return new Position(x * boxSize, y * boxSize, z * boxSize);
	}
	/**
	 * Returns the internal data for a new player or a player who fell from the platform.
	 */
	private Internal newInternal(){
		//return {'sangle':0, 'speed':0, 'zspeed':0}
		return new Internal();
	}
	
	private boolean onClientNew(String clientId){
		logs("New client "+clientId);
		if (clientsList.containsKey(clientId)){
			return false;
		}
		Car car = newClient();
		clientsList.put(clientId, car);
		clientStates.put(clientId, new String[]{});
		clientInternalList.put(clientId, newInternal());
		clientDataList.put(clientId, new HashMap<String,Integer>(){{put("score",0);}});
		
		wsServer.sendPublic(clientId, Messages.createId(clientId));
		// TODO: sendMessage(id, *("static-boxes", self.m_gridForClients))
		wsServer.sendPublic(clientId, Messages.createStartStartPosition(car.pos));
		return true;
	}
	private void onClientDead(String clientId){
		logs("client "+clientId+" is gone");
		clientsList.remove(clientId);
		clientStates.remove(clientId);
		clientInternalList.remove(clientId);
		clientDataList.remove(clientId);
	}
	// TODO: create timer 0,01s
	private void calculate(){
			
		HashMap<String, Integer> alreadyId = new HashMap<>();
		HashMap<String, Integer> zFloor = new HashMap<>();
		int axisX=0,axisY=1,axisZ=2;
		for (Entry<String, Car> entry: clientsList.entrySet()){
			Car car = entry.getValue();
			String id = entry.getKey();
			if (car.pos.z < -290){
				car = newClient();
				Internal inte = newInternal();
				clientsList.put(id, car);
				clientInternalList.put(id, inte);
				@SuppressWarnings("unchecked")
				HashMap<String, Object> data = (HashMap<String, Object>) clientDataList.get(id);
				if (data.containsKey("oponentid") && data.containsKey("oponenttime")){
					String oid = (String) data.get("oponentid");
					int otime = (Integer) data.get("oponenttime");
					
					final int sc = (Integer) clientDataList.get(oid).get("score");
					if (otime > now && clientDataList.containsKey(oid)){
						clientDataList.put(oid, new HashMap<String,Integer>(){{put("score", sc+1);}});
					}else{
						data.put("score", ((int)data.get("score"))-1);
					}
				}else{
					data.put("score", ((int)data.get("score"))-1);
				}
			}
		}
		for (Entry<String, Car> entry: clientsList.entrySet()){
			Car car = entry.getValue();
			String id = entry.getKey();
			
			Internal internal = clientInternalList.get(id);
			alreadyId.put(id, 1);
			zFloor.put(id, -300);
			Box[] pos = this.grid.getVicinity(car.pos.x, car.pos.y, car.pos.z);
			int[] carAxis = new int[]{car.pos.x,car.pos.y};
			for (Box box : pos){
				int clashaxis = 0;
				int clash = 0;
				double maxDiff = 0;
				int[] boxAxis = new int[]{box.pos.x,box.pos.y,box.pos.z};
				for (int axis : new int[]{axisX,axisY}){
					double diff = 0; 
					if (carAxis[axis]<boxAxis[axis] + Server.boxRadius){
						diff = Math.abs(boxAxis[axis] + Server.boxRadius - carAxis[axis] - Server.boxRadius);
					}else{
						diff = Math.abs(boxAxis[axis] + Server.boxRadius - carAxis[axis] + Server.boxRadius);
					}
					if (diff < ((double)Server.boxRadius) + 0.1){
						clash++;
						if (diff > maxDiff){
							clashaxis = axis;
							maxDiff = diff;
						}
					}
				}
				int zTop = 0;
				if (clash >= 2){
					zTop = box.pos.z + 2*Server.boxRadius;
					if (box.topmost!=-1 && car.pos.z + 0.1 > zTop){
						if (zTop > zFloor.get(id)){
							zFloor.put(id, zTop);
							if (car.pos.z < zTop + Server.floorDistance){
								switch(box.type){
								case 2: internal.zSpeed+=2; break;
								case 3: car.rSpeed += 0.001; break;
								case 4: car.rSpeed -= 0.001; break;
								case 7: internal.speed *= 1.05; break;
								}
							}
							if (box.type==8){
								internal.zSpeed*=0.95;
								internal.speed*=0.95;
							}
						}
					}else if(car.pos.z + Server.carHeight > box.pos.z && car.pos.z < zTop - 0.1){
						if (car.pos.z + ((double)Server.carHeight) * 0.1 > box.pos.z){
							int ax = clashaxis;
							int ay = (ax == axisX?axisY:axisX);

							boolean onLeft = carAxis[ax]<boxAxis[ax]+Server.boxRadius;
							
							switch (box.type){
							case 2 :
								double sx = decomposeSin(internal.sangle, internal.speed);
								double sy = decomposeCos(internal.sangle, internal.speed);
								int[] bounce = new int[]{0,0};
								if (onLeft){
									bounce[ax]-=2;
								}else{
									bounce[ax]+=2;
								}
								internal.zSpeed+=2;
								internal.sangle=(int) composeAtan2(sx+bounce[axisX], sy+bounce[axisY]);
								internal.speed=composeSqrt(sx+bounce[axisX], sy+bounce[axisY]);
								break;
							case 3:
								car.rSpeed+=0.001;
								break;
							case 4:
								car.rSpeed-=0.001;
								break;
							case 7:
								internal.speed *=1.05;
								break;
							}
							
							if (onLeft){
								if (ax==axisX){
									car.pos.x = (int) (boxAxis[ax] - Server.carRadius);
								}else{
									car.pos.y = (int) (boxAxis[ax] - Server.carRadius);
								}
							}else{
								if (ax==axisX){
									car.pos.x = (int) (2*Server.boxRadius + Server.carRadius);
								}else{
									car.pos.y = (int) (2*Server.boxRadius + Server.carRadius);
								}
								/*carAxis = new int[]{car.pos.x,car.pos.y};
								int dx = carAxis[ax] - boxAxis[ax] + Server.boxRadius;
								int dy = carAxis[ay] - boxAxis[ay] + Server.boxRadius;
								double cAngle = Math.atan2(dx, dy);
								double move = (Server.boxRadius + Server.carRadius) / Math.sin(cAngle);
								int mx = (int) composeAtan2(cAngle,move);
								int my = (int) composeSqrt(cAngle,move);
								
								carAxis[ax]+=mx;
								carAxis[ay]+=my;
								car.pos.x = carAxis[axisX];
								car.pos.y = carAxis[axisY];*/
							}
						}else if (maxDiff < ((double)Server.boxRadius) * 0.7){
							car.pos.z = (int) (boxAxis[axisZ] - Server.carHeight - 0.1);
							car.zSpeed = -0.1;
						}
					}
				}
			}
			for(Entry<String, Car> oEntry : clientsList.entrySet()){
				Car oCar = entry.getValue();
				final String oId = entry.getKey();
				if (alreadyId.containsKey(oId)){
					continue;
				}
				
				Internal oInternal = clientInternalList.get(oId);
				int x = car.pos.x, y = car.pos.y, z = car.pos.z;
				int ox = oCar.pos.x, oy = oCar.pos.y, oz = oCar.pos.z;
				int dx = ox - x, dy = oy - y, dz = oz - z;
				
				double dist = Math.sqrt(dx*dx + dy*dy);
				
				if (dist < Server.carSize && Math.abs(dz) < Server.carHeight){
					clientDataList.put(id, new HashMap<String,String>(){{put("oponentId",oId);}});
					clientDataList.put(id, new HashMap<String,Integer>(){{put("oponentTime",now+5);}});
					clientDataList.put(oId, new HashMap<String,String>(){{put("oponentId",oId);}});
					clientDataList.put(oId, new HashMap<String,Integer>(){{put("oponentTime",now+5);}});
					
					double tmp = internal.zSpeed;
					internal.zSpeed = oInternal.zSpeed * 0.8;
					oInternal.zSpeed = tmp * 0.8;
					
					double bumpAngle = Math.atan2(dx, dy);
					double oBumpAngle = Math.atan2(-dx, -dy);
					
					double sx = decomposeSin(internal.sangle, internal.speed);
					double sy = decomposeCos(internal.sangle, internal.speed);
					double bump = internal.speed * Math.cos(bumpAngle - internal.sangle);
					double bumpX = decomposeSin(bumpAngle, bump);
					double bumpY = decomposeCos(bumpAngle, bump);
					double dBumpX = decomposeSin(bumpAngle, 0.8 * bump);
					double dBumpY = decomposeCos(bumpAngle, 0.8 * bump);

					double osx = decomposeSin(oInternal.sangle, oInternal.speed);
					double osy = decomposeCos(oInternal.sangle, oInternal.speed);
					double oBump = oInternal.speed * Math.cos(oBumpAngle - oInternal.sangle);
					double oBumpX = decomposeSin(oBumpAngle, oBump);
					double oBumpY = decomposeCos(oBumpAngle, oBump);
					double odBumpX = decomposeSin(oBumpAngle, 0.8 * oBump);
					double odBumpY = decomposeCos(oBumpAngle, 0.8 * oBump);
					
					if (Math.cos(oBumpAngle - oInternal.sangle)>=0){
						car.rSpeed += 0.015 * oInternal.speed * Math.sin(oBumpAngle - oInternal.sangle);
					}
					
					if (Math.cos(bumpAngle - internal.sangle)>=0){
						oCar.rSpeed += 0.015 * internal.speed * Math.sin(bumpAngle - internal.sangle);
					}
					
					sx += odBumpX - bumpX;
					sy += odBumpY - bumpY;
					osx += dBumpX - oBumpX;
					osy += dBumpY - oBumpY;

					internal.sangle=(int) composeAtan2(sx, sy);
					internal.speed=composeSqrt(sx, sy);
					oInternal.sangle=(int) composeAtan2(osx, osy);
					oInternal.speed=composeSqrt(osx, osy);

					double mx = decomposeSin(bumpAngle, (Server.carSize - dist) / 1.98 );
					double my = decomposeCos(bumpAngle, (Server.carSize - dist) / 1.98 );
					
					car.pos.x -= mx;
					car.pos.y -= my;
					oCar.pos.x += mx;
					oCar.pos.y += my;
					
				}
			}
		}
		for (Entry<String, ?> entry: clientStates.entrySet()){
			Car car = clientsList.get(entry.getValue());
			Internal internal = clientInternalList.get(entry.getValue());
			String id = entry.getKey();
			
		}
	}
	
	private double decomposeSin(double angle, double speed){
		return speed * Math.sin(angle);
	}
	private double decomposeCos(double angle, double speed){
		return speed * Math.cos(angle);
	}
	private double composeAtan2(double x, double y){
		return Math.atan2(x, y);
	}
	private double composeSqrt(double x, double y){
		return Math.sqrt( x*x + y*y );
	}
	
}
