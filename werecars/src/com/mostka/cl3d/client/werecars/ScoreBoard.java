package com.mostka.cl3d.client.werecars;

import com.google.gwt.user.client.ui.HTML;

public class ScoreBoard {
	
	class Score{
		String name;
		int score;
	}
	
	private HTML scoreLabel;

	public ScoreBoard(HTML scoreLabel) {
		this.scoreLabel = scoreLabel;
	}


	private void updateScoreboard(Score[] scores){
		String sc = "";
		for (Score score : scores){
			sc+=score.name+": "+score.score+"<br>";
		}
		scoreLabel.setHTML(sc);
	}
	
}
