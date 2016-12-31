package me.alexandreh.fr.utils;


public enum State {
	
	// Waiting = first time
	// Pregame = first minute
	// Game = 9 days
	// PvP = the 10th day -> 1 day
	// Finish = when only 1 player left avec PvP
	WAITING, PREGAME, GAME, PVP, FINISH;
	
	private static State currentState;
	
	public static void setState(State state){
		
	State.currentState = state;	

	}
	
	public static boolean isState(State state){
		return State.currentState == state;
	}
	
	public static State getState(){
		return currentState;
	}
	
}


